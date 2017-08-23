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
		request.setCharacterEncoding("UTF-8");
	    String name=request.getParameter("uname");
	    String pwd=request.getParameter("upwd");
	    String[] hobbys=request.getParameterValues("hobby");
	    //out.print("用户名为："+name);
	    //out.print("<br/>密码为："+pwd);
	%>
	您注册的信息如下：<br/>
	用户名：<%=name%><br/>
	密码：<%= pwd %><br/>
	爱好：
	<%
		if(hobbys!=null){
			for(int i=0;i<hobbys.length;i++){
				out.print(hobbys[i]+"<br/>");
			}
		}
	%>
</body>
</html>