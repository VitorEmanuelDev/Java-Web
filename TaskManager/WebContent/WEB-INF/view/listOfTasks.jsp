<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.List,TaskManager.model.Task"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Java Standard Taglib</title>
</head>
<body>
	<c:import url="parcialLogout.jsp" />

	Logged user: ${loggedUser.login }
	
	<br>
	<br>
	<br>

	<c:if test="${not empty task}">
		Task ${ task } successfully registered!
	</c:if>
	
	Task list: <br />
	
	<ul>
		<c:forEach items="${tasks}" var="empresa">
			
			<li>
				${task.description } - <fmt:formatDate value="${task.deadline }" pattern="MM/dd/yyyy"/> 
				<a href="/TaskManager/entry?action=ShowTask&id=${task.id }">edit</a>
				<a href="/TaskManager/entry?action=RemoveTask&id=${task.id }">remove</a>
			</li>
		</c:forEach>
	</ul>
	
</body>
</html>



