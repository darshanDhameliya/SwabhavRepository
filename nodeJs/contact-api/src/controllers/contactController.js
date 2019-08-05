let ContactService = require('../services/contactService');
class ContactController {
    constructor(app) {
        this.app = app;
        this.routeHandler();
    }

    routeHandler() {
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