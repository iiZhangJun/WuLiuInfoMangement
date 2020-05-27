<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
//String times = (String)request.getAttribute("times");
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>总公司订单信息页</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	
	<link rel="stylesheet" type="text/css" href="<%=basePath%>style/themes/default/easyui.css">
	<link rel="stylesheet" type="text/css" href="<%=basePath%>style/themes/icon.css">
	<link rel="stylesheet" type="text/css" href="<%=basePath%>style/demo.css">
    <link rel="stylesheet" type="text/css" href="<%=basePath%>style/themes/color.css">
	<script type="text/javascript" src="<%=basePath%>js/jquery.min.js"></script>
	<script type="text/javascript" src="<%=basePath%>js/jquery.easyui.min.js"></script>

	<script type="text/javascript">


	$(function(){
    		$('#dg').datagrid({
				title:'订单信息',									
				nowrap: false,
				striped: true,								
				url: null,
				rownumbers:true,
				loadMsg : 'processing, please wait …',			
				columns:[[					
					{field:'orderid',title:'订单编号',align:'center',width:127},					
					{field:'stptaddr',title:'始发点',align:'center',width:180},					
					{field:'edptaddr',title:'目的地',align:'center',width:180},	
					{field:'cost',title:'费用',align:'center',width:60},					
					{field:'sendname',title:'发件人',align:'center',width:80},
					{field:'recvname',title:'收件人',align:'center',width:80},
					{field:'state',title:'订单状态',align:'center',width:80},
					{field:'sendtime',title:'发件日期',align:'center',width:86,
						formatter: function(value,row,index){	
					           if(value != null){
					               var date = value.time;
							       var sendTime = new Date(date).toLocaleString();							   
							       return sendTime;
					           }   						    
						}					        
					},
					{field:'recvtime',title:'收件日期',align:'center',width:86,
						formatter: function(value,row,index){	
					           if(value != null){
					               var date = value.time;
							       var sendTime = new Date(date).toLocaleString();							   
							       return sendTime;
					           }   						    
						}					        
					},
					{field:'username',title:'配送员工',align:'center',width:85}
				]]				
			});			
    	});     	


	function queryorder() {
		debugger;
	    var url = "<%=basePath%>admin/getOrder.do?orderid=" + $('#orderid').val();
		$('#dg').datagrid('options').url = url;
	    $('#dg').datagrid('reload');

	}
	</script>
  </head>
  
  <body>

	<div class="easyui-tabs" style="width:1146px;height:631px; margin:-20px; margin-right:-40px; padding-right:-10px;">
		<div title="订单查询">
        	<div align="center">
            <br/>
            	订单编号：<input type="text" id="orderid" name="orderid"/>&nbsp;               
                <input type="button" onclick="queryorder()"  style="height:30px; width:50px" value="查询"/>
            </div>
        	<br/>
        	<table id="dg" class="easyui-datagrid" title="订单信息" style="width:1145px;height:auto" data-options="rownumbers:true,singleSelect:true,method:'get', pagination:true">          	      			
			</table>
        </div>
	</div>
    
</body>
</html>
