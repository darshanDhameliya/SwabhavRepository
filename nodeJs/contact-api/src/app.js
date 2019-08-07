var Express = require('express');
var bodyParser = require('body-parser');
var Cors = require('cors');
var ContactApi = require('./controllers/contactController');

var contactApp = Express();
//swagger starts
var swaggerJSDoc = require('swagger-jsdoc');
var swaggerDefinition = {
    info: {
        title: 'Contact Api',
        version: '1.0.0',
        description: '<h2>CopyRight &copy; SwabhavTechlabs<h2>',
    },
    host: `localhost:8080`,
    basePath: '/',
};

var options = {
    // import swaggerDefinitions
    swaggerDefinition: swaggerDefinition,
    // path to the API docs
    apis: ['./controllers/*.js'],
};
var swaggerSpec = swaggerJSDoc(options);
contactApp.get('/swagger.json', function(req, res) {
    res.setHeader('Content-Type', 'application/json');
    res.send(swaggerSpec);
});
//swagger ends

contactApp.use(Express.static('public'));
contactApp.use(bodyParser.json());
contactApp.use(Cors());

new ContactApi(contactApp);
contactApp.listen(8080, () => {
    console.log('server running localhost:8080');
});