<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>

<head>
<title>One Gift | Home</title>
<link rel="icon" type="image/png"
	href="https://i.postimg.cc/mZzv5Z2r/gift.png" />
</head>

<body id="page-top">
	<%@ include file="./layout/Header.jsp"%>

	<div class="darker">

		<!-- Carousel-->
		<header class="masthead">
			<div class="container">

				<div class="masthead-subheading">Regalá una caja de regalos</div>
				<div class="masthead-heading text-uppercase">Llena de
					experiencias</div>
				<a class="btn btn-primary btn-xl text-uppercase js-scroll-trigger"
					href="#cajas">VER MÁS</a>

			</div>
		</header>

	</div>

	<section class="page-section" id="cajas">
		<div class="container">
			<div class="text-center">
				<h2 class="section-heading text-uppercase">Cajas de regalo</h2>
				<h3 class="section-subheading text-muted">Seleccioná una caja y
					descubrí todas sus experiencias</h3>		
			</div>
			
			<div class="row row-cols-1 row-cols-md-3 g-4">
				<c:forEach items="${cajas}" var="caja">
					<div class="col mt-5">
						<div class="card">
							<div class="card-img">
								<form:form method="POST" action="mostrarCaja"
									modelAttribute="CajaDeRegalo" class="form-container">
									<form:hidden path="numeroDeCaja" value="${caja.numeroDeCaja}" />
									<form:button type="submit" class="form-btn">
										<img src="${caja.imagen}" class="card-img-top img-fluid form-img">
									</form:button>
								</form:form>
							</div>
							<div class="card-body">
								<h5 class="card-title">${caja.nombre}</h5>
								<p class="card-text">${caja.descripcion}</p>
							</div>
							<div class="card-footer">
								<form:form method="POST" action="mostrarCaja"
									modelAttribute="CajaDeRegalo">
									<form:hidden path="numeroDeCaja" value="${caja.numeroDeCaja}" />
									<form:button class="btn btn-primary btn-lg w-100" type="submit">Ver regalos</form:button>
								</form:form>
							</div>
						</div>
					</div>
				</c:forEach>

			</div>
		</div>
	</section>

	<!-- Pasos-->
	<section class="page-section" id="services">
		<div class="container">
			<div class="text-center">
				<h2 class="section-heading text-uppercase">Pasos</h2>
				<h3 class="section-subheading text-muted">Pasos a seguir para
					realizar un regalo</h3>
			</div>
			<div class="row text-center">
				<div class="col-md-4">
					<span class="fa-stack fa-4x"> <i
						class="fas fa-circle fa-stack-2x text-primary"></i> <i
						class="fas fa-mouse-pointer fa-stack-1x fa-inverse"></i>
					</span>
					<h4 class="my-3">Elegir</h4>
					<p class="text-muted">Seleccioná una caja de regalo llena de
						experiencias</p>
				</div>
				<div class="col-md-4">
					<span class="fa-stack fa-4x"> <i
						class="fas fa-circle fa-stack-2x text-primary"></i> <i
						class="fas fa-envelope fa-stack-1x fa-inverse"></i>
					</span>
					<h4 class="my-3">Enviar</h4>
					<p class="text-muted">Completá el correo electrónico del
						beneficiario para enviárselo</p>
				</div>
				<div class="col-md-4">
					<span class="fa-stack fa-4x"> <i
						class="fas fa-circle fa-stack-2x text-primary"></i> <i
						class="fas fa-gift fa-stack-1x fa-inverse"></i>
					</span>
					<h4 class="my-3">Disfrutar</h4>
					<p class="text-muted">El beneficiaro elige una experiencia de
						la caja para canjear</p>
				</div>
			</div>
		</div>
	</section>

	<%@ include file="./layout/footer.jsp"%>
	<script src="js/home.js"></script>

</body>
</html>
