
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> <!-- importando a taglib -->
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Inshere</title>
</head>
<body>
	<ul>
	<!-- for ech em jSP da taglibs -->
		<c:forEach var="empresa" items="${empresas}">
			<li>${empresa.id} : ${empresa.nome}</li>
		</c:forEach>
	</ul>
</body>
</html>