<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%@ include file="layout/Head.jsp"%>

<title><s:property value="evento.nome" /></title>

</head>
<body>

	<%@ include file="layout/Header.jsp"%>

	<div class="main">

		<div class="section section-light-brown landing-section">
			<div class="container tim-container text-center">
				<div class="row">

					<div class="col-md-8 col-md-offset-2 text-center"></div>

					<div class="col-md-4">

						<s:if test="evento.locandina==''">

							<img src="/eureca/webApp/assets/img/placeholder.jpg"
								alt="Circle Image" class="img-rounded img-responsive">

						</s:if>
						<s:else>

							<img
								src="webApp/assets/img/eventi/<s:property value="evento.locandina"/>"
								alt="Circle Image" class="img-rounded img-responsive">
						</s:else>
					</div>

					<div class="col-md-6 column">
						<h2>
							<s:property value="evento.nome" />
						</h2>
						<p>
							<s:property value="evento.descrizione" />
						</p>
						<a class="btn "
							href="<s:url action='RedirectPertecipaEvento' namespace='/evento'>
								 <s:param name="evento.idEvento"><s:property value="evento.idEvento" /></s:param>
											</s:url>">Partecipa<i
							class="fa fa-chevron-right"></i></a>

					</div>
				</div>


			</div>

		</div>
	</div>


	<%@ include file="layout/Footer.jsp"%>

</body>
</html>