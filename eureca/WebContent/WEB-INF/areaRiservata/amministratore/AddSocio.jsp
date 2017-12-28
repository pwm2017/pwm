<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="s" uri="/struts-tags"%>
<html>

<head>

<%@ include file="../../../webApp/layout/Head.jsp"%>

<title><s:text name="title.addSocio" /></title>
</head>

<body>
	<%@ include file="../../../webApp/layout/Header.jsp"%>
	<%@ include file="MenuAdmin.jsp"%>
	<div class="main">
		<div class="section">
			<div class="container tim-container">
				<div class="tim-title">
					<h2>
						<s:text name="title.addSocio" />
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

					<s:form action="AggiungiSocio" enctype="multipart/form-data">
						<s:textfield key="label.socio.nome" requiredLabel="true" name="socio.nome"
							class="form-control" />
						<s:textfield key="label.socio.surname" name="socio.cognome"
							class="form-control" requiredLabel="true" />
						<s:textfield key="label.socio.indirizzo.cap"
							name="socio.indirizzo.cap" requiredLabel="true"
							class="form-control" />
						<s:textfield key="label.socio.indirizzo.civico"
							name="socio.indirizzo.civico" requiredLabel="true"
							class="form-control" />
						<s:textfield key="label.socio.indirizzo.citta"
							name="socio.indirizzo.citta" requiredLabel="true"
							class="form-control" />
						<s:textfield key="label.socio.indirizzo.via"
							name="socio.indirizzo.via" requiredLabel="true"
							class="form-control" />
						<s:textfield key="label.socio.email" name="socio.email"
							class="form-control" />
						<s:textfield key="label.socio.Telefono" name="socio.telefono"
							requiredLabel="true" type="number" class="form-control" />
						<s:textfield key="label.socio.dataNascita"
							name="socio.dataNascita" class="form-control" />
						<s:textfield key="label.user.username" requiredLabel="true"
							name="socio.username" class="form-control" />
						<s:password key="label.user.password" showPassword="true"
							requiredLabel="true" name="socio.password" class="form-control" />
						<s:textfield key="label.socio.codiceFiscale"
							name="socio.codiceFiscale" class="form-control" />
						<s:checkbox name="socio.amministratore"
							key="label.socio.amministratore" />
						<s:file name="uploadDoc" key="Carica immagine" />

						<s:submit value="Aggiungi" class="btn btn-danger btn-block" />
					</s:form>
				</div>
			</div>
		</div>
	</div>

	<%@ include file="../../../webApp/layout/Footer.jsp"%>

</body>

</html>
