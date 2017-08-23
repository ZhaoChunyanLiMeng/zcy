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
             //session是内置对象，因此可以直接使用，而不用自己去创建
   session.setAttribute("school","Blue Bridge");
   response.sendRedirect("createSessionResult.jsp");
  %>
</body>
</html>