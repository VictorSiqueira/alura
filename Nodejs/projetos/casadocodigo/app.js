/*usando a lib nodemon, o server será startado com ele e pegara qualquer alteração que for realizada no projeto*/

//modularizacao de um aplicação js
var server = require('./config/expressConfig')()//esse parenteses funciona como um disparo de função
var rota_produtos = require('./app/routes/produtos')(server);

server.listen(3000, function(){
	console.log('Server ready!');
})