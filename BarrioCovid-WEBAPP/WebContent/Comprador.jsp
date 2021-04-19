<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h1>Lista de comercios:</h1>
	<table border="1" width="500">
		<tr>
			<th width="50%">Mercadona@company.es</th>
			<th width="50%">Dia@gmail.com</th>
			<th width="50%">Carrefour@carrefour.es</th>
			<th width="50%">pescaderia@pescaderia.es</th>
		</tr>







		<tr>
			<td>Leche entera, brick pack 6 x 1 l - 6 l, 4.96E <input type="checkbox"></td>
			<td>PRINGLES patatas fritas sour cream & onion tubo 165 gr, 1.99E <input type="checkbox"></td>
			<td>Leche entera Carrefour brik 1l, 0,58 E <input type="checkbox"></td>
			<td>Lubina de ración 500 g aprox, 3.22E <input type="checkbox"></td>
		</tr>







		<tr>
			<td>Dentífrico pasta triple accion, tubo 100 cc, 1.96E <input type="checkbox"></td>
			<td>EL MOLINO DE DIA pan de hamburguesa maxi 4 unidades bolsa 300 gr, 0.79 E <input type="checkbox"></td>
			<td>Tomate frito Carrefour pack de 3 briks de 390 g., 0.95E <input type="checkbox"></td>
			<td>Dorada de ración 500 g apro, 3.75E <input type="checkbox"></td>
		</tr>



		<tr>
			<td>Tarrito platano mandarina pera a partir 4 meses, pack 4 x 130 g - 520 g, 2.59E <input type="checkbox"></td>
			<td>Fresón tarrina 500 gr, 1,35 E <input type="checkbox"></td>
			<td>Macarrones Carrefour 1 kg., 0.73E <input type="checkbox"></td>
			<td>Boquerones 500 g aprox, 1.95E <input type="checkbox"></td>
		</tr>



		<tr>
			<td>Arena gato, paquete 5 kg, 1.19E <input type="checkbox"></td>
			<td>DIA FIDIAS yogur griego con mango y papaya pack 4 unidades 125 gr, 1,75 E <input type="checkbox"></td>
			<td>Guacamole Carrefour 200 g, 1.59E <input type="checkbox"></td>
			<td>Lomo de atún 300 g aprox, 1.95E <input type="checkbox"></td>
		</tr>



		<tr>
			<td>Fiambre pechuga pavo lonchas finas, paquete pack 2 x 200 g - 400 g , 2.89E <input type="checkbox"></td>
			<td>SANYTOL limpiador desinfectante multiusos pistola 750 ml, 2.49E <input type="checkbox"></td>
			<td>Aceite de oliva suave 0,4º Carrefour 1 l, 2.28E <input type="checkbox"></td>
			<td>Pescadilla de pincho 1,5 kg aprox, 14.85E <input type="checkbox"></td>
		</tr>



		<tr>
			<td>Lejia detergente, botella 2 l , 0.99E <input type="checkbox"></td>
			<td>SEÑORÍO DE ONDAS Vino blanco semidulce DO Rioja 75 cl, 2.49E <input type="checkbox"></td>
			<td>Filetes de merluza sin piel Pescanova 400 g, 4.15E <input type="checkbox"></td>
			<td>Salmón ahumado 100 g, 2.65E <input type="checkbox"></td>
		</tr>



		<tr>
			<td>Lomo de cerdo grueso bandeja 300 g, 1.77E<input type="checkbox"></td>
			<td>DIA GALATEA queso rallado mezcla 4 quesos bolsa 200 gr, 1.79E <input type="checkbox"></td>
			<td>Arroz redondo Sos 1 kg, 1.52E <input type="checkbox"></td>
			<td>Pata de pulpo cocido 250 g, 7.39E <input type="checkbox"></td>
		</tr>
	</table>
		<br>
	<br>
	<form action="FormCreaPedidoServlet">
	<input type="email" id="email" name="email" placeholder="introduzca su email">
    <input type="email" id="emailVendedor" name="emailVendedor" placeholder="introduzca el correo del vendedor">
	<button value="submit">Realizar pedido</button>
	</form>
	<br>
	<br>
	<%@ include file="FormLogout.jsp"%>
</body>
</html>