<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<link href="css/registrarse.css" rel="stylesheet">
<title>Registrarse | One Gift</title>
<link rel="icon" type="image/png" href="https://i.postimg.cc/mZzv5Z2r/gift.png" />
</head>
<body>
	<%@ include file="./layout/Header.jsp"%>

	<div class="main">

		<section class="sign">
			<div class="container">
				<div class="signup-content">

					<form:form method="POST" action="validar-registro"
						modelAttribute="usuario" id="signup-form" class="signup-form">

						<h2 class="masthead-heading text-uppercase">Registrarse</h2>
						<h6 class="masthead-subheading text-center">Empezá a enviar y
							recibir regalos</h6>

						<%--Bloque que es visible si el elemento error no estÃ¡ vacÃ­o	--%>
						<c:if test="${not empty error}">
							<h6>
								<span class="text-warning">${error}</span>
							</h6>
							<br>
						</c:if>

						<div class="form-group">
							<form:input path="nombre" type="text" class="form-input"
								name="name" id="name" placeholder="Nombre" required="" />
						</div>
						<div class="form-group">
							<form:input path="apellido" type="text" class="form-input"
								name="apellido" id="apellido" placeholder="Apellido" required="" />
						</div>
						<div class="form-group">
							<form:input path="nombreUsuario" type="text" class="form-input"
								name="username    " id="username"
								placeholder="Nombre de usuario" required="" />
						</div>
						<div class="form-group">
							<form:input path="email" class="form-input" name="email"
								id="email" placeholder="Email" required="" />
						</div>
						<div class="form-group">
							<form:input path="password" type="password" class="form-input"
								name="password" id="password" placeholder="Contraseña"
								required="" />
							<span toggle="#password"
								class="zmdi zmdi-eye field-icon toggle-password"><i
								class="far fa-eye toggle-icon"></i></span>
						</div>
						<div class="form-group d-flex justify-content-center">
							<button class="form-submit btn btn-primary w-50 " type="submit"
								name="submit" id="submit" />
							Registrarse
							</button>
						</div>
					</form:form>
					<p class="loginhere">
						¿Ya tienes una cuenta? <a href="entrar" class="loginhere-link">Iniciar
							sesión</a>
					</p>
				</div>
			</div>
		</section>

	</div>

	<%@ include file="./layout/footer.jsp"%>

	<!-- JS -->
	<script src="js/iniciarSesion.js" type="text/javascript"></script>
</body>
</html>
