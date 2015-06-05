<%@ page language="java" contentType="text/html; charset=US-ASCII"
	pageEncoding="US-ASCII"%>
<%@ taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@ taglib prefix="h" uri="http://java.sun.com/jsf/html"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=US-ASCII">
<title>Progetto SIW</title>
</head>
<body>
	<f:view>
		<h1>Progetto SIW</h1>
		<h3>di Gabriele Di Bonaventura e Igor Proshchenko.</h3>
		<ul>
			<li>
				<a href='<c:url value="/faces/adminLogin.jsp" />'>Admin Login</a>
			</li>
			<li>
				<a href='<c:url value="/faces/customerLogin.jsp" />'>Customer Login</a>
			</li>
			<li>
				<h:form>
					<h:commandLink action="#{productController.listProducts}"
						value="List all Products" />
				</h:form>
			</li>
		</ul>
	</f:view>
</body>
</html>

