let fileOperation = require('./fileOperationAsync');

let fileRead = new fileOperation('text.txt');

fileRead.on('error', (error) => {
    console.log("error =" + error);
});
fileRead.on('file_read', (data) => {
    console.log(data);
});

fileRead.read();