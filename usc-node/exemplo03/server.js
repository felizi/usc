var restify = require('restify');
var server = restify.createServer();
server.use(restify.fullResponse()).use(restify.bodyParser());
server.get('/api/v1/usc/cliente', function(req, res, next) {
  res.json({
    mensagem: "Verbo GET - Listagem de Clientes"
  });
  next();
});

/**
 * Resources
 * @type {DepartamentoResource|*|exports|module.exports}
 */
var departamentoResource = require('./resources/departamentoResource');
/**
 * GET - Resource Departamento
 */
server.get('/api/v1/usc/departamento', departamentoResource.findAll);

function listenOnPort() {
  console.log('Servidor executando em http://localhost:8080');
}
server.listen(8080, listenOnPort);
