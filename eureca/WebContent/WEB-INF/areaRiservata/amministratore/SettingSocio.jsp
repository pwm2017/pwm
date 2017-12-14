<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="s" uri="/struts-tags"%>
<html>

<head>

<%@ include file="../../../webApp/layout/Head.jsp"%>

<title>Registration</title>
</head>

<body>
	<%@ include file="../../../webApp/layout/Header.jsp"%>
	<div class="section">
		<div class="container">
			<div class="row">
				<div
					class="col-md-7 col-md-offset-4 col-sm-6 col-sm-offset-3 col-xs-10 col-xs-offset-1">

					<s:form action="ModificaSocio">
						<s:hidden name="socio.idPersonaFisica"
							value="%{socio.idPersonaFisica}"></s:hidden>
						<s:textfield key="label.user.nome" name="socio.nome" class="form-control" />
						<s:textfield label="Cognome" name="socio.cognome" class="form-control" />
						<s:textfield label="email" requiredLabel="true" name="socio.email" class="form-control" />
						<s:textfield label="Telefono" name="socio.telefono" type="number" class="form-control"/>
						<s:textfield label="Data di nascita (gg/mm/aa)"
							name="socio.dataNascita" class="datepicker form-control"/>
						<s:textfield key="label.user.username" requiredLabel="true"
							name="socio.username" class="form-control" />
						<s:password label="Password" showPassword="true"
							requiredLabel="true" name="socio.password" class="form-control" />
						<s:textfield label="Codice Fiscale" requiredLabel="true"
							name="socio.codiceFiscale" class="form-control" />
						<s:checkbox name="socio.amministratore" label="È un amministratore?"/>

						<s:submit value="Modifica" class="btn btn-danger btn-block" />
					</s:form>


				</div>
			</div>
		</div>
	</div>

	<%@ include file="../../../webApp/layout/Footer.jsp"%>

</body>

</html>
