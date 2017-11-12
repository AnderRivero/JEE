<%-- 
    Document   : modificaAmigo
    Created on : 12/11/2017, 02:30:10 PM
    Author     : Alfredo Rivero
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%@taglib uri="/struts-tags" prefix="s" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
       <s:form action="ActualizarAmigos"   method="POST">
             <s:property value="usuario.cedula"/><br>
            <s:hidden label="Cedula" name="usuario.cedula"/>
            <s:textfield label="Nombre" name="usuario.nombre"/>
            <s:textfield label="Usuario" name="usuario.us"/>
            <s:textfield label="Password" name="usuario.pass"/>
            <s:submit value="Actualizar" />

        </s:form>
    </body>
</html>
