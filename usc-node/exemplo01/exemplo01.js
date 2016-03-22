var http = require('http');
http.createServer(
  function(req,res) {
    res.writeHead(200, { 'Content-Type': 'text/html; charset=utf-8' });
    res.end("<h2> Olá! Meu WebServer está no ar! </h2>");
  }
).listen(8081);
console.log("Servidor iniciado em localhost:8080");
