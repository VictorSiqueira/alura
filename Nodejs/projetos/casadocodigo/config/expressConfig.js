var express = require('express');
var load = require('express-load');
var bodyParser = require('body-parser');//lib que traduz o objeto que vem no request de um form 
var expressValidator =  require('express-validator');//validator de objetos em requisição

//modularização seguindo o padrão do CommonJS
/* CommonJS é uma convenção para carregamentos de módulos javascript em aplicações server-side. 
O objeto que o node disponibiliza é o module e a função é passada para o atributo exports desse objeto.*/
module.exports = function(){
	//caso queria sempre manter a mesma versão dos parametros para todos que chamarem, bata por eles fora desta function
	var server = express();

	/*satando o ejs no servidor, nao achei muito bacana, 
	pois aparentemento substitui todos os aruivos html para a extensao ejs. fica parecendo jsp do java
	o que faz a aplicação ficar amarrada e nao modular*/
	server.set('view engine', 'ejs');

	//indicação das views que o node vai procurar, quando voce utiliza em um local especifico
	server.set('views', './app/views');//esta com apenas um ponto no URI, pois é o endereço do arquivo principal

	//obtendo o objeto vindo de um request de um form por exemplo
	server.use(bodyParser.urlencoded({extended: true}));//o parametro extended com o valor true, serve pro parser compreender formularios complexos
	server.use(bodyParser.json());//fazendo a aplicação permitir receber json
	server.use(expressValidator())//fazendo a plicaço utilizador o validator para requisições
	//pré carregamento de todos arquivos que estiverem na pasta 'routes'
	load('routes', {cwd : 'app'})//cwd restringe a busca dos arquivos para a pasta que está declarada nele
	.then('infra')//carregamento posterior de arquivo
	//todos arquivos carregados ficaram estanciados na variavel server
	.into(server);

	return server;
}