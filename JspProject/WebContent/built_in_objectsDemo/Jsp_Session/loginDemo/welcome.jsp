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
		//进入欢迎页面前，先根据session的作用域内判断用户是否已经登录，若还没登录，则返回登录界面
		String loginName=(String)session.getAttribute("loginName");
	    if(loginName==null){
	    	response.sendRedirect("login.jsp");//用户还没有登录
	    }else{
	    	out.print("登录成功！欢迎您<strong>"+loginName+"<br/>");
	    	out.print("<a href='logout.jsp'>注销</a>");
	    }
	%>
</body>
</html>