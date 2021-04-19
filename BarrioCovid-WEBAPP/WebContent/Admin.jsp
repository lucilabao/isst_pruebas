<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>

<html>
<head>
<meta charset="ISO-8859-1">
<title>Admin JSP</title>
</head>
<body>

<table border="1">
<tr>
<th>emailComprador</th>
<th>status</th>
<th>Actualizar</th>
<th>emailVendedor</th>
<th>emailVoluntario</th>
<th>productos</th>
</tr>

<c:forEach items="${lista_final}" var="lista_finali">
<form action="FormAdminServlet" method="post">
        <tr>
        <td><input type="hidden" id="email" name="email" value="${lista_finali.email}" />${lista_finali.email}</td>
        <td><input type="number" id="status" name="status" value="${lista_finali.status}" min="0" max="8"/></td>
               <td><button type="submit">Actualizar valores</button></td>
        </tr>
</form>


</c:forEach>
</table>

<h2>Crear Match</h2>

<form action="FormCreaMatchServlet">
        <input type="email" id="email" name="email" placeholder="emailComprador">
        <input type="email" id="Voluntario" name="Voluntario" placeholder="emailVoluntario">
         <input type="email" id="Vendedor" name="Vendedor" placeholder="emailVendedor">
         
        <button type="submit">Registrar Match</button>
</form>

<%@ include file="FormLogout.jsp"%>
</body>
</html>