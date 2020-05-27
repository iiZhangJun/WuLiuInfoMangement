<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<base href="<%=basePath%>">

		<title>配送点---订单状态修改</title>

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
		<title>订单状态修改</title>

	</head>

	<body>
		<div style="clear: both;">
			<table class="easyui-datagrid" id="review"></table>
		</div>
		<div id="tb" style="padding: 2px 5px;">
			订单编号：
			<input id="orderno" class="easyui-validatebox textbox"
				data-options="prompt:'Enter User Name.',required:true"
				style="height: 21px;">
			<input value="${point.pointid}" type="hidden" name="pointId" id="pointId">
			<a href="javascript:void(0)" class="easyui-linkbutton"
				iconCls="icon-search" onclick="query()">查询</a>
			<a id="finishhand" href="javascript:void(0);" class="easyui-linkbutton" iconCls="icon-ok" onclick="receiptOrder()">客户签收</a>
		</div>
					
		<script type="text/javascript">
		function query(){
		var url="<%=basePath%>siteBack/getArrivalOrder.do?orderid=" + $('#orderno').val() + "&pointid=" + $('#pointId').val();
		$('#review').datagrid('options').url = url;
		$('#review').datagrid('reload');
		}
		$(function() {
			$('#review').datagrid( {
				title : '',
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
				columns : [ [  {field : 'chk',checkbox : true},
				{field : 'orderid',title : '单号',width : 100},
				{field:'sendname',title:'发件人姓名',width:80}, 
				{field:'sendphone',title:'发件人电话',width:80},
				{field:'sendaddress',title:'发件地址',width:120},
				{field:'recvname',title:'收件人姓名',width:80},
				{field:'recvphone',title:'收件人电话',width:80},
				{field:'recvaddress',title:'收件地址',width:120},
				{field:'safe',title:'保价费',width:80},
				{field:'weight',title:'质量',width:80},
				{field:'fastcost',title:'加急费',width:80},
				{field:'cost',title:'费用',width:80},
				{field : 'state',title : '订单状态',width : 80}
				] ]
			});
		});
 
 		function receiptOrder(){
   			var checkedItems = $('#review').datagrid('getChecked');
			var ids="";
			for ( var i = 0; i < checkedItems.length; i++) {
				ids = checkedItems[i].orderid +"," +ids;
			}
			var pointid = $('#pointid').val();
			var action ="<%=basePath%>siteBack/receiptOrder.do?ids=" + ids + "&state=已签收";
				$.ajax({
					url:action,
					type:'post',
					success:function(data){
						if(data != 0){
							alert('客户签收');
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
