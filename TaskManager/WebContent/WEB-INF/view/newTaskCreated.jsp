<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
	<body>
	
		<c:import url="parcialLogout.jsp" />
		
	
		<c:if test="${not empty task}">
			Task ${ task } successfully registered!
		</c:if>
		
		<c:if test="${empty task}">
			No task registered!
		</c:if>

	</body>
</html>
