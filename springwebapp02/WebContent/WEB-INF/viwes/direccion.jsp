<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h2>Direccion</h2>
	Expression Languaje IL Atributos del model:
	<c:out value="${mensaje}"></c:out>

	<br> Atributos del sesion:
	<c:out value="${sessionScope.resultado}"></c:out>
	<br>

	<sf:form action="${pageContext.request.contextPath }/direccion/save"
		method="post" commandName="direccion">
		<table>

		<%-- 	<c:if test="${admin.idAdmin ne 0 }">
				<sf:input path="idAdmin" type="hidden" />
				<sf:input path="fechaCreacion" type="hidden" />
			</c:if> --%>
			<tr>
				<td>Calle</td>
				<td><sf:input path="calle" type="text" /></td>
			</tr>
			<tr>
				<td>CP</td>
				<td><sf:input path="cp" type="text" /></td>
			</tr>

			<tr>
				<td></td>
				<td><input type="submit" /></td>
			</tr>

		</table>
	</sf:form>

	<c:out value="/>${resultado }" />

	IL expression language
	
	
	<br>
	
	
	<c:forEach items="${direcciones}" var="dir">
		<c:out value="${dir}"></c:out>
		<br>
	</c:forEach>


</body>
</html>