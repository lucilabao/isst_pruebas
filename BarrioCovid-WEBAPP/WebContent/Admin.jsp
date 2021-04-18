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
<th>email</th>
<th>estado</th>
<th>rol</th>

</tr>

<c:forEach items="${listaCovid}" var="listaCovidi">
<form action="FormAdminServlet" method="post">
        <tr>
        <td><input type="email" id="email" name="email" value="${listaCovidi.email}" />${listaCovidi.email}</td>
        
        <td><input type="number" id="status" name="status" value="${listaCovidi.status}" min="0" max="8"/></td>
        <td><input type="text" id="rol" name="rol" value="${listaCovidi.rol}" /></td>
       
        </tr>
</form>


</c:forEach>

</table>
</body>
</html>