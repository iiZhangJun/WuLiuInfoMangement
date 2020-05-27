<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>总公司后台首页</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	
	<link rel="stylesheet" type="text/css" href="<%=basePath%>style/themes/default/easyui.css">
	<link rel="stylesheet" type="text/css" href="<%=basePath%>style/themes/icon.css">
    <link rel="stylesheet" type="text/css" href="<%=basePath%>style/themes/color.css">
	<link rel="stylesheet" type="text/css" href="<%=basePath%>style/demo.css">
	<script type="text/javascript" src="<%=basePath%>js/jquery.min.js"></script>
	<script type="text/javascript" src="<%=basePath%>js/jquery.easyui.min.js"></script>
  </head>
  
  <body>
    
    <div style=" margin-top:-20px;"></div>
    
	<div class="easyui-layout" style="width:103%;height:770px; margin-left:-18px">
		<div data-options="region:'north'" style="height:102px">
	        <img src="<%=basePath%>images/bg3.jpg" style="width:100%; height:100px; float:left"/>
	        <div style="float:right; margin-top:-40px; margin-right:30px">
		        welcome：${user.username}  &nbsp;&nbsp;
		        <a href="<%=basePath%>logout.do">退出</a>
		    </div>
        </div>
		
		<div data-options="region:'west',split:true" title="导航栏" style="width:200px; resize:none;">
			<div class="easyui-accordion" data-options="fit:false,border:false">
            	<div title="订单管理" style="padding:0px;">
					<a href="<%=basePath%>admin/orderManage.do"  target="main">订单查询</a>
                    <br/>
				</div>
				<div title="配送点管理" style="padding:0px;">
					<a href="<%=basePath%>admin/siteManage.do"  target="main">配送点管理</a>
				</div>
				<div title="线路管理" style="padding:0px;">
					<a href="<%=basePath%>admin/roteManage.do"  target="main">线路管理</a>
				</div>
				<div title="班次管理" style="padding:0px">
					<a href="<%=basePath%>admin/classInfoManage.do"  target="main">管理班次</a>
                    <br/>
				</div>
                <div title="配送费管理" style="padding:0px">
					<a href="<%=basePath%>admin/chargeManage.do"  target="main">配送费</a>
					<br/>
					<a href="<%=basePath%>admin/chargeAudit.do" target="main">收费标准审核</a>
				</div>
                <div title="车辆维护" style="padding:0px">
					<a href="<%=basePath%>admin/autoManage.do"  target="main">车辆信息</a>
                    <br/>
                    <a href="<%=basePath%>admin/autoTypeManage.do"  target="main">车型信息</a>
				</div>
                <div title="权限管理" style="padding:0px">
					 <a href="<%=basePath%>admin/authorityMange.do"  target="main">权限管理</a>
				</div>
               <%--  <div title="财务管理" style="padding:0px">
					 <a href="<%=basePath%>companycontrol/IndexSvl?operate=12"  target="main">收益统计-配送点</a>
                     <br/>
                   <!--  <a href="incomeDiv.html"  target="main">利润分配</a>-->
				</div> --%>
			</div>
		</div>
		
		<div data-options="region:'center',title:'主菜单',iconCls:'icon-ok'">
			<iframe name="main" style="width:100%; height:632px; border:none"/>
		</div>
	</div>
    
    
    
  </body>
</html>
