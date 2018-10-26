//replace port 8080 below if you wish to change the server port
var serverport = 8080;

var http = require('http');
var qs = require('querystring');
var url = require('url');
var fs = require('fs');
var util = require('util');
var mime = require('C:\\nodejs\\node_modules\\mime');

var vidStreamer = require("C:\\nodejs\\node_modules\\vid-streamer");

//write back result
writeResult = function(res, code, result, mimetype) {
    res.writeHead(code, {'Content-Type': mimetype, 'Content-Length': result.length});
    res.write(result);
    res.end();
}

// get getFilename from request using url
getFilename = function(req) {
    var filename = req.url.substring(1);
    if (!!filename)
        return filename;
    return "/";
}

// sendFile 
sendFile = function(filename, res) {
    if (filename[filename.length - 1] === '/')
        filename += 'index.html'
    fs.readFile(filename, function(err, data) {
        if (err) {
            writeResult(res, "404", "Page not found!", "text/plain");
            return;
        }
//    console.log('file: ' + filename + ' mime : ' + mime.lookup(filename));    
        writeResult(res, 200, data, mime.lookup(filename));
    });
}

// sendScores
sendScores = function(req, res) {
    var str = "<ul>"
            + "<li>Midterm</li><li>Peter [ 18 / 20 ]</li><li>Nancy [ 15 / 20 ]</li>"
            + "<li>Final</li><li>Peter [ 19 / 20 ]</li><li>Nancy [ 17 / 20 ]</li></ul>";
    writeResult(res, "200", str, "text/html");
}

// the GET handler
handleGet = function(req, res) {
    var filename = getFilename(req).replace(/%20/g, " ");
    if (req.url === "/") {
        writeResult(res, "200", "A Simple Server says: Hello!", "text/plain");
    }
    else if (req.url === "/getScores") {
        sendScores(req, res);
    }
    else if (req.url === "/delay") {
        setTimeout(function() {
            sendFile('dummypage', res);
        }, 2000);
    }
    else if (req.url === '/getxml') {
        console.log("INCOMING REQUEST: " + req.method + " " + req.url);
        res.writeHead(200, {"Content-Type": "text/xml"});
        res.end("<order>12345</order>" + "\n");
    }
    else if (req.url.indexOf("/resources/video") >= 0
            || req.url.indexOf("/resources/audio") >= 0) {
        vidStreamer(req, res);
    } else {
        sendFile(filename, res);
    }
}

//Handles /postComment
addComment = function(req, res) {
    var body = "";
    req.on('data', function(data) {
        body += data;
    });
    req.on('end', function() {
        var obj = qs.parse(body);
        var str = "<div><h1>Comments Added</h1>"
                + "<div>Hi " + obj.username + "!"
                + "<p>Your Email ID: " + obj.email + "</p>"
                + "<p>Added your comment: " + obj.comments + "</p>"
                + "</div></div>";
        writeResult(res, "200", str, "text/html");
    });
}

//Handles /postRegister
registerClub = function(req, res) {
    var body = "";
    req.on('data', function(data) {
        body += data;
    });
    req.on('end', function() {
        var obj = qs.parse(body);
        var str = "<div><h1>Thanks for registering our Club!</h1>"
                + "<div>Hi " + obj.first_name + "!"
                + "<p>Your Email ID: " + obj.email_address + "</p>"
                + "</div></div>";
        writeResult(res, "200", str, "text/html");
    });
}


// HTTP REQUEST HANDLERS
handlePost = function(req, res) {
    if (req.url === "/postComment") {
        addComment(req, res);
    } else if (req.url === "/postRegister") {
        registerClub(req, res);
    
    } else {
        var str = "<h1>Server Response</h1>"
                + "Your post was successful!";
        writeResult(res, "200", str, "text/html");

    }
}

// server starts here
http.createServer(function(req, res) {
    if (req.method == 'GET') {
        handleGet(req, res);
    }
    else
    if (req.method == 'POST') {
        handlePost(req, res);
    }
}).listen(serverport);
util.log('A Simple Node Server is running...');
