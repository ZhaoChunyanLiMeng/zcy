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
		pageContext.setAttribute("bookName", "JAVA EE");
	    pageContext.setAttribute("author", "颜群");
	%>
	<%--获取并显示bookName属性的值 --%>
	书名：<%=pageContext.getAttribute("bookName") %>
	作者：<%=pageContext.getAttribute("author") %>
</body>
</html>