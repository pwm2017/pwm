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

	<div class="profile-content section-nude">
		<div class="container">
			<div class="row owner">
				<div
					class="col-md-2 col-md-offset-5 col-sm-4 col-sm-offset-4 col-xs-6 col-xs-offset-3 text-center">
					<div class="avatar">
						<s:if test="#session.amministratore.foto==null">
							<img src="/eureca/webApp/assets/img/placeholder.jpg"
								alt="Circle Image"
								class="img-circle img-no-padding img-responsive">
						</s:if>
						<s:else>
							<img
								src="/eureca/webApp/assets/img/soci/<s:property value="#session.amministratore.foto"/>"
								alt="Circle Image"
								class="img-circle img-no-padding img-responsive">
						</s:else>
					</div>
					<div class="name">
						<h4>
							<s:property value="#session.amministratore.nome" />
							<br /> <small><s:property
									value="#session.amministratore.cognome" /></small>
						</h4>
					</div>
				</div>
			</div>
			<div class="row">
				<div class="col-md-6 col-md-offset-3 text-center">
					<p>Amministratore</p>
					<br />
					<btn class="btn"> <i class="fa fa-cog"></i> <a
						href="<s:url action='SetSocio' namespace='/amministratore/socio'>
						<s:param name="socio.idPersonaFisica"><s:property value="#session.amministratore.idPersonaFisica" /></s:param>
						</s:url>">Settings</a>

					</btn>
				</div>
			</div>
			<div class="profile-tabs"></div>

		</div>

	</div>


	<%@ include file="../../../webApp/layout/Footer.jsp"%>


</body>

</html>
