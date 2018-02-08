<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="s" uri="/struts-tags"%>
<html>

<head>

<%@ include file="../../../webApp/layout/Head.jsp"%>

<title><s:text name="title.updateEvento" /></title>
</head>

<body>
	<%@ include file="../../../webApp/layout/Header.jsp"%>
	<%@ include file="MenuAdmin.jsp"%>
	<div class="main">
		<div class="section">
			<div class="container tim-container">
				<div class="tim-title">
					<h2>
						<s:text name="title.updateEvento" />
					</h2>
				</div>
			</div>
		</div>
	</div>
	<div class="section">
		<div class="container">
			<div class="row">
				<div class="col-md-5">

					<s:form action="ModificaEvento" enctype="multipart/form-data">
						<s:hidden name="evento.idEvento" value="%{evento.idEvento}"></s:hidden>
						<s:hidden name="evento.locandina" value="%{evento.locandina}"></s:hidden>
						<s:textfield key="label.evento.nome" requiredLabel="true"
							name="evento.nome" class="form-control" />
						<s:textfield key="label.evento.descrizione"
							name="evento.descrizione" class="form-control" />
						<s:textfield key="label.evento.luogo" name="evento.luogo"
							class="form-control" />
						<s:textfield key="label.evento.dataEvento"
							name="evento.dataEvento" class="form-control" />

						<s:file name="uploadDoc" key="Modifica Immagine" />

						<s:submit value="Modifica" class="btn btn-block" />
					</s:form>
				</div>

				<div class="col-md-4 col-md-offset-3">

					<h4>
						Attività dell'evento: "
						<s:property value="evento.nome" />
						"
					</h4>
					<ul class="list-unstyled follows">

						<s:iterator value="attivitàEvento">
							<li>
								<div class="row">
									<div class="col-md-7 col-xs-4">
										<h6>
											<s:property value="nome" />

										</h6>

									</div>
									<div class="col-md-3 col-xs-2 ">
										<h6>
											<a
												href="<s:url action='EliminaAttivitaEvento' namespace='/amministratore/evento'>
															<s:param name="attivita.idAttivita"><s:property value="idAttivita" /></s:param>
															</s:url>">Elimina</a>
											<a
												href="<s:url action='SetAttivita' namespace='/amministratore/evento'> 
															<s:param name="attivita.idAttivita"><s:property value="idAttivita" /></s:param>
															</s:url>">Modifica</a>
										</h6>
									</div>
								</div>
							</li>
							<hr />
						</s:iterator>
				</div>

			</div>
		</div>
	</div>

	<%@ include file="../../../webApp/layout/Footer.jsp"%>

</body>

</html>
