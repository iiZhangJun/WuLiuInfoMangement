<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
response.sendRedirect(basePath + "main.do");
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
   <TITLE>首页</TITLE>
	<meta http-equiv="Content-Style-Type" content="text/css">
	</HEAD>
  </head>

<BODY>

</BODY>
</HTML>
