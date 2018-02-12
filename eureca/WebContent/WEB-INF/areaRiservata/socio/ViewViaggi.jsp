<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%@ include file="../../../webApp/layout/Head.jsp"%>

<title><s:text name="Viaggi" /></title>

</head>
<body>

	<%@ include file="../../../webApp/layout/Header.jsp"%>
	<%@ include file="MenuSocio.jsp"%>

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
				<s:if test="listaViaggi.isEmpty()">

					<div
						class="col-md-8 col-md-offset-2 text-center alert alert-warning">
						<h2>Non Ci sono Viaggi a cui puoi partecipare!!</h2>
					</div>
				</s:if>

				<s:iterator value="listaViaggi">

					<div class="col-md-4">

						<h4>
							<s:property value="nome" />
						</h4>
						<s:if test="locandina==''">

							<img src="/eureca/webApp/assets/img/placeholder.jpg"
								alt="Circle Image" class="img-rounded img-responsive"
								style="width: 300px; height: 300px;">

						</s:if>
						<s:else>

							<img
								src="/eureca/webApp/assets/img/viaggi/<s:property value="locandina"/>"
								alt="Imagine evento <s:property value="nome"/>"
								class="img-rounded img-responsive"
								style="width: 300px; height: 300px;">
S
						</s:else>
						<div class="img-details">
							<p>
								Luogo:
								<s:property value="luogo" />
							</p>
							<hr>

							<p>
								Posti rimanenti:
								<s:property value="numPartecipanti" />
							</p>
							<hr>
							<p>
								Descricione:
								<s:property value="descricione" />
							</p>
							<hr>
							<p>
								Data Inizio:
								<s:property value="dataInizio" />
							</p>
							<hr>

							<p>
								Data Fine:
								<s:property value="datafine" />
							</p>
							<hr>


						</div>

						<div class="col-md-6 col-md-offset-2">

							<a class="btn "
								href="<s:url action='PartecipaViaggio' namespace='/socio/viaggio'>
								 <s:param name="viaggio.idViaggio"><s:property value="idViaggio" /></s:param>
											</s:url>">Partecipa</a>
						</div>
					</div>

				</s:iterator>

			</div>
		</div>
	</div>

	<%@ include file="../../../webApp/layout/Footer.jsp"%>

</body>
</html>