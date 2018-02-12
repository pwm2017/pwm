<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="s" uri="/struts-tags"%>
<html>
<head>

<%@ include file="../../../webApp/layout/Head.jsp"%>

<title><s:text name="global.title.areaRiservata" /></title>
</head>

<body>

	<%@ include file="../../../webApp/layout/Header.jsp"%>
	<%@ include file="MenuSocio.jsp"%>

	<div class="profile-content section-nude">
		<div class="container">
			<div class="row owner">
				<div
					class="col-md-2 col-md-offset-5 col-sm-4 col-sm-offset-4 col-xs-6 col-xs-offset-3 text-center">
					<div class="avatar">
						<s:if test="#session.socio.foto==''">
							<img src="/eureca/webApp/assets/img/placeholder.jpg"
								alt="Circle Image"
								class="img-circle img-no-padding img-responsive">
						</s:if>
						<s:else>
							<img
								src="/eureca/webApp/assets/img/soci/<s:property value="#session.socio.foto"/>"
								alt="Circle Image"
								class="img-circle img-no-padding img-responsive">
						</s:else>
					</div>
					<div class="nome">
						<h4>
							<s:property value="#session.socio.nome" />
							<br />

						</h4>
					</div>
				</div>
			</div>
			<div class="row">
				<div class="col-md-6 col-md-offset-3 text-center">
					<btn class="btn"> <i class="fa fa-cog"></i> <a
						href="<s:url action='SetSocio' namespace='/socio'>
						<s:param name="socio.idPersonaFisica"><s:property value="#session.socio.idPersonaFisica" /></s:param>
						</s:url>">Settings</a>

					</btn>
				</div>
			</div>

			<div class="profile-tabs">
				<div class="nav-tabs-navigation">
					<div class="nav-tabs-wrapper">
						<ul id="tabs" class="nav nav-tabs" data-tabs="tabs">
							<li class="active"><a href="#follows" data-toggle="tab">Info</a></li>
							<li><a href="#tessera" data-toggle="tab">Tessera</a></li>
						</ul>
					</div>
				</div>
				<div id="my-tab-content" class="tab-content">
					<div class="tab-pane active" id="follows">
						<div class="row">
							<div class="col-md-6 col-md-offset-3">
								<ul class="list-unstyled follows">
									<li>
										<div class="row">

											<div class="col-md-11 col-xs-4">
												<div class="tim-typo">
													<span class="tim-note">Informazioni</span>
													<blockquote>
														<p>Codice Fiscale:</p>
														<small> <s:property
																value="#session.socio.codiceFiscale" /> <br>
														</small>
														<p>Username:</p>
														<small> <s:property
																value="#session.socio.username" /> <br>
														</small>
														<p>Indirizzo:</p>
														<small> <s:property
																value="#session.socio.indirizzo.citta" /> <br> <s:property
																value="#session.socio.indirizzo.via" /> <br> <s:property
																value="#session.socio.indirizzo.civico" /> <br> <s:property
																value="#session.socio.indirizzo.cap" /> <br>
														</small>
														<p>Telefono:</p>
														<small> <s:property
																value="#session.socio.telefono" /> <br>
														</small>
														<p>E-mail:</p>
														<small> <s:property value="#session.socio.email" />
															<br>
														</small>

														<p>Data di nascita:</p>
														<small> <s:property
																value="#session.socio.dataNascita" /> <br>
														</small>
													</blockquote>
												</div>
											</div>
										</div>
									</li>
									<hr />

								</ul>
							</div>
						</div>
					</div>
					<div class="tab-pane text-center" id="tessera">
					
						Punti:
						<s:property value="#session.tessera.punti" />
						<br>
						<br>
						Data Rilascio:
						<s:property value="#session.tessera.dataRilascio" />
						<br>
						<br>
						Data Scadenza:
						<s:property value="#session.tessera.dataScadenza" />
	
						
					</div>
				</div>

			</div>

		</div>

	</div>


	<%@ include file="../../../webApp/layout/Footer.jsp"%>


</body>

</html>
