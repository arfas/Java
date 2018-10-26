var http = require('http');
var server = http.createServer(function (req, res) {
    res.setHeader('Content-Type', 'application/json');
    res.writeHead(200, 'json content');
    res.write('{ "price": "$57.6" }');
    res.end();
});
server.listen(8080);
