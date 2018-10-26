var http = require('http');
var url = require('url');
var request = require('C:\\Users\\arfas\\node_modules\\request');

function handle_incoming_request(req, res) {
    console.log("INCOMING REQUEST: " + req.method + " " + req.url);
    req.parsed_url = url.parse(req.url, true);
    var getp = req.parsed_url.query;
    var agency = getp.agency ? getp.agency : "";
    console.log("agency: " + agency);

    res.writeHead(200, {"Content-Type": "text/xml"});
    request(agency, function (error, response, body) {
        if (!error && response.statusCode == 200) {
            res.end(body);
        }
    });
}
var s = http.createServer(handle_incoming_request);
s.listen(8080); 