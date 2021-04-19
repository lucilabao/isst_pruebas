<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Vendedor</title>
</head>
<body>

<h3>Lista Compradores</h3>
<table border="1">
        <tr>
            <th>emailComprador</th>
            <c:forEach items="${lista}" var="listai">
               <tr>
                    <td>${listai.email}</td>
                   </tr>
                  
               </c:forEach>
               </tr>
               </table>
          
<h3>Por favor, registre sus productos introducciendo el nombre y el precio del mismo</h3>
<form action="FormSubeProductoServlet">
<input type="text" id="nombre_precio" name="nombre_precio" placeholder="nombre, precioE" lenght=100%>
<button value="submit">Subir producto</button>
</form>
         
	<br>
	<br>
<%@ include file="FormLogout.jsp"%>

</body>
</html>