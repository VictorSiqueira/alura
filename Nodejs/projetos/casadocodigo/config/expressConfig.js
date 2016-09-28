//modularização seguindo o padrão do CommonJS
module.exports = function(){
	//caso queria sempre manter a mesma versão dos parametros para todos que chamarem, bata por eles fora desta function

	var express = require('express');
	var server = express();

	/*satando o ejs no servidor, nao achei muito bacana, 
	pois aparentemento substitui todos os aruivos html para a extensao ejs. fica parecendo jsp do java
	o que faz a aplicação ficar amarrada e nao modular*/
	server.set('view engine', 'ejs');

	//indicação das views que o node vai procurar, quando voce utiliza em um local especifico
	server.set('views', './app/views');//esta com apenas um ponto no URI, pois é o endereço do arquivo principal
	return server;
}