let schema = require('../schema');
let mongoose = require('mongoose');
class SubTaskServices {
    constructor() {
        let uri = "mongodb+srv://admin:root@cluster0-zn1vi.mongodb.net/task_management?retryWrites=true&w=majority";
        mongoose.set('useCreateIndex', true);
        mongoose.connect(uri, { useNewUrlParser: true }, (err) => {
            if (err)
                throw err;
            console.log('sub task services : mongoDb connected!');

        });
        this._myModel = mongoose.model('user', schema);
    }
    addSubTask(userId, taskId, subTask) {
        if (!subTask.isComplated)
            subTask.isComplated = false;
        return new Promise((resolve, reject) => {
            this._myModel.updateOne({ '_id': userId, 'task._id': taskId }, { $push: { 'task.$.subTask': subTask } }, { upsert: true },
                (err, result) => {
                    if (err)
                        reject(err);
                    if (result)
                        resolve(result);
                });
        });
    }
    getSubTasks(userId, taskId) {
        return new Promise((resolve, reject) => {
            this._myModel.findOne({ '_id': userId }, { task: { $elemMatch: { _id: taskId } } }).exec((err, result) => {
                if (err)
                    reject(err);
                if (result && result.task[0] == null)
                    resolve(result.task);
                if (result && result.task[0] != null)
                    resolve(result.task[0].subTask);
            });
        });
    }
    getSubTaskById(userId, taskId, subTaskId) {
        return new Promise((resolve, reject) => {
            this.getSubTasks(userId, taskId)
                .then((result) => {
                    result.forEach(element => {
                        if (element._id == subTaskId)
                            resolve(element);
                    });
                })
                .catch((error) => {
                    reject(error);
                });
        });
    }
    updateSubTask(userId, taskId, subTaskId, newData) {
        newData._id = subTaskId;
        return new Promise((resolve, reject) => {
            this.deleteSubTask(userId, taskId, subTaskId)
                .then((result) => {
                    this.addSubTask(userId, taskId, newData)
                        .then((result) => {
                            resolve(result);
                        })
                        .catch((error) => {
                            reject(error);
                        });
                })
                .catch((error) => {
                    reject(error);
                });
        });
    }
    deleteSubTask(userId, taskId, subTaskId) {
        return new Promise((resolve, reject) => {
            this._myModel.updateOne({ '_id': userId, 'task._id': taskId }, { $pull: { 'task.$.subTask': { _id: subTaskId } } }, { upsert: true }, (err, result) => {
                if (err)
                    reject(err);
                if (result)
                    resolve(result);
            });
        });
    }
}
module.exports = SubTaskServices;