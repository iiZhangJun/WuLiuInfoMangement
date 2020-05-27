<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>配送站点个人信息页</title>
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
				    <form id="userInfo" action="<%=basePath%>siteBack/updateUserInfo.do" class="easyui-form" method="post" data-options="novalidate:true">
				    	<table cellpadding="5">
				    	    <tr>
				    			<td></td>
				    			<td><input type="hidden" name="userid" value="${user.userid}"/></td>
				    		</tr>        		
				    		<tr>
				    			<td>用户名:</td>
				    			<td><input class="easyui-textbox" type="text" name="username" value="${user.username}" data-options="required:true" style="height:30px; width:200px"/></td>
				    		</tr>
				    		<tr>
				    			<td>密&nbsp;&nbsp;&nbsp;码:</td>
				    			<td><input class="easyui-textbox" type="text" id="password" name="password" value="${user.password}" data-options="required:true" style="height:30px; width:200px"/></td>
				    		</tr>
				    		<tr>
				    			<td>站&nbsp;&nbsp;&nbsp;点:</td>
				    			<td><input class="easyui-textbox" type="text" id="pointname" name="pointname" value="${point.pointname}" data-options="required:true" readonly="true" style="height:30px; width:200px"/></td>
				    		</tr>
				    	</table>
				    </form>
				    <div style="text-align:center;padding:20px">
				    	<a href="javascript:void(0)" class="easyui-linkbutton" onclick="submitForm()">修改</a>
				    	<a href="javascript:void(0)" class="easyui-linkbutton" onclick="clearForm()">重置</a>
				    </div>
			    </div>
			</div>
	 	</div>
	    
	    </div>
	 
	</div>
	
    <script type="text/javascript">
	
	function submitForm(){
       $('#userInfo').form('submit', {        
		    success:function(data){
		    	alert(data);   		      
		        if(data==1){
		           alert("个人信息修改成功！");
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
	</script>
</body>
</html>
