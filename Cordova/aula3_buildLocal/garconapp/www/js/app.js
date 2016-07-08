$(document).ready(function(){
	navigator.vibrate(3000);//vibração do plugin
})

$('.collection-item').on('click', function(){
	var badge = $('.badge', this); //busca elemento dentro do collection
	if(badge.length == 0){
	 	badge = $('<span class="badge brown-text">0</span>').appendTo(this);
	}
	badge.text(parseInt(badge.text()) +1);//adicionando +1 ao pedido 

	//TOAST do materialize (valor, tempo milisegundos)
	var nomeProduto = this.firstChild.textContent;
	Materialize.toast(nomeProduto + ' adicionado', 1000);
});

/*itera em cima de todos elementes que tiverem a classe badge para 
	obter o valor das divs parents e assim escrever no final os valores
	corretos do pedido
*/
$('#confirmar').on('click', function(){
	var texto = '';
	$('.badge').parent().each(function(){
		var produto = this.firstChild.textContent;
		var quantidade = this.lastChild.textContent;

		texto += produto+': '+quantidade; 
		console.log(texto);
	})
	$('#resumo').text('Os produtos selecionados são:'+texto);
});

//remover o valor do badge quando clicado no numero
$('.collection').on('click', '.badge', function(){
	$(this).remove();
	return false;
});

//limpar todos os badges
$('.acao-limpar').on('click', function(){
	$('#numeroMesa').val('');
	$('.badge').remove();
})

//para inicializar e tornar disponivel o modal do materialize
$('.modal-trigger').leanModal();

$('.scan-qrcode').click(function(){
	if(typeof cordova !== 'undefined'){
		cordova.plugins.barCodeScanner.scan(function(result){
			if(result.text){
				Materialize.toast('Mesa '+result.text,2000);
				$('#numeroMesa').val(result.text);
			}
		}, function (erro) {
			Materialize.toast('Função não suportada. Erro: '+erro,2000, 'red-text');//mostra com cor a mensagem
		});	
	}else{
		Materialize.toast('Função não suportada. Erro: 404-cordova-barCodeScanner',2000);
	}
	
});

$('.acao-finalizar').on('click', function() {
	//https://github.com/sergiolopes/cozinhapp
   $.ajax({
        url: 'http://cozinhapp.sergiolopes.org/novo-pedido',
        data: {
            mesa: $('#numeroMesa').val(),
            pedido: $('#resumo').text()
        },
        error: function(erro) {
           Materialize.toast(erro.responseText, 3000, 'red-text');
        },
        success: function(dados) {
            Materialize.toast(dados, 2000);
            $('#numeroMesa').val('');
            $('.badge').remove();
        }
    }); 
});