<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:url value="/entrada" var="linkServetNovaEmpresa"/>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Formulario de Cadastro</title>
</head>
<body>
	<c:import url="logout-parcial.jsp"/>
	<form action=${linkServetNovaEmpresa} method="post">
		Nome: <input type="text" name="nome"/>
		Data Abertura: <input type="text" name="data"/>
		<input type= "hidden" name="acao" value="NovaEmpresa" />
		<input type="submit" />
	</form>
</body>
</html>