<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%@ include file="layout/Head.jsp"%>

<title><s:text name="global.title.allEvents" /></title>

</head>
<body>

	<%@ include file="layout/Header.jsp"%>

	<div class="main">

		<div class="section section-white section-with-space">
			<div class="container tim-container text-center">
				<div class="row">

					<div class="col-md-8 col-md-offset-2 text-center">
						<h2>
							<s:text name="global.title.Events" />
						</h2>
						<p>
							<s:text name="global.title.EventsDettagli" />
						</p>
					</div>
				</div>
				<s:if test="eventi.isEmpty()">
					<div
						class="col-md-8 col-md-offset-2 text-center alert alert-warning">
						<h3>Non ci sono eventi in programma</h3>
					</div>
				</s:if>
				<s:iterator value="eventi">

					<div class="col-md-4">

						<h4>
							<s:property value="nome" />
						</h4>
						<s:if test="locandina==''">
							<a
								href="<s:url action='Evento' namespace='/'>
							<s:param name="evento.idEvento"><s:property value="idEvento" /></s:param>
											</s:url>">
								<img src="/eureca/webApp/assets/img/placeholder.jpg"
								alt="Circle Image" class="img-rounded img-responsive"
								style="width: 300px; height: 300px;">
							</a>
						</s:if>
						<s:else>
							<a
								href="<s:url action='Evento' namespace='/'>
							<s:param name="evento.idEvento"><s:property value="idEvento" /></s:param>
											</s:url>">
								<img
								src="/eureca/webApp/assets/img/eventi/<s:property value="locandina"/>"
								alt="Imagine evento <s:property value="nome"/>"
								class="img-rounded img-responsive"
								style="width: 300px; height: 300px;">
							</a>
						</s:else>
						<div class="img-details">
							<p>
								<s:property value="luogo" />
							</p>
						</div>

						<div class="col-md-6 col-md-offset-2">

							<a class="btn "
								href="<s:url action='RedirectPertecipaEvento' namespace='/evento'>
								 <s:param name="evento.idEvento"><s:property value="idEvento" /></s:param>
											</s:url>"><s:text name="global.title.Partecipa"/></a>
						</div>
					</div>

				</s:iterator>

				<div class="row">
					<div class="col-md-12">
						<div class="product-pagination text-center">
							<nav>
							<ul class="pagination">
								<s:iterator begin="1" end="pagine" status="pagina">
									<li><a
										href="<s:url action='TuttiGliEventi' namespace='/'><s:param name="numeroPagina"><s:property value="#pagina.index"/></s:param></s:url>"><s:property
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


	<%@ include file="layout/Footer.jsp"%>

</body>
</html>