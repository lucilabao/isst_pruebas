<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h2>Eres un voluntario</h2>
<table border="1" width="500">
		<tr>
			<th width="50%">EmailComprador</th>
			<th width="50%">EmailVendedor</th>
		</tr>
		
		<tr>
			<td>maria@gmail.com</td>
			<td>Mercadona@company.es<input type="checkbox"></td>
		</tr>
	<tr>
			<td>tania@gmail.com</td>
			<td>pescaderia@pescaderia.es<input type="checkbox"></td>
		</tr>


		<tr>
			<td>juan@gmail.com</td>
			<td>Carrefour@carrefour.es<input type="checkbox"></td>
		</tr>
	</table>

	<br>
	<br>
	<%@ include file="FormLogout.jsp"%>
</body>
</html>