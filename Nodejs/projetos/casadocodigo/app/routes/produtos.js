//var dbConnection = require('../infra/dbConnectionFactory');

module.exports = function(server){//modulo pode ser parametrizado, porem usando com o express-load fiquei em duvida como o parametro é carregado
	var showListaProdutos = function (req, res){
		//res.send('<html><body>Listagem de produtos</body></html>');
		var connection = server.infra.dbConnectionFactory();

		//usar o modficador new gera um novo escopo para o objto a srr chamado
		//pq por defaul ele assume o escopo de que o chama
		var ProdutosDAO = new server.infra.ProdutosDAO(connection); 

		ProdutosDAO.lista(function(error, result){
			//especificando o retorno a partir do headers de quem solicitou
			res.format({
				// caso estejam requerindo um html
				html: function(){
					res.render("index", {lista: result});
				},
				json: function(){
					res.json(result);
				}
			})
		});

		connection.end();//encerramento da conexao com o BD
	};

	server.get('/produtos', showListaProdutos);

	server.get('/produtos/form', function(req,res){
		res.render('form', {errosValidacao: {}, produto: {}});
	});

	server.post('/produtos/salva', function(req,res){
		var produto = req.body;//os objetos que estao sendo enviados de um form vem no body mas necessita da lib body-parser;

		//testando o objeto vindo da tela, com o plugin express-validator
		//primeiro parametro é o atributo a ser testado e o segundo é a mensagem em caso de erro
		//validação para verificar nulo usando o express-validator
		req.assert('titulo','Titulo é obrogatório').notEmpty();
		req.assert('preco','preco é obrogatório').isFloat();
		//verificação de gereção de erros pelas validações do express-validator, que é armazenado na requisição
		var erros = req.validationErrors();

		if(erros){
			res.format({
				// caso estejam requerindo um html
				html: function(){
					// erro 400 de Bad Request
					res.status(400).render('form', {errosValidacao: erros, produto, produto});//vale lembrar que nao é a url e sim o arquivo no diretorio
				},
				json: function(){
					res.status(400).json(erros);
				}
			})

			return // pra cortar a execução do codigo
		}

		var connection = server.infra.dbConnectionFactory();
		var produtosDAO = new server.infra.ProdutosDAO(connection);
		produtosDAO.salva(produto, function(error, result){
			res.redirect('/produtos');//redirecionamento
		});
	});

	/*server.get('/produtos/remove', function(){
		var ProdutosDAO = server.infra.ProdutosDAO(connection);
		var produto = ProdutosDAO.carrega(id, callback);
		if(produto){
			ProdutosDAO.remove(produto, callback);
		}
	});*/
}