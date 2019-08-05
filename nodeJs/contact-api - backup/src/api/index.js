let Express = require('express');
let api = Express();

api.get('/', (req, res) => {
    res.send({
        message: 'Hello from the API',
    });
});

module.exports = api;