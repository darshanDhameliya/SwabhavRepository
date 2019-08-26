let schema = require('../schema');
let mongoose = require('mongoose');
class TaskServices {
    constructor() {
        this._myModel = mongoose.model('user', schema);
    }
    addTask(userId, task) {
        task.isComplated = false;
        task.createDate = Date.now();
        return new Promise((resolve, reject) => {
            this._myModel.updateOne({ '_id': userId }, { $push: { 'task': task } }, { upsert: true }, (err, result) => {
                if (err)
                    reject(err);
                resolve(result);
            });
        });
    }
    getTasks(userId) {
        return new Promise((resolve, reject) => {
            this._myModel.findOne({ '_id': userId })
                .select("task._id task.tittle task.description task.startDate task.dueDate task.assignee task.priority task.isComplated task.createDate")
                .exec((err, result) => {
                    if (err)
                        reject(err);
                    if (result)
                        resolve(result.task);
                });
        });
    }
    getTaskById(userId, taskId) {
        return new Promise((resolve, reject) => {
            this._myModel.findOne({ '_id': userId, 'task._id': taskId }, { task: { $elemMatch: { _id: taskId } } })
                .select("task.tittle task.description task.startDate task.dueDate task.assignee task.priority task.isComplated task.createDate")
                .exec((err, result) => {
                    if (err)
                        reject(err);
                    if (result)
                        resolve(result.task[0]);
                    resolve(JSON.parse('{"message": "data not found."}'));
                });
        });
    }
    updateTask(userId, taskId, newData) {
        return new Promise((resolve, reject) => {
            this._myModel.updateOne({ '_id': userId, 'task._id': taskId }, {
                '$set': {
                    'task.$.tittle': newData.tittle,
                    'task.$.description': newData.description,
                    'task.$.startDate': newData.startDate,
                    'task.$.dueDate': newData.dueDate,
                    'task.$.assignee': newData.assignee,
                    'task.$.priority': newData.priority,
                    'task.$.isComplated': newData.isComplated
                }
            }, { upsert: true }, (err, result) => {
                if (err)
                    reject(err);
                if (result)
                    resolve(result);
            });
        });
    }
    deleteTask(userId, taskId) {
        return new Promise((resolve, reject) => {
            this._myModel.updateOne({ '_id': userId, 'task._id': taskId }, { $pull: { task: { _id: taskId } } }, { upsert: true }, (err, result) => {
                if (err)
                    reject(err);
                if (result)
                    resolve(result);
            });
        });
    }
}
module.exports = TaskServices;