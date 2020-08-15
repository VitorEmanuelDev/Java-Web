<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:url value="/newTask" var="linkServletNewTask"/>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<form action="${linkServletNewTask }" method="post">
	
		Name: <input type="text" name="name"  />
		Deadline: <input type="text" name="date"  />
	
		<input type="submit" />
	</form>

</body>
</html>