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