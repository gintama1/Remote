<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8" %>
<%@ page import="a.LoginDao" %>
<%@ page import="a.customer2" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
</head>
<body>
<%
LoginDao _login=new LoginDao();
String name=request.getParameter("uname");
String pwd=request.getParameter("upwd");
customer2 user=new customer2(name,pwd);
int u=_login.Login(user);
if(u>0){
	out.print("登录成功");
}else{
	out.print("登录失败");
}

%>



</body>
</html>