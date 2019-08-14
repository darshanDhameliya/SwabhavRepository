let Express = require('express');
let BodyParser = require('body-parser');
let Cors = require('cors');
let UserController = require('./controllers/UserController');
let TaskController = require('./controllers/TaskController');
let SubTaskController = require('./controllers/SubTaskController');
let swaggerJSDoc = require('swagger-jsdoc');

let app = Express();
let PORT = 8080;

app.use(BodyParser.json());
app.use(Express.static('public'));
app.use(Cors());

let swaggerDefinition = {
    info: {
        title: 'taskManagement API documentation',
        version: '1.0.0',
        description: '<h2>CopyRight &copy; SwabhavTechlabs<h2>',
    },
    host: `localhost:${PORT}`,
    basePath: '/',
};
var options = {
    swaggerDefinition: swaggerDefinition,
    apis: ['./controllers/*.js'],
};
var swaggerSpec = swaggerJSDoc(options);
app.get('/swagger.json', function(req, res) {
    res.setHeader('Content-Type', 'application/json');
    res.send(swaggerSpec);
});


new UserController(app);
new TaskController(app);
new SubTaskController(app);
app.listen(PORT, () => {
    console.log('server listen  Localhost : ' + PORT);
});