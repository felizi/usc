var restify = require('restify');
var server = restify.createServer();
server.use(restify.fullResponse()).use(restify.bodyParser());

/**
 * Resources
 * @type {DepartamentoResource|*|exports|module.exports}
 */
var bankResource = require('./resources/bankResource');

// GET - Find of BankResource
server.get('/api/v1/usc/bank/:id', bankResource.find);
// GET - FindAll of BankResource
server.get('/api/v1/usc/banks', bankResource.findAll);
// POST - Incluir um banco
server.post('/api/v1/usc/bank', bankResource.insert);
// DELETE - Deletar um banco através do código
server.del('/api/v1/usc/bank', bankResource.delete);
// PUT - Atualizar um banco
server.put('/api/v1/usc/bank', bankResource.update);

/**
 * Callback para o listen
 */
function listenOnPort() {
  console.log('Servidor executando em http://localhost:8080');
}
server.listen(8080, listenOnPort);
