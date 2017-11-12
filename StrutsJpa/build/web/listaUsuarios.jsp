<%-- 
    Document   : listaUsuarios
    Created on : 11/11/2017, 07:14:55 PM
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
<h1> Lista de Usuarios</h1><br/>
<table border="1" align="" width="50%">
	<tr>
		<th>Nombre</th>
		<th>Usuario</th>
		<th>Password</th>
	</tr>
<s:iterator value="amigos"> 
	<tr>
		<td><s:property value="nombre"/> </td>
		<td><s:property value="us"/></td>
		<td><s:property value="pass"/></td>
	</tr>
</s:iterator>
</table>
</body>
</html>