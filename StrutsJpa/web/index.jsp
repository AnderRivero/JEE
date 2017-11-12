<%-- 
    Document   : index
    Created on : 10/11/2017, 02:10:15 PM
    Author     : Hellmuth Trejo y Ander Rivero.
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@taglib uri="/struts-tags" prefix="s" %>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>INGRESO</title>
    </head>
    <body>
        <header>
            <s:a href="registrar.jsp">Registrar</s:a>
            </header>
        <s:form action="iniciarSesion"  class="form-horizontal" autocomplete="off" method="POST">
            <s:textfield label="Usuario" name="usuario.us"/>
            <s:password label="Contraseña" name="usuario.pass"/>
            <s:submit value="Ingresar" />

        </s:form>
        <s:property value="getFieldErrors().get('Error')[0]"/>
        <s:property value="getFieldErrors().get('EUC')[0]"/>            
        <s:property value="getFieldErrors().get('CV')[0]"/>
    </body>
</html>