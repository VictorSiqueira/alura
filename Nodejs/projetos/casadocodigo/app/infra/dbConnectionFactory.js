// conexao mysql;
var mysql = require('mysql');

function createDBConnection(){
	console.log('conexao com DB');
	return  mysql.createConnection({
				host : "localhost",
				user: "root",
				password: "",
				database : "nodejs"
			});
}

//wrapper
module.exports = function(){
	return createDBConnection;
}