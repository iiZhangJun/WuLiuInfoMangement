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

		<title>My JSP 'updateirder.jsp' starting page</title>

		<meta http-equiv="pragma" content="no-cache">
		<meta http-equiv="cache-control" content="no-cache">
		<meta http-equiv="expires" content="0">
		<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
		<meta http-equiv="description" content="This is my page">
		<link href="<%=basePath%>css/themes/default/easyui.css"
			rel="stylesheet" />
		<link href="<%=basePath%>css/themes/icon.css" rel="stylesheet" />
		<link href="<%=basePath%>css/themes/color.css" rel="stylesheet" />
		<link href="<%=basePath%>css/apply.css" rel="stylesheet" />
		<script src="<%=basePath%>js/jquery.min.js"></script>
		<script src="<%=basePath%>js/jquery.easyui.min.js"></script>

	</head>

	<body>

		<div title="待修改订单">
			<div style="clear: both;">
				<table class="easyui-datagrid" id="review"></table>
			</div>
			<div id="tb" style="padding: 2px 5px;">
				<input value="${point.pointid}" type="hidden" name="pointId" id="pointId">
				订单状态
				<select name="state" id="state" class="easyui-combobox"
					panelHeight="auto" style="width: 100px;">
					<option value="审核未通过">审核未通过</option>
				</select>
				<a id="select" href="javascript:void(0);" class="easyui-linkbutton"
					iconCls="icon-search" onclick="query()">查询</a>
			</div>
			

			<div id="w" class="easyui-window" title="修改订单"
				data-options="modal:true,closed:true,iconCls:'icon-save'"
				style="width: 600px; height: 400px;">
				<table style="margin-left: 200px;">
					<tr style="height: 10px;"></tr>
					<tr style="height: 10px;"></tr>
					<tr style="height: 10px;"></tr>
					<tr style="height: 10px;"></tr>
					<tr>
						<td>
							订单编号：
						</td>
						<td>
							<input id="orderno" class="easyui-textbox" type="text">
						</td>
					</tr>
					<tr></tr>
					<tr style="height: 10px;"></tr>
					<tr>
						<td>
							发件人电话：
						</td>
						<td>
							<input id="sendph" class="easyui-textbox" type="text">
						</td>

					</tr>
					<tr style="height: 10px;"></tr>
					<tr>
						<td>
							收件人电话：
						</td>
						<td>
							<input id="recvph" class="easyui-textbox" type="text">
						</td>

					</tr>
					<tr style="height: 10px;"></tr>
					<tr>
						<td>
							费用：
						</td>
						<td>
							<input id="cost" class="easyui-textbox" type="text">
						</td>
					</tr>
					<tr style="height: 10px;"></tr>
					<tr>
						<td>
							订单状态：
						</td>
						<td>
							<select id="orderstate" name="orderstate" class="easyui-combobox"
								panelHeight="auto" style="width: 130px;">
								<option value="审核未通过">审核未通过</option>
								<option value="入库">入库</option>
							</select>
						</td>
					</tr>
				</table>
				<div style="padding: 5px; margin-left: 200px; margin-top: 20px;">
					<a href="javascript:void(0);" style="width: 60px;"
						class="easyui-linkbutton" onclick="submitForm()">提交</a>
				</div>
			</div>
		</div>

		<script type="text/javascript">
			$(function() {
				$('#review').datagrid( {
					title : '待修改订单',
					height : 500,
					toolbar : '#tb',
					onClickRow : onClickRow,
					nowrap : false,
					striped : true,
					url : null,
					rownumbers : true,
					pagination : true,
					pageList : [ 1, 10 ],
					loadMsg : '加载中请等待...',
					columns : [ [ {
						field : 'orderid',
						title : '订单ID',
						width : 100
					}, {
						field : 'sendphone',
						title : '发件人电话',
						width : 80
					}, {
						field : 'sendaddress',
						title : '发件地址',
						width : 80
					}, {
						field : 'recvphone',
						title : '收件人电话',
						width : 80
					}, {
						field : 'recvaddress',
						title : '收件地址',
						width : 80
					}, {
						field : 'sendDelivery',
						title : '发件配送费',
						width : 80
					}, {
						field : 'recvDelivery',
						title : '收货配送费',
						width : 80
					}, {
						field : 'safe',
						title : '保价费',
						width : 80
					}, {
						field : 'weight',
						title : '质量',
						width : 80
					}, {
						field : 'fastcost',
						title : '加急费',
						width : 80
					}, {
						field : 'cost',
						title : '费用',
						width : 80
					}, {
						field : 'state',
						title : '订单状态',
						width : 80
					}
			
					] ]
			
				});
			
			});

			function query() {
			
				var pointId = document.getElementById("pointId").value;
				var state = document.getElementById("state").value;
				url = '<%=basePath%>siteBack/queryOrderOnSite.do?pointid=' + pointId + '&state=' + state + '&flag=start';
				$('#review').datagrid('options').url = url;
				$('#review').datagrid('reload');
			}

			function onClickRow(index, row) {
				$("#w").window({
			    		top:($(window).height() - 400) * 0.5,  
			    		left:($(window).width() - 600) * 0.5,
			            
			  		});
				$('#w').window('open');
				var orderno = row["orderid"];
				var sendph = row["sendphone"];
				var recvph = row["recvphone"];
				var cost = row["cost"];
				$("#orderno").textbox('setValue', orderno);
				$("#sendph").textbox('setValue', sendph);
				$("#recvph").textbox('setValue', recvph);
				$("#cost").textbox('setValue', cost);
			
				$('#orderno').textbox('textbox').attr('readonly', true);
			}

			function submitForm() {
				var orderid = $('#orderno').val();
				var sendphone = $('#sendph').val();
				var recvphone = $('#recvph').val();
				var cost = $('#cost').val();
				var state = $('#orderstate').combobox('getValue');
			
				$.ajax( {
					type : "Post",
					dataType : "text",
					url : "<%=basePath%>siteBack/updateOrder.do",
					data : "orderid=" + orderid + "&state=" + state + "&sendphone="
							+ sendphone + "&recvphone=" + recvphone + "&cost=" + cost,
					success : function(msg) {
						if (msg == 0) {
							var r = confirm('修改失败');
							if (r == true) {
			
								query();
								$('#w').window('close');
							}
						} else if (msg == 1) {
							//登录成功，转到主页
					var r = confirm('修改成功');
					if (r == true) {
			
						query();
						$('#w').window('close');
					}
				} else {
			
				}
			}
				});
			
			}
</script>
	</body>
	
</html>
