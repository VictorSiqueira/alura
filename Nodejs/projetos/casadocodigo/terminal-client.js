//exemplicação do terminal consumindo os serviços da aplicação
//nao pode esquecer de subir o outro server para garantir o funcionamento
var http = require('http');

var configuracoes = {
	hostname: 'localhost',
	port : 3000,
	path : '/produtos/salva',
	method: 'post', //nao pode esquecer de por ele, pois por default vai get
	headers: {
		'Accept' : 'application/json',
		'Content-type': 'application/json'//indica que queremos enviar json para outra aplicação que permita receber json
	}
};

//usando o metodo resquest, obtem o retorno de um objto clientHttp
//que só é disparado quando usa-se o metodo end(), indicando que está todo montado
var client = http.request(configuracoes, function(res){
	console.log('code: '+res.statusCode); //recebra o code 302 nesse exemplo pq o serviço faz redirecionamento

	//evento de obtenção de dados completos
	res.on('data', function(body){
		console.log('body: '+body);
	});
});

var produto = {
	titulo: "teste terminal",
	descricao: "descricao terminal",
	preco: 200
}

client.end(JSON.stringify(produto));//stringifando para enviar ao server, normal para serviços REST