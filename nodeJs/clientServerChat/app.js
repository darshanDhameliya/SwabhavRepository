let Express = require('express');
let app = Express();
let http = require('http').Server(app);
let io = require('socket.io')(http);
let PORT = 8080;
let clientMap = new Map();

app.use(Express.static('public'));

io.on('connection', (socket) => {

    console.log('------------------------------------------------------------');
    console.log('A new websocket connection has been established');
    console.log('connected : ' + socket.id);
    clientMap.set(socket.id, '');
    console.log('total connection : ' + clientMap.size);



    socket.on('chat message', function(data) {
        clientMap.set(socket.id, data);
        console.log('------------------------------------------------------------');
        console.log(data.SOCKETID + '{\n\tuserName : ' + data.USERNAME + ',\n\tmessage : ' + data.MESSAGE + '\n}');
        io.to(data.SOCKETID).emit('chat message', 'hello client');
    });

    socket.on('disconnect', () => {
        clientMap.delete(socket.id);
        console.log('------------------------------------------------------------');
        console.log('disconnected : ' + socket.id);
        console.log('total connection : ' + clientMap.size);
    });
});
http.listen(PORT, () => {
    console.log('server connected  localhost:' + PORT);
});