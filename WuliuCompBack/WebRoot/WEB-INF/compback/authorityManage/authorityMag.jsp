<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'rightManage.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<link rel="stylesheet" type="text/css" href="<%=basePath%>style/themes/default/easyui.css">
	<link rel="stylesheet" type="text/css" href="<%=basePath%>style/themes/icon.css">
	<link rel="stylesheet" type="text/css" href="<%=basePath%>css/demo.css">
	<script type="text/javascript" src="<%=basePath%>js/jquery.min.js"></script>
	<script type="text/javascript" src="<%=basePath%>js/jquery.easyui.min.js"></script>
	<script type="text/javascript">
	
		$(function(){
    		$('#right').datagrid({
				title:'用户信息',									
				nowrap: false,
				striped: true,								
				url: null,
				rownumbers:true,
				loadMsg : 'processing, please wait …',			
				columns:[[					
					{field:'userid',title:'用户ID',align:'center',width:100},					
					{field:'username',title:'用户姓名',align:'center',width:250},					
					{field:'pointname',title:'所属单位',align:'center',width:250},									
				]]					
			});			
    	});     	


		function queryUser() {
		
		    var url = "<%=basePath%>admin/getUser.do?roleid=" + $('#r1').val();
		
			$('#right').datagrid('options').url = url;
		    $('#right').datagrid('reload');
		
		}


	function removeUser(){
			var userId = $('#right').datagrid('getSelected')['userid'];
			var r = confirm('请确认要删除此车辆吗?');
			if (r == true) {
			$.ajax( {
					type : "POST",
					dataType : "text",
					url : "<%=basePath%>admin/removeUser.do",
					data : "userid="  + userId,
					success : function(msg) {
						if(msg == 1){
							var r = confirm('删除成功');
								if(r == true){						  	
								queryUser();						 
								}
						}			
					}	
				});  
		
			}
		}
	function addUser(){
		var pointid = $('#pointid').val();
		var roleid = $('#roleid').val();
		var username = $('#username').val();
		var password = $('#password').val();
		$.ajax( {
					type : "POST",
					dataType : "text",
					url : "<%=basePath%>admin/addSiteUser.do",
					data : "username="  + username + '&password='+ password + '&roleid='+ roleid + '&pointid='+ pointid,
					success : function(msg) {
						if(msg == 1){
							var r = confirm('添加成功');
								if(r == true){						  	
								queryUser();						 
								}
						}			
					}	
		});  
	
	}
	
	</script>
  </head>
  
  <body>

	<div class="easyui-tabs" style="width:1146px;height:632px; margin:-20px; margin-right:-40px; padding-right:-10px">
    <div title="权限设置">
	    <table id="right" class="easyui-datagrid" title="权限设置" style="width:1145px;height:auto"
				data-options="rownumbers:true,pagination:true,singleSelect:true,method:'get',toolbar:'#tb',footer:'#ft'">		
		</table>
		<div id="tb" style="padding:2px 5px;">
			权限: 
			<select id="r1" name="right" panelHeight="auto" style="width:100px">
				<option value="2">配送点人员</option>
				<option value="1">管理员</option>
			</select>
			<a href="javascript:void(0)" class="easyui-linkbutton" onclick="queryUser()" iconCls="icon-search">查询</a>
			<a id="add" href="javascript:void(0)" class="easyui-linkbutton"  iconCls="icon-add">添加</a>
			<a href="javascript:void(0)" class="easyui-linkbutton" onclick="removeUser()" iconCls="icon-remove">删除</a>
		</div>
		<div id="w" class="easyui-window" title="增加配送站点人员"
				data-options="modal:true,closed:true,iconCls:'icon-save'"
				style="width: 600px; height: 400px;">
				<div style="height: 50px;"></div>
				<div align="center">
					配送点：
					<select name="pointid" id="pointid" 
							panelHeight="auto" style="width: 150px;height: 20px;border-color: rgb(149,184,231);border-radius: 6px;">
						<option value=""></option>
						<c:forEach var="bp" items="${points}">
							<option value="${bp.pointid}">
								${bp.pointname}
							</option>
						</c:forEach>
					</select>
				</div>
				<div style="height: 20px;"></div>
				<div align="center">
					用户名：
					<input id="username" name="username" class="easyui-textbox" type="text">
				</div>
				<div style="height: 20px;"></div>
				<div align="center">
					密&nbsp;&nbsp;&nbsp;码：
					<input id="password" name="password" class="easyui-textbox" type="text" value="12345">
				</div>
				<div style="height: 20px;"></div>
				<div align="center">
					角&nbsp;&nbsp;&nbsp;色：
					<select id="roleid" name="roleid" panelHeight="auto" style="width: 150px;height: 20px;border-color: rgb(149,184,231);border-radius: 6px;">
						<option value="2">配送站点人员</option>
						<option value="1">管理员</option>
					</select>	
				</div>
				<div style="height: 20px;"></div>
				<div align="center">
					<input type="button"  value="添加" onclick="addUser()"/>
				</div>
			</div>
    </div>
	</div>
	<script type="text/javascript">
		$('#add').click(function() {
			
			$("#w").window({
		    		top:($(window).height() - 400) * 0.5,  
		    		left:($(window).width() - 600) * 0.5,
		            
		  		});
		  		
			$('#w').window('open');
			
		});
	</script>
</body>
</html>
