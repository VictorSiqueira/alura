//usando a lib nodemon, o server será startado com ele e pegara qualquer alteração que for realizada no projeto
var express = require('express');
var server = express();

/*satando o ejs no servidor, nao achei muito bacana, 
pois aparentemento substitui todos os aruivos html para a extensao ejs. fica parecendo jsp do java
o que faz a aplicação ficar amarrada e nao modular*/
server.set('view engine', 'ejs');


server.get('/produtos', function(req, res){
	//res.send('<html><body>Listagem de produtos</body></html>');
	res.render("index");//chamada do arquivo
})

server.listen(3000, function(){
	console.log('Server ready!');
})