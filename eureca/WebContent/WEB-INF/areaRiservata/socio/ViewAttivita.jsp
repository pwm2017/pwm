<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@taglib prefix="display" uri="http://displaytag.sf.net"%>

<html>
<head>
<link rel="stylesheet"
	href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">
<%@ include file="../../../webApp/layout/Head.jsp"%>

<title>Attività a cui devi partecipare</title>
</head>

<body>

	<%@ include file="../../../webApp/layout/Header.jsp"%>


	<%@ include file="MenuSocio.jsp"%>
	<div class="main">
		<div class="section">
			<div class="container tim-container">
				<div class="tim-title">
					<h2>Attività a cui devi partecipare</h2>
				</div>
			</div>
		</div>
	</div>

	<s:if test="listaUtenti.isEmpty()">
		<div class="alert alert-success">
			<h4>
				<h3>Non ci sono Attività</h3>
			</h4>
		</div>

	</s:if>


	<div class="profile-content section-nude">
		<div class="container">
			<div class="row">
				<div class="col-md-8 col-md-offset-2">
					<br> <br>
					<display:table name="listaAttivita" pagesize="10" requestURI=""
						sort="list" export="true" class="table table-bordered">
						<display:column property="nome" title="Nome" sortable="true" />
						<display:column property="tipologia" title="Tipologia"
							sortable="true" />
						<display:column property="descrizione" title="Descrizione"
							sortable="true" />
						<display:column property="dataScadenza" title="Data Scadenza"
							sortable="true" />
						<display:setProperty name="export.excel.filename"
							value="PartecipantiViaggio.xls" />
						<display:setProperty name="export.pdf" value="true" />
						<display:setProperty name="export.pdf.filename"
							value="PartecipantiViaggio.pdf" />

					</display:table>

					<br> <br> <br> <br>

				</div>
			</div>
		</div>

	</div>




	<%@ include file="../../../webApp/layout/Footer.jsp"%>


</body>

</html>
