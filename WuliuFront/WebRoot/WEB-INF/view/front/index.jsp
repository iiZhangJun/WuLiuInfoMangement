<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
//response.sendRedirect(basePath + "main.do");
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
   <TITLE>首页</TITLE>
	<meta http-equiv="Content-Style-Type" content="text/css">
	<LINK HREF="<%=basePath%>css/style.css" TYPE="text/css" REL="stylesheet"> 
	<style type="text/css">
		.STYLE2 {color: #FFFFFF}
		.STYLE3 {color: #717171}
		.STYLE7 {font-size: 12px}
		.STYLE10 {color: #000000}
	</style>
	</HEAD>
  </head>

<BODY BGCOLOR=#FFFFFF LEFTMARGIN=0 TOPMARGIN=0 MARGINWIDTH=0 MARGINHEIGHT=0 rightmargin="0" bottommargin="0" background="images/body.jpg" style="background-repeat:repeat-x;background-position:top">
		<table width="766"  border="0" align="center" cellpadding="0" cellspacing="0">
		
		<jsp:include page="public.jsp"></jsp:include>
			
			
		<td height="389">
		<div style=" padding-left:27px;padding-top:13px">
				<table width="698" height="295" border="0" cellspacing="0" cellpadding="0">
				<tr>
					<td width="233">
					  <div style=" padding-left:9px;padding-top:20px"><img src="images/txt-1.jpg" style="margin-bottom:2px "><a href="index.html"><img src="images/car-3.jpg" style="margin-top:14px "></a><br>
					</div>
				    <img src="images/line-1.jpg" style="margin-left:3px;margin-top:13px "><br>
						<div style=" padding-left:9px;padding-top:11px">
	
	        </div>
	                                             
					  <p><span class="STYLE3">&nbsp;&nbsp;<span class="STYLE10">&nbsp;</span></span></p>
					  <p>&nbsp;</p>
					  <p>&nbsp;</p>
					 
				  </td>
					<td width="5" background="images/b-1.jpg"><img src="images/spacer.gif" width="5" height="1"></td>
					<td width="460" align="right">
						<table width="437" height="100%" border="0" cellspacing="0" cellpadding="0">
						<tr>
							<td colspan="2" width="437" height="125"> 
								<div style=" padding-left:10px;padding-top:9px">
								  <p><span class="style-b STYLE7">关于我们</span></p>
								  <p>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; 本公司经营全国各大城市间的货物投递业务，业务水准趋于国内领先行列。从事的高速公路投递业务，安全、快速、廉价，是您投递物品的不二选择。我们的宗旨是“用心经营，诚信服务”，随时期待您的垂青。</p>
								</div>						</td>
						</tr>
						<tr>
							<td width="269" height="100%">
								<p><img src="images/txt-3.jpg" style="margin-left:10px;margin-bottom:6px"></p>
							    <div style=" padding-left:10px;padding-right:25px;line-height:13px">
							      <p><img src="images/china.gif" width="193" height="156"></p>
							      <p>&nbsp;</p>
							    </div>			         </td>
			  <td width="168" height="100%">
								<img src="images/txt-4.jpg" style="margin-bottom:18px ">
								<img src="images/pic-2.jpg">						</td>
						</tr>
				  </table>	</td>
				</tr>
				</table>
		  </div>
		</td>
		</tr>
		<tr><td><table width="700" align="center" cellpadding="0" cellspacing="0" style="margin-bottom:">
		  <tr>
		    <th height="5" scope="col"><img src="images/line-2.jpg" width="700" height="5"></th>
		  </tr>
		</table></td>
		</tr>
		<tr>
			<td height="52">
		  <div style=" padding-top:12px;padding-bottom:7px">
				      <div align="center"><a href="index.html">首页</a>&nbsp;| <a href="index-1.html">注册会员</a>&nbsp;| <a href="index-2.html">费用计算</a>&nbsp;|&nbsp;<a href="index-3.html">下订单</a>&nbsp;| <a href="index-4.html">订单进度查询</a></div>
			        </div>
		            <div style="padding-bottom:7px">
				    <div align="center"><a href="index-5.html" style="color:#6E6E6E;text-decoration:none">&copy;</a> 2009   天津大学软件学院IT_MOB项目组 物流管理系统 版权所有</div>
		            </div>	
			</td>
		</tr>
	</table>
</BODY>
</HTML>
