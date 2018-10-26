var http = require('http');
var fs = require('fs');
var path = require('path');
//Content types map
var contentTypes = {
    '.htm': 'text/html',
    '.html': 'text/html',
    '.js': 'text/javascript',
    '.json': 'application/json',
    '.css': 'text/css',
    '.gif': 'image/gif',
    '.jpg': 'image/jpg',
    '.png': 'image/png'
};
var server = http.createServer(function (req, res) {
    console.log(req.url);
    var fileStream = fs.createReadStream(req.url.slice(1));
    fileStream.on('error', function (error) {
        if (error.code === 'ENOENT') {
            res.statusCode = 404;
            res.end(http.STATUS_CODES[404]);
        } else {
            res.statusCode = 500;
            res.end(http.STATUS_CODES[500]);
        }
    });
    //Get the extension
    var extension = path.extname(req.url);
    //read the extension against the content type map - default to plain text
    var contentType = contentTypes[extension] || 'text/plain';
    // add the content type header
    res.writeHead(200, {'Content-Type': contentType});
    // pipe the stream to the response stream
    fileStream.pipe(res);
});
server.listen(8080);