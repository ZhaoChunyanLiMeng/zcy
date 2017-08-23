<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<%--通过application作用域来获取属性值 --%>
	<%
		application.setAttribute("bookName", "JAVA EE");
	    application.setAttribute("author", "颜群");
	    response.sendRedirect("application_scope_redirect_two.jsp");
	%>
</body>
</html>