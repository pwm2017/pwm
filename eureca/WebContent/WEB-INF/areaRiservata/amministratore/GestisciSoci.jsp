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

	<div style="background-color: #aaffcc;">
		<s:actionmessage />
	</div>

	<%@ include file="MenuAdmin.jsp"%>

	<div class="profile-content section-nude">
		<div class="container">

			<div class="row">
				<div class="profile-tabs">
					<div class="nav-tabs-navigation">
						<div class="nav-tabs-wrapper"></div>
					</div>
					<div id="my-tab-content" class="tab-content">
						<div class="tab-pane active" id="follows">
							<div class="row">
								<div class="col-md-6 col-md-offset-3">
									<ul class="list-unstyled follows">
										<s:iterator value="listaSoci">
											<li>
												<div class="row">
													<div
														class="col-md-2 col-md-offset-0 col-xs-3 col-xs-offset-2">
														<img
															src="/eureca/webApp/assets/img/<s:property value="idPersonaFisica"/>.jpg"
															alt="Circle Image"
															class="img-circle img-no-padding img-responsive">
													</div>
													<div class="col-md-7 col-xs-4">
														<h6>
															<s:property value="nome" />
															<br /> <small><s:property value="cognome" /></small> 
															<a href="<s:url action='EliminaSocio' namespace='/amministratore/socio'>
															<s:param name="socio.idPersonaFisica"><s:property value="idPersonaFisica" /></s:param>
															</s:url>">Elimina</a> <br/>
															<a href="<s:url action='ModificaSocio' namespace='/amministratore/socio'> 
															<s:param name="socio.idPersonaFisica"><s:property value="idPersonaFisica" /></s:param>
															</s:url>">Modifica</a>
															 <br/>
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

				</div>

			</div>
		</div>
		<div class="profile-tabs"></div>

	</div>

	</div>


	<%@ include file="../../../webApp/layout/Footer.jsp"%>


</body>

</html>
