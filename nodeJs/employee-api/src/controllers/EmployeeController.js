let EmployeeService = require('../services/EmployeeService-MySql');

class EmployeeController {
    constructor(app) {
        this._app = app;
        this._employeeService = new EmployeeService();
        this.routeHandler();
    }
    routeHandler() {
        this._app.get('/api/v1/employee', (req, res) => {
            this._employeeService.getEmployeeData()
                .then((result) => {
                    res.send(result);
                })
                .catch((error) => {
                    console.log(error);
                });
        });
        this._app.get('/api/v1/employee/:id', (req, res) => {
            this._employeeService.getEmployeeDataById(req.params.id)
                .then((result) => {
                    res.send(result);
                })
                .catch((error) => {
                    console.log(error);
                });
        });

    }
}
module.exports = EmployeeController;