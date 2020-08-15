<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.List,br.com.task.manager.servlet.Task"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Java Standard Taglib</title>
</head>
<body>

	<c:if test="${not empty task}">
		Task ${ task } successfully registered!
	</c:if>
	
	Task list: <br />
	
	<ul>
		<c:forEach items="${tasks}" var="task">
			
			<li>
				${task.name } - <fmt:formatDate value="${task.deadline }" pattern="MM/ddyyyy"/> 
				<a href="/manager/showTask?id=${task.id }">edit</a>
				<a href="/manager/removeTask?id=${task.id }">remove</a>
			</li>
		</c:forEach>
	</ul>
	
</body>
</html>



