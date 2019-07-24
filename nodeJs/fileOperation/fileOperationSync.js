var EventEmitter = require('events').EventEmitter;
var emitter = new EventEmitter();
var fs = require('fs');

class fileOperation extends EventEmitter {
    constructor(fileName) {
        super();
        this.fileName = fileName;
    }
    read() {

        console.log("-----file-reading-start---------");
        let data = fs.readFileSync(this.fileName, 'utf8');
        this.emit('file_read', data);
        console.log("-----file-reading-over---------");
    }
    append(data) {
        fs.appendFileSync(this.fileName, "\n" + data);
    }
    watch() {
        fs.watch(this.fileName, (event, fileName) => {
            if (fileName && event === 'change')
                console.log('file change');
        });
    }
}
module.exports = fileOperation;