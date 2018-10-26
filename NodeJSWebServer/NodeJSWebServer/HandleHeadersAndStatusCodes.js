var http = require('http');
var url = require('url');
var server = http.createServer(function(req, res) {
    if (req.headers) {
        console.log('request headers', req.headers);
}
var parsedUrl = url.parse(req.url);
if (parsedUrl.path === '/manifest.webapp' && req.method === ‘GET’) {
    // serving an application manifest file type
    res.writeHead(200, { 'Content-Type' : 'application/x-web-app-manifest+json' });
    res.write('{ "name" : "App" }');
    res.write( '"description": "My elevator pitch goes here",');
    res.write('"launch_path": "/",');
    res.write('"icons": {');
    res.write('"128": "/img/icon-128.png" },');
    res.write('"developer": {');
    res.write(' "name": "Your name or organization",');
    res.write(' "url": "http://your-homepage-here.org" },');
    res.write('"default_locale": "en" }');0
    res.end();
} else if (parsedUrl.path !== '/') {
    res.statusCode = 404;
    res.end(http.STATUS_CODES[res.statusCode]);
} else {
    res.writeHead(200, { 'Content-Type': 'text/html'});
    res.end('<h2>normalContent</h2>');
} });
server.listen(8080);