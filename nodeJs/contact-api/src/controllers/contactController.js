let ContactService = require('../services/contactService');


/**
 * @swagger
 * tags:
 *   name: ContactController
 *   description: Contact Management
 */
/**
 * @swagger
 * definitions:
 *      contact:
 *          properties:
 *              _id:
 *                  type: integer
 *              _name:
 *                  type: string
 *              _contactNumber:
 *                  type: integer
 */

class ContactController {
    constructor(app) {
        this.app = app;
        this.routeHandler();
    }

    routeHandler() {
        /**
         * @swagger
         *  /api/v1/contact:
         *   get:
         *     tags:
         *       - ContactController
         *     description: Returns all contacts
         *     produces:
         *       - application/json
         *     responses:
         *       200:
         *         description: An array of contacts
         *         schema:
         *              $ref: '#/definitions/contact'
         */
        this.app.get('/api/v1/contact', (req, res) => {
            ContactService.readData()
                .then(
                    (result) => {
                        res.send(result);
                    }
                )
                .catch(
                    (error) => {
                        // console.log(error);
                        res.send(error);
                    }
                );
        });
        /**
         * @swagger
         * /api/v1/contact:
         *   post:
         *     tags:
         *       - ContactController
         *     description: Creates a new Contact
         *     produces:
         *       - application/json
         *     parameters:
         *       - name: contact
         *         description: Contact object
         *         in: body
         *         required: true
         *         schema:
         *           $ref: '#/definitions/contact'
         *     responses:
         *       200:
         *         description: Successfully created
         */
        this.app.post('/api/v1/contact', (req, res) => {
            ContactService.addContact(req.body)
                .then(
                    (result) => {
                        res.send(result);
                    }
                ).catch(
                    (error) => {
                        console.log(error);
                        res.send(error);
                    }
                );
        });
        /**
         * @swagger
         * /api/v1/contact/{id}:
         *   delete:
         *     tags:
         *       - ContactController
         *     description: Deletes a single contact
         *     produces:
         *       - application/json
         *     parameters:
         *       - name: id
         *         description: Contact's id
         *         in: path
         *         required: true
         *         type: integer
         *     responses:
         *       200:
         *         description: Successfully deleted
         */
        this.app.delete('/api/v1/contact/:id', (req, res) => {
            ContactService.deleteContact(req.params.id)
                .then(
                    (result) => {
                        res.send(result);
                    }
                ).catch(
                    (error) => {
                        res.send(error);
                    }
                );
        });
        // this.app.get('/api/v1/contact/:id', function(req, res) {

        //     res.send(contactService.getContact(req.params.id));

        //     res.end();
        // });
        // this.app.put('/api/v1/contact/:id', function(req, res) {
        //     contactService.editContact(req.params.id, req.body);

        //     res.end();
        // });
    }

}

module.exports = ContactController;