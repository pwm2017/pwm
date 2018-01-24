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


	<%@ include file="MenuAdmin.jsp"%>
	<div class="main">
		<div class="section">
			<div class="container tim-container">
				<div class="tim-title">
					<h2>
						<s:text name="title.gestisciSoci" />
					</h2>
				</div>
			</div>
		</div>
	</div>
	
	
	<s:if test="listaSoci.isEmpty()">
	<div class="alert alert-success">
			<h4>
				<h3> Non ci sono soci</h3>
			</h4>
		</div>
	
	 </s:if>
	 
	
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
										<%-- <s:iterator value="listaSoci" status="incr"> --%>
										<s:iterator value="listaSoci" >
											<li>
												<div class="row">
												<%-- <s:property value="%{#incr.index}"/> --%>
													<div
														class="col-md-2 col-md-offset-0 col-xs-3 col-xs-offset-2">
														<s:if test="foto==null">
														<img
															src="/eureca/webApp/assets/img/placeholder.jpg"
															alt="Circle Image"
															class="img-circle img-no-padding img-responsive">
														</s:if>
														<s:else>
														<img
															src="/eureca/webApp/assets/img/soci/<s:property value="foto"/>"
															alt="Circle Image"
															class="img-circle img-no-padding img-responsive">
															</s:else>
													</div>
													<div class="col-md-7 col-xs-4">
														<h6>
															<s:property value="nome" />
															<br /> <small><s:property value="cognome" /></small> <a
																href="<s:url action='EliminaSocio' namespace='/amministratore/socio'>
															<s:param name="socio.idPersonaFisica"><s:property value="idPersonaFisica" /></s:param>
															</s:url>">Elimina</a>
															<a
																href="<s:url action='SetSocio' namespace='/amministratore/socio'> 
															<s:param name="socio.idPersonaFisica"><s:property value="idPersonaFisica" /></s:param>
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

				</div>

			</div>
		</div>
		<div class="profile-tabs"></div>

	</div>

	</div>


	<%@ include file="../../../webApp/layout/Footer.jsp"%>


</body>

</html>
