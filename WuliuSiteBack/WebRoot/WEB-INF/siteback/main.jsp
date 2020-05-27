<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'main.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<title>物流系统</title>
    <link href="css/index.css" rel="stylesheet" />
    <link href="css/themes/default/easyui.css" rel="stylesheet" />
    <link href="css/themes/icon.css" rel="stylesheet" />
    <link href="css/demo.css" rel="stylesheet" />
    <script src="js/jquery.min.js"></script>
    <script src="js/jquery.easyui.min.js"></script>
	<script>
        $(function () {
            bindEvent();
        });
        function bindEvent() {
            $(".btn_menu").click(function () {
                var title = $(this).text();
                var url = $(this).attr("url");
                var isSelect = $("#container").tabs('exists', title);
                if (isSelect) {
                    $("#container").tabs('select', title);
                    return;
                }
                $("#container").tabs('add', {
                    title: title,
                    content: CreateContent(url),
                    closable: true
                });
            });
        }

        function CreateContent(url) {
            var strHtml = '<iframe src="' + url + '" scrolling="no" frameborder="0" fit="true" style="height:110%;width:100%;min-height:750px;"></iframe>';
            return strHtml;
        }
    </script> 
  </head>
  
  <body>
   <body>
<div id="layout_div" class="easyui-layout">
        <div data-options="region:'north',border:false" style="overflow:hidden; height:110px; background-image:url(<%=basePath%>images/bg3.jpg);padding:10px;padding-left:30px;">
            <div style="color:#fff  ;font-size:3em; float:left;margin-left:30px;">
            </div>
            <div style="float:right;height:70px; margin-right:50px;">
                <span>您好,${user.username}</span>
                <span><a href="<%=basePath%>logout.do">注销</a></span>
            </div>
        </div>
        <div data-options="region:'west',split:false,title:'菜单',collapsible:false" style="width:170px;">
            <div id="menu" class="easyui-accordion" fit="true">
                <!-- a标签url属性中填写（/控制器名称/视图名称） -->
                <div title="订单状态管理" data-options="iconCls:'icon-print'" style=" overflow:auto;padding:10px;">
                    <ul class="easyui-tree">
                   	    <li><a href="javascript:;" class="btn_menu" url="<%=basePath%>siteBack/makeOrder.do">现场下单</a></li>
                        <li><a href="javascript:;" class="btn_menu" url="<%=basePath%>siteBack/updateOrderState.do">订单修改</a></li>
                        <li><a href="javascript:;" class="btn_menu" url="<%=basePath%>siteBack/checkOrder.do?state=审核">订单审核</a></li>
                    </ul>
                </div>
                <div title="物流进程管理" data-options="iconCls:'icon-redo'" style="overflow:auto;padding:10px;">
                    <ul class="easyui-tree">
                        <li><a href="javascript:;" class="btn_menu" url="<%=basePath%>siteBack/queryClass.do">班次查询</a></li>
                        <li><a href="javascript:;" class="btn_menu" url="<%=basePath%>siteBack/handoverConfirm.do?flag=start">发货点发货</a></li>
                        <li><a href="javascript:;" class="btn_menu" url="<%=basePath%>siteBack/handoverConfirm.do?flag=pass">物流中转交接</a></li>
                        <li><a href="javascript:;" class="btn_menu" url="<%=basePath%>siteBack/handoverConfirm.do?flag=end">收货点收货</a></li>
                        <li><a href="javascript:;" class="btn_menu" url="<%=basePath%>siteBack/orderReceipt.do">客户签收录入</a></li>
                        <%-- <li><a href="javascript:;" class="btn_menu" url="<%=basePath%>ApplyClassSvl">加开线路申请</a></li> --%>
                    </ul>
                </div>
               
                 <div title="订单异常处理" data-options="iconCls:'icon-cancel'" style="overflow:auto;padding:10px;">
                    <ul class="easyui-tree">
                        <li><a href="javascript:;" class="btn_menu" url="<%=basePath%>siteBack/recordExcepOrder.do">订单异常处理登记</a></li>
                        <li><a href="javascript:;" class="btn_menu" url="<%=basePath%>siteBack/queryExcepOrder.do">订单异常处理查询</a></li>
                    </ul>
                </div>
                <div title="个人信息管理" data-options="iconCls:'icon-cancel'" style="overflow:auto;padding:10px;">
                    <ul class="easyui-tree">
                        <li><a href="javascript:;" class="btn_menu" url="<%=basePath%>siteBack/userInfoMag.do">个人信息修改</a></li>
                    </ul>
                </div>
          </div>
  </div>
        <!--<div data-options="region:'south',border:false" style="height:50px; font-size:15px; color:#fff; background:#338FCC;padding:10px; text-align:center">
           © 2016 - 快递服务申请系统
        </div>-->
        <div data-options="region:'center'" style="overflow:hidden">
            <div class="easyui-tabs" fit="true" id="container">
                <div title="主页" style="padding:10px">
                    <img src="<%=basePath%>/images/welcome.jpg"></img>
                    <!--<iframe src="make_order.html" scrolling="no" frameborder="0" height="1000" width="1100" style="overflow:hidden; margin-bottom:10px;"></iframe>-->
                </div>
            </div>

        </div>
    </div>
</body>
  </body>
</html>
