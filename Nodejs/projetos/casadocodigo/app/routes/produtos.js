//var dbConnection = require('../infra/dbConnectionFactory');

module.exports = function(server){//modulo pode ser parametrizado, porem usando com o express-load fiquei em duvida como o parametro é carregado
	server.get('/produtos', function(req, res){
		//res.send('<html><body>Listagem de produtos</body></html>');
		var connection = server.infra.dbConnectionFactory();

		//usar o modficador new gera um novo escopo para o objto a srr chamado
		//pq por defaul ele assume o escopo de que o chama
		var ProdutosDAO = new server.infra.ProdutosDAO(connection); 

		ProdutosDAO.lista(function(error, result){
			res.render("index", {lista: result});
		});

		connection.end();
	});

	server.get('produtos/remove', function(){
		var ProdutosDAO = server.infra.ProdutosDAO(connection);
		var produto = ProdutosDAO.carrega(id, callback);
		if(produto){
			ProdutosDAO.remove(produto, callback);
		}
	});
}