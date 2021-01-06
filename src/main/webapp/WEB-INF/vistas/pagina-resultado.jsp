<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Resultado | One Gift</title>
<link rel="icon" type="image/png" href="https://i.postimg.cc/mZzv5Z2r/gift.png" />
<link href="css/pagina-resultado.css" rel="stylesheet">
</head>
<body>

	<%@ include file="./layout/Header.jsp"%>


	<div class="container mt-5 pt-5 mb-5">
		<div class="main-body">
			<div class="row gutters-sm"></div>
		</div>
	</div>

	<c:if test="${not empty ok}">

		<div
			class="d-flex justify-content-center align-items-center flex-column contenedor-error">
			<div class="icon-result ok mt-3">
				<svg viewBox="0 0 32 32" style="fill: #48DB71">
								<path d="M1 14 L5 10 L13 18 L27 4 L31 8 L13 26 z"></path></svg>
			</div>
			<h1>Felicidades!</h1>
			<p>Se ha realizado la operación con éxito</p>
			<p class="mt-5">${ok}</p>

		</div>


	</c:if>

	<c:if test="${not empty error}">

		<div
			class="d-flex justify-content-center align-items-center flex-column contenedor-error">
			<div class="icon-result mt-3">
				<svg class="svg-icon" viewBox="0 0 20 20" style="fill: #ff0000;">
							<path
						d="M15.898,4.045c-0.271-0.272-0.713-0.272-0.986,0l-4.71,4.711L5.493,4.045c-0.272-0.272-0.714-0.272-0.986,0s-0.272,0.714,0,0.986l4.709,4.711l-4.71,4.711c-0.272,0.271-0.272,0.713,0,0.986c0.136,0.136,0.314,0.203,0.492,0.203c0.179,0,0.357-0.067,0.493-0.203l4.711-4.711l4.71,4.711c0.137,0.136,0.314,0.203,0.494,0.203c0.178,0,0.355-0.067,0.492-0.203c0.273-0.273,0.273-0.715,0-0.986l-4.711-4.711l4.711-4.711C16.172,4.759,16.172,4.317,15.898,4.045z"></path>
						</svg>
			</div>
			<h1>Opps,</h1>
			<p>ha ocurrido un error</p>
			<p class="mt-5">
				<b>Causa:</b> ${error}
			</p>
			<c:if test="${not empty boton}">

				<a class="mt-5 btn btn-primary btn-xl p-2 pl-5 pr-5 font-weight-bold" href="${boton }"> ${boton}</a>
			</c:if>
		</div>


	</c:if>	
	
</body>
</html>