var Express = require('express');
var bodyParser = require('body-parser');
var Cors = require('cors');
var ContactApi = require('./controllers/contactController');

var contactApp = Express();

// contactApp.use(Express.static('public'));
contactApp.use(bodyParser.json());
contactApp.use(Cors());

new ContactApi(contactApp);
contactApp.listen(8080, () => {
    console.log('server running localhost:8080');
});