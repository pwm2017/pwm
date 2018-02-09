<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="display" uri="http://displaytag.sf.net"%>
<html>
<head>

<%@ include file="../../../webApp/layout/Head.jsp"%>

<title><s:text name="Partecipanti" /></title>
</head>

<body>

	<%@ include file="../../../webApp/layout/Header.jsp"%>


	<%@ include file="MenuAdmin.jsp"%>
	<div class="main">
		<div class="section">
			<div class="container tim-container">
				<div class="tim-title">
					<h2>
						Partecipanti
					</h2>
				</div>
			</div>
		</div>
	</div>


	<s:if test="listaUtenti.isEmpty()">
		<div class="alert alert-success">
			<h4>
				<h3>Non ci sono Eventi</h3>
			</h4>
		</div>

	</s:if>


	<div class="profile-content section-nude">
		<div class="container">
			<div class="row">
			
			
			
			
			
			
			
			
			</div>
		</div>

	</div>


	<%@ include file="../../../webApp/layout/Footer.jsp"%>


</body>

</html>
