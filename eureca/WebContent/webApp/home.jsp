<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%@ include file="layout/Head.jsp"%>

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
					</ol>

					<!-- Wrapper for slides -->
					<div class="carousel-inner">
						<div class="item active">
							<img src="webApp/assets/img/pencils.jpg" alt="Awesome Image">
						</div>
						<div class="item">
							<img src="webApp/assets/img/shoes.jpg" alt="Awesome Image">
						</div>
						<div class="item">
							<img src="webApp/assets/img/types.jpg" alt="Awesome Image">
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



		<div class="section section-nude section-with-space">
			<div class="container tim-container">
				<div class="row">
					<div class="col-md-8 col-md-offset-2 text-center">
						<h2>bohhhhhhhhhhhhhhh</h2>
						<p>ciiiiiiaaaaaaaaaa</p>
					</div>
					<div
						class="col-xs-8 col-xs-offset-2 col-sm-4 col-sm-offset-4 col-md-4 col-md-offset-4 download-area">
						<a href="http://www.creative-tim.com/product/paper-kit"
							class="btn btn-danger btn-fill btn-block btn-lg">Download</a>
					</div>
				</div>
				<div class="row sharing-area text-center">
					<h3>Sharing is caring!</h3>
					<a href="#" class="btn"> <i class="fa fa-twitter"></i> Twitter
					</a> <a href="#" class="btn"> <i class="fa fa-facebook-square"></i>
						Facebook
					</a>
				</div>
			</div>
		</div>
	</div>

	<%@ include file="layout/Footer.jsp"%>
	</div>
</body>

</html>