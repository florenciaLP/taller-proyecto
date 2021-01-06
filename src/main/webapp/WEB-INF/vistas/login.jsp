<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<link href="css/registrarse.css" rel="stylesheet">
<title>Iniciar sesión | One Gift</title>
<link rel="icon" type="image/png" href="https://i.postimg.cc/mZzv5Z2r/gift.png" />
</head>
<body>
	<%@ include file="./layout/Header.jsp"%>

	<div class="main">

		<section class="sign">
			<div class="container">
				<div class="signup-content">

					<form:form method="POST" action="validar-login"
						modelAttribute="usuario" id="signup-form" class="signup-form">

						<h2 class="masthead-heading text-uppercase">Hola!</h2>
						<h6 class="masthead-subheading text-center">Continúa haciendo y recibiendo regalos</h6>

				
						<c:if test="${not empty error}">
							<h6>
								<span class="text-warning">${error}</span>
							</h6>
							<br>
						</c:if>

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
							<button class="form-submit btn btn-primary w-50" type="submit"
								name="submit" id="submit" />
							Iniciar sesión
							</button>
						</div>
					</form:form>
					<p class="loginhere">
						¿No te registraste? <a href="registrarse" class="loginhere-link">Darse de alta</a>
					</p>
				</div>
			</div>
		</section>

	</div>

	<%@ include file="./layout/Footer.jsp"%>

	<!-- JS -->
	<script src="js/bootstrap.min.js" type="text/javascript"></script>
	<script src="js/iniciarSesion.js" type="text/javascript"></script>
</body>
</html>
