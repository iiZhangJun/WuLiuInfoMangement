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
			<a id="makehand" href="javascript:void(0);" class="easyui-linkbutton" iconCls="icon-ok" >中转交接</a>
		</div>
		<div id="w" class="easyui-window" title="中转交接" data-options="modal:true,closed:true,iconCls:'icon-save'" style="width: 600px; height: 400px;">
					<div style="height: 50px;"></div>
					<div align="center">
						交接班次
						<select name="classid" id="classid">
							<c:forEach var="classInfo" items="${classInfo}">
								<option value="${classInfo.tclassid}">
									${classInfo.roadname}  ::  ${classInfo.tclassstarttime} _____ ${classInfo.tclassendtime}
								</option>
							</c:forEach>
						</select>
					</div>
						<div style="height: 20px;"></div>
					<div align="center">
					起始配送点
						<select name="startpointid" id="startpointid" >
							<c:forEach var="bp" items="${points}">
								<option value="${bp.pointid}">
									${bp.pointname}
								</option>
							</c:forEach>
						</select>
					</div>
						<div style="height: 20px;"></div>
					<div align="center">
					终止配送点
						<select name="endpointid" id="endpointid">
							<c:forEach var="bp" items="${points}">
								<option value="${bp.pointid}">
									${bp.pointname}
								</option>
							</c:forEach>
						</select>
					</div>
						<div style="height: 20px;"></div>
					<div align="center">
						<input type="button"  value="绑定" onclick="createB()"/>
					</div>
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
		
		
		$(document).ready(function() {
			var data = ${point.pointid};
		 	$("#startpointid").find("option[value='"+data+"']").attr("selected",true);
		}); 

		
		$('#makehand').click(function() {
			
			$("#w").window({
		    		top:($(window).height() - 400) * 0.5,  
		    		left:($(window).width() - 600) * 0.5,
		            
		  		});
		  		
			$('#w').window('open');
			
		});
		
		function query(){
			var url="<%=basePath%>siteBack/getPassPointOrderInfo.do?orderid=" + $('#orderno').val() + "&pointid=" + $('#pointid').val() + "&flag=pass";
			$('#review').datagrid('options').url = url;
			$('#review').datagrid('reload');
		}
   
   		function createB() {	
				var checkedItems = $('#review').datagrid('getChecked');
				var ids="";
				var joinids = "";
				for ( var i = 0; i < checkedItems.length; i++) {
					ids = checkedItems[i].orderid +"," +ids;
					joinids = checkedItems[i].joinid +"," + joinids;
				}
				var classid = document.getElementById("classid").value;	
				var startpointid = $('#startpointid').val();
				var endpointid = $('#endpointid').val();
				var action ="<%=basePath%>siteBack/transferHandover.do?classid=" + classid + "&ids=" + ids + "&startpointid=" +startpointid +"&endpointid=" +endpointid + "&joinids=" + joinids + "&flag=transfer";
				$.ajax({
					url:action,
					type:'post',
					success:function(data){
						if(data != 0){
							alert('绑定成功，交接单编号为：'+data);
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
