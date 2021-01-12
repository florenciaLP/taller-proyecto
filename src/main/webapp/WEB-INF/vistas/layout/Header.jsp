<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link href="css/bootstrap.min.css" rel="stylesheet">
<link href="css/header.css" rel="stylesheet">
<link href="css/style.css" rel="stylesheet">

<script src="https://kit.fontawesome.com/222a3ac483.js"
	crossorigin="anonymous"></script>

<!-- Google fonts-->
<link href="https://fonts.googleapis.com/css?family=Montserrat:400,700"
	rel="stylesheet" type="text/css" />
<link
	href="https://fonts.googleapis.com/css?family=Droid+Serif:400,700,400italic,700italic"
	rel="stylesheet" type="text/css" />
<link
	href="https://fonts.googleapis.com/css?family=Roboto+Slab:400,100,300,700"
	rel="stylesheet" type="text/css" />
</head>
<body>

	<header>

		<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

		<nav class="navbar navbar-expand-lg navbar-dark fixed-top darkNav"
			id="mainNav">

			<div class="container">
				<a class="navbar-brand js-scroll-trigger" href="/Regalo/home"
					id="logo">One Gift</a>

				<button class="navbar-toggler navbar-toggler-right" type="button" data-toggle="collapse" data-target="#navbarResponsive"
					aria-controls="navbarResponsive" aria-expanded="false" aria-label="Toggle navigation">
					Menu <i class="fas fa-bars ml-1"></i>
				</button>

				<div class="collapse navbar-collapse" id="navbarResponsive">
					<ul class="navbar-nav text-uppercase ml-auto">

						<li class="nav-item"><a class="nav-link js-scroll-trigger"
							href="home">Inicio</a></li>
						<li class="nav-item"><a class="nav-link js-scroll-trigger"
							href="/Regalo/perfil">Perfil</a></li>

						<ul class="navbar-nav ml-auto mt-1">
							<li class="nav-item d-flex justify-content-center"><c:if
									test="${not empty IDUSUARIO}">
									<a class="nav-link h5 ml-5" href="perfil">${USERNAME}</a>
									<a class="nav-link h5 font-weight-bold" href="logout">|
										Logout</a>
								</c:if> <c:if test="${empty IDUSUARIO}">
									<a class="nav-link h5 ml-5 font-weight-bold" href="entrar">Iniciar
										sesión</a>
								</c:if></li>
						</ul>

					</ul>
				</div>
			</div>
		</nav>
	</header>

</body>
</html>