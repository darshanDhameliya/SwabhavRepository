let fileOperation = require('./fileOperationSync');

let fileRead = new fileOperation('text.txt');

fileRead.on('error', (error) => {
    console.log("error =" + error);
});
fileRead.on('file_read', (data) => {
    console.log(data);
});
fileRead.watch();
// fileRead.read();
// fileRead.append("vivek jivani");
fileRead.read();