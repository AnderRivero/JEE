<%-- 
    Document   : registrar
    Created on : 10/11/2017, 06:00:56 PM
    Author     : Hellmuth Trejo y Ander Rivero.
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@taglib uri="/struts-tags" prefix="s" %>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>REGISTRAR</title>
    </head>
    <body>
        <header>
          <s:a href="index.jsp">Volver</s:a>
        </header>
        <h1>Registro de Usuario</h1>
           <s:form action="registrarAction" autocomplete="off" method="POST">
            <s:textfield label="Cedula" name="usuario.cedula"/>
            <s:textfield label="Nombre" name="usuario.nombre"/>
            <s:textfield label="Usuario" name="usuario.us"/>
            <s:password label="Contraseña" name="usuario.pass"/> 
             <s:submit value="Ingresar" />
        </s:form>        
    </body>
</html>
