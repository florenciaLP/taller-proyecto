<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>  

<!DOCTYPE html>  
<html>  
<head>  
    <title>Regalo Form</title> 
    <link rel="icon" type="image/png" href="https://i.postimg.cc/mZzv5Z2r/gift.png" />
    <!-- Bootstrap core CSS -->
	    <link href="../css/bootstrap.min.css" rel="stylesheet" >
	    <!-- Bootstrap theme -->
	    <link href="../css/bootstrap-theme.min.css" rel="stylesheet">
	    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" integrity="sha384-JcKb8q3iqJ61gNV9KGb8thSsNjpSL0n8PARn9HuZOnIxN0hoP+VmmDGMN5t9UJ0Z" crossorigin="anonymous">
 
</head> 
<header>
<%@ include file="./layout/Header.jsp"%> 
</header>
  

<body>  
<div class = "container h3">
<div id="loginbox" style="margin-top:30px;" class="mainbox col-md-6 col-md-offset-3 col-sm-8 col-sm-offset-2">
<h4>Completa los datos para realizar tu regalo</h4>  
    <form:form action="submitForm" modelAttribute="regalo">  
    
        Nombre: <form:input class="form-control" path="nombre" />      
       
        Numero de Caja: <form:input class="form-control" path="numeroDeCaja" />  
         
        Descripcion: <form:input class="form-control" path="descripcion"/>  
        <br><br>  
        Precio que deseas gastar: <form:input path="precio"/>
        <br><br>
        Escoge tu regalo:
        <br><br>
        <div class="form-check form-check-inline">
        Restaurante<form:checkbox  path="categoria" value="Restaurante"/> 
        </div>
        <div class="form-check form-check-inline"> 
        Spa <form:checkbox  path="categoria" value="Spa"/> 
        </div>
        <div class="form-check form-check-inline"> 
        Cursos<form:checkbox  path="categoria" value="Cursos"/>  
    <br><br>
        <hr class="colorgraph"><br>
        </div>
        <input class="btn btn-lg btn-primary btn-block"  type="submit" value="Submit" /> 
        
    </form:form>
    </div>
    </div>  
    
    
   <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js" integrity="sha384-9/reFTGAW83EW2RDu2S0VKaIzap3H66lZH81PoYlFhbGU+6BZp6G7niu735Sk7lN" crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js" integrity="sha384-B4gt1jrGC7Jh4AgTPSdUtOBvfO8shuf57BaghqFfPlYxofvL8/KUEfYiJOMMV+rV" crossorigin="anonymous"></script> 
   </body>  
</html>  