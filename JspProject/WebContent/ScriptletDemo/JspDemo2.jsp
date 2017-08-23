<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%!
		public String bookName;
		public String author;
		public void initInfo(){  //变量初始化方法
			bookName="JAVA EE";
			author="颜路";
		}
	%>
	<%  //！！！注意此处为<%
		initInfo();
		out.print("书名："+bookName+"<br/>作者:"+author);
	%>
</body>
</html>