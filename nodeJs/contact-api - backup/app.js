var Express = require('express');
var bodyParser = require('body-parser');
var Cors = require('cors');

var contactApp = Express();

// contactApp.use(Express.static('public'));
contactApp.use(bodyParser.json());
contactApp.use(bodyParser.urlencoded({ extended: false }));
contactApp.use(Cors());

contactApp.listen(8080, () => {
    console.log('server running localhost:8080');
});
module.exports = contactApp;