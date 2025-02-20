<%-- 
    Document   : index
    Created on : 6 jun 2024, 7:18:27
    Author     : Docente
--%>

<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ page session="true" %>
<%
    response.setHeader("Pragma", "no-cache");
    response.addHeader("Cache-Control", "must-revalidate");
    response.addHeader("Cache-Control", "no-cache");
    response.addHeader("Cache-Control", "no-store");
    response.setDateHeader("Expires", 0);
    String user = "";
    HttpSession sesion = request.getSession();
    if (sesion.getAttribute("username") == null) {
%>
<jsp:forward page="login.jsp">
    <jsp:param name="error" value="Ud. debe autenticarse...!"/>
</jsp:forward>
<%
} else {
    user = (String) sesion.getAttribute("username");
%>

<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Solicitud</title>
    <link rel="stylesheet" href="assets/jss/styles.css">
</head>
<body>
    <div class="sidebar" id="sidebar">
        <div class="logo">
            <img src="logo.png" alt="Logo">
        </div>
        <nav>
            <ul>
                <li><a href="assets/practicas.html">Prácticas Pre Profesionales</a></li>
                <li><a href="assets/solicitudes.html">Solicitudes</a></li>
                <li><a href="assets/estudiantes.html">Estudiantes</a></li> <!-- Actualizado -->
                <li><a href="assets/carrera.html">Carrera</a></li>
                <li><a href="assets/asignar.html">Asignar</a></li>
                <li><a href="">Configuración</a></li>
                <li><a href="assets/index.html">Cerrar Sesión</a></li>
            </ul>
            
        </nav>
    </div>
    <div class="main-content" id="main-content">
        <header>
            <button id="toggle-btn">☰</button>
            <h1>Solicitud</h1>
            <div class="user-info">
                <span>Coordinador</span>
                <img src="assets/images/user_varon.png" alt="User Icon">
            </div>
        </header>
        <section class="datos-estudiante">
            <h2>Datos Estudiante</h2>
            <div class="campo">
                <span>Estudiante:</span> Jaime Aron Marquez Fernandez
            </div>
            <div class="campo">
                <span>DNI:</span> 60852561
            </div>
            <div class="campo">
                <span>Programa de estudio por Plan:</span> 2023-1: Ingeniería de Sistemas
            </div>
            <div class="campo">
                <span>Código de Alumno:</span> 202312365
            </div>
            <div class="campo">
                <span>Semestre:</span> 2014-1
            </div>
            <div class="campo">
                <span>Correo:</span> jaime.marquez@upeu.edu.pe
            </div>
            <div class="campo">
                <span>Línea de Trabajo:</span> Ingeniería de Software
            </div>
            <div class="campo">
                <span>Teléfono:</span> 978438825
            </div>
        </section>
        <section class="datos-empresa">
            <h2>Datos de Empresa</h2>
            <div class="campo">
                <span>Nombre:</span> BCP
            </div>
            <div class="campo">
                <span>Numero de RUC:</span> 20100047218
            </div>
            <div class="campo">
                <span>Correo Electrónico:</span> consultasbcp@bcp.com.pe
            </div>
            <div class="campo">
                <span>Forma Jurídica:</span> sociedad anónima
            </div>
        </section>
        <div class="acciones">
            <button>Plan PPP</button>
            <button>Cancelar</button>
            <button>Enviar</button>
            <button>Eliminar</button>
        </div>
    </div>
    <script src="jss/scripts.js"></script>
</body>
</html>
<%}%>
