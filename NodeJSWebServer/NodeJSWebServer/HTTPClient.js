var http = require('http');
var args = process.argv.slice(2);

console.log( args );
//Set defaults
var clientOptions = {
    host: 'localhost',
    // hostname:'nodejs.org',
    port: '8080',
    path: '/',
    method: 'GET'
};

args.forEach(function (arg) {
    switch (arg) {
        case 'GET':
            clientOptions.method = 'GET';
            break;
        case 'SUBMIT':
        case 'POST':
            clientOptions.method = 'POST';
            clientOptions.path = '/api';
            break;
        case 'UPDATE':
        case 'PUT':
            clientOptions.path = '/api';
            clientOptions.method = 'PUT';
            break;
        case 'REMOVE':
        case 'DELETE':
            clientOptions.method = 'DELETE';
            clientOptions.path = '/api';
            break;
        default:
            clientOptions.method = 'GET';
            clientOptions.path = '/';
    }
    console.log(clientOptions.method);
    var clientReq = http.request(clientOptions, function (res) {
        console.log('status code', res.statusCode);
        switch (res.statusCode) {
            case 200:
                res.setEncoding('utf8');
                res.on('data', function (data) {
                    console.log('data', data);
                });
                break;
            case 404:
                console.log('404 error');
                break;
        };
    });
    clientReq.on('error', function (error) {
        throw error;
    });
    clientReq.end();
});
                 