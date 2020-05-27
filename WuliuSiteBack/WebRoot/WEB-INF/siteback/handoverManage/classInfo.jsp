<%@ page language="java" import="java.util.*" pageEncoding="gbk"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'query_class.jsp' starting page</title>
    
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
		function query(){
		var url="<%=basePath%>siteBack/queryPassClassInfo.do?classid="+$('#classid').val()+"&pointid="+$('#pointid').val();
		$('#review').datagrid('options').url = url;
		$('#review').datagrid('reload');
		}
	$(function() {
		$('#review').datagrid( {
		title : '',
		height : 500,
		toolbar : '#tb',
		nowrap : false,
		striped : true,
		url : null,
		rownumbers : true,
		pagination : true,
		pageList : [ 1,10 ],
		loadMsg : '��������ȴ�...',
		columns : [ [ 
		{field : 'tclassid',title : '��α��',width : 80},
        {field : 'troadid',title : '��·���',width : 80},
        {field : 'roadname',title:'��·����',width : 250},
        {field : 'tclassstarttime',title : '����ʱ��',width : 150,
			formatter: function(value,row,index){	
					           if(value != null){
					               var date = value.time;
							       var classStartTime = new Date(date).toLocaleString();							   
							       return classStartTime;
					           }   						    
						}
		},
		{field : 'tclassendtime',title : '�ִ�ʱ��',width : 150,
			formatter: function(value,row,index){	
					           if(value != null){
					               var date = value.time;
							       var classEndTime = new Date(date).toLocaleString();							   
							       return classEndTime;
					           }   						    
						}
		},
		{field : 'tclassstate',title : '״̬',width : 100},
		{field : 'classremarks',title : '��ע',width : 100}
		] ]
	});
	});

		</script>
<title>��β�ѯ</title>
  </head>
  
  <body>
   <table class="easyui-datagrid" id="review" 
			data-options="rownumbers:true,singleSelect:true,method:'post',toolbar:'#tb',footer:'#ft'">
	</table>
	<div id="tb" style="padding:2px 5px;">
	<input type="hidden" id="pointid" value="${point.pointid}" name="pointid"/>
		�������α��: <input class="easyui-textbox" id="classid">
		<a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-search" onclick="query()">��ѯ</a>
	</div>
  </body>
</html>
