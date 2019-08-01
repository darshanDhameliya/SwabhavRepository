'use srict';
var mysql = require('mysql');
class contactService {
    constructor() {
        this._sql = null;
        this._con = mysql.createConnection({
            host: "127.0.0.1",
            user: "root",
            password: "root",
            database: "swabhav"
        });
    }
    addContact(contact) {
        this._sql = "INSERT INTO contectdetail VALUES ?";
        var value = [
            [contact.id, contact.name, contact.contactNumber]
        ];
        this._con.query(this._sql, [value], function(err, result) {
            if (err) throw err;
            console.log("Number of records inserted: " + result.affectedRows);
        });
    }
    displayContact() {
        this._sql = "SELECT * FROM contectdetail";
        this._con.query(this._sql, function(err, result) {
            if (err) throw err;
            console.log(result);
        });
    }
}
module.exports = contactService;