<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h1>hellow</h1>

	<a href='<c:url value="about"/>'>Acerca de</a>
	<a href='<c:url value="admin"/>'>Gestionar administradores</a> 
	
	Atributos del model:<c:out value="${mensaje}"></c:out>
	<br> Atributos del sesion:
	<c:out value="${sessionScope.resultado}"></c:out>
	<c:out value="${adminForm}"></c:out>
</body>
</html>