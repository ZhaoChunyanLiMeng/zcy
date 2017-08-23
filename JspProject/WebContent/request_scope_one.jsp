<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
		request.setAttribute("bookName", "JAVA EE");
	    request.setAttribute("author", "颜群");
	    request.getRequestDispatcher("request_scope_two.jsp").forward(request, response);
	%>
</body>
</html>