<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<html>
<head>
<title>Login effettuato</title>
</head>

<body>

	<hr>
	<h3>Login effettuato</h3>
	<p>
		Benvenuto <s:property value="user.username" />
	</p>
	<p>Questa pagina è visibile solo se è stato effettuato il login.</p>


	<hr>
</body>

</html>
