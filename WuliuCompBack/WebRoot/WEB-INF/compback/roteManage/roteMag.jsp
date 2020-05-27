<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<base href="<%=basePath%>">
		<title>总公司线路管理页</title>
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
		function bao(s) {
			var strArray = s.split(",");
			var x = document.getElementById("textarea");
			var y = document.getElementById("siteids");
			y.innerHTML = y.innerHTML + strArray[0] + ",";
			x.innerHTML = x.innerHTML + strArray[1] + "-";
		}

		function submitForm() {
			$('#f').form('submit', {
				success : function(data) {
						alert(data);
					if (data == 1) {
						alert("添加线路成功，请继续");
						//document.getElementById("submitAlert").innerHTML = "用户添加成功，请继续";
						window.location.href = "<%=basePath%>admin/roteManage.do";
					} else {
						alert("网络异常，稍后再试");
						//document.getElementById("submitAlert").innerHTML = "网络异常，稍后再试";
					}
				}
			});
		}

		$(function() {
			$('#rotedg').datagrid( {
				nowrap : false,
				striped : true,
				url : null,
				rownumbers : true,
				loadMsg : 'processing, please wait …',
				pageList : [ 1, 2, 10 ],
				columns : [ [ {
					field : 'troadid',
					checkbox : true
				}, {
					field : 'roadname',
					title : '线路名称',
					align : 'center',
					width : 150
				}, {
					field : 'startptname',
					title : '起始配送点',
					align : 'center',
					width : 200
				}, {
					field : 'endptname',
					title : '终止配送点',
					align : 'center',
					width : 200
				}, {
					field : 'raodlength',
					title : '线路长度',
					align : 'center',
					width : 200
				}, {
					field : 'raodvalue',
					title : '权值',
					align : 'center',
					width : 200
				}, ] ]
			});
		});
		
		function querysites() {
		
			var url = "<%=basePath%>admin/getAllRote.do?startSite="
					+ $('#startSite').val() + "&endSite=" + $('#endSite').val();
		
			$('#rotedg').datagrid('options').url = url;
			$('#rotedg').datagrid('reload');
		
		}

		 $(function(){
		    		$('#windg').datagrid({									
						nowrap: false,
						striped: true,								
						url: null,
						rownumbers:true,
						loadMsg : 'processing, please wait …',			
						columns:[[				
							{field:'pointname',title:'配送点名',align:'center',width:200},										
							{field:'pointaddr',title:'地址',align:'center',width:200},					
							{field:'pointphone',title:'联系电话',align:'center',width:200},				
						]]					
					});			
		    	});     	
		
		
		$(function(){
		    		$('#win').window({	
		    		title : '途经站点信息',	    		         		
		    		collapsible : false,	
		    		minimizable : false,
		    		maximizable : false,
					modal:true
					});
					$('#win').window('close');      		
		    	});
    	
		function getChanges() {
			var row = $('#rotedg').datagrid('getSelected')['troadid'];
			if (row){
					var url = "<%=basePath%>admin/getRoteBySite.do?roadid="+ row ;
					$('#windg').datagrid('options').url = url;
					$('#windg').datagrid('reload');
							
					$('#win').window('open');	
					
					}
		}    	
	</script>
	</head>
	<body>

		<div class="easyui-tabs" style="width: 1146px; height: 632px; margin: -20px">
			<div title="查询线路">
			
				<div id="win" class="easyui-window" title="站点信息"
					data-options="iconCls:'icon-save'"
					style="width:700px; height:auto; padding: 0px;">

					<table id="windg" class="easyui-datagrid" title="途经站点"
						style="width:100%; height:auto"
						data-options="rownumbers:true,singleSelect:true,method:'get'">						
					</table>
				</div>

				<br />
				<div align="center">
					开始配送点
					<input type="text" id="startSite" name="startSite" />
					&nbsp;&nbsp; 结束配送点
					<input type="text" id="endSite" name="endSite" />
					<input style="height: 30px; width: 50px" type="button" value="查询"
						onclick="querysites()" />
				</div>
				<br />
				<table id="rotedg" class="easyui-datagrid" title="路线信息"  style="width: 1142px; height: auto;"
					data-options="
		            	rownumbers:true,
						iconCls: 'icon-edit',
						singleSelect: true,
						toolbar: '#tb',
						method: 'get',
		                pagination:true,
						onClickRow: onClickRow">
				</table>

				<div id="tb" style="height: auto">
					<a href="javascript:void(0)" class="easyui-linkbutton"
						data-options="iconCls:'icon-remove',plain:true"
						onclick="removeit()">删除</a>
					<a href="javascript:void(0)" class="easyui-linkbutton"
						data-options="iconCls:'icon-search',plain:true"
						onclick="getChanges()">查看详细信息</a>
				</div>

			</div>

			<!--  -->

			<div title="添加线路">
				<div class="easyui-panel" style="width: 0; height: 100%">
					<div>
						<br />
						<br />
						<!-- data-options="novalidate:true" -->
						<form id="f" class="easyui-form" action="<%=basePath%>admin/roteManage.do" method="post" >
							<div align="center">
								<table cellpadding="5">
									<tr>
										<td>
											起始配送点:
										</td>
										<td>
											<select name="stptid">
												<option selected>
													请选择
												</option>
												<c:forEach var="bp" items="${points}">
													<option value="${bp.pointid}">
														${bp.pointname}
													</option>
												</c:forEach>
											</select>
										</td>
									</tr>
									<tr>
										<td>
											目的配送点:
										</td>
										<td>
											<select name="endptid">
												<option>
													请选择
												</option>
												<c:forEach var="ep" items="${points}">
													<option value="${ep.pointid}">
														${ep.pointname}
													</option>
												</c:forEach>
											</select>
										</td>
									</tr>
									<tr>
										<td>
											线路名称:
										</td>
										<td>
											<!-- class="easyui-textbox" data-options="required:true" -->
											<input type="text" name="roadname" style="height: 30px; width: 200px"/>
										</td>
									</tr>
									<tr>
										<td>
											权值:
										</td>
										<td>
											<!-- class="easyui-textbox" data-options="required:true" -->
											<input type="text" name="raodvalue" style="height: 30px; width: 200px" />
										</td>
									</tr>
									<tr>
										<td>
											距离:
										</td>
										<td>
											<!-- class="easyui-textbox" data-options="required:true" -->
											<input type="text" name="raodlength" style="height: 30px; width: 200px" />
											km
										</td>
									</tr>
									<tr>
										<td>
											选择途经站点:
										</td>
										<td>
										<!-- name="bysite" -->
											<select 
												onchange="bao(this.options[this.options.selectedIndex].value)">
												<option selected>
													请选择
												</option>
												<c:forEach var="p" items="${points}">
													<option value="${p.pointid},${p.pointname}">
														${p.pointname}
													</option>
												</c:forEach>
											</select>
										</td>
									</tr>
									<tr>
										<td>
											所选途经配送点：
										</td>
										<td>
										<!-- name="allsites" -->
											<textarea id="textarea" 
												style="height: 50px; width: 600px; resize: none" readonly
												disabled>
                        	
                        					</textarea>
											<br />
											<textarea id="siteids" name="siteids"
												style="height: 55px; width: 300px; resize: none; display: none"
												readonly></textarea>
										</td>
									</tr>
								</table>
							</div>
							 <div style="text-align: center; padding: 20px">
							
							<a href="javascript:void(0)"  class="easyui-linkbutton"
								onclick="submitForm()">添加</a>
							<a href="javascript:void(0)" class="easyui-linkbutton"
								onclick="clearForm()">重置</a>
						</div>
						</form>
						
					</div>

				</div>


			</div>

			<script type="text/javascript">

			var editIndex = undefined;
				function onClickRow(index) {
					if (editIndex != index) {
						if (endEditing()) {
							$('#rotedg').datagrid('selectRow', index).datagrid('beginEdit',
									index);
							editIndex = index;
						} else {
							$('#rotedg').datagrid('selectRow', editIndex);
						}
					}
			}
			function removeit() {
				var roadId = $('#rotedg').datagrid('getSelected')['troadid'];
				var r = confirm('请确认要删除此线路吗?');
				if (r == true) {
				$.ajax( {
								type : "Get",
								dataType : "text",
								url : "<%=basePath%>admin/delRote.do",
								data : "roadid="  + roadId,
								success : function(msg) {
									if(msg == 1){
										var r = confirm('修改成功');
											if(r == true){						  	
											querysites();						 
											}
									}			
								}	
							});  
				}
			}


		$(function(){
			var pager = $('#rotedg').datagrid().datagrid('getPager');	// get the pager of datagrid
			pager.pagination({			
			});			
		});
		
		
		$(function(){  	
			$('#win').window({    
				   
				modal:true
			});	
			$('#win').window('close');      		
    	});
    	
		function clear(){
			$('#f').form('clear');
		}
		
		function clearForm(){
			var tx = document.getElementById("textarea");
			tx.innerHTML = "";
		}

	</script>
	</body>
</html>
