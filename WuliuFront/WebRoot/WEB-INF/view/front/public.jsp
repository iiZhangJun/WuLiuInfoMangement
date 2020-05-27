<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<<!DOCTYPE tr PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<body>
	<tr>
		<td>
		<TABLE WIDTH=766 BORDER=0 CELLPADDING=0 CELLSPACING=0>
			<TR>
				<TD><IMG SRC="images/menu_01.jpg" WIDTH=239 HEIGHT=100 ALT=""></TD>
				<TD background="images/car-1.jpg" WIDTH=527 HEIGHT=100 ALT="">
					<div class="STYLE2" style=" padding-left:329px;padding-top:40px"><a  class="
                     STYLE2">首页</a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <a  class="STYLE2">帮助</a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <a  class="STYLE2">联系</a></div>				</TD>
			</TR>
			<TR>
				<TD><a href="<%=basePath%>indexPage.do"><img src="images/menu_02.jpg" width=239 height=35 alt=""></a></TD>
				<TD ROWSPAN=5><IMG SRC="images/car-2.jpg" WIDTH=527 HEIGHT=175 ALT=""></TD>
			</TR>
			<TR>
				<TD><a href="<%=basePath%>calcuCharge.do"><img src="images/menu_04.jpg" width=239 height=35 alt=""></a></TD>
			</TR>
			<TR>
				<TD><a href="<%=basePath%>queryOrder.do"><img src="images/menu_06.jpg" width=239 height=35 alt=""></a></TD>
		  </TR>
		</TABLE>
		</td>
	</tr>
  <tr>
</body>
</html>