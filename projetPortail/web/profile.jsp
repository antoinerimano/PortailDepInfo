<%-- 
    Document   : profile
    Created on : Apr 10, 2023, 2:34:31 AM
    Author     : 15146
--%>

<!DOCTYPE html>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<html lang="en">
<head>
<title>Portail d'informatique</title>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
<link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Lato">
<link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Montserrat">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<link rel="stylesheet" href="./style/style.css">
<style>
body,h1,h2,h3,h4,h5,h6 {font-family: "Lato", sans-serif}
.w3-bar,h1,button {font-family: "Montserrat", sans-serif}
.fa-anchor,.fa-coffee {font-size:200px}

</style>
</head>
<body>


<jsp:include page="enTete.jsp"/>

	<h1>Mon Profile</h1>
	<table>
		<tr>
			<td>Nom complet:</td>
			<td><%=session.getAttribute("nom")%> <%=session.getAttribute("prenom")%></td>
		</tr>
                <tr>
			<td>Code Permanent:</td>
			<td><%=session.getAttribute("codeP")%></td>
		</tr>
		<tr>
			<td>Date de naissance:</td>
			<td><%=session.getAttribute("dateNaissance")%></td>
		</tr>
		<c:if test="${programme != null}">
			<tr>
				<td>Type de Programme:</td>
				<td><%=session.getAttribute("programme")%></td>
			</tr>
			<tr>
				<td>Type d'etudiant:</td>
				<td><%=session.getAttribute("typeEtudiant")%></td>
			</tr>
			<tr>
				<td>Anciennete:</td>
				<td><%=session.getAttribute("ancien")%></td>
			</tr>
		</c:if>
	</table>
</body>
</html>