<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="s" uri="/struts-tags"%>
<html>

<head>

<%@ include file="../../../webApp/layout/Head.jsp"%>

<title><s:text name="title.addViaggio" /></title>
</head>

<body>
	<%@ include file="../../../webApp/layout/Header.jsp"%>
	<%@ include file="MenuAdmin.jsp"%>
	<div class="main">
		<div class="section">
			<div class="container tim-container">
				<div class="tim-title">
					<h2>
						<s:text name="title.addViaggio" />
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

					<s:form action="AggiungiViaggio" enctype="multipart/form-data">
						<s:textfield key="label.viaggio.nome" requiredLabel="true"
							name="nome" class="form-control" />
						<s:textfield key="label.viaggio.descrizione" name="descrizione"
							class="form-control" />
						<s:textfield key="label.viaggio.numPartecipanti"
							name="numPartecipanti" requiredLabel="true" value="0"
							class="form-control" />
						<s:textfield key="label.viaggio.dataInizio" name="dataInizio"
							class="form-control" type="date" />
						<s:textfield key="label.viaggio.dataFine" name="dataFine"
							class="form-control" type="date" />

						<s:file name="uploadDoc" key="label.viaggio.Caricaimmagine" />

						<s:submit value="Aggiungi" class="btn btn-block" />
					</s:form>
				</div>
			</div>
		</div>
	</div>

	<%@ include file="../../../webApp/layout/Footer.jsp"%>

</body>

</html>
