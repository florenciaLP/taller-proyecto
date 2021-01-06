<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>Caja de Regalo</title>
		<link href="css/bootstrap.min.css" rel="stylesheet">
		<link href="css/Style.css" rel="stylesheet">
	</head>
	<%@ include file="./layout/Header.jsp"%>
	<body>
		<div class="container mr-5">
			<div id="loginbox" style="margin-top: 50px;" class="mainbox col-md-6 col-md-offset-3 col-sm-8 col-sm-offset-2">			
				<form:form action="crear-cajaDeRegalo" method="POST" modelAttribute="cajaDeRegalo">
					<h3 class="form-signin-heading">Caja de Regalo</h3>
					<hr class="colorgraph">
					<br>
					<form:input path="nombre"  type="text"  		placeholder="nombre" class="form-control" />
					<form:input path="descripcion"  type="text"  	placeholder="descripcion" class="form-control" />
					<form:input path="precio"  type="number"  		placeholder="precio" class="form-control" />
					<form:input path="cantidadPersonas"  type="number"  placeholder="cantidad de personas" class="form-control" />
					<form:input path="imagen"  type="text"  		placeholder="url:imagen" class="form-control" />
					<br>
					<button class="btn btn-lg btn-primary btn-block m-5" Type="Submit" />Crear</button>
				</form:form>
			</div>
		</div>
	</body>
	<%@ include file="./layout/Footer.jsp"%>
	<script src="js/jquery-3.5.1.min.js"></script>
	<script src="js/bootstrap.min.js"></script>
</html>