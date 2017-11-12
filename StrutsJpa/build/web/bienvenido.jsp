<%-- 
    Document   : bienvenido
    Created on : 10/11/2017, 02:28:19 PM
    Author     : Hellmuth Trejo y Alfredo Rivero.
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@taglib uri="/struts-tags" prefix="s" %>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Bienvenido</title>
    </head>
    <body>
        <s:a href="listarUsuarios"> lista de usuarios</s:a>
        <s:property value="usuario.nombre"/><br>
        <s:property value="usuario.us"/><br>
        
        
        <s:form action="listaAmigos" class="form-horizontal"  method="POST">
            <s:textfield label="Cedula" name="usuario.cedula"/>
            <s:submit value="Mis Amigos x3" />

        </s:form>
        
        
    </body>
</html>

