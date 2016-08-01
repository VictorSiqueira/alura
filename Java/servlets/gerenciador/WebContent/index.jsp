<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> <!-- importando a taglib -->
<html>
<body>
<!-- esta obtendo da session, pois quado nao encontra no request,
 ele busca a variavel na session -->
<c:if test="${not empty usuarioLogado}">
	Logado como : ${usuarioLogado.email}
</c:if>
	Bem vindo ao nosso gerenciador de empresas!<br/>
	<form action="fazTudo?tarefa=NovaEmpresa " method="POST">
		<input type="text" name="nome"/>
		<input type="submit" value="Enviar"/>		
	</form>
	
	<form action="login " method="POST">
		<input type="email" name="email"/>
		<input type="password" name="senha"/>		
		<input type="submit" value="Enviar"/>		
	</form>
	
	<form action="fazTudo" method="POST">
		<input type="hidden" name="tarefa" value="Logout"/><!-- modo de mandar escondido -->
		<input type="submit" value="Logout"/>
	</form>
</body>
</html>