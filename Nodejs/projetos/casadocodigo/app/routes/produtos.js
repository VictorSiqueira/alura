module.exports = function(server){//modulo pode ser parametrizado
	server.get('/produtos', function(req, res){
		//res.send('<html><body>Listagem de produtos</body></html>');
		
		// conexao mysql;
		var mysql = require('mysql');
		var connection = mysql.createConnection({
			host : "localhost",
			user: "root",
			password: "",
			database : "teste"
		});

		//a funcao de query recebe um statement e um callback com o primeiro parametro sendo o erro e o result o segundo SEMPRE
		//connection.query('Select * from livros', function(error, result){
			//res.send(result);//envia apenas o json;
			var result = [{id : 1, titulo: "nome 1", descricao : "descricao 1", preco : 0.15},{id : 2, titulo: "nome 2", descricao : "descricao 2", preco : 153}]
			res.render("index", {lista: result});//chamada do arquivo e passagem de variaveis que serão utilizadas no template gerado
		//});

		//connection.end();
	})
}