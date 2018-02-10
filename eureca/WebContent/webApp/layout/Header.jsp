<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">


</head>
<body>

	<nav class="navbar navbar-ct-transparent" role="navigation-demo"
		id="demo-navbar">
	<div class="container">
		<!-- Brand and toggle get grouped for better mobile display -->
		<div class="navbar-header">

			<a href="<s:url action='HOME' namespace='/'/>">
				<div class="logo-container">
					<div class="logo">
						<img src="/eureca/webApp/assets/img/logo.png" alt="Eureca">
					</div>
					<div class="brand">
						<s:text name="global.title.home" />
					</div>
				</div>
			</a>
		</div>

		<!-- Collect the nav links, forms, and other content for toggling -->
		<div class="collapse navbar-collapse" id="navigation-example-2">
		
			<ul class="nav navbar-nav navbar-right" style="padding: 0px 15px" >


				<li class="dropdown">
					<button href="#" class="btn btn-fill" data-toggle="dropdown">
						Lingua <b class="caret"></b>
					</button> <!--                                  You can add classes for different colours on the next element -->
					<ul class="dropdown-menu dropdown-primary dropdown-menu-right">
						<li><a
							href="<s:url action='CambiaLingua' namespace='/'><s:param name="lang">EN</s:param></s:url>">English</a></li>
						<li class="divider"></li>

						<li><a
							href="<s:url action='CambiaLingua' namespace='/'><s:param name="lang">IT</s:param></s:url>">Italiano</a></li>

					</ul>
				</li>

			</ul>
			<ul class="nav navbar-nav navbar-right">
				<s:if test="%{!(#session.isEmpty())}">

					<li><a href="<s:url action='Logout' namespace='/'/>"
						class="btn btn-fill">Logout</a></li>
					<s:if test="%{(#session.amministratore.username!=null)}">
						<li><a
							href="<s:url action='AuthenticatedAmministratore' namespace='/areaRiservata/amministratore'/>"
							class="btn btn-fill">Area Riservata</a></li>
					</s:if>

					<s:if test="%{(#session.socio.username!=null)}">
						<li><a
							href="<s:url action='AuthenticatedSocio.action' namespace='/areaRiservata/socio'/>"
							class="btn btn-fill">Area Riservata</a></li>
					</s:if>

				</s:if>
				<s:else>
					<li><a href="<s:url action='LoginForm' namespace='/'/>"
						class="btn btn-fill">Login </a></li>
				</s:else>

			</ul>
		</div>
	</div>
	</nav>


	<div class="wrapper">
		<div class="demo-header demo-header-image">
			<div class="motto">
				<h1 class="title-uppercase">
					<s:text name="global.title.home" />
				</h1>
				<h3>Bhahahahahaah.</h3>
			</div>
		</div>
	</div>
</body>
</html>