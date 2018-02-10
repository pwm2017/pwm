<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="s" uri="/struts-tags"%>
<html>
<head>

<%@ include file="../../../webApp/layout/Head.jsp"%>

<title><s:text name="title.gestisciViaggi" /></title>
</head>

<body>

	<%@ include file="../../../webApp/layout/Header.jsp"%>


	<%@ include file="MenuAdmin.jsp"%>
	<div class="main">
		<div class="section">
			<div class="container tim-container">
				<div class="tim-title">
					<h2>
						<s:text name="title.gestisciViaggi" />
					</h2>
				</div>
			</div>
		</div>
	</div>


	<s:if test="listaViaggi.isEmpty()">
		<div class="alert alert-success">
			<h4>
				<h3>Non ci sono viaggi</h3>
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
										<s:iterator value="listaViaggiPagina">
											<li>
												<div class="row">
													<%-- <s:property value="%{#incr.index}"/> --%>
													<div
														class="col-md-2 col-md-offset-0 col-xs-3 col-xs-offset-2">
														<s:if test="locandina==''">
															<img src="/eureca/webApp/assets/img/placeholder.jpg"
																alt="Circle Image"
																class="img-circle img-no-padding img-responsive">
														</s:if>
														<s:else>
															<img
																src="/eureca/webApp/assets/img/viaggi/<s:property value="locandina"/>"
																alt="Circle Image"
																class="img-circle img-no-padding img-responsive">
														</s:else>
													</div>
													<div class="col-md-7 col-xs-4">
														<h6>
															<s:property value="nome" />
															<br /> <small><s:property value="luogo" /></small>
														</h6>
													</div>
													<div class="col-md-3 col-xs-2">
														<h6>
															<a
																href="<s:url action='EliminaViaggio' namespace='/amministratore/viaggio'>
															<s:param name="viaggio.idViaggio"><s:property value="idViaggio" /></s:param>
															</s:url>">Elimina</a>
															<a
																href="<s:url action='SetViaggio' namespace='/amministratore/viaggio'> 
															<s:param name="viaggio.idViaggio"><s:property value="idViaggio" /></s:param>
															</s:url>">Edit</a>
														</h6>
													</div>
												</div>
											</li>
											<hr />
										</s:iterator>
										</ul>

										<div class="row">
											<div class="col-md-12">
												<div class="product-pagination text-center">
													<nav>
													<ul class="pagination">
														<s:iterator begin="1" end="pagine" status="pagina">
															<li><a
																href="<s:url action='GestisciViaggi' namespace='/amministratore/viaggio'><s:param name="numeroPagina"><s:property value="#pagina.index"/></s:param></s:url>"><s:property
																		value="#pagina.index+1" /></a></li>
														</s:iterator>
													</ul>
													</nav>
												</div>
											</div>
										</div>
								</div>
							</div>
						</div>
					</div>

					<div
						class="col-xs-9 col-xs-offset-2 col-sm-4 col-sm-offset-3 col-md-8 col-md-offset-5 download-area">
						<a class="btn btn-fill"
							href="<s:url action='InserisciViaggioRedirect' namespace='/amministratore/viaggio'/>">Aggiungi
							Viaggio</a>

					</div>


				</div>

			</div>
		</div>
		<div class="profile-tabs"></div>

	</div>


	<%@ include file="../../../webApp/layout/Footer.jsp"%>


</body>

</html>
