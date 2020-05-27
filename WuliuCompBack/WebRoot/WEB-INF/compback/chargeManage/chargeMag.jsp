<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'chargeManage.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<link rel="stylesheet" type="text/css" href="<%=basePath%>style/themes/default/easyui.css">
	<link rel="stylesheet" type="text/css" href="<%=basePath%>style/themes/icon.css">
	<link rel="stylesheet" type="text/css" href="<%=basePath%>css/demo.css">
    <link rel="stylesheet" type="text/css" href="<%=basePath%>style/themes/color.css">
    
    <script type="text/javascript" src="<%=basePath%>js/cityselect.js"></script>
	<script type="text/javascript" src="<%=basePath%>js/jquery.min.js"></script>
	<script type="text/javascript" src="<%=basePath%>js/jquery.easyui.min.js"></script>
	
	<script src="<%=basePath%>/js/cityjson.js"></script>
	<script src="<%=basePath%>/js/cityset.js"></script>
	<script src="<%=basePath%>/js/popt.js"></script>
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
  </head>
  
  <body>
		
   <div class="easyui-tabs" style="width:1146px;height:632px; margin:-20px; margin-right:-40px; padding-right:-10px">		
		<div title="添加运费方案">
              <div class="easyui-panel" title="运费方案" style="width:1144px; height:98%" align="center">
		<div style="padding:10px 60px 20px 60px">
	    <form id="ff" action="<%=basePath%>admin/addCharge.do" class="easyui-form" method="post" data-options="novalidate:true">
	    	<table cellpadding="10px">
            	<br/>
                <br/>
                <tr>
                	<td>城区：</td>
                	 <!-- 代码 开始 -->
					<td>
						<input type="text" id="city1" name="city" style="width: 150px;height: 20px;border-radius: 3px;border-width: 1px;border-color: rgb(149,184,231);"/>
					</td>
					<script type="text/javascript">
					$("#city1").click(function (e) {
						SelCity(this,e);
					    console.log("inout",$(this).val(),new Date())
					});
					</script>
					<!-- 代码 结束 -->
                	
                </tr>
                <tr></tr><tr></tr><tr></tr>
	    		<tr>
	    			<td>首体重单价:</td>
	    			<td><input class="easyui-textbox" type="text" name="firstweight" data-options="required:true"/></td>
	    		</tr>
                <tr></tr><tr></tr><tr></tr>
                <tr></tr><tr></tr><tr></tr>
	    		<tr>
	    			<td>次体重单价:</td>
	    			<td><input class="easyui-textbox" type="text" name="secondweight" data-options="required:true"/></td>
	    		</tr>
                <tr></tr><tr></tr><tr></tr>
                <tr></tr><tr></tr><tr></tr>
	    		<tr>
                	<td>备注：</td>
                    <td>
                    	<textarea name="chargeremarks" style="width:400px; height:60px; resize:none">
                        </textarea>
                    </td>
                </tr>
	    	</table>

        <br/>
	    <div style="text-align:center;padding:5px">
	    	<a href="javascript:void(0)" class="easyui-linkbutton" onclick="submitForm()">提交</a>
	    	<a href="javascript:void(0)" class="easyui-linkbutton" onclick="clearForm()">重置</a>
	    </div>
		</form>
	    </div>
	</div>
    </div>
    
    <!-- 分栏 -->
    
    <div title="查询方案">   	
        <table id="chargedg" class="easyui-datagrid" title="运费方案" style="width:1144px;height:auto"
			data-options="rownumbers:true,pagination:true,singleSelect:true,method:'get',toolbar:'#tb',footer:'#ft'">
	</table>
	<div id="tb" style="padding:2px 5px;">
		状态: 
		<select id="state" name="state" class="combobox" panelHeight="auto" style="width:100px">
			<option value="1" selected>使用中</option>
			<option value="-1" >已弃用</option>
			<option value="0" >待审核</option>
		</select>
		<a href="javascript:void(0)" class="easyui-linkbutton" onclick="query()" iconCls="icon-search">查询</a>
	</div>        
    </div>
	<script type="text/javascript">
	
	$(function(){	   
    		$('#chargedg').datagrid({									
				nowrap: false,
				striped: true,	
				pageList:[1,10],							
				loadMsg : 'processing, please wait …',			
				columns:[[									
					{field:'citySTR',title:'城区',align:'center',width:150},						
					{field:'firstweight',title:'首重量单价',align:'center',width:100},					
					{field:'secondweight',title:'次重量单价',align:'center',width:100},
					{field:'starttime',title:'启用时间',align:'center',width:200,
						formatter: function(value,row,index){	
					           if(value != null){
					               var date = value.time;
							       var startTime = new Date(date).toLocaleString();							   
							       return startTime;
					           }   						    
						}},
					{field:'endtime',title:'弃用时间',align:'center',width:200,
						formatter: function(value,row,index){	
					           if(value != null){
					               var date = value.time;
							       var endTime = new Date(date).toLocaleString();							   
							       return endTime;
					           }   						    
						}},
					{field:'chargestate',title:'状态',align:'center',width:100}					
				]]					
			});			
    	});     	


function query() {

    var url = "<%=basePath%>admin/getChargeInfo.do?state=" + $('#state').val();

	$('#chargedg').datagrid('options').url = url;
    $('#chargedg').datagrid('reload');

}
    
	
	
	
	
		function submitForm(){

			$('#ff').form('submit',{				
				success:function(data){   		      
		        if(data==1){
		           alert("添加成功，请继续");
		          clearForm();
		        }else{
		           alert("网络异常，稍后再试");
		           //document.getElementById("submitAlert").innerHTML = "网络异常，稍后再试";
		        }
		        		          
		    	}    
			});
		}
		function clearForm(){
			$('#ff').form('clear');
		}
		
		

    var test=new Vcity.CitySelector({input:'citySelect'});

		
	</script>     
        
   </div>
</body>
</html>
