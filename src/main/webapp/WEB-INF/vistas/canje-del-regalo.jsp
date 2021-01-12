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
					<p>
						<i class="fas fa-users mr-2"></i><b>Personas:</b>
						${caja.cantidadPersonas}
					</p>
					<p>
						<i class="fas fa-gift mr-2"></i><b>Hecho por:</b>
						${Regalo.regalador.nombre}
					</p>
					<p>
						<i class="fas fa-comment mr-2"></i><b>Mensaje:</b>
						${Regalo.mensaje}
					</p>
				</div>
			</div>
		</div>
	</div>

	<hr>

	<div class="container contenedor text-center">
		<div class="masthead-heading mt-1">Experiencias de la caja</div>
		<h1 class="text-info">${caja.nombre}</h1>

		<div id="carousel1" class="carousel slide carousel-fade mt-4"
			data-ride="carousel">
			<div class="carousel-inner">
				<div class="carousel-item active">
					<svg class="bd-placeholder-img bd-placeholder-img-lg d-block w-100"
						width="800" height="400" xmlns="http://www.w3.org/2000/svg"
						preserveAspectRatio="xMidYMid slice" focusable="false" role="img"
						aria-label="Placeholder: Primer slide">
					<rect width="100%" height="100%" fill="#5bc0de"></rect>
					<text x="13%" y="50%" fill="#eceff1" dy="0.3em" font-size="3em">ELEGÍ TU EXPERIENCIA FAVORITA</text></svg>
				</div>

				<c:forEach items="${experiencias}" var="exp">
					<div class="carousel-item">

						<form:form method="POST" action="elegirExperiencia"
							modelAttribute="experienciaForm">
							<div class="d-flex justify-content-center">
								<form:hidden path="idRegalo" value="${Regalo.id }" />
								<form:hidden path="idExp" value="${exp.id }" />
								<form:hidden path="cupon" value="${Regalo.cupon }" />
								<form:button type="submit"
									class="btn btn-success btn-xl w-100 my-2 canjear-btn">Confirmar Experiencia</form:button>
							</div>
						</form:form>
						<div class="image">
							<img src="${exp.imagen}"
								class="bd-placeholder-img bd-placeholder-img-lg d-block mx-auto rounded w-100 image"
								width="500" height="400px" xmlns="http://www.w3.org/2000/svg"
								preserveAspectRatio="xMidYMid slice" focusable="false"
								role="img">
						</div>
						<div class="carousel-caption d-none d-md-block">
							<h5>${exp.nombre }</h5>
							<div class="d-flex w-100 mx-auto">
								<p class="font-italic text-center w-100">${exp.descripcion }</p>
							</div>

						</div>
					</div>
				</c:forEach>

			</div>

			<!--Controles NEXT y PREV-->
			<a class="carousel-control-prev" href="#carousel1" role="button"
				data-slide="prev"> <span class="carousel-control-prev-icon"
				style="background-color: grey;" aria-hidden="true"></span> <span
				class="sr-only">Previous</span>
			</a> <a class="carousel-control-next" href="#carousel1" role="button"
				data-slide="next"> <span class="carousel-control-next-icon"
				style="background-color: grey;" aria-hidden="true"></span> <span
				class="sr-only">Next</span>
			</a>
			<!--Controles de indicadores-->
			<ol class="carousel-indicators">
				<li data-target="#carousel1" data-slide-to="0" class="active"></li>
				<li data-target="#carousel1" data-slide-to="1"></li>
				<li data-target="#carousel1" data-slide-to="2"></li>
				<li data-target="#carousel1" data-slide-to="3"></li>
				<li data-target="#carousel1" data-slide-to="4"></li>
				<li data-target="#carousel1" data-slide-to="5"></li>
				<li data-target="#carousel1" data-slide-to="6"></li>
			</ol>

		</div>

	</div>

	<%@ include file="./layout/footer.jsp"%>
</body>
</html>