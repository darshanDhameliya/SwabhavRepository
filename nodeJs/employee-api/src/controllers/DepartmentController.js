let DepartmentService = require('../services/DepartmentService-MongoDB');
/**
 * @swagger
 * tags:
 *   name: DepartmentController
 *   description: Department Management
 */
/**
 * @swagger
 * definitions:
 *      department:
 *          properties:
 *              DEPTNO:
 *                  type: integer
 *              DNAME:
 *                  type: string
 *              LOC:
 *                  type: string
 *      employee:
 *          properties:
 *              EMPNO:
 *                  type: integer
 *              ENAME:
 *                  type: string
 *              JOB:
 *                  type: string
 *              MGR:
 *                  type: integer
 *              HIREDATE:
 *                  type: string
 *              SAL:
 *                  type: integer
 *              COMM:
 *                  type: integer
 */

class DepartmentController {
    constructor(app) {
        this._app = app;
        this._departmentService = new DepartmentService();
        this.routeHandler();
    }
    routeHandler() {
        /**
         * @swagger
         *  /api/v1/department:
         *   get:
         *     tags:
         *       - DepartmentController
         *     description: Returns all departments
         *     produces:
         *       - application/json
         *     responses:
         *       200:
         *         description: An array of departments
         *         schema:
         *              $ref: '#/definitions/department'
         */
        this._app.get('/api/v1/department', (req, res) => {
            this._departmentService.getDepartmentData()
                .then((result) => {
                    res.send(result);
                })
                .catch((error) => {
                    console.log(error);
                });
        });
        /**
         * @swagger
         * /api/v1/department/{id}:
         *   get:
         *     tags:
         *       - DepartmentController
         *     description: Returns a single department
         *     produces:
         *       - application/json
         *     parameters:
         *       - name: id
         *         description: Department's id
         *         in: path
         *         required: true
         *         type: integer
         *     responses:
         *       200:
         *         description: A single Depatment
         *         schema:
         *           $ref: '#/definitions/department'
         */
        this._app.get('/api/v1/department/:id', (req, res) => {
            this._departmentService.getDepartmentDataById(req.params.id)
                .then((result) => {
                    res.send(result);
                })
                .catch((error) => {
                    console.log(error);
                });
        });
        /**
         * @swagger
         * /api/v1/department:
         *   post:
         *     tags:
         *       - DepartmentController
         *     description: Creates a new Department
         *     produces:
         *       - application/json
         *     parameters:
         *       - name: department
         *         description: Department object
         *         in: body
         *         required: true
         *         schema:
         *           $ref: '#/definitions/department'
         *     responses:
         *       200:
         *         description: Successfully created
         */
        this._app.post('/api/v1/department', (req, res) => {
            console.log(req);

            this._departmentService.addDepartmentData(req.body)
                .then((result) => {
                    res.send('department data add');
                })
                .catch((error) => {
                    console.log(error);
                });
        });
        /**
         * @swagger
         * /api/v1/department/{id}:
         *   delete:
         *     tags:
         *       - DepartmentController
         *     description: Deletes a single department
         *     produces:
         *       - application/json
         *     parameters:
         *       - name: id
         *         description: Department's id
         *         in: path
         *         required: true
         *         type: integer
         *     responses:
         *       200:
         *         description: Successfully deleted
         */
        this._app.delete('/api/v1/department/:id', (req, res) => {
            this._departmentService.deleteDepartmentData(req.params.id)
                .then((result) => {
                    res.send('department data delete');
                })
                .catch((error) => {
                    console.log(error);
                });
        });

        /**
         * @swagger
         *  /api/v1/department/{deptId}/employee:
         *   get:
         *     tags:
         *       - DepartmentController
         *     description: Returns all employees of department
         *     produces:
         *       - application/json
         *     parameters:
         *       - name: deptId
         *         description: Department's id
         *         in: path
         *         required: true
         *         type: integer
         *     responses:
         *       200:
         *         description: An array of employees of department
         *         schema:
         *              $ref: '#/definitions/employee'
         */

        this._app.get('/api/v1/department/:id/employee', (req, res) => {
            this._departmentService.getEmployeeDataDepartmentWise(req.params.id)
                .then((result) => {
                    res.send(result);
                })
                .catch((error) => {
                    console.log(error);
                });
        });
        /**
         * @swagger
         * /api/v1/department/{deptId}/employee/{empId}:
         *   get:
         *     tags:
         *       - DepartmentController
         *     description: Returns a single employee
         *     produces:
         *       - application/json
         *     parameters:
         *       - name: deptId
         *         description: Department's id
         *         in: path
         *         required: true
         *         type: integer
         *       - name: empId
         *         description: Employee's id
         *         in: path
         *         required: true
         *         type: integer
         *     responses:
         *       200:
         *         description: A single Employee
         *         schema:
         *           $ref: '#/definitions/employee'
         */
        this._app.get('/api/v1/department/:deptId/employee/:empId', (req, res) => {
            this._departmentService.getEmployeeDataById(req.params.deptId, req.params.empId)
                .then((result) => {
                    res.send(result);
                })
                .catch((error) => {
                    console.log(error);
                });

        });
        /**
         * @swagger
         * /api/v1/department/{deptId}/employee:
         *   post:
         *     tags:
         *       - DepartmentController
         *     description: Creates a new Employee of Department
         *     produces:
         *       - application/json
         *     parameters: 
         *       - name: deptId
         *         description: Department's id
         *         in: path
         *         required: true
         *         type: integer
         *       - name: employee
         *         description: Employee object
         *         in: body
         *         required: true
         *         schema:
         *           $ref: '#/definitions/employee'
         *     responses:
         *       200:
         *         description: Successfully created
         */
        this._app.post('/api/v1/department/:deptId/employee', (req, res) => {
            this._departmentService.addEmployeeData(req.params.deptId, req.body)
                .then((result) => {
                    res.send('employee data add');
                })
                .catch((error) => {
                    console.log(error);
                });

        });
        /**
         * @swagger
         * /api/v1/department/{deptId}/employee/{empId}:
         *   delete:
         *     tags:
         *       - DepartmentController
         *     description: Deletes a single employee
         *     produces:
         *       - application/json
         *     parameters:
         *       - name: deptId
         *         description: Department's id
         *         in: path
         *         required: true
         *         type: integer
         *       - name: empId
         *         description: Employee's id
         *         in: path
         *         required: true
         *         type: integer
         *     responses:
         *       200:
         *         description: Successfully deleted
         */
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