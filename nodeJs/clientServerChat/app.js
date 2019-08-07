let Express = require('express');
let app = Express();
let http = require('http').Server(app);
let io = require('socket.io')(http);

app.use(Express.static('public'));

io.on('connection', (socket) => {
    console.log('A new websocket connection has been established');

    socket.on('chat message', function(msg) {
        console.log('client : ' + msg);

        io.emit('chat message', 'hello client');
    });
});
http.listen(8080, () => {
    console.log('server connected  localhost:8080');
});