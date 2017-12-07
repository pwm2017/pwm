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

	<div class="section section-light-blue">
		<div class="container">
			<div id="menu-dropdown">
				<div class="row">
					<div class="col-md-6">

						<br>

					</div>
					<div class="col-md-6"></div>
				</div>
				<!-- end row -->

				<div class="tim-title">

					<br />
					<div id="navbar-dropdown">
						<nav class="navbar navbar-default">
						<div class="container-fluid">
							<!-- Brand and toggle get grouped for better mobile display -->
							<div class="navbar-header">
								<button type="button" class="navbar-toggle"
									data-toggle="collapse"
									data-target="#bs-example-navbar-collapse-1">
									<span class="sr-only">Toggle navigation</span> <span
										class="icon-bar"></span> <span class="icon-bar"></span> <span
										class="icon-bar"></span>
								</button>
								<a class="navbar-brand">Menu</a>
							</div>

							<!-- Collect the nav links, forms, and other content for toggling -->
							<div class="collapse navbar-collapse"
								id="bs-example-navbar-collapse-1">
								<ul class="nav navbar-nav pull-right">
									
									<li class="dropdown">
										<button href="#" class="dropdown-toggle btn"
											data-toggle="dropdown">
											Socio <b class="caret"></b>
										</button> <!--                                  You can add classes for different colours on the next element -->
										<ul class="dropdown-menu dropdown-primary dropdown-menu-right">
											<li><a href="<s:url action='InserisciSocioRedirect' namespace='/'/>">Aggiungi Socio</a></li>
											<li class="divider"></li>
											<li><a href="#">Modifica Socio</a></li>
											<li class="divider"></li>
											<li><a href="#">Elimina Socio</a></li>
											<li class="divider"></li>
											<li><a href="#">Elenco Soci</a></li>
											
										</ul>
									</li>
									
									<li class="dropdown">
										<button href="#" class="dropdown-toggle btn"
											data-toggle="dropdown">
											Socio <b class="caret"></b>
										</button> <!--                                  You can add classes for different colours on the next element -->
										<ul class="dropdown-menu dropdown-primary dropdown-menu-right">
											<li><a href="<s:url action='InserisciSocioRedirect' namespace='/'/>">Aggiungi Socio</a></li>
											<li class="divider"></li>
											<li><a href="#">Modifica Socio</a></li>
											<li class="divider"></li>
											<li><a href="#">Elimina Socio</a></li>
											<li class="divider"></li>
											<li><a href="#">Elenco Soci</a></li>
											
										</ul>
									</li>
								</ul>
							</div>
							<!-- /.navbar-collapse -->
						</div>
						<!-- /.container-fluid --> </nav>

					</div>
					<!--  end navbar -->
				</div>
				<br />
				<div class="tim-title"></div>
				<div class="tim-title"></div>
				<div class="tim-title"></div>
			</div>
			<!-- end menu-dropdown -->

		</div>
	</div>
	</div>


	<div class="profile-content section-nude">
		<div class="container">
			<div class="row owner">
				<div
					class="col-md-2 col-md-offset-5 col-sm-4 col-sm-offset-4 col-xs-6 col-xs-offset-3 text-center">
					<div class="avatar">
						<img src="/eureca/webApp/assets/img/chet_faker_2.jpg"
							alt="Circle Image"
							class="img-circle img-no-padding img-responsive">
					</div>
					<div class="name">
						<h4>
							Chet Faker<br /> <small>Music Producer</small>
						</h4>
					</div>
				</div>
			</div>
			<div class="row">
				<div class="col-md-6 col-md-offset-3 text-center">
					<p>i.</p>
					<br />
					<btn class="btn"> <i class="fa fa-cog"></i> Settings</btn>
				</div>
			</div>
			<div class="profile-tabs"></div>

		</div>

	</div>


	<%@ include file="../../../webApp/layout/Footer.jsp"%>


</body>

</html>
