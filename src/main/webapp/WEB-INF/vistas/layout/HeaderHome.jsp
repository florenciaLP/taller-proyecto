<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<header>

	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


	<nav class="navbar navbar-expand-lg navbar-dark fixed-top darkNav"
		id="mainNav">
		<div class="container">
			<a class="navbar-brand js-scroll-trigger" href="#page-top"><img
				src="assets/img/navbar-logo.svg" alt="" /></a>
			<button class="navbar-toggler navbar-toggler-right" type="button"
				data-toggle="collapse" data-target="#navbarResponsive"
				aria-controls="navbarResponsive" aria-expanded="false"
				aria-label="Toggle navigation">
				Menu <i class="fas fa-bars ml-1"></i>
			</button>
			<div class="collapse navbar-collapse" id="navbarResponsive">
				<ul class="navbar-nav text-uppercase ml-auto">
					<li class="nav-item"><a class="nav-link js-scroll-trigger"
						href="home">Inicio</a></li>
					<li class="nav-item"><a class="nav-link js-scroll-trigger"
						href="/Regalo/perfil">Perfil</a></li>
					<ul class="navbar-nav ml-auto">
						<li class="nav-item d-flex justify-content-center">
								<c:if test="${not empty IDUSUARIO}">
									<<a class="nav-link h5 ml-5"
										href="profile?username=${USERNAME}">${USERNAME}</a>
									<a class="nav-link h5 font-weight-bold" href="logout">|
										Logout</a>
								</c:if>
								<c:if test="${empty IDUSUARIO}">
									<a class="nav-link h5 ml-5 font-weight-bold" href="entrar">Iniciar
										sesión</a>
								</c:if>
						</li>
					</ul>
				</ul>
			</div>

		</div>
	</nav>

</header>