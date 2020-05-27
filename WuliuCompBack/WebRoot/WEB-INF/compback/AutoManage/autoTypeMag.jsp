<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>总公司后台车型页</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<link rel="stylesheet" type="text/css" href="<%=basePath%>style/themes/default/easyui.css">
	<link rel="stylesheet" type="text/css" href="<%=basePath%>style/themes/icon.css">
	<link rel="stylesheet" type="text/css" href="<%=basePath%>style/demo.css">
	<script type="text/javascript" src="<%=basePath%>js/jquery.min.js"></script>
	<script type="text/javascript" src="<%=basePath%>js/jquery.easyui.min.js"></script>
  </head>
  
 <body>
	<div class="easyui-tabs" style="width:1146px;height:632px; margin:-20px; margin-right:-40px; padding-right:-10px">
	
		<div title="添加车型">
	    	<div class="easyui-panel"  style="width:100%; height:100%"  align="center">
				<div style="padding:10px 60px 20px 60px">
		        <br/><br/>
				    <form id="carType" action="<%=basePath%>admin/addNewAutoType.do" class="easyui-form" method="post" data-options="novalidate:true">
				    	<table cellpadding="5">          		
				    		<tr>
				    			<td>车型编号:</td>
				    			<td><input class="easyui-textbox" type="text" name="cartypeid" data-options="required:true" style="height:30px; width:200px"/></td>
				    		</tr>
				    		<tr>
				    			<td>车型名称:</td>
				    			<td><input class="easyui-textbox" type="text" id="carTypeName" name="cartypename" data-options="required:true" style="height:30px; width:200px"/></td>
				    		</tr>
				    	</table>
				    </form>
				    <div style="text-align:center;padding:20px">
				    	<a href="javascript:void(0)" class="easyui-linkbutton" onclick="submitForm()">提交</a>
				    	<a href="javascript:void(0)" class="easyui-linkbutton" onclick="clearForm()">重置</a>
				    </div>
			    </div>
			</div>
	 	</div>
	
		
	    <div title="查询车型">
	    
	    	<table id="dg" class="easyui-datagrid" title="车型信息" style="width:1145px;height:auto"
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
	
			<div id="tb" style="height:auto">
				<input type="button" onclick="queryCarType()" value="查询"/>
				<input type="button" onclick="removeit()"value="删除"/>
			</div>
	    
	    </div>
	 
	</div>
	
    <script type="text/javascript">
	
	function queryCarType(){

	    var url = "<%=basePath%>admin/getAutoType.do";
	
		$('#dg').datagrid('options').url = url;
	    $('#dg').datagrid('reload');

	} 
	
	$(function(){	   
   		$('#dg').datagrid({									
			nowrap: false,
			striped: true,	
			pageList:[1,10],							
			loadMsg : 'processing, please wait …',			
			columns:[[
				{field:'cartypeid',checkbox:true},	
				{field:'cartypename',title:'车型名称',align:'center',width:150},											
			]]					
		});			
    }); 
	
	
	
	function submitForm(){
       $('#carType').form('submit', {        
		    success:function(data){
		    	alert(data);   		      
		        if(data==1){
		           alert("添加车型成功，请继续");
		           //document.getElementById("submitAlert").innerHTML = "用户添加成功，请继续";
		        }else{
		           alert("网络异常，稍后再试");
		           //document.getElementById("submitAlert").innerHTML = "网络异常，稍后再试";
		        }
		        		          
		    }    
		}); 
    }   
    
	function clearForm(){
		$('#fff').form('clear');
	}
		
	var editIndex = undefined;		
	function onClickRow(index){
		if (editIndex != index){
			if (endEditing()){
				$('#dg').datagrid('selectRow', index)
						.datagrid('beginEdit', index);
				editIndex = index;
			} else {
				$('#dg').datagrid('selectRow', editIndex);
			}
		}
	}
		
	function removeit(){
		var carSizeId = $('#dg').datagrid('getSelected')['cartypeid'];
		var r = confirm('请确认要删除此车型?');
   	    if(r == true){
   	   		 $.ajax( {
				type : "POST",
				dataType : "text",
				url : "<%=basePath%>admin/delAutoType.do",
				data : "cartypeid="  + carSizeId,
				success : function(msg) {
					if(msg == 1){
						var r = confirm('删除成功');
							if(r == true){						  	
							queryCarType();						 
							}
					}			
				}	
			});
   	    }
	}
		
		
	</script>
</body>
</html>
