<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Perfil | One Gift</title>
<link rel="icon" type="image/png" href="https://i.postimg.cc/mZzv5Z2r/gift.png" />
<link href="css/nuevoPerfil.css" rel="stylesheet">
</head>

<body class="profile-page sidebar-collapse">

	<%@ include file="./layout/Header.jsp"%>


	<div class="wrapper">
		<div class="page-header clear-filter">
			<div class="page-header-image" data-parallax="true"
				style="background-image: url('https://images.unsplash.com/photo-1557053819-aa6046add523?ixlib=rb-1.2.1&amp;ixid=eyJhcHBfaWQiOjEyMDd9&amp;auto=format&amp;fit=crop&amp;w=889&amp;q=80');">
			</div>
			<div class="container">
				<div class="photo-container">
					<img
						src="https://lh3.googleusercontent.com/proxy/QLT_YEwY0np6TLIMtoZl8SUzXmOFcSLFf75CJpf43IBAPD9RvF4SV4Th__IiV_nIr-spr5NMt2Y6m7ziPYeSSKJhXmxrG84kCn3Pj7BhMPv6sPZL257ArsLpxZiN7YUJtMu70hU"
						alt="">
				</div>
				<h4 class="title">${usuario.nombreUsuario}</h4>
				<p class="category">${usuario.email}</p>
				<div class="content">
					<div class="social-description">
						<h2>
							<c:if test="${not empty cantHechos}">
								<i>${cantHechos}</i>
							</c:if>
						</h2>
						<p>Hechos</p>
					</div>
					<div class="social-description">
						<h2>
							<c:if test="${not empty cantRecibido}">
								<i>${cantRecibido}</i>
							</c:if>
						</h2>
						<p>Recibidos</p>
					</div>
				</div>
			</div>
		</div>
	</div>



	<c:if test="${not empty error}">
		<h6>
			<span class="text-warning">${error}</span>
		</h6>
		<br>
	</c:if>


	<div>
		<div class="wrapper">
			<c:if test="${not empty listaHechos}">
				<ul class="menu">
					<div class="head">Regalos Hechos</div>
					<ul>
						<c:forEach items="${listaHechos}" var="regaloHecho">
							<form:form method="POST" action="mostrarCaja"
								modelAttribute="CajaDeRegalo">
								<form:hidden path="numeroDeCaja"
									value="${regaloHecho.cajaDeRegalo.numeroDeCaja}" />
								<li class="container">
									<div class="proPic margin-top-propic">
										<img class="margin-top-img"
											src="${regaloHecho.cajaDeRegalo.imagen}" />
									</div>
									<div class="info">
										<h3>Caja: ${regaloHecho.cajaDeRegalo.nombre}</h3>
										<div class="social">
											<div>
												<i class="fas fa-user"></i><span class="text">Para:
													${regaloHecho.emailDestinatario}</span>
											</div>
											<br>
											<div>
												<i class="fas fa-calendar-day"></i><span class="text">Fecha:
													${regaloHecho.fechaRegistro}</span>
											</div>
											<br>
											<form:button type="submit" class="btn btn-primary">VER CAJA</form:button>
										</div>
									</div>
								</li>
							</form:form>
						</c:forEach>
						<br>
					</ul>
				</ul>
			</c:if>

			<c:if test="${not empty listaRecibido}">
				<ul class="menu">
					<div class="head">Regalos Recibidos</div>
					<ul>
						<c:forEach items="${listaRecibido}" var="regaloRecibido">
							<form:form method="POST" action="canjearRegalo"
								modelAttribute="Regalo">
								<form:hidden path="id" value="${regaloRecibido.id}" />
								<li class="container">
									<div class="proPic" style="height: 4rem;">
										<img style="margin-top: -6.5rem;"
											src="${regaloRecibido.cajaDeRegalo.imagen }" />
									</div>
									<div class="info">
										<h3>Regalo: ${regaloRecibido.cajaDeRegalo.nombre}</h3>
										<div class="social">
											<div>
												<i class="fas fa-user"></i><span class="text">De:
													${regaloRecibido.regalador.nombre}</span>
											</div>
											<br>
											<div>
												<i class="fas fa-ticket-alt"></i><span class="text">Cupón:
													${regaloRecibido.cupon}</span>
											</div>
											<br>
											<form:button type="submit" class="btn btn-primary">CANJEAR</form:button>
										</div>
									</div>
								</li>
							</form:form>
						</c:forEach>
					</ul>
				</ul>
			</c:if>

			<c:if test="${not empty listaCanjeados}">
				<ul class="menu">
					<div class="head">Experiencias Canjeadas</div>
					<c:forEach items="${listaCanjeados}" var="regaloCanjeado">
						<li class="container">
							<div class="proPic">
								<img src="${regaloCanjeado.imagen }" />
							</div>
							<div class="info">
								<h3>Experiencia: ${regaloCanjeado.nombre }</h3>
								<c:choose>

									<c:when test="${regaloCanjeado.meGusta}">
										<form:form method="POST" action="cambiarMeGusta"
											modelAttribute="Experiencia">
											<form:hidden path="id" value="${regaloCanjeado.id}" />
											<form:button class="like-btn" type="submit">
												<i class="fas fa-heart"></i>
											</form:button>
										</form:form>
									</c:when>

									<c:otherwise>
										<form:form method="POST" action="cambiarMeGusta"
											modelAttribute="Experiencia">
											<form:hidden path="id" value="${regaloCanjeado.id}" />
											<form:button class="like-btn" type="submit">
												<i class="far fa-heart"></i>
											</form:button>
										</form:form>
									</c:otherwise>

								</c:choose>


								<div class="social">
									<div>
										<i class="fas fa-gift"></i><span class="text">Tipo:
											${regaloCanjeado.cajaDeRegalo.nombre}</span>
									</div>
								</div>
							</div>
						</li>
					</c:forEach>
				</ul>
			</c:if>
		</div>
	</div>

	<%@ include file="./layout/Footer.jsp"%>

	<script>
		(function($) {
			var tabs = $(".tabs li a");
			tabs.click(function() {
				var content = this.hash.replace('/', '');
				tabs.removeClass("active");
				$(this).addClass("active");
				$("#content").find('p').hide();
				$(content).fadeIn(200);
			});
		})(jQuery);
	</script>
</body>
</html>