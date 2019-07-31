'use srict';
var mysql = require('mysql');
var sql;

var con = mysql.createConnection({
    host: "127.0.0.1",
    user: "root",
    password: "root",
    database: "swabhav",
    insecureAuth: true
});

con.connect(function(err) {
    if (err) throw err;
    console.log("Connected!");
    con.query("SELECT * FROM DEPT", function(err, result) {
        if (err) throw err;
        console.log(result);
    });
    // sql = "INSERT INTO DEPT VALUES (50,'OPERATIONS','BOSTON')";
    // con.query(sql, function(err, result) {
    //     if (err) throw err;
    //     console.log("1 record inserted");
    // });
    // sql = "UPDATE DEPT SET DNAME='ABD' WHERE DEPTNO=50";
    // con.query(sql, function(err, result) {
    //     if (err) throw err;
    //     console.log(result.affectedRows + " record(s) updated");
    // });
    sql = "DELETE FROM DEPT WHERE DEPTNO=50";
    con.query(sql, function(err, result) {
        if (err) throw err;
        console.log("Number of records deleted: " + result.affectedRows);
    });
    con.query("SELECT * FROM DEPT", function(err, result) {
        if (err) throw err;
        console.log(result);
    });
    con.end();
});
console.log('end program');