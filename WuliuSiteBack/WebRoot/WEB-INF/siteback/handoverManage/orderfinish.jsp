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
    
    <title>My JSP 'confirm_hand.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<link href="<%=basePath%>css/themes/default/easyui.css" rel="stylesheet" />
	<link href="<%=basePath%>css/themes/icon.css" rel="stylesheet" />
	<link href="<%=basePath%>css/themes/color.css" rel="stylesheet" />
	<link href="<%=basePath%>css/apply.css" rel="stylesheet" />
	<script src="<%=basePath%>js/jquery.min.js"></script>
	<script src="<%=basePath%>js/jquery.easyui.min.js"></script>
	
	

  </head>
  
  <body>
  		<div style="clear: both;">
				<table class="easyui-datagrid" id="review"></table>
		</div>
		<div id="tb" style="padding:2px 5px;">
			<input type="hidden" id="pointid" value="${point.pointid}" name="pointid"/>
			请输入物流单号: <input class="easyui-textbox" id="orderno">
			<a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-search" onclick="query()">查询</a>
			<a id="obtain" href="javascript:void(0);" class="easyui-linkbutton" iconCls="icon-ok" onclick="finishHandover()">终点收货</a>
		</div>
		
		<script type="text/javascript">
		$(function() {
			$('#review').datagrid( {
				title : '中转订单',
				height : 500,
				toolbar : '#tb',
				nowrap : false,
				striped : true,
				url : null,
				rownumbers : true,
				pagination : true,
				pageList : [ 10 ],
				loadMsg : '加载中请等待...',
				singleSelect : false,
				selectOnCheck : true,
				checkOnSelect : true,
				columns : [ [ {field : 'chk',checkbox : true},
				{field : 'joinid',title : '交接单号',hidden:'true'}, 
				{field : 'orderid',title : '订单ID',width : 100}, 
				{field : 'sendname',title : '发件人姓名',width : 80}, 
				{field : 'sendphone',title : '发件人电话',width : 80},
				{field : 'sendaddress',title : '发件地址',width : 150}, 
				{field : 'recvname',title : '收件人姓名',width : 80}, 
				{field : 'recvphone',title : '收件人电话',width : 80}, 
				{field : 'recvaddress',title : '收件地址',width : 150}, 
				{field : 'cost',title : '费用',width : 80}, 
				{field : 'state',title : '订单状态',width : 80}
				] ]
			});
		});

		
		function query(){
			var url="<%=basePath%>siteBack/getPassPointOrderInfo.do?orderid=" + $('#orderno').val() + "&pointid=" + $('#pointid').val() + "&flag=end";
			$('#review').datagrid('options').url = url;
			$('#review').datagrid('reload');
		}
   
   		function finishHandover(){
   			var checkedItems = $('#review').datagrid('getChecked');
			var ids="";
			var joinids = "";
			for ( var i = 0; i < checkedItems.length; i++) {
				ids = checkedItems[i].orderid +"," +ids;
				joinids = checkedItems[i].joinid +"," + joinids;
			}
			var pointid = $('#pointid').val();
			var action ="<%=basePath%>siteBack/finishHandover.do?ids=" + ids + "&endpointid=" + pointid + "&joinids=" + joinids;
				$.ajax({
					url:action,
					type:'post',
					success:function(data){
						if(data != 0){
							alert('收货成功，请立即配送');
							$('#w').window('close');
							query();
						}else{
							alert('绑定失败');
						}
					}
				});
   		}	
		</script>
  </body>
</html>
