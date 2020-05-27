<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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

		<title>My JSP 'class.jsp' starting page</title>

		<meta http-equiv="pragma" content="no-cache">
		<meta http-equiv="cache-control" content="no-cache">
		<meta http-equiv="expires" content="0">
		<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
		<meta http-equiv="description" content="This is my page">
		<link rel="stylesheet" type="text/css" href="<%=basePath%>style/themes/default/easyui.css">
		<link rel="stylesheet" type="text/css" href="<%=basePath%>style/themes/icon.css">
		<link rel="stylesheet" type="text/css" href="<%=basePath%>css/demo.css">
		<link rel="stylesheet" type="text/css" href="<%=basePath%>style/themes/color.css">
		
		<script type="text/javascript" src="<%=basePath%>js/jquery.min.js"></script>
		<script type="text/javascript" src="<%=basePath%>js/jquery.easyui.min.js"></script>
		<script type="text/javascript" src="<%=basePath%>js/jquery.easyui.mobile.js"></script>
	</head>

	<body>
		<div class="easyui-tabs" style="width: 1146px; height: 632px; margin: -20px; margin-right: -40px; padding-right: -10px">
			<div title="添加班次">
				<div class="easyui-panel" title="" style="width: 0px; height: 100%">
					<div style="padding: 10px 60px 20px 60px" align="center">
						<br />
						<br />
						<form id="ff" action="<%=basePath%>admin/addClassInfo.do" class="easyui-form" method="post"
							data-options="novalidate:true">
							<table cellpadding="5" style="font-size: 24px;">
								<tr>
									<td>
										选择车辆:
									</td>
									<td>
										<select name="cars" data-options="required:true">
											<option selected>
												请选择
											</option>
											<c:forEach var="am" items="${autoMobiles}">
												<option value="${am.autoid}">
													${am.autoid}
												</option>
											</c:forEach>
										</select>
									</td>
								</tr>
								<tr>
									<td>
										选择路线:
									</td>
									<td>
										<select name="rotes" data-options="required:true">
											<option selected>
												请选择
											</option>
											<c:forEach var="rd" items="${roads}">
												<option value="${rd.troadid}">
													${rd.roadname}
												</option>
											</c:forEach>
										</select>
									</td>
								</tr>
								<tr>
									<td>
										发车时间:
									</td>
									<td>
										<input class="easyui-datetimebox" name="tclassstarttime"
											data-options="required:true" required style="width: 200px">
									</td>
								</tr>
								<tr>
									<td>
										到达时间:
									</td>
									<td>
										<input class="easyui-datetimebox" name="tclassendtime"
											data-options="required:true" required style="width: 200px">
									</td>
								</tr>
								<tr>
									<td>
										状态:
									</td>
									<td>
										<input class="easyui-textbox" name="tclassstate"
											data-options="multiline:true"
											/>
									</td>
								</tr>
								<tr>
									<td>
										备注:
									</td>
									<td>
										<input class="easyui-textbox" name="classremarks"
											data-options="multiline:true"
											style="height: 40px; width: 460px" />
									</td>
								</tr>
							</table>
						</form>
						<div style="text-align: center; padding: 20px">
							<a href="javascript:void(0)" class="easyui-linkbutton"
								onclick="submitForm()">提交</a>
							<a href="javascript:void(0)" class="easyui-linkbutton"
								onclick="clearForm()">重置</a>
						</div>
					</div>
				</div>
				<!--   隐藏窗口 查看班次详细信息   -->
				<div id="win" class="easyui-window" title=""
					data-options="iconCls:'icon-save'"
					style="width:700px; height:auto; padding: 0px;">

					<table id="windg" class="easyui-datagrid" title="班次时刻信息"
						style="width:100%; height:auto"
						data-options="rownumbers:true,singleSelect:true,method:'get'">						
					</table>
				</div>
			</div>


			<div title="查询班次">
				
				<br />
				<div align="center">
					请输入起始配送点
					<input type="text" id="beginSite" name="beginSite" />
					&nbsp;请输入目的配送点
					<input type="text" id="endSite" name="endSite" />
					&nbsp;
					<input onclick="queryClass()"
						style="height: 30px; width: 50px" type="button" value="查询" />
				</div>
				<br />
				<table id="classdg" class="easyui-datagrid" title="配送点信息"
					style="width: auto; height: auto"
					data-options="
            	rownumbers:true,
				iconCls: 'icon-edit',
				singleSelect: true,
				toolbar: '#tb',
				method: 'get',
                pagination:true,
				onClickRow: onClickRow
			">		
				</table>

				<div id="tb" style="height: auto">
					<a href="javascript:void(0)" class="easyui-linkbutton"
						data-options="iconCls:'icon-remove',plain:true"
						onclick="removeit()">删除</a>
						<a href="javascript:void(0)" class="easyui-linkbutton"
						data-options="iconCls:'icon-search',plain:true"
						onclick="getChanges()">查看班次时刻信息</a>
				</div>

				<script type="text/javascript">
					var editIndex = undefined;
					
					function onClickRow(index) {
						if (editIndex != index) {
							if (endEditing()) {
								$('#dg').datagrid('selectRow', index).datagrid('beginEdit', index);
								editIndex = index;
							} else {
								$('#dg').datagrid('selectRow', editIndex);
							}
						}
					}

				function queryClass() {
				
				    var url = "<%=basePath%>admin/getClassInfo.do?beginSite=" + $('#beginSite').val()+"&endSite=" + $('#endSite').val();
				
					$('#classdg').datagrid('options').url = url;
				    $('#classdg').datagrid('reload');
				
				}
				
				 $(function(){
				    		$('#classdg').datagrid({									
								nowrap: false,
								striped: true,								
								url: null,
								rownumbers:true,
								pageList:[1,2,10],
								loadMsg : 'processing, please wait …',			
								columns:[[		
									{field:'tclassid',checkbox:true},			
									{field:'sp1',title:'起始配送点',align:'center',width:100},					
									{field:'ep1',title:'目的配送点',align:'center',width:100},					
									{field:'tclassstarttime',title:'发车时间',align:'center',width:200,
										formatter: function(value,row,index){	
									           if(value != null){
									               var date = value.time;
											       var classStartTime = new Date(date).toLocaleString();							   
											       return classStartTime;
									           }   						    
										}	
									},					
									{field:'tclassendtime',title:'抵达时间',align:'center',width:200,
										formatter: function(value,row,index){	
									           if(value != null){
									               var date = value.time;
											       var classEndTime = new Date(date).toLocaleString();							   
											       return classEndTime;
									           }   						    
										}	
									},		
									{field:'driver1',title:'主驾驶',align:'center',width:100},
									{field:'driver2',title:'副驾驶',align:'center',width:100},
									{field:'autoid',title:'车牌号',align:'center',width:100},
									{field:'classState',title:'状态',align:'center',width:100},		
								]]					
							});			
				    	});     	
				
				
				function removeit() {
					var classId = $('#classdg').datagrid('getSelected')['classId'];
					
					var r = confirm('请确认要删除此班次吗?');
					if (r == true) {
					$.ajax( {
					
									type : "POST",
									dataType : "text",
									url : "<%=basePath%>companycontrol/RemoveClassSvl",
									data : "classId="  + classId,
									success : function(msg) {
										if(msg == 1){
											var r = confirm('删除成功');
												if(r == true){						  	
												queryClass();						 
												}
										}else{
											alert("网络异常，稍后再试");		
										}			
									}	
							});  
						
					}
				}
				
				function submitForm() {
					$('#ff').form('submit', {
						success : function(data) {
							if (data == 1) {
								alert("班次添加成功！");
								clearForm();
						} else {
							alert("网络异常，稍后再试");
						}
				
					}
					});
				}
				function clearForm(){
							$('#ff').form('clear');
						}
						
				
						
						
						 $(function(){
				    		$('#windg').datagrid({									
								nowrap: false,
								striped: true,								
								url: null,
								rownumbers:true,
								loadMsg : 'processing, please wait …',			
								columns:[[				
									{field:'pointName',title:'途经配送点名',align:'center',width:100},														
									{field:'comeTime',title:'到达时间',align:'center',width:200,
										formatter: function(value,row,index){	
									           if(value != null){
									               var date = value.time;
											       var comeTime = new Date(date).toLocaleString();							   
											       return comeTime;
									           }   						    
										}
									},	
									{field:'goTime',title:'出发时间',align:'center',width:200,
										formatter: function(value,row,index){	
									           if(value != null){
									               var date = value.time;
											       var goTime = new Date(date).toLocaleString();							   
											       return goTime;
									           }   						    
										}
									},	
									{field:'sequence',title:'次序',align:'center',width:50},				
								]]					
							});			
				    	});     	
				
				
				$(function(){
				    		$('#win').window({	
				    		title : '班次时刻信息',	    		         		
				    		collapsible : false,	
				    		minimizable : false,
				    		maximizable : false,
							modal:true
							});
							$('#win').window('close');      		
				    	});
				    	
				function getChanges() {
					var row = $('#classdg').datagrid('getSelected')['classId'];
					if (row){
							var url = "<%=basePath%>companycontrol/ClassTimeSvl?classId="+ row ;
							$('#windg').datagrid('options').url = url;
							$('#windg').datagrid('reload');
							
									
							$('#win').window('open');	
							
							}
						} 
	</script>
			</div>
		</div>
	</body>
</html>
