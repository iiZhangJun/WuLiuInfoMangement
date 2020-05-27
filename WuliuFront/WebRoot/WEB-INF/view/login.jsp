<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>配送点后台登录页</title>
   	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<link rel="stylesheet" type="text/css" href="<%=basePath%>css/themes/icon.css">
	<link rel="stylesheet" type="text/css" href="<%=basePath%>css/themes/default/easyui.css">
	<link rel="stylesheet" type="text/css" href="<%=basePath%>css/demo.css">
	<script type="text/javascript" src="<%=basePath%>js/jquery.min.js"></script>
	<script type="text/javascript" src="<%=basePath%>js/jquery.easyui.min.js"></script>
	
</head>

<body>
	
	<div style="margin-left:450px; margin-top:110px;">
		<form action="login.do" method="post">
			<div class="easyui-panel" title="用户登录" style="width:400px;padding:30px 70px 20px 70px;">
				<div style="margin-bottom:10px">
					<input class="easyui-textbox" id="uname" name="uname" style="width:100%;height:40px;padding:12px" data-options="prompt:'用  户   名',iconCls:'icon-man',iconWidth:38">
				</div>
				<div style="margin-bottom:10px">
					<input class="easyui-textbox" id="pwd" name="pwd" type="password" style="width:100%;height:40px;padding:12px" data-options="prompt:'密        码',iconCls:'icon-lock',iconWidth:38">   
				<br/>
				<div style="margin-bottom:20px; clear:both;">
				<br/>
					<input type="checkbox" checked="checked">
					<span>记住密码</span>
				</div>
				<div>
				 	<span style="color: red; font-size: 8pt">${msg}</span>
				</div>
				<br/>
				<div align="center">
					<input type="submit" class="easyui-linkbutton" value="登录" data-options="iconCls:'icon-ok'" style="padding:5px 0px;width:100px;"/>		
				</div>
		     
			</div>
		</form>
    </div>

</body>
</html>
