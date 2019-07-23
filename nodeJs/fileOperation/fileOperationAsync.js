var EventEmitter = require('events').EventEmitter;
var emitter = new EventEmitter();
var fs = require('fs');

class fileOperation extends EventEmitter {
    constructor(fileName) {
        super();
        this.fileName = fileName;
    }
    read() {
        console.log("---------read file--------------------");

        let that = this;
        fs.readFile(this.fileName, 'utf8', function(err, data) {
            if (err) {
                that.emit('error', 'file not found or read');
            } else {
                that.emit('file_read', data);
            }
        });
    }
}
module.exports = fileOperation;