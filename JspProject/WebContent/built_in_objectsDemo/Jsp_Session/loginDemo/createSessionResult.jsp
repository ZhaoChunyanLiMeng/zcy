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
   //获取session的值
   out.print("sessionId:"+session.getId()+"<br/>");
   Cookie[] cookies = request.getCookies();
   //前面学Cookie时已经知道，Cookie中会默认保存一个jsessionid的名和值
   //获取cook中jsessionid的名和值
out.print(cookies[0].getName()+
"---"+cookies[0].getValue());
  %>
</body>
</html>