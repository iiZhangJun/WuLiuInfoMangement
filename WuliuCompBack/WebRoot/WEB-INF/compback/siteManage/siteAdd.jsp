<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>配送点管理页</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	
	<link rel="stylesheet" type="text/css" href="<%=basePath%>style/themes/default/easyui.css">
	<link rel="stylesheet" type="text/css" href="<%=basePath%>style/themes/icon.css">
	<link rel="stylesheet" type="text/css" href="<%=basePath%>style/demo.css">
    <link rel="stylesheet" type="text/css" href="<%=basePath%>style/themes/color.css">
    
    <script type="text/javascript" src="<%=basePath%>js/jquery.min.js"></script>
	<script type="text/javascript" src="<%=basePath%>js/jquery.easyui.min.js"></script>
	<script src="<%=basePath%>js/cityjson.js"></script>
	<script src="<%=basePath%>js/cityset.js"></script>
	<script src="<%=basePath%>js/popt.js"></script>
	<style type="text/css">
	
		._citys { width: 450px; display: inline-block; border: 2px solid #eee; padding: 5px; position: relative; background:#fff; }
		._citys span { color: #56b4f8; height: 15px; width: 15px; line-height: 15px; text-align: center; border-radius: 3px; position: absolute; right: 10px; top: 10px; border: 1px solid #56b4f8; cursor: pointer; }
		._citys0 { width: 100%; height: 34px; display: inline-block; border-bottom: 2px solid #56b4f8; padding: 0; margin: 0; }
		._citys0 li { display: inline-block; line-height: 34px; font-size: 15px; color: #888; width: 80px; text-align: center; cursor: pointer; }
		.citySel { background-color: #56b4f8; color: #fff !important; }
		._citys1 { width: 100%; display: inline-block; padding: 10px 0; }
		._citys1 a { width: 83px; height: 35px; display: inline-block; background-color: #f5f5f5; color: #666; margin-left: 6px; margin-top: 3px; line-height: 35px; text-align: center; cursor: pointer; font-size: 13px; overflow: hidden; }
		._citys1 a:hover { color: #fff; background-color: #56b4f8; }
		.AreaS { background-color: #56b4f8 !important; color: #fff !important; }
	</style>
	
	
	<script type="text/javascript">
		 $(function(){
    		$('#dg').datagrid({									
				nowrap: false,
				striped: true,								
				url: null,
				rownumbers:true,
				loadMsg : 'processing, please wait …',			
				columns:[[		
					{field:'pointid',checkbox:true},			
					{field:'pointname',title:'配送点名',align:'center',width:200},					
					{field:'district',title:'所属城区',align:'center',width:250},					
					{field:'pointaddr',title:'地址',align:'center',width:300},					
					{field:'pointphone',title:'联系电话',align:'center',width:200},				
				]]					
			});			
    	});     
    		
    	function querysite() {

		    var url = "<%=basePath%>admin/getSite.do?pointid=" + $('#pointid').val();
		
			$('#dg').datagrid('options').url = url;
		    $('#dg').datagrid('reload');

		}
	</script>
	
	

  </head>
  
  <body>
   
   <div class="easyui-tabs" style="width:1146px;height:632px; margin:-20px; margin-right:-40px; padding-right:-10px">		
		<div title="配送点管理"><br/>
		
        	<div align="center">请输入配送点
	        	<input type="text" id="pointid" name="pointid"/>&nbsp;
	        	<input  style="height:30px; width:50px" onclick="querysite()" type="submit" value="查询"/>
        	</div><br/>
            
        	<table id="dg" class="easyui-datagrid" title="配送点信息" style="width:0x;height:auto"
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
				<a href="javascript:void(0)" class="easyui-linkbutton" data-options="iconCls:'icon-remove',plain:true" onclick="removeit()">删除</a>
			</div>
     	</div>
		
		
		<div title="新增配送点">
              
	        <div class="easyui-panel"  style="width:0px; height:599px">
			<div style="padding:10px 60px 20px 0px; "  align="center"><br/><br/>
	        
			    <form id="newSite" action="<%=basePath%>admin/addNewSite.do" method="post" class="easyui-form" method="post" data-options="novalidate:true">
			    	<table cellpadding="5">
			    		<tr>
			    			<td>配送点名称:</td>
			    			<td><input class="easyui-textbox" type="text" name="pointname" data-options="required:true" style="height:30px;"/></td>
			    		</tr>
			    		<!-- <tr></tr><tr></tr><tr></tr><tr></tr><tr></tr><tr></tr><tr></tr> -->
		                 <tr>
		                	<td>城区：</td>
		                	<td>
		                	<!-- 代码 开始 -->
								<div>
									<input type="text" id="city" name="district"  style="height:30px; border-radius: 5px;border: 1px solid rgb(182,220,230);padding-left: 5px;" />
								 </div>
								<script type="text/javascript">
								$("#city").click(function (e) {
									SelCity(this,e);
								    console.log("inout",$(this).val(),new Date())
								});
								</script>
							<!-- 代码 结束 -->
		                	</td>
		                </tr>
		               <!--  <tr></tr><tr></tr><tr></tr><tr></tr><tr></tr><tr></tr><tr></tr> -->
			    		<tr>
			    			<td>联系电话:</td>
			    			<td><input class="easyui-textbox" name="pointphone" data-options="required:true" style="height:30px; width:200px"/></td>
			    		</tr>	
			    		<!-- <tr></tr><tr></tr><tr></tr><tr></tr><tr></tr><tr></tr><tr></tr> -->
			    		<tr>
			    			<td>详细地址:</td>
			    			<td><input class="easyui-textbox" type="text" name="pointaddr" data-options="required:true" style="height:30px; width:500px"/></td>
			    		</tr>
			    	</table>
			    	<div style="text-align:center;padding:15px">
				    	<a href="javascript:void(0)" class="easyui-linkbutton" onclick="submitForm()">提交</a>
				    	<a href="javascript:void(0)" class="easyui-linkbutton" onclick="clearForm()">重置</a>
			    	</div>
			    </form>
	    	</div>
		</div>     	
     </div>
  </div> 
  
   <script type="text/javascript">
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
			var pointid = $('#dg').datagrid('getSelected')['pointid'];
			var r = confirm('确认要删除此配送点?');
    	    if(r == true){
    	   		 $.ajax( {
					type : "Get",
					url : "<%=basePath%>admin/delSite.do",
					data : "pointid="  + pointid,
					success : function(msg) {
						if(msg == 1){
							var r = confirm('修改成功');
								if(r == true){						  	
									querysite();						 
								}
						}			
					}	
				});
    	    	         	    	
    	    }
    	    		
		}
   
   		function submitForm(){
	       $('#newSite').form('submit', {        
			    success:function(data){   		      
			        if(data==1){
			           alert("添加配送点成功，请继续");
			           //document.getElementById("submitAlert").innerHTML = "用户添加成功，请继续";
			        }else{
			           alert("网络异常，稍后再试");
			           //document.getElementById("submitAlert").innerHTML = "网络异常，稍后再试";
			        }
			        		          
			    }    
			}); 
    	}    
   
		$(function(){
				var pager = $('#dg').datagrid().datagrid('getPager');	// get the pager of datagrid
				pager.pagination({			
				});			
			});
			
			
	</script>
   
   
  </body>
</html>	


