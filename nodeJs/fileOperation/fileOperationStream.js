let EventEmitter = require('events').EventEmitter;
let emitter = new EventEmitter();
let fs = require('fs');

class fileOperation extends EventEmitter {
    constructor(fileName) {
        super();
        this.fileName = fileName;
    }
    read() {
        console.log("file read");

        let stream;
        stream = fs.createReadStream(this.fileName);

        stream.on("data", function(data) {
            let chunk = data.toString();
            console.log(chunk);
        });
    }
}
module.exports = fileOperation;