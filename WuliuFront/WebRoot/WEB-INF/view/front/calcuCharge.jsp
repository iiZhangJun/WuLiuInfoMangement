<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'caculCharge.jsp' starting page</title>
    
	<LINK HREF="<%=basePath%>css/style.css" TYPE="text/css" REL="stylesheet"> 
	<script type="text/javascript" src="<%=basePath%>/js/jquery-1.9.0.min.js"></script> 
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
	<style type="text/css">
		.STYLE2 {color: #FFFFFF}
		.STYLE3 {color: #717171}
		.STYLE7 {font-size: 12px}
		.STYLE8 {color: #000000}
	</style>
  </head>
  
  <body  BGCOLOR=#FFFFFF LEFTMARGIN=0 TOPMARGIN=0 MARGINWIDTH=0 MARGINHEIGHT=0 rightmargin="0" bottommargin="0" background="images/body.jpg" style="background-repeat:repeat-x;background-position:top">
	<table width="766"  border="0" align="center" cellpadding="0" cellspacing="0">
	<jsp:include page="public.jsp"></jsp:include>
	<tr>
		<td height="327">
			<div style=" padding-left:27px;padding-top:13px">
				<table width="698" height="295" border="0" cellspacing="0" cellpadding="0">
				<tr>
					<td width="233">
						<div style=" padding-left:9px;padding-top:20px">
							<img src="images/2-txt-1.jpg" style="margin-bottom:2px "><a href="index-2.html"><img src="images/car-3-2.jpg" style="margin-top:14px "></a><br>
						</div>
	    <img src="images/line-1.jpg" style="margin-left:3px;margin-top:13px "><br>
						<div style=" padding-left:9px;padding-top:11px">费用计算可以使您方便的估算出自己投递相应物品所需的费用，这项服务包括两个部分，一部分是一定距离内的运费计算，另一部分是一定重量体积比下的费用，一目了然，让您明明白白的放心下单。<br>
					</div> 
		  <p>&nbsp;</p>
		  <p>&nbsp;</p>
		  <p><span class="STYLE3">&nbsp;&nbsp;&nbsp;</span></p>
		  <p><span class="STYLE3">&nbsp;&nbsp;&nbsp;</span></p>
		  <p>&nbsp;</p>
		  <p>&nbsp;</p>
		  <p>&nbsp;</p>
					<td width="5" background="images/b-1.jpg"><img src="images/spacer.gif" width="5" height="1"></td>
					<td width="460" align="right">
						<form  action="<%=basePath%>CalcuCharge.do"    method="post" style="margin:0">
						<table width="427" height="100%" border="0" cellspacing="0" cellpadding="0">
						<tr>
							<td colspan="2" width="427" height="46"> 
								<div style=" padding-left:10px;padding-top:9px">
									<img src="images/2-txt-2.jpg" style="margin-bottom:0px "><br>								
								</div>						</td>
						</tr>
						<tr>
							<td width="228" height="111">
							<div align="left">
							  <p><img src="images/发货地.jpg" style="margin-left:0px;margin-bottom:16px"><br>&nbsp;&nbsp;&nbsp;</p>
							  <p>
							    <!-- 代码 开始 -->
								<div style=" width:210px; margin:25px auto 30px auto;">
								<!-- <form action="####" method="post"> -->
								<input type="text" id="city1" name="city1" value="${city1}" required style="height:30px; width:200px; line-height:30px; font-size:14px; padding:0 5px;" />
								<!-- </form> -->
								 </div>
								 </form>
								<script type="text/javascript">
								$("#city1").click(function (e) {
									SelCity(this,e);
								    console.log("inout",$(this).val(),new Date())
								});
								</script>
								<!-- 代码 结束 -->
								
							    <br>					      
							    <img src="images/spacer.gif" width="1" height="3"><br>
						        </p>
							</div></td>
	      <td width="199" height="111">
								<p><img src="images/收货地.jpg" style="margin-bottom:4px ">						  </p>
								<br>
								<p>
	                            	    <!-- 代码 开始 -->
								<div style=" width:210px; margin:25px auto 30px auto;">
								<!-- <form action="####" method="post"> -->
								<input type="text" id="city2" name="city2" value="${city2}" required style="height:30px; width:200px; line-height:30px; font-size:14px; padding:0 5px;" />  <!-- required oninvalid="setCustomValidity('收货地信息不能为空')" --> 
								<!-- <div class="button"><span><input type="submit" value = "购票" style="width:180px;height:50px;font-size:1.5em;background:#FC7D01;color:#FFF;"/></span></div>	 -->
								<!-- </form> -->
								 </div>
								 </form>
								<script type="text/javascript">
								$("#city2").click(function (e) {
									SelCity(this,e);
								    console.log("inout",$(this).val(),new Date())
								});
								</script>
								<!-- 代码 结束 -->
								
	                              <br>
	                              <img src="images/spacer.gif" width="1" height="3"><br>
								</p>
						  		<p>&nbsp;</p></td>
						</tr>
						<tr>
							<td width="228" height="90">
							  <p><img src="images/质量.jpg" style="margin-left:0px;margin-bottom:5px"><br>
							  <p>&nbsp;&nbsp;&nbsp;&nbsp;重量：
	                            <input type="text" name="weight" id="weight" required value="${weight}" style="width:100px;height:20px;font-size:11px;border-color:#D4D4D4;border-style:solid;border-width:1px">&nbsp;&nbsp;Kg
	  		<br>
			  <img src="images/spacer.gif" width="1" height="3"><br>
							          </p><span id="wi"></span>
							  </td>
							  <td width="209" height="90" style="padding-top:40px;">
								  <p align="center">
							   <input type="submit" name="button" id="button" onclick="return check()" style="width:60px;height:18px;font-size:11px;border-color:#D4D4D4;border-style:solid;border-width:1px" value="进行估算">
						      <span class="STYLE7"> &nbsp;&nbsp;</span></p>
						      <script type="text/javascript">
						      	function check(){
						      		debugger;
						 			var text = document.getElementById("weight").value;
						 			if(isNaN(text)){
										document.getElementById("wi").innerHTML = "重量必须是数字";
										return false;
									}
								}						      
						      </script>
							  </td>
						</tr>
						<tr><td colspan="2"><img src="images/2-line-1.jpg"></td></tr>
						<tr>
							<td colspan="2" width="427" height="100%"><br>
							  <p align="right"><span class="STYLE7">预计费用:</span>
							    <input type="text" value="${charge}" style="width:100px;height:20px;font-size:11px;border-color:#D4D4D4;border-style:solid;border-width:1px" readonly />&nbsp;&nbsp;元
						      </p>
							</td>
						</tr>
						</table>
					  </form>
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
			      <div align="center"><a href="index.html">首页</a>&nbsp;| <a href="index-1.html">注册会员</a>&nbsp;| <a href="index-2.html">费用计算</a>&nbsp;|&nbsp;<a href="index-3.html">下订单</a>&nbsp;| <a href="index-4.html">订单进度查询</a></div>
		        </div>
	            <div style="padding-bottom:7px">
			    <div align="center"><a href="index-5.html" style="color:#6E6E6E;text-decoration:none">&copy;</a> 2009   天津大学软件学院IT_MOB项目组 物流管理系统 版权所有</div>
	            </div>	
		</td>
	</tr>
</table>
  </body>
</html>
