let DepartmentService = require('../services/DepartmentService-MongoDB');

class DepartmentController {
    constructor(app) {
        this._app = app;
        this._departmentService = new DepartmentService();
        this.routeHandler();
    }
    routeHandler() {
        this._app.get('/api/v1/department', (req, res) => {
            this._departmentService.getDepartmentData()
                .then((result) => {
                    res.send(result);
                })
                .catch((error) => {
                    console.log(error);
                });
        });
        this._app.get('/api/v1/department/:id', (req, res) => {
            this._departmentService.getDepartmentDataById(req.params.id)
                .then((result) => {
                    res.send(result);
                })
                .catch((error) => {
                    console.log(error);
                });
        });
        this._app.post('/api/v1/department', (req, res) => {
            this._departmentService.addDepartmentData(req.body)
                .then((result) => {
                    res.send('department data add');
                })
                .catch((error) => {
                    console.log(error);
                });
        });
        this._app.delete('/api/v1/department/:id', (req, res) => {
            this._departmentService.deleteDepartmentData(req.params.id)
                .then((result) => {
                    res.send('department data delete');
                })
                .catch((error) => {
                    console.log(error);
                });
        });
        this._app.get('/api/v1/department/:id/employee', (req, res) => {
            this._departmentService.getEmployeeDataDepartmentWise(req.params.id)
                .then((result) => {
                    res.send(result);
                })
                .catch((error) => {
                    console.log(error);
                });
        });
        this._app.get('/api/v1/department/:deptId/employee/:empId', (req, res) => {
            this._departmentService.getEmployeeDataById(req.params.deptId, req.params.empId)
                .then((result) => {
                    res.send(result);
                })
                .catch((error) => {
                    console.log(error);
                });

        });
        this._app.post('/api/v1/department/:deptId/employee', (req, res) => {
            this._departmentService.addEmployeeData(req.params.deptId, req.body)
                .then((result) => {
                    res.send('employee data add');
                })
                .catch((error) => {
                    console.log(error);
                });

        });
        this._app.delete('/api/v1/department/:deptId/employee/:empId', (req, res) => {
            this._departmentService.deleteEmployeeData(req.params.deptId, req.params.empId)
                .then((result) => {
                    res.send('employee data deleted');
                })
                .catch((error) => {
                    console.log(error);
                });

        });
    }
}
module.exports = DepartmentController;