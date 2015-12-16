<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"
    import = "Galenos.classes.*"
    
    %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.List" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>

</head>

<body>
<% 
  List<ClinicalElement> elements = new ArrayList<ClinicalElement>();
  Logic lg = new Logic();
  AllSigns as = new AllSigns();
  as.GetAllSigns(lg);
%>
<form action="enviar-array.jsp" method="post">
<label for="favoritos">Marca de las siguientes opcion, cuales son tus favoritas</label><br/>
<select multiple="multiple" id="favoritos" name="favoritos" size=2>
	<option value="deportips">Deportips</option>
	<option value="cine">Cine</option>
	<option value="teatro">Teatro</option>
	<option value="fotografía">Fotografía</option>
	<option value="lectura">Lectura</option>
	<option value="viajes">Viajes</option>
	<option value="pintura">Pintura</option>
	<option value="música">Música</option>
	<option value="otros">Otros</option>	
</select>

<input type="submit" value="Enviar"/>
</form>
 

 
 
 
</body>
</html>