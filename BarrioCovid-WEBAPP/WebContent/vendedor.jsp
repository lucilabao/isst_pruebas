<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>VENDEDOR</title>
<link href="pedido.css" rel="stylesheet" type="text/css">
</head>
<body>
<table border="1">
	<tr>
		<th>ID</th>
		<th>Comprador</th>
		<th>Voluntario</th>
		<th>Estado</th>
	</tr>
	<c:forEach items="${pedidos}" var="pedidoi">
		<tr>
			<td>${pedidoi.idped}</td>
			<td>${pedidoi.comprador}</td>
			<td>${pedidoi.voluntario}</td>
			<td>${pedidoi.status}</td>
			<c:if test="${pedidoi.status == 1}">
			        <td>
				        <form action="VendedorServlet">
					        <input type="submit">Pedido Preparado</input>
				        </form>
			        </td>
			</c:if>
			<c:if test="${pedidoi.status != 1 }">
				<td></td>
			</c:if>
		</tr>
	</c:forEach>
</table>
</body>
<%@ include file="logout.jsp"%>
<%@ include file="Footer.jsp"%>
</html>