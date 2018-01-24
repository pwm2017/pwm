<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="s" uri="/struts-tags"%>
<html>

<head>

<%@ include file="../../../webApp/layout/Head.jsp"%>

<title><s:text name="title.addAttivia" /></title>
</head>

<body>
	<%@ include file="../../../webApp/layout/Header.jsp"%>
	<%@ include file="MenuAdmin.jsp"%>
	<div class="main">
		<div class="section">
			<div class="container tim-container">
				<div class="tim-title">
					<h2>
						<s:text name="title.addAttivia" />
					</h2>
				</div>
			</div>
		</div>
	</div>
	<div class="section">
		<div class="container">
			<div class="row">
				<div
					class="col-md-6 col-md-offset-3 col-sm-6 col-sm-offset-3 col-xs-10 col-xs-offset-1">
					<s:form action="AggiungiAttivita" enctype="multipart/form-data">
						<s:hidden name="attivita.evento.nome" value="%{evento.nome}"></s:hidden>
						<s:hidden name="attivita.evento.locandina"
							value="%{evento.locandina}"></s:hidden>
						<s:hidden name="attivita.evento.descrizione"
							value="%{evento.descrizione}"></s:hidden>
						<s:hidden name="attivita.evento.luogo" value="%{evento.luogo}"></s:hidden>
						<s:hidden name="attivita.evento.dataEvento"
							value="%{evento.dataEvento}"></s:hidden>
						<s:textfield key="label.attivita.nome" name="attivita.nome"
							class="form-control" />
						<s:textfield key="label.attivita.tipologia"
							name="attivita.tipologia" class="form-control"
							requiredLabel="true" />
						<s:textfield key="label.attivita.descrizione"
							name="attivita.descrizione" class="form-control" />
						<s:textfield key="label.attivita.dataScadenza"
							name="attivita.dataScadenza" class="form-control" />

						<s:submit value="Aggiungi" class="btn btn-danger btn-block" />
					</s:form>
				</div>
			</div>
		</div>
	</div>

	<%@ include file="../../../webApp/layout/Footer.jsp"%>

</body>

</html>
