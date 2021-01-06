<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<title>One Gift | Home</title>
<link href="css/bootstrap.min.css" rel="stylesheet">
<link href="css/Style.css" rel="stylesheet">
</head>
<%@ include file="./layout/Header.jsp"%>
<body>

	<div class="container">
		<h1>${usuario.nombreUsuario }</h1>
	</div>

<%@ include file="./layout/Footer.jsp"%>

	<script src="js/jquery-3.5.1.min.js"></script>
	<script src="js/bootstrap.min.js"></script>
</body>
</html>
