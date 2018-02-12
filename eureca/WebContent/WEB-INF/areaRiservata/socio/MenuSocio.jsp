<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

</head>
<body>

	<div class="section section-light-brown landing-section">
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
									<a
										href="<s:url action='AuthenticatedSocio.action' namespace='/areaRiservata/socio'/>"
										class="btn">Home</a>


									<li class="dropdown">
										<button href="#" class="dropdown-toggle btn"
											data-toggle="dropdown">
											Viaggi <b class="caret"></b>
										</button> <!--                                  You can add classes for different colours on the next element -->
										<ul class="dropdown-menu dropdown-primary dropdown-menu-right">
											<li><a
												href="<s:url action='VisualizzaViaggiRedirect' namespace='/socio/viaggio'/>">Visualizza
													Viaggi</a></li>
											<li class="divider"></li>

										</ul>
									</li>

									<li class="dropdown">
										<button href="#" class="dropdown-toggle btn"
											data-toggle="dropdown">
											Attività <b class="caret"></b>
										</button> <!--                                  You can add classes for different colours on the next element -->
										<ul class="dropdown-menu dropdown-primary dropdown-menu-right">
											<li><a
												href="<s:url action='VisualizzaAttivita' namespace='/socio'/>">Visualizza
													Attività</a>
					
											<li class="divider"></li>

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


			</div>
			<!-- end menu-dropdown -->

		</div>
	</div>

	<s:if test="hasActionMessages()">
		<div class="alert alert-success">
			<h4>
				<s:actionmessage />
			</h4>
		</div>
	</s:if>

	<s:if test="hasActionError()">
		<div class="alert alert-danger">
			<h4>
					<s:actionerror />
			</h4>
		</div>

	</s:if>
</body>
</html>