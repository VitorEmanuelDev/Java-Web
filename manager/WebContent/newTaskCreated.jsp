<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
	<body>
	
		<c:if test="${not empty task}">
			Task ${ task } successfully registered!
		</c:if>
		
		<c:if test="${empty task}">
			No task was registered.
		</c:if>

	</body>
</html>
