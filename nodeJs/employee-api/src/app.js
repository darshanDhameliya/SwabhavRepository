let Express = require('express');
let EmployeeController = require('./controllers/EmployeeController');
let DepartmentController = require('./controllers/DepartmentController');
let BodyParser = require('body-parser');
let Cors = require('cors');

let app = Express();
//swagger starts
var swaggerJSDoc = require('swagger-jsdoc');
var swaggerDefinition = {
    info: {
        title: 'Department Api',
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
app.get('/swagger.json', function(req, res) {
    res.setHeader('Content-Type', 'application/json');
    res.send(swaggerSpec);
});
//swagger ends

app.use(BodyParser.json());
app.use(Cors());
app.use(Express.static('public'));

new DepartmentController(app);
// new EmployeeController(app);
app.listen(8080, () => {
    console.log('server running localhost:8080');
});