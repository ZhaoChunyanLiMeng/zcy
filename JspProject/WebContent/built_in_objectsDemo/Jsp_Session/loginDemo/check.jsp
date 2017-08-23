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
		request.setCharacterEncoding("UTF-8");//将post请求方式的编码设置为UTF-8
	    String name=request.getParameter("uname"); //接收名字
		String pwd=request.getParameter("upwd");
	    if(name.equals("lisi")&&pwd.equals("123456")){
	    	session.setAttribute("loginName", name);//登录成功后，将用户信息保存在session的作用域下
	    	session.setMaxInactiveInterval(60*10);//设置sesson的非活动时间为10分钟
	    	request.getRequestDispatcher("welcome.jsp").forward(request,response);//将请求信息重新定向到welcome.jsp页
	    }else{
	    	response.sendRedirect("login.jsp");//若登录失败，返回登录界面
	    }
	%>
</body>
</html>