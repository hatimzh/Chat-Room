<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="dao.Account"%>
<%@ page import="main.AccountsManager"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Dashbord</title>

</head>
<body>
<%
AccountsManager managA = new AccountsManager();
%>
<form action="banne" method="get">
<%
for (Account a : managA.listaccounts()) {
%> 	<%= a.getName() %> <input type="hidden" name="banned" value="etudiant"><input type="submit" value="banne">  <br>
<%}
%>
</form>
</body>
</html>