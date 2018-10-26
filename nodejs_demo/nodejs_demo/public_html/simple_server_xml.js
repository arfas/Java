var http = require('http');
function handle_incoming_request(req, res) {
    console.log("INCOMING REQUEST: " + req.method + " " + req.url);
    res.writeHead(200, {"Content-Type": "text/xml"});
    res.end("<order>12345</order>" + "\n");
}
var s = http.createServer(handle_incoming_request);
s.listen(8080); 