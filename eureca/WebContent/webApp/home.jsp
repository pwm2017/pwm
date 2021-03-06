<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%@ include file="layout/Head.jsp"%>

<title><s:text name="global.title.home" /></title>

</head>
<body>

	<%@ include file="layout/Header.jsp"%>

	<div class="main">


		<div id="carousel">
			<div id="carousel-example-generic" class="carousel slide"
				data-ride="carousel">
				<div class="carousel slide" data-ride="carousel">

					<!-- Indicators -->
					<ol class="carousel-indicators">
						<li data-target="#carousel-example-generic" data-slide-to="0"
							class="active"></li>
						<li data-target="#carousel-example-generic" data-slide-to="1"></li>
						<li data-target="#carousel-example-generic" data-slide-to="2"></li>
						<li data-target="#carousel-example-generic" data-slide-to="3"></li>
						<li data-target="#carousel-example-generic" data-slide-to="4"></li>
						<li data-target="#carousel-example-generic" data-slide-to="5"></li>
						<li data-target="#carousel-example-generic" data-slide-to="6"></li>
						<li data-target="#carousel-example-generic" data-slide-to="7"></li>

					</ol>

					<!-- Wrapper for slides -->
					<div class="carousel-inner">
						<div class="item active">
							<img src="webApp/assets/img/s5.jpg" alt="Awesome Image">
						</div>
						<div class="item">
							<img src="webApp/assets/img/s10.jpg" alt="Awesome Image">
						</div>
						<div class="item">
							<img src="webApp/assets/img/s8.jpg" alt="Awesome Image">
						</div>
						<div class="item">
							<img src="webApp/assets/img/s9.jpg" alt="Awesome Image">
						</div>
						<div class="item">
							<img src="webApp/assets/img/s2.jpg" alt="Awesome Image">
						</div>
						<div class="item">
							<img src="webApp/assets/img/s11.jpg" alt="Awesome Image">
						</div>
						<div class="item">
							<img src="webApp/assets/img/s4.jpg" alt="Awesome Image">
						</div>
					</div>

					<!-- Controls -->
					<a class="left carousel-control" href="#carousel-example-generic"
						data-slide="prev"> <span class="fa fa-angle-left"></span>
					</a> <a class="right carousel-control" href="#carousel-example-generic"
						data-slide="next"> <span class="fa fa-angle-right"></span>
					</a>
				</div>
			</div>
			<!-- end carousel -->

		</div>

		<div class="section section-dark-blue">
			<div class="container tim-container">
				<div class="row">
					<div class="col-md-8 col-md-offset-2 text-center">
						<h2>
							<s:text name="global.title.allEvents" />
						</h2>
					</div>

					<div
						class="col-xs-8 col-xs-offset-2 col-sm-4 col-sm-offset-4 col-md-4 col-md-offset-4 download-area">
						<a href="<s:url action='TuttiGliEventi' namespace='/'/>"
							class="btn btn-fill btn-block btn-lg"><s:text
								name="global.title.Events" /></a>

					</div>


					<div class="col-md-8 col-md-offset-2 text-center">
						<h2>
							<s:text name="global.title.RecentEvents" />
						</h2>

					</div>

				</div>
				<s:if test="eventiRecenti.isEmpty()">
					<div
						class="col-md-8 col-md-offset-2 text-center alert alert-warning">
						<h3>
							<s:text name="global.title.NoEvents" />
						</h3>
					</div>
				</s:if>
				<s:else>
					<s:iterator status="status" value="eventiRecenti">

							<div class="col-xs-6 col-sm-6 col-md-3">
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

								<div class="col-md-6 col-md-offset-3">

									<a class="btn btn-neutral btn-tooltip"
										href="<s:url action='RedirectPertecipaEvento' namespace='/evento'>
								 <s:param name="evento.idEvento"><s:property value="idEvento" /></s:param>
											</s:url>"><s:text
											name="global.title.Partecipa" /></a>
								</div>
							</div>

					</s:iterator>
				</s:else>
			</div>
		</div>
	</div>

	<%@ include file="layout/Footer.jsp"%>

</body>

</html>