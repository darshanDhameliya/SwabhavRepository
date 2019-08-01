var express = require('express');
var app = express();


app.use(express.static('public'));

function compressionMiddleware(req, res, next) {
    console.log('inside compression middleware');
    next();
}

function encryptionMiddleware(req, res, next) {
    console.log('inside encryption middleware');
    next();
}

function analysisMiddleware(req, res, next) {
    console.log('inside analysis middleware');
    next();
}
app.use('/login', compressionMiddleware, encryptionMiddleware, analysisMiddleware);

app.get('/login', function(req, res) {
    console.log('inside login controller');
    res.end();
});

app.listen(3000, () => {
    console.log('server running');
});