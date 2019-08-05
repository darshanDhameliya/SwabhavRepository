var App = require('./app');
var ContactService = require('./contactService');


var contactService = new ContactService('contactData.json');

App.get('/api/v1/contact', function(req, res) {
    res.header('Access-Control-Allow-Origin', '*');

    res.send(contactService.getContactList());

    res.end();
});
App.post('/api/v1/contact', function(req, res) {
    contactService.addContact(req.body);
    res.end();
});
App.delete('/api/v1/contact/:id', function(req, res) {

    contactService.deleteContact(req.params.id);

    res.end();
});
App.get('/api/v1/contact/:id', function(req, res) {

    res.send(contactService.getContact(req.params.id));

    res.end();
});
App.put('/api/v1/contact/:id', function(req, res) {
    contactService.editContact(req.params.id, req.body);

    res.end();
});