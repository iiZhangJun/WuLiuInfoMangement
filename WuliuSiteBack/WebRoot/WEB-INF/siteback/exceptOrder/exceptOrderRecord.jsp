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

		<title>My JSP 'exc_order_reg.jsp' starting page</title>

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
		<script type="text/javascript">
		function tijiao(){
		$('#order').form('submit',{
		success:function(msg){
		if(msg==1){
			alert("登记成功");	
		}else{
			alert("登记失败");
		}
		$('#order')[0].reset();
		
		}
		});
		}
		</script>
		

	</head>
	<body>
		<form id="order" action="<%=basePath%>siteBack/recordExcepOrder.do" method="post">
			<div align="center">
				<table class="table">
					<tr>
						<td class="first">
							订单编号
						</td>
						<td class="input">
							<input class="easyui-textbox" name="orderid" />
						</td>
					</tr>
					<tr>
						<td class="first">
							汇报时间
						</td>
						<td class="input">
							<input name="exctime" class="easyui-datetimebox" required
								style="width: 180px">
						</td>
					</tr>
					<tr>
						<td class="first">
							发生事故
						</td>
						<td>
							<input name="accident" class="easyui-textbox" data-options="multiline:true" style="height: 70px;"></input>
						</td>
					</tr>

					<tr>
						<td class="first">
							补偿方案
						</td>
						<td>
							<input name="resolve" class="easyui-textbox" data-options="multiline:true" style="height: 70px;"></input>
						</td>
					</tr>
					<tr>
						<td class="first">
							客户反馈
						</td>
						<td>
							<input name="position" class="easyui-textbox" data-options="multiline:true" style="height: 70px;"></input>
						</td>
					</tr>
					<tr>
						<td class="first">
							状态
						</td>
						<td class="input">
							<select id="excstate" name="excstate" class="easyui-combobox"
								panelHeight="auto" style="width: 180px;">
								<option value="已解决">已解决</option>
								<option value="未解决">未解决</option>
							</select>
						</td>
					</tr>
				</table>
				
				<input type="button"  name="button" value="提交" onclick="tijiao()" />
				
			</div>
		</form>
	</body>
</html>
