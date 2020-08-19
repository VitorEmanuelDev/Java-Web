<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:url value="/entry" var="linkEntryServlet"/>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<c:import url="parcialLogout.jsp" />


	<form action="${linkEntryServlet }" method="post">
	
		Description: <input type="text" name="description"  />
		Deadline: <input type="text" name="data"  />
		
		<input type="hidden" name="action" value="NewTask">
	
		<input type="submit" />
	</form>

</body>
</html>