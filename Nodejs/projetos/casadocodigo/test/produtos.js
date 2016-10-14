//usando o mocha para realizar teste com o nodejs
//ele sempre busca a pasta 'test'

/*Teste manual usando mocha
var http = require('http');
var assert = require('assert');//lib para testes e respostas automaizadas, parecido com junit do java



//monstagem do teste, esses primeiros paramettros no describw e no it são apenas alias
//colocar '#' serve apenas para facilitar no verbosa do console
describe('#ProdutosController', function(){//cenario
	//quando coloco uma função de parametro no it, ela funciona para fazer o it entender que tem chamadas assincronas e ele precisa esperar
	it('#listagem json', function(done){

		var config = {
			hostname: 'localhost',
			port: 3000,
			path: '/produtos',
			headers: {
				'Accept': 'application/json'
			}
		}
		
		http.get(config, function(res){
			//primeiro valor variavel, segundo é o valor esperado para ele dizer se é true
			assert.equal(res.statusCode, 200);
			assert.equal(res.headers['content-type'],'application/json');
			done();//chaamo a função apos realizar os testes, dentro do callback da chamada assincrona
		})
	});
});*/


/*Teste usando a lib supertest, que serve para testes de integração, verificando headers e etc*/
//saindo da pasta chamando o arquivo express criado por mim, que sobe o express configurado
var express = require('../config/expressConfig')();
/*passando o express para o construtor do supertest que espera uma estancia de server,
isso faz com que nao seja mais necessario subir as instacias de server para realizar osteste
pois ele ja estara fazendo issso para fazer as requisições*/
var request = require('supertest')(express);
describe('#ProdutosController', function(){

	//funcao que roda antes de cada teste
	//no caso está limpando a base
	//caso precise limpar uma base com tabelas mais complexas ou mais associações, usar a lib 'node-database-cleaner'
	beforeEach(function(done){
		var conn = express.infra.dbConnectionFactory();
		conn.query('delete from livros', function(error, result){
			if(!error){
				done();
			}
		});
	});

	it('#listagem json', function(done){		
		request.get('/produtos')//passando a rota que deseja testar
			//objeto retornado para configuraçções relativas a chamada
			.set('Accept','application/json') //fazendo verificação de headers
			.expect('Content-type', /json/)
			.expect(200, done);//passando numero no primeiro parametro indica que é o atributo de status, e o done serve para indicar o encerramento
	});

	it('#cadastro de produto invalido', function(done){
		request.post('/produtos/salva')
			.send({titulo: '', descricao:'novo livro'})//passa o argumentos para a requisição
			.expect(400, done);
	});

	it('#cadastro de produto valido', function(done){
		request.post('/produtos/salva')
			.send({titulo: 'teste', descricao:'novo livro', preco: 1.50})//passa o argumentos para a requisição
			.expect(302, done);
	});
});

