var http = require('http'); //lib interna do Node

// instaciamento do servicor, colocando callback de respostas as requisições
// forma manual de se fazer a inidcação de endpoints 
var server = http.createServer(function(request, response){
	if(request.url == '/produtos'){
		response.end('<html><body>aaaaaa</body></html>');
	}else{
		response.end('<html><body>404 not found</body></html>');
	}
});

server.listen(3000) // indica a porta que ele deve ficar escutando

/*Todo o trecho acima é possivel por em apenas uma linha, está assim para ficar mais didatico*/
console.log('Server Created!');
