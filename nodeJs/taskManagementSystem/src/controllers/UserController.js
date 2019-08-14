let UserServices = require('../services/UserServices-MongoDb');
/**
 * @swagger
 * tags:
 *   name: UserController
 *   description: User management and login
 */

/**
 * @swagger
 * definitions:
 *      user:
 *          properties:
 *              firstName:
 *                  type: string
 *              lastName:
 *                  type: string
 *              gender:
 *                  type: string
 *              birthOfDate:
 *                  type: date
 *              contactNo:
 *                  type: number
 *              country:
 *                  type: string
 *              state:
 *                  type: string
 *              city:
 *                  type: string
 *              street:
 *                  type: string
 *              houseNumber:
 *                  type: string
 *              emailId:
 *                  type: string
 *              password:
 *                  type: string  
 *      userUpdate:
 *          properties:
 *              firstName:
 *                  type: string
 *              lastName:
 *                  type: string
 *              gender:
 *                  type: string
 *              birthOfDate:
 *                  type: date
 *              contactNo:
 *                  type: number
 *              country:
 *                  type: string
 *              state:
 *                  type: string
 *              city:
 *                  type: string
 *              street:
 *                  type: string
 *              houseNumber:
 *                  type: string
 *              emailId:
 *                  type: string      
 *      userLogin:
 *          properties:
 *              emailId:
 *                  type: string
 *              password:
 *                  type: string
 */
class UserController {
    constructor(app) {
        this._app = app;
        this._userServices = new UserServices();
        this.routeHandler();
    }
    routeHandler() {
        /**
         * @swagger
         * /api/v1/register:
         *   post:
         *     tags:
         *       - UserController
         *     description: Creates a new Account
         *     produces:
         *       - application/json
         *     parameters:
         *       - name: user
         *         description: User object
         *         in: body
         *         required: true
         *         schema:
         *           $ref: '#/definitions/user'
         *     responses:
         *       200:
         *         description: Successfully created
         */
        this._app.post('/api/v1/register', (req, res) => {
            this._userServices.userRegister(req.body)
                .then((result) => {
                    res.send(JSON.parse('{"message": "register success."}'));
                })
                .catch((error) => {
                    res.send(error);
                });
        });
        /**
         * @swagger
         * /api/v1/login:
         *   post:
         *     tags:
         *       - UserController
         *     description: Returns a user's id
         *     produces:
         *       - application/json
         *     parameters:
         *       - name: loginDTO
         *         description: emailId & password
         *         in: body
         *         required: true
         *         schema:
         *           $ref: '#/definitions/userLogin'
         *     responses:
         *       200:
         *         description: user's id
         */
        this._app.post('/api/v1/login', (req, res) => {
            this._userServices.userLogin(req.body)
                .then((result) => {
                    res.send(result);
                })
                .catch((error) => {
                    res.send(error);
                });
        });
        /**
         * @swagger
         * /api/v1/user/{userId}:
         *   get:
         *     tags:
         *       - UserController
         *     description: Returns a single user
         *     produces:
         *       - application/json
         *     parameters:
         *       - name: userId
         *         description: user's id
         *         in: path
         *         required: true
         *     responses:
         *       200:
         *         description: A single User
         */
        this._app.get('/api/v1/user/:userId', (req, res) => {
            this._userServices.getUserById(req.params.userId)
                .then((result) => {
                    res.send(result);
                })
                .catch((error) => {
                    res.send(error);
                });
        });

        /**
         * @swagger
         * /api/v1/user/{userId}:
         *   put:
         *     tags:
         *       - UserController
         *     description: Update User
         *     produces:
         *       - application/json
         *     parameters:
         *       - name: userId
         *         description: user's id
         *         in: path
         *         required: true
         *       - name: user
         *         description: User object
         *         in: body
         *         required: true
         *         schema:
         *           $ref: '#/definitions/userUpdate'
         *     responses:
         *       200:
         *         description: Successfully updated
         */
        this._app.put('/api/v1/user/:userId', (req, res) => {
            this._userServices.updateUser(req.params.userId, req.body)
                .then((result) => {
                    res.send(JSON.parse('{"message": "update success."}'));
                })
                .catch((error) => {
                    res.send(error);
                });
        });

        /**
         * @swagger
         * /api/v1/user/{userId}:
         *   delete:
         *     tags:
         *       - UserController
         *     description: Deletes a single user
         *     produces:
         *       - application/json
         *     parameters:
         *       - name: userId
         *         description: user's id
         *         in: path
         *         required: true
         *     responses:
         *       200:
         *         description: Successfully deleted
         */
        this._app.delete('/api/v1/user/:userId', (req, res) => {
            this._userServices.deleteUser(req.params.userId)
                .then((result) => {
                    res.send(JSON.parse('{"message": "delete success."}'));
                })
                .catch((error) => {
                    res.send(error);
                });
        });
    }
}
module.exports = UserController;