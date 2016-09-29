function ProdutosDAO(connection){
	/*guardando atributo no construtor igual a java
	usar o undeline indica ao programador que o atributo 
	é privado e não é pra ser utilizado, mas iss é apenas convencionalmente*/
	this._connection = connection;
}

/*prototype é uma propriedade existente em todas classes JS 
que permite inserirmos valores e funções na estrutura do objeto, 
evitando que os valores sejam estanciados sempre dinamicamente*/
ProdutosDAO.prototype.lista = function(callback){
	//a funcao de query recebe um statement e um callback com o primeiro parametro sendo o erro e o result o segundo SEMPRE
	this._connection.query('Select * from livros',callback);
	/*connection.query('Select * from livros', function(error, result){
		//res.send(result);//envia apenas o json;
		res.render("index", {lista: result});//chamada do arquivo e passagem de variaveis que serão utilizadas no template gerado
	});*/
}

ProdutosDAO.prototype.salva = function(produto, callback){
	// o set insere um conjunto de valores e suas colunas, no caso o json identico
	//mas funciona bem parecido com o preparedStatement do jdbc
	this._connection.query('Insert into livros set ?', produto,callback);
}

module.exports = function(){
	//aninhamento para possibilitar o objeto receber o parametro na sua cri~ção, praticamente um construtor
	//foi feito dessa forma para que evite undefined durante o carregamento do express-load 
	return ProdutosDAO;
}