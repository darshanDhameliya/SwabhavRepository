let FileSystem = require('fs');
let http = require('http');
let server = http.createServer((req, res) => {
    let fileName = req.url.slice(1);
    FileSystem.readFile('./' + fileName, (error, data) => {
        if (data) {
            res.write(data);
        } else {
            res.write('<html><body><p>404: Page Not Found</p></body></html>');
        }
    })
});
server.listen(5000);