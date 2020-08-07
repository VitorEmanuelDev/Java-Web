<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="java.util.List, teste.servlet.Email"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
	<body>
	Email list: 
	<br/>
		<ul>
        <% 
        	List<Email> list = (List<Email>)request.getAttribute("emails");
        	for (Email email : list) {
        %>
        		 
        		<li><%= email.getEmail() %></li>
        		 
		<%
			}
		%>  
		</ul>
	</body>
</html>