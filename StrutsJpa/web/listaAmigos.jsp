<%-- 
    Document   : listaAmigos
    Created on : 10/11/2017, 10:15:39 PM
    Author     : Alfredo Rivero
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@taglib uri="/struts-tags" prefix="s" %>


    
<html>
<head>
<style type="text/css">
</style>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Mis amiguitos xD</title>
</head>
<body>
<br/><br/><br/>
<h1>Mi Lista de Amigos</h1><br/><br/><br/><br/>


<table border="1" align="center" width="50%">
    
    
    
	<tr>
		<th>Nombre</th>
		<th>Usuario</th>
		<th>Password</th>
                <th colspan="2">Accion</th>
	
<s:iterator value="amigos"> 
	<tr>
		
		<td><s:property value="nombre"/></td>
                <td><s:property value="us"/></td>
                <td><s:property value="pass"/></td>
                <td> <s:a action="eliminarAmigo" value="cedula">Eliminar</s:a></td>
                <td> <s:a href="modificarAmigo" value="cedula">Actualizar</s:a></td>
	</tr>
</s:iterator>
		
	

</table>
</body>
</html>
