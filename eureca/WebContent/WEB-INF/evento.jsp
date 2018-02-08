<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<html>

	<head>
    <title>Ricerca Utenti</title>
	</head>

	<body>
	    <hr>
		<h4>Inserisci l'id dell'utente da cercare</h4> 	
		<s:form action="EventoJson" method="GET">
    	<s:textfield name="id" label="Id"/>
    	<s:submit/>
		</s:form>
	    <hr>	
	</body>
	
</html>
