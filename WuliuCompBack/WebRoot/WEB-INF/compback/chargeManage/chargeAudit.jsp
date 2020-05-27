<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title></title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<link rel="stylesheet" type="text/css" href="<%=basePath%>style/themes/default/easyui.css">
	<link rel="stylesheet" type="text/css" href="<%=basePath%>style/themes/icon.css">
	<link rel="stylesheet" type="text/css" href="<%=basePath%>css/demo.css">
	<script type="text/javascript" src="<%=basePath%>js/jquery.min.js"></script>
	<script type="text/javascript" src="<%=basePath%>js/jquery.easyui.min.js"></script>
	<script type="text/javascript">
	
		
$(function(){	   
    		$('#dg').datagrid({									
				nowrap: false,
				striped: true,	
				pageList:[1,10],							
				loadMsg : 'processing, please wait …',			
				columns:[[
					{field:'chargeid',checkbox:true},									
					{field:'citySTR',title:'城区',align:'center',width:150},						
					{field:'firstweight',title:'首重量单价',align:'center',width:150},					
					{field:'secondweight',title:'次重量单价',align:'center',width:150},
					{field:'chargestate',title:'状态',align:'center',width:150}
				]]					
			});			
    	}); 
    	
function queryNoChar(){

    var url = "<%=basePath%>admin/getChargeInfo.do";

	$('#dg').datagrid('options').url = url;
    $('#dg').datagrid('reload');

}  

function audit(state){
	alert(state);
	var chargeId = $('#dg').datagrid('getSelected')['chargeid'];
	if(state == '1'){
		var r = confirm('请确认通过此配送方案?');
	}else if(state == '-1'){
		var r = confirm('请确认不通过此配送方案?');
	}
    if(r == true){
    	 $.ajax( {
					type : "Get",
					dataType : "text",
					url : "<%=basePath%>admin/auditCharge.do?chargeid=" + chargeId + "&chargestate=" + state,
					success : function(msg) {
						if(msg == 1){
							var r = confirm('修改成功');
								if(r == true){						  	
								queryNoChar();						 
								}
						}			
					}	
				});   	    	    
	}
}   

function noPass(){
	var chargeId = $('#dg').datagrid('getSelected')['chargeId'];
	var r = confirm('请确认通过此配送方案?');
    if(r == true){
     $.ajax( {
					type : "Get",
					dataType : "text",
					url : "<%=basePath%>companycontrol/NoPassCharSvl",
					data : "chargeId="  + chargeId,
					success : function(msg) {
						if(msg == 1){
							var r = confirm('修改成功');
								if(r == true){						  	
								queryNoChar();						 
								}
						}			
					}	
				});   
  
	}



}   	
    	    	
	</script>
  </head>
  
  <body>

  <div class="easyui-tabs" style="width:1146px;height:632px; margin:-20px; margin-right:-40px; padding-right:-10px">
  		
        <div title="收费标准审核">
        	<table id="dg" class="easyui-datagrid" title="收费标准审核" style="width:1145px;height:auto"
			data-options="rownumbers:true,pagination:true,singleSelect:true,method:'get',toolbar:'#tb'">
			</table>
	<div id="tb" style="padding:2px 5px;">
		<input type="button" onclick="queryNoChar()" value="查询"/>
       	<input type="button" onclick="audit('1')" iconCls="icon-search" value="通过"/>
        <input type="button" onclick="audit('-1')" iconCls="icon-search" value="不通过"/>
	</div>
        </div>
        
  </div>
</body>
</html>
