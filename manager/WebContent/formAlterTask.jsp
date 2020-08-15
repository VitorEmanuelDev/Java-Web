<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>


<c:url value="/alterTask" var="linkServletNewTask"/>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<form action="${linkServletNewTask }" method="post">
	
		Name: <input type="text" name="name" value="${task.name }" />
		Deadline: <input type="text" name="date"  value="<fmt:formatDate value="${task.deadline }" pattern="MM/dd/yyyy"/>" />
		<input type="hidden" name="id" value="${task.id }">
		<input type="submit" />
	</form>

</body>
</html>