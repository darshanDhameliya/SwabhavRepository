let MongoClient = require('mongodb').MongoClient;

class DepartmentService {
    constructor() {
        this._collection = null;
        let uri = "mongodb+srv://admin:root@cluster0-zn1vi.mongodb.net/test?retryWrites=true&w=majority";

        let client = new MongoClient(uri, { useNewUrlParser: true });
        client.connect((err, db) => {
            if (err) throw err;
            console.log('mongoDb conected');
            this._collection = client.db("swabhav").collection("DEPT");
        });
    }

    // DEPARTMENT

    getDepartmentData() {
        return new Promise((resolve, reject) => {
            this._collection.find({}, {
                projection: {
                    _id: 0,
                    EMP: 0
                }
            }).toArray((err, result) => {
                if (err)
                    reject(err);
                resolve(result);
            });
        });
    }
    getDepartmentDataById(deptId) {
        let id = parseInt(deptId);
        return new Promise((resolve, reject) => {
            this._collection.find({ DEPTNO: id }, {
                projection: {
                    _id: 0,
                    EMP: 0
                }
            }).toArray((err, result) => {
                if (err)
                    reject(err);
                resolve(result);
            });
        });
    }
    addDepartmentData(department) {
        return new Promise((resolve, reject) => {
            this._collection.insertOne(department, (err, result) => {
                if (err)
                    reject(err);
                resolve(result);
            });
        });
    }
    deleteDepartmentData(deptId) {
        let id = parseInt(deptId);
        return new Promise((resolve, reject) => {
            this._collection.remove({ DEPTNO: id }, (err, result) => {
                if (err)
                    reject(err);
                resolve(result);
            });
        });
    }

    // EMPLOYEE

    getEmployeeDataDepartmentWise(deptId) {
        let id = parseInt(deptId);
        return new Promise((resolve, reject) => {
            this._collection.find({ DEPTNO: id }, {
                projection: {
                    _id: 0,
                    EMP: 1
                }
            }).toArray((err, result) => {
                if (err)
                    reject(err);
                result.forEach((element) => {
                    resolve(element.EMP);
                });

            });
        });
    }

    getEmployeeDataById(deptId, empId) {
        let dId = parseInt(deptId);
        let eId = parseInt(empId);

        return new Promise((resolve, reject) => {
            this._collection.find({ DEPTNO: dId }, {
                projection: {
                    _id: 0,
                    EMP: 1
                }
            }).toArray((err, result) => {
                if (err)
                    reject(err);
                result.forEach((element) => {
                    element.EMP.forEach((employee) => {
                        if (employee.EMPNO == eId) {
                            resolve(employee);
                        }
                    });

                });
            });
        });
    }

    addEmployeeData(deptId, employee) {
        let id = parseInt(deptId);
        return new Promise((resolve, reject) => {
            this._collection.updateOne({ DEPTNO: id }, { $push: { EMP: employee } }, (err, result) => {
                if (err)
                    reject(err);
                resolve(result);
            });
        });
    }

    deleteEmployeeData(deptId, empId) {
        let dId = parseInt(deptId);
        let eId = parseInt(empId);
        return new Promise((resolve, reject) => {
            this._collection.updateOne({ DEPTNO: dId }, { $pull: { 'EMP': { EMPNO: eId } } }, (err, result) => {
                if (err)
                    reject(err);
                resolve(result);
            });
        });
    }
}
module.exports = DepartmentService;