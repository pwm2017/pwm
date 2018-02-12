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

<title><s:text name="Partecipanti Viaggio" /></title>
</head>

<body>

	<%@ include file="../../../webApp/layout/Header.jsp"%>


	<%@ include file="MenuAdmin.jsp"%>
	<div class="main">
		<div class="section">
			<div class="container tim-container">
				<div class="tim-title">
					<h2>Partecipanti Viaggio</h2>
				</div>
			</div>
		</div>
	</div>

	<s:if test="listaSoci.isEmpty()">
		<div class="alert alert-success">
			<h4>
				<h3>Non ci sono soci partecipanti al viaggio</h3>
			</h4>
		</div>

	</s:if>


	<div class="profile-content section-nude">
		<div class="container">
			<div class="row">
				<div class="col-md-8 col-md-offset-2">
					<br> <br>
					<display:table name="listaSoci" pagesize="10" requestURI=""
						sort="list" export="true" class="table table-bordered">
						<display:column property="nome" title="Nome" sortable="true" />
						<display:column property="cognome" title="Cognome" sortable="true" />
						<display:column property="email" title="E-mail" sortable="true" />
						<display:column property="telefono" title="Telefono"
							sortable="true" />
						<display:column property="dataNascita" title="Data Nascita"
							sortable="true" />
						<display:column property="codiceFiscale" title="CF" sortable="true" />
						<display:setProperty name="export.excel.filename" value="PartecipantiViaggio.xls"/>
						<display:setProperty name="export.pdf" value="true" />
						<display:setProperty name="export.pdf.filename" value="PartecipantiViaggio.pdf"/>

					</display:table>

					<br> <br> <br> <br>

				</div>
			</div>
		</div>

	</div>




	<%@ include file="../../../webApp/layout/Footer.jsp"%>


</body>

</html>
