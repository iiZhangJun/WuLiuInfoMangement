<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'query_exc.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<link href="<%=basePath%>css/themes/default/easyui.css"
			rel="stylesheet" />
		<link hre="<%=basePath%>css/themes/icon.css" rel="stylesheet" />
		<link href="<%=basePath%>css/themes/color.css" rel="stylesheet" />
		<link href="<%=basePath%>css/apply.css" rel="stylesheet" />
		<script src="<%=basePath%>js/jquery.min.js">
</script>
		<script src="<%=basePath%>js/jquery.easyui.min.js">
</script>

  </head>
  
  <body>
    <div title="异常订单查询">
			<div style="clear: both;">
				<table class="easyui-datagrid" id="review"></table>
			</div>
			<div id="tb" style="padding: 2px 5px;">
				<input value="${pointid.pointid}" type="hidden" name="pointId" id="pointId">
				异常订单ID<input class="easyui-textbox" name="excid" id="excid"/>
				<a id="select" href="javascript:void(0);" class="easyui-linkbutton"
				 onclick="query()">查询</a>
			</div>
			<div id="w" class="easyui-window" title="修改订单"
				data-options="modal:true,closed:true,iconCls:'icon-save'"
				style="width: 600px; height: 300px;">
				<table style="margin-left: 200px;">
					<tr style="height: 10px;"></tr>
					<tr style="height: 10px;"></tr>
					<tr style="height: 10px;"></tr>
					<tr style="height: 10px;">
					   <td><input id="excid" name="excid" type="hidden"></td>
					</tr>
					<tr>
						<td>
							订单编号：
						</td>
						<td>
							<input id="orderno" class="easyui-textbox" type="text" readonly="readonly">
						</td>
					</tr>
					<tr style="height: 10px;"></tr>
					<tr>
						<td>
							处理方式：
						</td>
						<td>
							<input id="resolve" class="easyui-textbox" type="text" name="resolve">
						</td>
					</tr>
					<tr style="height: 10px;"></tr>
					<tr>
						<td>
							顾客反馈：
						</td>
						<td>
							<input id="position" class="easyui-textbox" type="text" name="position">
						</td>

					</tr>
					<tr style="height: 10px;"></tr>
					<tr>
						<td>
							处理状态：
						</td>
						<td>
							<select id="excstate" name="excstate" class="easyui-combobox"
								panelHeight="auto" style="width: 130px;">
								<option value="已解决">已解决</option>
								<option value="未解决">未解决</option>
							</select>
						</td>
					</tr>
					
				</table>
				<div style="padding: 5px; margin-left: 200px; margin-top: 20px;">
					<a href="javascript:void(0);" style="width: 60px;"
						class="easyui-linkbutton" onclick="submitForm()">更改</a>
				</div>
			</div>
		</div>


		<script type="text/javascript">
			$(function() {
				$('#review').datagrid( {
					title : '',
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
					columns : [ [
					{field : 'excid', hidden:'true'},
					{field : 'orderid',title : '订单ID',width : 140}, 
					{field : 'exctime',title : '汇报时间 ',width : 150,
					formatter: function(value,row,index){	
								           if(value != null){
								               var date = value.time;
										       var excTime = new Date(date).toLocaleString();							   
										       return excTime;
								           }   						    
									}
					}, 
					{field : 'accident',title : '发生事故',width : 120}, 
					{field : 'resolve',title : '补偿方案',width : 120},
					{field : 'position',title : '顾客反馈',width : 150},
					{field : 'excstate',title : '状态',width : 100}, 	
					] ]
			
				});
			
			});
			
			function onClickRow(index, row) {
				$("#w").window({
			    		top:($(window).height() - 400) * 0.5,  
			    		left:($(window).width() - 600) * 0.5,  
			  		});
				$('#w').window('open');
				var orderno = row["orderid"];
				var excid = row["excid"];
				var resolve = row["resolve"];
				var position = row["position"];
				var excstate = row["excstate"];
				$("#orderno").textbox('setValue', orderno);
				$("#excid").val(excid);
				$("#resolve").textbox('setValue', resolve);
				$("#position").textbox('setValue', position);			
				$('#orderno').textbox('textbox').attr('readonly', true);
				$("#excstate").find("option[value='"+ excstate +"']").attr("selected",true);
			}
			
			
			function query() {
			
				var pointId = document.getElementById("pointId").value;
				var excId = document.getElementById("excid").value;
				url = '<%=basePath%>siteBack/queryExcepOrder.do?pointId=' + pointId + '&orderid=' + excId;
				$('#review').datagrid('options').url = url;
				$('#review').datagrid('reload');
			}
			
		   function submitForm(){
		    var excid = $('#excid').val();
			var orderid = $('#orderno').val();
			var excstate = $('#excstate').combobox('getValue');
			var resolve =  $('#resolve').val();
			var position =  $('#position').val();
				$.ajax( {
					type : "Post",
					dataType : "text",
					url : "<%=basePath%>siteBack/updateExcorder.do",
					data : "excid=" + excid +"&orderid="  + orderid + "&excstate=" + excstate + "&resolve=" + resolve + "&position=" + position,
					success : function(msg) {
						if(msg == 0){
						  var r = confirm('更改失败');
						  if(r == true){
						  	
						  	query();
						  	$('#w').window('close');
						  }
						}
						else if(msg == 1){
						    //登录成功，转到主页
						   var r = confirm('更改成功');
						   if(r == true){
						   	
						   query();
						   	$('#w').window('close');
						   }
						}
						else{	
						}
					}
				}	);	
		}
     </script>
	</body>
</html>
