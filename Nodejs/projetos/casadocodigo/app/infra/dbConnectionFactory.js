// conexao mysql;
var mysql = require('mysql');

function createDBConnection(){
/*o epxress tem uma varival chamada 'NODE_ENV', dentrod objeto process.env, que conseuge verificar se voce esta num ambiante de desenv ou producao,
pois pra producao ele faz algumas otimizações como deixar as views em cache para otimizar o carregamento*/
	//fazendo verificação de ambiente de desenvolvimento
	if(!process.env.NODE_ENV){
		console.log('conexao com DB');
		return  mysql.createConnection({
					host : "localhost",
					user: "root",
					password: "",
					database : "nodejs"
				});
		
	//comando para windows not termial, caso nao seja nao precisa usar set e nem node, associe a variavel direto e rode o mocha
	//SET NODE_ENV=test 
	//node node_modules/mocha/bin/mocha
	}else if(process.env.NODE_ENV == 'test'){
		console.log('conexao com DB de teste');
		return  mysql.createConnection({
					host : "localhost",
					user: "root",
					password: "",
					database : "nodejs_test"
				});
	}
}

//wrapper
module.exports = function(){
	return createDBConnection;
}