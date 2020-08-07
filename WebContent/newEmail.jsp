<!DOCTYPE html>

<%
   //scriptlet
	String emailUser = (String)request.getAttribute("email");
	System.out.println(emailUser);

%>

<html>
	<body>
		Email '<%= (emailUser) %>' successfully registered!
	</body>
</html>