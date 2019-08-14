let SubTaskServices = require('../services/SubTaskServices-MongoDb');
/**
 * @swagger
 * tags:
 *   name: SubTaskController
 *   description: Sub Task management
 */

/**
 * @swagger
 * definitions:
 *      subTask:
 *          properties:
 *              tittle:
 *                  type: string
 *              discription:
 *                  type: string
 *              startDate:
 *                  type: date
 *              dueDate:
 *                  type: date
 *              assignee:
 *                  type: string
 *      subTaskUpdate:
 *          properties:
 *              tittle:
 *                  type: string
 *              discription:
 *                  type: string
 *              startDate:
 *                  type: date
 *              dueDate:
 *                  type: date
 *              assignee:
 *                  type: string
 *              isComplated:
 *                  type: boolean
 */
class SubTaskController {
    constructor(app) {
        this._app = app;
        this._subTaskServices = new SubTaskServices();
        this.routeHandler();
    }
    routeHandler() {
        /**
         * @swagger
         * /api/v1/user/{userId}/task/{taskId}/subTask:
         *   post:
         *     tags:
         *       - SubTaskController
         *     description: Creates a new Sub Task of Task
         *     produces:
         *       - application/json
         *     parameters: 
         *       - name: userId
         *         description: User's id
         *         in: path
         *         required: true
         *       - name: taskId
         *         description: Task's id
         *         in: path
         *         required: true
         *       - name: subTask
         *         description: SubTask object
         *         in: body
         *         required: true
         *         schema:
         *           $ref: '#/definitions/subTask'
         *     responses:
         *       200:
         *         description: Successfully Add Sub Task
         */

        this._app.post('/api/v1/user/:userId/task/:taskId/subTask', (req, res) => {
            this._subTaskServices.addSubTask(req.params.userId, req.params.taskId, req.body)
                .then((result) => {
                    res.send(JSON.parse('{"message": "sub task add."}'));
                })
                .catch((error) => {
                    res.send(error);
                });
        });
        /**
         * @swagger
         *  /api/v1/user/{userId}/task/{taskId}/subTask:
         *   get:
         *     tags:
         *       - SubTaskController
         *     description: Returns all sub tasks of task
         *     produces:
         *       - application/json
         *     parameters:
         *       - name: userId
         *         description: User's id
         *         in: path
         *         required: true
         *       - name: taskId
         *         description: Task's id
         *         in: path
         *         required: true
         *     responses:
         *       200:
         *         description: An array of sub task of task
         */
        this._app.get('/api/v1/user/:userId/task/:taskId/subTask', (req, res) => {
            this._subTaskServices.getSubTasks(req.params.userId, req.params.taskId)
                .then((result) => {
                    res.send(result);
                })
                .catch((error) => {
                    res.send(error);
                });
        });
        /**
         * @swagger
         * /api/v1/user/{userId}/task/{taskId}/subTask/{subTaskId}:
         *   get:
         *     tags:
         *       - SubTaskController
         *     description: Returns a single sub task of task
         *     produces:
         *       - application/json
         *     parameters:
         *       - name: userId
         *         description: User's id
         *         in: path
         *         required: true
         *       - name: taskId
         *         description: Task's id
         *         in: path
         *         required: true
         *       - name: subTaskId
         *         description: Sub Task's id
         *         in: path
         *         required: true
         *     responses:
         *       200:
         *         description: A single Sub Task of task
         */
        this._app.get('/api/v1/user/:userId/task/:taskId/subTask/:subTaskId', (req, res) => {
            this._subTaskServices.getSubTaskById(req.params.userId, req.params.taskId, req.params.subTaskId)
                .then((result) => {
                    res.send(result);
                })
                .catch((error) => {
                    res.send(error);
                });
        });
        /**
         * @swagger
         * /api/v1/user/{userId}/task/{taskId}/subTask/{subTaskId}:
         *   put:
         *     tags:
         *       - SubTaskController
         *     description: Update a sub Task of User
         *     produces:
         *       - application/json
         *     parameters: 
         *       - name: userId
         *         description: User's id
         *         in: path
         *         required: true
         *       - name: taskId
         *         description: Task's id
         *         in: path
         *         required: true
         *       - name: subTaskId
         *         description: Sub Task's id
         *         in: path
         *         required: true
         *       - name: subTask
         *         description: Sub Task object
         *         in: body
         *         required: true
         *         schema:
         *           $ref: '#/definitions/subTaskUpdate'
         *     responses:
         *       200:
         *         description: Successfully Update Sub Task
         */
        this._app.put('/api/v1/user/:userId/task/:taskId/subTask/:subTaskId', (req, res) => {
            this._subTaskServices.updateSubTask(req.params.userId, req.params.taskId, req.params.subTaskId, req.body)
                .then((result) => {
                    res.send(JSON.parse('{"message": "sub task update."}'));
                })
                .catch((error) => {
                    res.send(error);
                });
        });

        /**
         * @swagger
         * /api/v1/user/{userId}/task/{taskId}/subTask/{subTaskId}:
         *   delete:
         *     tags:
         *       - SubTaskController
         *     description: Deletes a single sub task of task
         *     produces:
         *       - application/json
         *     parameters:
         *       - name: userId
         *         description: User's id
         *         in: path
         *         required: true
         *       - name: taskId
         *         description: Task's id
         *         in: path
         *         required: true
         *       - name: subTaskId
         *         description: Sub Task's id
         *         in: path
         *         required: true
         *     responses:
         *       200:
         *         description: Successfully deleted
         */
        this._app.delete('/api/v1/user/:userId/task/:taskId/subTask/:subTaskId', (req, res) => {
            this._subTaskServices.deleteSubTask(req.params.userId, req.params.taskId, req.params.subTaskId)
                .then((result) => {
                    res.send(JSON.parse('{"message": "sub task delete."}'));
                })
                .catch((error) => {
                    res.send(error);
                });
        });
    }
}
module.exports = SubTaskController;