var connect = require('connect');
var http = require('http');

var app = connect()
app.use('/foo', function fooMiddleware(req, res, next) {
    console.log('foo');
    next();
});
app.use('/bar', function barMiddleware(req, res, next) {
    console.log('bar');
    next();
});
http.createServer(app).listen(3000);