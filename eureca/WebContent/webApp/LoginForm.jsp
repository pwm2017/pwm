<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@ taglib prefix="s" uri="/struts-tags" %>
<html>

	<head>
	
	<%@ include file="layout/Head.jsp"%>
	
	</head>

	<body>
	
	<%@ include file="layout/Header.jsp"%>
	    <hr>
		<h4>Login</h4> 	
		<s:form action="Login">
    	<s:textfield name="username" label="Username"/>
    	<s:password name="password" label="Password"/>
    	
    	<s:submit/>
		</s:form>
	    <hr>	
	    
	    <%@ include file="layout/Footer.jsp"%>
	</body>
	
</html>
