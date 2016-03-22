var http = require('http');
var server = http.createServer(function(request, response){
  response.writeHead(200, {"Content-Type": "text/html; charset=utf-8"});
  switch (request.url) {
    case "/":
      response.write("<h1>Página principal</h1>");
      break;

    case "/bemvindo":
      response.write("<h1>Seja Bem Vindo!</h1>");
      break;

    default:
      response.write("<h1>Página não encontrada...</h1>");
      break;
    }

  response.end();
});
server.listen(8081, function(){
  console.log('Servidor iniciado em localhost:8080');
});
