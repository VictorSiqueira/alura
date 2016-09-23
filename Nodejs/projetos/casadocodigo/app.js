var express = require('express');
var server = express();

server.get('/produtos', function(req, res){
	res.send('<html><body>Listagem de produtos</body></html>')
})

server.listen(3000, function(){
	console.log('Server ready!');
})