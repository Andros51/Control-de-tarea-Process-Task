<%-- 
    Document   : A_tareas_rechazadas
    Created on : 27-11-2021, 22:41:12
    Author     : diego
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <link href="css/estilos.css" rel="stylesheet" type="text/css"/>
        <!-- Required meta tags -->
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">

        <!-- Bootstrap CSS -->
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">

        <title>Process Task</title>
    </head>
    <body>
        <nav class="navbar navbar-expand-lg navbar-dark bg-dark">
            <div class="container-fluid">
                <a class="navbar-brand" href="#">Process Task S.A</a>
                <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
                    <span class="navbar-toggler-icon"></span>
                </button>
                <div class="collapse navbar-collapse" id="navbarNav">
                    <ul class="navbar-nav">
                        <li class="nav-item dropdown">
                            <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-bs-toggle="dropdown" aria-expanded="false">
                                Tareas
                            </a>
                            <ul class="dropdown-menu" aria-labelledby="navbarDropdown">
                                <li><a class="dropdown-item" href="Controladora?accion=Listar_t_r_f">Tareas realizadas</a></li>
                                <li><a class="dropdown-item" href="Controladora?accion=Listar_t_p_f2">Tareas en proceso</a></li>
                                <li><a class="dropdown-item" href="Controladora?accion=Listar_t_re_f">Tareas Rechazadas</a></li>
                                <li><a class="dropdown-item" href="Controladora?accion=Listar_t_es_f">Tareas en espera</a></li>
                            </ul>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link active" aria-current="page" href="Controladora?accion=Salir">Salir</a>
                        </li>
                    </ul>
                </div>
            </div>
        </nav>


        <div class="container mt-5">
            <div class="table-responsive">
                <h3 class="text-center mb-3">Tareas rechazadas</h3>
                <table id="tabla-u"  class="table table-bordered table-hover table-striped">
                    <thead>
                        <tr class="bg-dark text-white">
                            <th scope="col">ID tarea</th>
                            <th scope="col">Descripcion</th>
                            <th scope="col">Fecha inicio</th>
                            <th scope="col">Fecha termino</th>
                            <th scope="col">Estado</th>
                            <th scope="col">Justificacion</th>
                            <th scope="col">Id diseñador</th>
                            <th scope="col">id usuario</th>

                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach var="dato" items="${datos}">
                            <tr>
                                <td data-label="Id"> <span id="idT">${dato.getId_tarea()}</span></td>
                                <td data-label="Descripcion"><span id="idT">${dato.getDescripcion()}</span></td>
                                <td data-label="Nombre"><span id="Fini">${dato.getFecha_inicio()}</span></td>
                                <td data-label="Username"><span id="Fter"> ${dato.getFecha_termino()}</span></td>
                                <td data-label="Username"><span id="Est"> ${dato.getEstado_tarea()}</span></td>
                                <td data-label="Estado"><span id="Pava">${dato.getJustificacion()}</span></td>
                                <td data-label="Username"><span id="IdDi"> ${dato.getId_desenador()}</span></td>
                                <td data-label="Estado"><span id="IdUs">${dato.getId_usuario()}</span></td>
                            </tr>
                        </c:forEach>
                    </tbody>
                </table>
            </div>
        </div>





        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>

        <!-- Option 2: Separate Popper and Bootstrap JS -->
        <!--
        <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.10.2/dist/umd/popper.min.js" integrity="sha384-7+zCNj/IqJ95wo16oMtfsKbZ9ccEh31eOz1HGyDuCQ6wgnyJNSYdrPa03rtR1zdB" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.min.js" integrity="sha384-QJHtvGhmr9XOIpI6YVutG+2QOK9T+ZnN4kzFN1RtK3zEFEIsxhlmWl5/YESvpZ13" crossorigin="anonymous"></script>
        -->

    </body>
</html>