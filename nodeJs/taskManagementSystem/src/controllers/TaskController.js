let TaskServices = require('../services/TaskServices-MongoDb');
/**
 * @swagger
 * tags:
 *   name: TaskController
 *   description: Task management
 */

/**
 * @swagger
 * definitions:
 *      task:
 *          properties:
 *              tittle:
 *                  type: string
 *              description:
 *                  type: string
 *              startDate:
 *                  type: date
 *              dueDate:
 *                  type: date
 *              assignee:
 *                  type: string
 *              priority:
 *                  type: string
 *      taskUpdate:
 *          properties:
 *              tittle:
 *                  type: string
 *              description:
 *                  type: string
 *              startDate:
 *                  type: date
 *              dueDate:
 *                  type: date
 *              assignee:
 *                  type: string
 *              priority:
 *                  type: string
 *              isComplated:
 *                  type: boolean
 */
class TaskController {
    constructor(app) {
        this._app = app;
        this._taskServices = new TaskServices();
        this.routeHandler();
    }
    routeHandler() {

        /**
         * @swagger
         * /api/v1/user/{userId}/task:
         *   post:
         *     tags:
         *       - TaskController
         *     description: Creates a new Task of User
         *     produces:
         *       - application/json
         *     parameters: 
         *       - name: userId
         *         description: User's id
         *         in: path
         *         required: true
         *       - name: task
         *         description: Task object
         *         in: body
         *         required: true
         *         schema:
         *           $ref: '#/definitions/task'
         *     responses:
         *       200:
         *         description: Successfully Add Task
         */


        this._app.post('/api/v1/user/:userId/task', (req, res) => {
            this._taskServices.addTask(req.params.userId, req.body)
                .then((result) => {
                    res.send(JSON.parse('{"message": "task add."}'));
                })
                .catch((error) => {
                    res.send(error);
                });
        });
        /**
         * @swagger
         *  /api/v1/user/{userId}/task:
         *   get:
         *     tags:
         *       - TaskController
         *     description: Returns all tasks of user
         *     produces:
         *       - application/json
         *     parameters:
         *       - name: userId
         *         description: User's id
         *         in: path
         *         required: true
         *     responses:
         *       200:
         *         description: An array of task of user
         */
        this._app.get('/api/v1/user/:userId/task', (req, res) => {
            this._taskServices.getTasks(req.params.userId)
                .then((result) => {
                    res.send(result);
                })
                .catch((error) => {
                    res.send(error);
                });
        });
        /**
         * @swagger
         * /api/v1/user/{userId}/task/{taskId}:
         *   get:
         *     tags:
         *       - TaskController
         *     description: Returns a single task
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
         *         description: A single Task
         */
        this._app.get('/api/v1/user/:userId/task/:taskId', (req, res) => {
            this._taskServices.getTaskById(req.params.userId, req.params.taskId)
                .then((result) => {
                    res.send(result);
                })
                .catch((error) => {
                    res.send(error);
                });
        });
        /**
         * @swagger
         * /api/v1/user/{userId}/task/{taskId}:
         *   put:
         *     tags:
         *       - TaskController
         *     description: Update a  Task of User
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
         *       - name: task
         *         description: Task object
         *         in: body
         *         required: true
         *         schema:
         *           $ref: '#/definitions/taskUpdate'
         *     responses:
         *       200:
         *         description: Successfully Update Task
         */
        this._app.put('/api/v1/user/:userId/task/:taskId', (req, res) => {
            this._taskServices.updateTask(req.params.userId, req.params.taskId, req.body)
                .then((result) => {
                    res.send(JSON.parse('{"message": "task update."}'));
                })
                .catch((error) => {
                    res.send(error);
                });
        });
        /**
         * @swagger
         * /api/v1/user/{userId}/task/{taskId}:
         *   delete:
         *     tags:
         *       - TaskController
         *     description: Deletes a single task
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
         *         description: Successfully deleted
         */
        this._app.delete('/api/v1/user/:userId/task/:taskId', (req, res) => {
            this._taskServices.deleteTask(req.params.userId, req.params.taskId)
                .then((result) => {
                    res.send(JSON.parse('{"message": "task delete."}'));
                })
                .catch((error) => {
                    res.send(error);
                });
        });
    }
}
module.exports = TaskController;