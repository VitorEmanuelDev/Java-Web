<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:url value="/entry" var="linkEntryServlet"/>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<form action="${linkEntryServlet }" method="post">
	
		Login: <input type="text" name="login"  />
		Password: <input type="password" name="password"  />
		
		<input type="hidden" name="action" value="Login">
	
		<input type="submit" />
	</form>

</body>
</html>