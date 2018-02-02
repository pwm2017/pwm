<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="s" uri="/struts-tags"%>
<html>

<head>

<%@ include file="../../../webApp/layout/Head.jsp"%>

<title><s:text name="title.partecipaEvento" /></title>
</head>

<body>
	<%@ include file="../../../webApp/layout/Header.jsp"%>
	<div class="main">
		<div class="section">
			<div class="container tim-container">
				<div class="tim-title">
					<h2>
						<s:text name="title.partecipaEvento" />
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

					<s:form action="PartecipaEvento" enctype="multipart/form-data">
						<s:hidden name="evento.idEvento" value="%{evento.idEvento}"></s:hidden>
						<s:textfield key="label.utente.nome" requiredLabel="true"
							name="utente.nome" class="form-control" />
						<s:textfield key="label.utente.cognome" name="utente.cognome"
							class="form-control" requiredLabel="true"/>
						<s:textfield key="label.utente.email" name="utente.email"
							class="form-control" requiredLabel="true" />
						<s:textfield key="label.utente.telefono" name="utente.telefono"
							class="form-control" type="number" requiredLabel="true"/>
						<s:textfield key="label.utente.dataNascita"
							name="utente.dataNascita" class="form-control" type="date" />
						<s:textfield key="label.utente.ente" name="utente.ente"
							class="form-control" />
						<s:submit value="Aggiungi" class="btn btn-block" />
					</s:form>
				</div>
			</div>
		</div>
	</div>

	<%@ include file="../../../webApp/layout/Footer.jsp"%>

</body>

</html>
