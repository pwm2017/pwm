<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@ taglib prefix="s" uri="/struts-tags"%>
<html>
<title><s:text name="title.login" /></title>
<head>

<%@ include file="layout/Head.jsp"%>

</head>

<body>

	<s:include value="layout/Header.jsp"></s:include>
	
	<div class="main">
		<div class="section">
			<div class="container tim-container">
				<div class="tim-title">
					<h2>
						<s:text name="title.login" />
					</h2>
				</div>
			</div>
		</div>
	</div>
  
	<div class="container">
		<div class="row">
			<div
				class="col-md-4 col-md-offset-4 col-sm-6 col-sm-offset-3 col-xs-10 col-xs-offset-1">
				<div class="register-card">
					<h3 class="title">
						<s:text name="title.login" />
					</h3>
					<hr>
					<s:form class="register-form" action="Login">

						<s:textfield name="username" class="form-control" key="label.user.username"
							placeholder="Username" />

						<s:password name="password" class="form-control" key="label.user.password"
							placeholder="Password" />
						<s:submit class="btn btn-danger btn-block" value="Accedi" />

					</s:form>
					<hr>
				</div>
			</div>
		</div>
	</div>

	<%@ include file="layout/Footer.jsp"%>
</body>

</html>
