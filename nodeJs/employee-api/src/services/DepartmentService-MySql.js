let mysql = require('mysql');

class DepartmentService {
    constructor() {
        this._con = mysql.createConnection({
            host: "127.0.0.1",
            user: "root",
            password: "root",
            database: "swabhav"
        });

        this._con.connect(function(err) {
            if (err) throw err;
            console.log("MySQL Connected!");
        });
    }

    getDepartmentData() {
        let sql = 'SELECT * FROM DEPT';
        return this.quarryFire(sql);
    }

    getDepartmentDataById(id) {
        let sql = 'SELECT * FROM DEPT WHERE DEPTNO = ?';
        let value = [id];
        return this.quarryFire(sql, value);
    }
    addDepartmentData(department) {
        let sql = 'INSERT INTO DEPT VALUE(?) ';
        let value = [department.DEPTNO, department.DNAME, department.LOC];
        return this.quarryFire(sql, value);
    }
    deleteDepartmentData(id) {
        let sql = 'DELETE FROM DEPT WHERE DEPTNO=?';
        let value = [id];
        return this.quarryFire(sql, value);
    }
    getEmployeeDataDepartmentWise(id) {
        let sql = 'SELECT * FROM EMP WHERE DEPTNO =?';
        let value = [id];
        return this.quarryFire(sql, value);
    }
    getEmployeeDataById(deptId, empId) {
        let sql = 'SELECT * FROM EMP WHERE EMPNO = ? AND DEPTNO = ?';
        return new Promise((resolve, reject) => {
            this._con.query(sql, [empId, deptId], function(err, result) {
                if (err) {
                    reject(err);
                }
                if (result) {
                    resolve(result);
                }
            });
        });
    }
    addEmployeeData(deptId, employee) {
        let sql = 'INSERT INTO EMP VALUE(?) ';
        let value = [employee.EMPNO, employee.ENAME, employee.JOB, employee.MGR, employee.HIREDATE, employee.SAL, employee.COMM, parseInt(deptId, 10)];
        return this.quarryFire(sql, value);
    }
    deleteEmployeeData(deptId, empId) {
        let sql = 'DELETE FROM EMP WHERE EMPNO=? AND DEPTNO=?';
        return new Promise((resolve, reject) => {
            this._con.query(sql, [empId, deptId], function(err, result) {
                if (err) {
                    reject(err);
                }
                if (result) {
                    resolve(result);
                }
            });
        });
    }
    quarryFire(sql, value) {
        return new Promise((resolve, reject) => {
            this._con.query(sql, [value], function(err, result) {
                if (err) {
                    reject(err);
                }
                if (result) {
                    resolve(result);
                }
            });
        });
    }
}
module.exports = DepartmentService;