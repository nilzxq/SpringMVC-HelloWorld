<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'index.jsp' starting page</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
  </head>
  
  <body>
  <a href="/SpringMVC-HelloWorld/springmvc/testParams?userName=1000&age=11">跳转到testParams请求地址</a>
  <form action="/SpringMVC-HelloWorld/springmvc/testMethod" method="post">
  <input type="submit" value="提交到/SpringMVC-HelloWorld/springmvc/testMethod post请求">
  </form>
   <a href="/SpringMVC-HelloWorld/springmvc/springMVCTest">跳转到类路径+方法路径</a>
  </body>
</html>
