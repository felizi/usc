var restify = require('restify'),
	server = restify.createServer();
server.use(restify.fullResponse()).use(restify.bodyParser());

var enigmaResource = require('./resources/enigmaResource');

server.post('/api/v1/encrypt', enigmaResource.encrypt);
server.post('/api/v1/decrypt', enigmaResource.decrypt);

/**
 * Callback para o listen
 */
function listenOnPort() {
	console.log('Servidor executando em http://localhost:8080');
}
server.listen(8080, listenOnPort);