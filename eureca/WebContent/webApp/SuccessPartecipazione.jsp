<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="s" uri="/struts-tags"%>
<html>

<head>

<%@ include file="../../../webApp/layout/Head.jsp"%>

<title>Grazie!!!</title>
</head>

<body>
	<%@ include file="../../../webApp/layout/Header.jsp"%>
	<div class="main">
		<div class="section">
			<div class="container tim-container">
				<div class="tim-title">
					<h2>
						Grazie!!!
					</h2>
				</div>
			</div>
		</div>
	</div>
	<div class="section">
		<div class="container">
			<div class="row">
				<div
					class="col-md-6 col-md-offset-3 col-sm-6 col-sm-offset-3 col-xs-10 col-xs-offset-1">

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
								<h3>
									<s:actionerror />
								</h3>
							</h4>
						</div>

					</s:if>
				</div>
			</div>
		</div>
	</div>

	<%@ include file="../../../webApp/layout/Footer.jsp"%>

</body>

</html>
