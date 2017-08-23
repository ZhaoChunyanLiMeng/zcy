<%--简单的注册及显示功能，演示request 对象 部分方法的使用   form表单  填入信息及显示 --%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="show.jsp "  method="post">
		用户名<input type="text"   name="uname"/>;<br/>
        密码<input  type="password"    name="upwd"/>;	<br/>
        爱好<br/>
        足球<input type="checkbox" name="hobby" value="足球"/> 
        篮球<input type="checkbox" name="hobby" value="篮球"/> 
        羽毛球<input type="checkbox" name="hobby"  value="羽毛球"/>          <br/>
        <input type="submit"  value="注册"/>
	</form>
</body>
</html>