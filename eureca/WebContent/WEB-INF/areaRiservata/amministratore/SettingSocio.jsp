<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="s" uri="/struts-tags"%>
<html>

<head>

<%@ include file="../../../webApp/layout/Head.jsp"%>

<title><s:text name="title.modificaSocio" /></title>
</head>

<body>
	<%@ include file="../../../webApp/layout/Header.jsp"%>
	<%@ include file="MenuAdmin.jsp"%>

	<div class="main">
		<div class="section">
			<div class="container tim-container">
				<div class="tim-title">
					<h2>
						<s:text name="title.modificaSocio" />
					</h2>
				</div>
			</div>
		</div>
	</div>

	<div class="section">
		<div class="container">
			<div class="row">
				<div
					class="col-md-7 col-md-offset-1 col-sm-6 col-sm-offset-3 col-xs-10 col-xs-offset-1">

					<s:form action="ModificaSocio" enctype="multipart/form-data">
						<s:hidden name="socio.idPersonaFisica"
							value="%{socio.idPersonaFisica}"></s:hidden>
						<s:hidden name="socio.foto" value="%{socio.foto}"></s:hidden>
						<s:textfield key="label.socio.nome" requiredLabel="true"
							name="socio.nome" class="form-control" />
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
							name="socio.dataNascita" class="form-control" type="date"/>
						<s:textfield key="label.user.username" requiredLabel="true"
							name="socio.username" class="form-control" />
						<s:hidden name="socio.password" />
						<s:textfield key="label.socio.codiceFiscale"
							name="socio.codiceFiscale" class="form-control" />
						<s:checkbox name="socio.amministratore"
							key="label.socio.amministratore" />
						<s:file name="uploadDoc" key="Carica immagine" />

						<s:submit value="Modifica" class="btn btn-block" />
					</s:form>
				</div>

				<div class="col-md-4">
					<div ALIGN="CENTER">
						<h3>Tessera</h3>
					</div>
					<div class=" col-md-offset-2">
						<button type="button" class="btn " data-toggle="popover"
							data-placement="left"
							title="Tessera socio '<s:property value="socio.nome" />'"
							data-content="Punti: <s:property value="tessera.punti"/> <br>
                        Data Rilascio: <s:property value="tessera.dataRilascio"/> <br> 
                        Data Scadenza: <s:property value="tessera.dataScadenza"/> <br> 
                        "
							data-html="true">Visualizza</button>

						<s:if
							test="%{(#session.amministratore.idPersonaFisica!=socio.idPersonaFisica)}">
							<button class="btn" data-toggle="modal" data-target="#myModal">Modifica</button>
						</s:if>
						<div class="modal fade" id="myModal" tabindex="-1" role="dialog"
							aria-labelledby="myModalLabel" aria-hidden="true">
							<div class="modal-dialog">
								<div class="modal-content">
									<div class="modal-header">
										<button type="button" class="close" data-dismiss="modal"
											aria-hidden="true">&times;</button>
										<h4 class="modal-title" id="myModalLabel">
											<s:text name="title.updateTessera" />
										</h4>
									</div>
									<div class="modal-body">
										<div class="section">
											<div class="container">
												<div class="row">
													<div class="col-md-5 col-md-offset2">
														<s:form action="ModificaTessera">
															<s:hidden name="tessera.idSocio"
																value="%{socio.idPersonaFisica}"></s:hidden>
															<s:textfield label="Punti" name="tessera.punti"
																class="form-control" />
															<s:textfield label="DataRilascio"
																name="tessera.dataRilascio" class="form-control" />
															<s:textfield label="DataScadenza"
																name="tessera.dataScadenza" class="form-control" />

															<s:submit value="Modifica" class="btn btn-block" />
														</s:form>
													</div>
												</div>
											</div>
										</div>
									</div>

								</div>
							</div>
						</div>

					</div>

					<div ALIGN="CENTER">
						<h3>Password</h3>
					</div>
					<div class="col-md-8 col-md-offset-2">
						<button class="btn" data-toggle="modal" data-target="#myModal1">Modifica
							Password</button>
					</div>


					<div class="modal fade" id="myModal1" tabindex="-1" role="dialog"
						aria-labelledby="myModalLabel" aria-hidden="true">
						<div class="modal-dialog">
							<div class="modal-content">
								<div class="modal-header">
									<button type="button" class="close" data-dismiss="modal"
										aria-hidden="true">&times;</button>
									<h4 class="modal-title" id="myModalLabel">Modifica
										Password</h4>
								</div>
								<div class="modal-body">
									<div class="section">
										<div class="container">
											<div class="row">
												<div class="col-md-5 col-md-offset2">
													<s:form action="ModificaPasswordSocioBase">
														<s:password key="label.user.password" showPassword="true"
															requiredLabel="true" name="socio.password"
															class="form-control" value="" />
														<s:hidden name="socio.idPersonaFisica"
															value="%{socio.idPersonaFisica}"></s:hidden>
														<s:hidden name="socio.foto" value="%{socio.foto}"></s:hidden>
														<s:hidden name="socio.nome" />
														<s:hidden name="socio.cognome" />
														<s:hidden name="socio.indirizzo.cap" />
														<s:hidden name="socio.indirizzo.civico" />
														<s:hidden name="socio.indirizzo.citta" />
														<s:hidden name="socio.indirizzo.via" />
														<s:hidden name="socio.email" />
														<s:hidden name="socio.telefono" />
														<s:hidden name="socio.dataNascita" />
														<s:hidden name="socio.username" />

														<s:hidden name="socio.codiceFiscale" />
														<s:hidden name="socio.amministratore" />

														<s:submit value="Modifica" class="btn btn-block" />
													</s:form>
												</div>
											</div>
										</div>
									</div>
								</div>

							</div>
						</div>
					</div>

				</div>
			</div>

			<div class="clearfix"></div>
			<div class="clearfix"></div>

		</div>
	</div>



	<%@ include file="../../../webApp/layout/Footer.jsp"%>

</body>

</html>
