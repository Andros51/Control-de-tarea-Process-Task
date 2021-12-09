
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=divice-width, initial-scale=1.0">
    <title>Document</title>
    <link href="css/login.css" rel="stylesheet" type="text/css"/>
    <script src="https://kit.fontawesome.com/946d6368af.js" crossorigin="anonymous"></script>
    <link rel="stylesheet" href="css/estilos.css">
</head>
<body>
   <div class="wrapper">
       <div class="title"><span>Inicio de sesion</span></div>
       <form action="Controladora">
           <div class="row">
               <i class="fas fa-user"></i>
               <input type="text" name="txtid" placeholder="Rut" required>
           </div>
           <div class="row">
               <i class="fas fa-lock"></i>
               <input type="password" name="txtcont" placeholder="Contraseña" required>
           </div>
           <div class="row button">
               <input type="submit" name="accion" value="Ingresar">
              
           </div>
       </form>
   </div>
    
</body>
</html>
