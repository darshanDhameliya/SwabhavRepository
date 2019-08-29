let schema = require('../schema');
let mongoose = require('mongoose');

class UserServices {
    constructor() {
        this._myModel = mongoose.model('user', schema);
    }
    userRegister(user) {
        let data = '{"firstName":"' + user.firstName +
            '","lastName":"' + user.lastName +
            '","gender":"' + user.gender +
            '","birthOfDate":"' + user.birthOfDate +
            '","contactInfo":{"contactNo":' + user.contactNo +
            ',"address":{"country":"' + user.country +
            '","state":"' + user.state +
            '","city":"' + user.city +
            '","street":"' + user.street +
            '","houseNumber":"' + user.houseNumber +
            '"},"emailId":"' + user.emailId +
            '"},"password":"' + user.password +
            '","isDelete":' + false +
            '}';
        return new Promise((resolve, reject) => {
            this._myModel.findOne({
                    'contactInfo.emailId': user.emailId,
                    isDelete: false
                })
                .select('_id')
                .exec((err, result) => {
                    if (err)
                        reject(err);
                    if (result)
                        reject(JSON.parse('{"message": "email already exicute."}'));
                    if (!err && !result) {
                        new this._myModel(JSON.parse(data)).save((err, result) => {
                            if (err)
                                reject(err);
                            if (result) {
                                userLogin('{"emailId":"' + user.emailId +
                                    '","password":"' + user.password +
                                    '"}').then((result) => {
                                    resolve(result)
                                }).catch((error) => {
                                    reject(error)
                                });
                            }
                        });
                    }
                });

        });
    }
    userLogin(loginDetail) {
        return new Promise((resolve, reject) => {
            this._myModel.findOne({
                    'contactInfo.emailId': loginDetail.emailId,
                    'password': loginDetail.password,
                    isDelete: false
                })
                .select('_id')
                .exec((err, result) => {
                    if (err)
                        reject(err);
                    if (result)
                        resolve(result);
                    resolve(JSON.parse('{"message": "userName and password uncorrect."}'));
                });
        });
    }
    getUserById(userId) {
        return new Promise((resolve, reject) => {
            this._myModel.findOne({
                    '_id': userId
                })
                .select("firstName lastName gender birthOfDate contactInfo")
                .exec((err, result) => {
                    console.log();
                    if (err)
                        reject(err);
                    resolve(result);
                });
        });
    }
    updateProfile(userId, newData) {
        let data = '{"firstName":"' + newData.firstName +
            '","lastName":"' + newData.lastName +
            '","gender":"' + newData.gender +
            '","birthOfDate":"' + newData.birthOfDate +
            '","contactInfo":{"contactNo":' + newData.contactNo +
            ',"address":{"country":"' + newData.country +
            '","state":"' + newData.state +
            '","city":"' + newData.city +
            '","street":"' + newData.street +
            '","houseNumber":"' + newData.houseNumber +
            '"},"emailId":"' + newData.emailId +
            '"}}';

        return this.updateUser(userId, data);
    }
    changePassword(userId, password) {
        return new Promise((resolve, reject) => {
            this._myModel.findOne({
                    '_id': userId,
                    'password': password.oldPassword
                })
                .exec((err, result) => {
                    console.log();
                    if (err)
                        reject(err);
                    if (result) {
                        let data='{"password":"' + password.newPassword +
                        '"}';
                        this.updateUser(userId,data)
                        .then((result)=>{
                            resolve(result);
                        })
                        .catch((error)=>{
                            reject(error);
                        });
                    }
                    if(!err&&!result)
                        reject(JSON.parse('{"message": "old password uncorrect."}'));
                });
        });
    }
    updateUser(userId, newData) {
        return new Promise((resolve, reject) => {
            this._myModel.updateOne({
                '_id': userId
            }, JSON.parse(newData), {
                upsert: true
            }, (err, doc) => {
                if (err)
                    reject(err);
                resolve(doc);
            });
        });
    }
    deleteUser(userId) {
        return new Promise((resolve, reject) => {
            this._myModel.update({
                '_id': userId
            }, {
                'isDelete': true
            }, {
                upsert: true
            }, (err, doc) => {
                if (err)
                    reject(err);
                resolve(doc);
            });
        });
    }
}
module.exports = UserServices;