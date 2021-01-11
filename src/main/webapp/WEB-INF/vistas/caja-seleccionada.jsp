<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<title>One Gift | Home</title>
<link rel="icon" type="image/png" href="https://i.postimg.cc/mZzv5Z2r/gift.png" />
<link href="css/stylecajaexp.css" rel="stylesheet">
</head>
<body>
	<%@ include file="./layout/Header.jsp"%>

<style>
#mainNav {
	background-color: #212529 !important;
}</style>
	<div class="container mt-5 pt-5">
		<div class="masthead-heading text-uppercase">Caja de regalo</div>
	</div>

	<div class="container mt-3">
		<div class="card-deck row">
			<div class="col-7">
				<img src="${caja.imagen}" class="card-img-top img-fluid">
			</div>
			<div class="col-5 pl-3 p-1 data-container">
				<div>
					<h3 class="text-uppercase">${caja.nombre}</h3>
					<p class="mt-4 font-weight-normal">${caja.descripcion}</p>
					<p class="mt-5">
						<i class="fas fa-dollar-sign mr-3"></i>Precio: <b>$${caja.precio}</b>
					</p>
					<p>
						<i class="fas fa-users mr-2"></i>Personas: <b>${caja.cantidadPersonas}</b>
					</p>
				</div>
				<div class="w-100 d-flex mt-5">
					<a class="btn btn-info btn-xl w-50 m-1" onclick="mostrar()"
						id="ver">Ver dentro</a> <a class="btn btn-danger btn-xl w-50 m-1"
						data-toggle="modal" data-target="#myModal" id="regalar">Regalar</a>
				</div>

			</div>
		</div>
	</div>


	<!-- MODAL -->
	<div class="modal fade" id="myModal" tabindex="-1" role="dialog"
		aria-labelledby="modal-register-label" aria-hidden="true">
		<div class="modal-dialog">
			<div class="modal-content">

				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal">
						<span aria-hidden="true">&times;</span><span class="sr-only">Close</span>
					</button>
					<h3 class="modal-title" id="modal-register-label">Hacer regalo</h3>
					<p>Completá los datos para enviar tu regalo</p>
				</div>

				<div class="modal-body">
					<form:form method="POST" action="hacerRegalo"
						modelAttribute="RegaloForm" class="form-inline registration-form">
						<div class="w-100">
							<div class="form-group w-100">
								<label for="form-email" class="mb-1">Email</label>
								<form:input path="email" placeholder="Email"
									class="form-email form-control w-100" id="form-email"
									required="" />
								<form:hidden path="idRegalador" value="${IDUSUARIO}" />
							</div>

							<div class="form-group w-100">
								<label for="mensaje" class="mt-4 mb-1">Mensaje</label>

								<form:textarea path="mensaje" name="mensaje"
								placeholder="Mensaje (Opcional)" class="mensaje form-control w-100"
								id="mensaje" maxlength="255"/> 
							</div>
						</div>

						<div class="d-flex justify-content-center w-100">

							<form:hidden path="numeroCajaDeRegalo"
								value="${caja.numeroDeCaja}" />
							<form:button type="submit"
								class="btn btn-primary text-uppercase js-scroll-trigger p-2 pl-5 pr-5 font-weight-bold"
								data-toggle="modal" data-target="#modalOk">Enviar</form:button>
						</div>
					</form:form>
				</div>
			</div>
		</div>
	</div>

	<hr>

	<div class="container-fluid contenedor text-center" id="experiencias">
		<div class="masthead-heading mt-1">Experiencias de la caja</div>
		<h1 class="text-info">${caja.nombre}</h1>
		<div
			class=" container-fluid d-flex row justify-content-center text-center">

			<c:forEach items="${experiencias }" var="experiencia">
				<div
					class="col-lg-3 col-md-3 col-sm-6 col-xs-12 m-2 container_foto ">
					<article class="text-left">
						<h2>${experiencia.nombre }</h2>
						<h4>${experiencia.descripcion }</h4>
					</article>
					<img src="${experiencia.imagen}" alt="">
				</div>
			</c:forEach>
		</div>
	</div>





	<%@ include file="./layout/Footer.jsp"%>
	<script src="js/experiencias.js"></script>
</body>
</html>
