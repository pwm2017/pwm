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

			<a href="<s:url action='HOME'/>">
				<div class="logo-container">
					<div class="logo">
						<img src="/eureca/webApp/assets/img/logo.png" alt="Eureca">
					</div>
					<div class="brand">Eureca</div>
				</div>
			</a>
		</div>

		<!-- Collect the nav links, forms, and other content for toggling -->
		<div class="collapse navbar-collapse" id="navigation-example-2">
			<ul class="nav navbar-nav navbar-right">
				
				<s:if test="%{!(#session.isEmpty())}">
				
				<li><a href="<s:url action='Logout' namespace='/'/>" class="btn btn-danger btn-fill">Logout</a>
				</li>
				<s:if test="%{(#session.amministratore.username!=null)}">
				<li><a href="<s:url action='AuthenticatedAmministratore' namespace='/secure'/>" class="btn btn-danger btn-simple">Area Riservata</a>
				</li>
				</s:if>
				
				<s:if test="%{(#session.socio.username!=null)}">
				<li><a href="<s:url action='AuthenticatedSocio.action' namespace='/secure'/>" class="btn btn-danger btn-simple">Area Riservata</a>
				</li>
				</s:if>
			
				</s:if>
				<s:else>
				<li><a href="<s:url action='LoginForm' namespace='/'/>" class="btn btn-danger btn-fill">Login </a></li>
				</s:else>
		
			</ul>
		</div>
	</div>
	</nav>


	<div class="wrapper">
		<div class="demo-header demo-header-image">
			<div class="motto">
				<h1 class="title-uppercase">Eureca</h1>
				<h3>Bhahahahahaah.</h3>
			</div>
		</div>

</body>
</html>