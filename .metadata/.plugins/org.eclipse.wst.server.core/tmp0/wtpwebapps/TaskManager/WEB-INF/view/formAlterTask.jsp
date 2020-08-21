<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>


<c:url value="/entry" var="linkEntryServlet"/>

<!DOCTYPE html>
<html>
<head>
<meta charset="IUTF-8">
<title>Insert title here</title>
</head>
<body>

	<c:import url="parcialLogout.jsp" />
	

	<form action="${linkEntryServlet }" method="post">
	
		Description: <input type="text" name="description" value="${task.description }" />
		Deadline: <input type="text" name="deadline"  value="<fmt:formatDate value="${task.deadline }" pattern="MM/dd/yyyy"/>" />
		<input type="hidden" name="id" value="${task.id }">
		<input type="hidden" name="action" value="AlterTask">
		<input type="submit" />
	</form>

</body>
</html>