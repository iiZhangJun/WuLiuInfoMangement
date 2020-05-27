<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">      
<HTML>
<HEAD>
	<TITLE>订单进度查询</TITLE>
	 <base href="<%=basePath%>">
	 <meta http-equiv="Content-Style-Type" content="text/css">
	 <LINK HREF="<%=basePath%>css/style.css" TYPE="text/css" REL="stylesheet"> 
	 <script type="text/javascript" src="<%=basePath%>/js/jquery-1.9.0.min.js"></script> 
	 <style type="text/css">
		.STYLE2 {color: #FFFFFF}
		.STYLE3 {color: #717171}
		.STYLE10 {color: #000000}
	</style>
	<script type="text/javascript">
		function getOrderInfo(){
			var oid = document.getElementById("orderno").value;
			var destURL = "<%=basePath%>queryOrder.do";
			if(oid == ''){
				alert("*****请先填写订单编号*****");
				return false;
			}else{
				$.getJSON(destURL, {orderid:encodeURI(oid)},function callback(data){
					alert(data);
				
				});
			
			}
		
		}
	</script>
	
	 </HEAD>
<BODY BGCOLOR=#FFFFFF LEFTMARGIN=0 TOPMARGIN=0 MARGINWIDTH=0 MARGINHEIGHT=0 rightmargin="0" bottommargin="0" background="images/body.jpg" style="background-repeat:repeat-x;background-position:top">
		<table width="766"  border="0" align="center" cellpadding="0" cellspacing="0">
		<jsp:include page="public.jsp"></jsp:include>
		<tr>
			<td height="327">
		<div style=" padding-left:27px;padding-top:13px">
					<table width="698" height="295" border="0" cellspacing="0" cellpadding="0">
					<tr>
						<td width="233">
						  <div style=" padding-left:9px;padding-top:20px"><img src="images/txt-1.jpg" style="margin-bottom:2px "><a href="index-4.html"><img src="images/car-3-4.jpg" style="margin-top:14px "></a><br>
						</div>
					    <img src="images/line-1.jpg" style="margin-left:3px;margin-top:13px "><br>
		<div style=" padding-top:6px;padding-left:9px;line-height:14px;padding-right:45px">						
						</div>				
		                 <p>订单进度查询，使您清楚地了解自己的订单所处的状态，如果定单位通过审核，说明您填写的信息有误，请您修改订单，重新下单，谢谢。</p	>
		                 <p>&nbsp;</p	>
		                 <p>&nbsp;</p	>
		                 <p><span class="STYLE3"><span class="STYLE5">&nbsp;&nbsp;&nbsp;</span></span></p	>
		                 <p><span class="STYLE3"><span class="STYLE5">&nbsp;&nbsp;&nbsp;</span></span></p	>
		                 <p>&nbsp;</p	>
		                 <p>&nbsp;</p	>
		                 <p>&nbsp;</p	>
		                </td>
						<td width="5" background="images/b-1.jpg"><img src="images/spacer.gif" width="5" height="1"></td>
						<td width="460" align="right">					
							<table width="" height="100%" border="0" cellspacing="0" cellpadding="0">
							<tr>
								<td width="" height="100%"> 
									<div style="">
									  <p><img src="images/1-txt-3.jpg" width="450" height="24" style="margin-left:10px;margin-bottom:12px"></p>
									  <form name="form1" method="post" action="">
									    <table width="400px" border="1" align="center" bgcolor="#FFFFFF">
		                                  <tr bgcolor="#CCCCCC">
		                                    <td><div align="center">订单编号</div></td>
		                                    <td><div align="center">订单状态</div></td>
		                                  </tr>
		                                  <tr>
		                                    <td><div align="center">
		                                      <input type="text" name="orderid" value="${baseOrder.orderid}" required style="width:150px;height:16px;padding-left: 5px;font-size:11px;border-color:#D4D4D4;border-style:solid;border-width:1px">
		                                    </div></td>
		                                    <td><div align="center">
		                                      <input type="text"  value="${baseOrder.statedesc}" style="width:180px;height:16px;padding-left: 5px;font-size:11px;border-color:#D4D4D4;border-style:solid;border-width:1px" readonly>                                    
		                                    </div></td>
		                                  </tr>
		
											  <tr height="28px">
		                                    <td colspan="2"><div align="center">
		                                      <input type="submit" value="查询" style="width:120px;height:23px;font-size:11px;border-color:#D4D4D4;border-style:solid;border-width:1px">
		                                    </div></td>
		                                  </tr>
		                                </table>
									  </form>
									  <p style="margin-left:30px;">${message} </p>
									  <div style="margin-left:30px;">
										  <c:if test="${transInfo!=null}">
											  <c:forEach var="trans" items="${transInfo}">
											  	<c:if test="${trans.pointid == baseOrder.stptpointid }">
											  		<p style="color: rgb(0,0,0); font-size: 14px;line-height: 1.5em;">${trans.transferTime}&nbsp;&nbsp;&nbsp;${trans.pointname}发出</p>
											  	</c:if>
											  	<c:if test="${trans.pointid != baseOrder.stptpointid && trans.pointid != baseOrder.edptpointid }">
											  		<p style="color: rgb(0,0,0); font-size: 14px;line-height: 1.5em;">${trans.transferTime}&nbsp;&nbsp;&nbsp;抵达${trans.pointname}并发出</p>
											  	</c:if>
											  	<c:if test="${trans.pointid == baseOrder.edptpointid }">
											  		<p style="color: rgb(0,0,0); font-size: 14px;line-height: 1.5em;">
											  			${trans.transferTime}&nbsp;&nbsp;&nbsp; 抵达${trans.pointname}&nbsp;&nbsp;&nbsp;
											  			<c:if test="${baseOrder.state=='抵达'}"> &nbsp;&nbsp;&nbsp;配送员正在派件...   电话: ${baseOrder.edpttel}</c:if>
											  			<c:if test="${baseOrder.state=='已签收'}"> 已签收 </c:if>
											  		</p>
											  	</c:if>
											  </c:forEach>
											  
										 </c:if>
									</div>
							  </div>						
							 </td>
							</tr>											
							</table>				
						</td>
					</tr>
					</table>
			  </div>
			</td>
		</tr>
		<tr><td><table width="700" align="center" cellpadding="0" cellspacing="0" style="margin-bottom:">
		  <tr>
		    <th height="5" scope="col"><img src="images/line-2.jpg" width="700" height="5"></th>
		  </tr>
		</table></td></tr>
		<tr>
				<td height="52">
		  <div style=" padding-top:12px;padding-bottom:7px">
				      <div align="center"><a href="index.html">首页</a>&nbsp;| <a href="index-1.html">注册会员</a>&nbsp;| <a href="index-2.html">费用计算</a>&nbsp;|&nbsp;<a href="index-3.html">下订单</a>&nbsp;| <a href="index-4.html">订单查询</a></div>
			        </div>
		            <div style="padding-bottom:7px">
				    <div align="center"><a href="index-5.html" style="color:#6E6E6E;text-decoration:none">&copy;</a> 2009   天津大学软件学院IT_MOB项目组 物流管理系统 版权所有</div>
		            </div>	
			</td>
		</tr>
		</table>
</BODY>
</HTML>
