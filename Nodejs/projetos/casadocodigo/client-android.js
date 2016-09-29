//exemplicação de outro sistema consumindo os serviços da aplicação
//nao pode esquecer de subir o outro server para garantir o funcionamento
var http = require('http');

var configuracoes = {
	hostname: 'localhost',
	port : 3000,
	path : '/produtos',
	//tipando o retorno para ser preferencialmente json
	headers: {
		'Accept' : 'application/json'
		//'Accept' : 'test/hmtl'// para solicitar o html
	}
};

http.get(configuracoes, function(res){
	console.log('code: '+res.statusCode);

	//evento de obtenção de dados completos
	res.on('data', function(body){
		console.log('body: '+body);
	});
});