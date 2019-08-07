let Express = require('express');
let EmployeeController = require('./controllers/EmployeeController');
let DepartmentController = require('./controllers/DepartmentController');
let BodyParser = require('body-parser');
let Cors = require('cors');

let app = Express();
app.use(Cors());
app.use(BodyParser.json());

new DepartmentController(app);
// new EmployeeController(app);
app.listen(8080, () => {
    console.log('server running localhost:8080');
});