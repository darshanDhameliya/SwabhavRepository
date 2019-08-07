let mysql = require('mysql');

class EmployeeService {
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
    getEmployeeData() {
        let sql = 'SELECT * FROM EMP';
        return this.quarryFire(sql);
    }

    getEmployeeDataById(id) {
        let sql = 'SELECT * FROM EMP WHERE EMPNO =' + id;
        return this.quarryFire(sql);
    }
    quarryFire(sql) {
        return new Promise((resolve, reject) => {
            this._con.query(sql, function(err, result) {
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
module.exports = EmployeeService;