let fileOperation = require('./fileOperationStream');

let fileRead = new fileOperation('./text.txt');
fileRead.read();