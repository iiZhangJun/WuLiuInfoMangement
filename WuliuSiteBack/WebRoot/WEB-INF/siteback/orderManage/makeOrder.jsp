<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'make_order.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<link href="<%=basePath%>css/themes/default/easyui.css" rel="stylesheet" />
    <link href="<%=basePath%>css/themes/icon.css" rel="stylesheet" />
    <%-- <link rel="stylesheet" type="text/css" href="<%=basePath%>demo.css"> --%>
    <link href="<%=basePath%>css/themes/color.css" rel="stylesheet" />
    <link rel="stylesheet" type="text/css" href="<%=basePath%>css/cityselect.css">
    <link href="<%=basePath%>css/apply.css" rel="stylesheet" />
  <%--   <script type="text/javascript" src="<%=basePath%>js/jquery-form.js"></script> --%>
    <script type="text/javascript" src="<%=basePath%>js/jquery.min.js"></script>
    <script type="text/javascript" src="<%=basePath%>js/jquery.easyui.min.js"></script>
    <script type="text/javascript">
    $(document).ready(function() {
		var data = ${point.pointid};
		$("#stptid").find("option[value='"+data+"']").attr("selected",true);
	}); 
    function tijiao(){
    var goodsTypeId=$('#goodsTypeId').val();
    $('#order').form('submit',{
        
    	onSubmit:function(){
    	if(goodsTypeId == "value"){
        			  alert("请选择物品类型");
        			  return false;}
    	},
    	success:function(data){
    	alert(data);
    	
    	}
    })
    }
    
    function reset(){
    
    	$('#order')[0].reset();
    }
    </script>
    <title>现场下单</title>

  </head>
  
  <body>
	<br/>
    <form id="order" action="<%=basePath%>siteBack/makeOrder.do" class="easyui-form" method="post" data-options="novalidate:true">
    <div align="center">
    <table id="table1" style="border-collapse:separate; border-spacing:10px;">
    
    <c:if test="${order != null}">
   		<tr>
	    	<td colspan="4">
	    		<h4>单号 -- ${order.orderid}</h4>
	    	</td>
    	</tr>
    </c:if>
    <tr>
    	<td colspan="4"><h4>发货人信息</h4></td>
    </tr>
    <tr>
    <td>发货人：</td><td><input class="easyui-textbox" type="text" name="sendname" data-options="required:true" value="${order.sendname}"></td>
    <td>联系方式：</td><td><input class="easyui-numberbox" type="text" name="sendphone" data-options="required:true" value="${order.sendphone}"></td>
    </tr>
    <tr>
    <td>发货地址：</td><td colspan="3"><input name="sendaddress" class="easyui-textbox" data-options="multiline:true,required:true" style="width:300px;height:50px" value="${order.sendaddress}"></td>
    </tr>
    <tr>
    <td colspan="4"><h4>收货人信息</h4></td>
    </tr>
    <tr>
    <td>收货人：</td><td><input class="easyui-textbox" type="text" name="recvname" data-options="required:true" value="${order.recvname}"></td>
    <td>联系方式：</td><td><input class="easyui-numberbox" type="text" name="recvphone" data-options="required:true" value="${order.recvphone}"></td>
    </tr>
    <tr>
    <td>收货地址：</td><td colspan="3"><input name="recvaddress" class="easyui-textbox" data-options="multiline:true,required:true" style="width:300px;height:50px" value="${order.recvaddress}"></td>
    </tr>
    <tr>
    <td colspan="4"><h4>货物信息</h4></td>
	</tr>
	<tr>
    <td>重量</td><td><input class="easyui-numberbox" precision="2" name="weight" data-options="required:true" value="${order.weight}"></td>
    </tr>
    <tr>
    <td>加急</td><td>是 <input name="fast" type="radio" value="1" style="width:auto;"> 否  <input name="fast" type="radio" value="0" style="width:auto;"></td>
    
    <td>加急费用</td>
    <td>
	    <c:if test="${order!=null}">
	    	<input name="fastcost" class="easyui-numberbox" type="text" data-options="required:true" value="${order.fastcost}">
	    </c:if>
	    <c:if test="${order==null}">
	    	<input name="fastcost" class="easyui-numberbox" type="text" data-options="required:true" value="0">
	    </c:if>
    </td>
    </tr>
    <tr>
    <td>货物类型</td>
    <td>
    	<c:if test="${good!=null}">
    	<select name="goodsTypeId" id="goodsTypeId" value="${good.goodstypeid}">
           <option value="value">请选择</option>
           <c:forEach var="good" items="${goodtype}">
				<option value="${good.goodstypeid}">${good.goodstypename}</option>
		   </c:forEach>
         </select>
    	</c:if>
    	<c:if test="${good==null}">
    	<select name="goodsTypeId" id="goodsTypeId" >
           <option value="value">请选择</option>
           <c:forEach var="good" items="${goodtype}">
				<option value="${good.goodstypeid}">${good.goodstypename}</option>
		   </c:forEach>
         </select>
    	</c:if>
         
    </td>
    <td>保价费</td>
    <td>
    	<c:if test="${order != null}">
    		<input name="safe" class="easyui-numberbox" type="text" value="${order.safe}"/>
    	</c:if>
    	<c:if test="${order == null}">
    		<input name="safe" class="easyui-numberbox" type="text" value="0" />
    	</c:if>
    </td>
    </tr>
    <tr>
    <td>费用</td><td><input class="easyui-numberbox" precision="2" type="text" name="cost" data-options="required:true"  value="${order.cost}"></td>
    </tr>
    <td>备注：</td><td colspan="3"><input name="remarks" class="easyui-textbox" data-options="multiline:true" style="width:300px;height:50px" value="${order.remarks}"></td>
    </tr>
   <tr>
    <td colspan="4"><h4>服务信息</h4></td>
    </tr>
    <tr>
    <td>发货配送点：</td>
    <td>
    <select name="stptid" value="${point.pointid}" id="stptid">
		<c:forEach var="bp" items="${points}">
			<option value="${bp.pointid}">
				${bp.pointname}
			</option>
		</c:forEach>
	</select>
    </td>
                    
    <td>收货配送点：</td>
    <td>
    	<c:if test="${endpoint == null}">
	    	<select name="edptid">
				<option value="">
					请选择
				</option>
				<c:forEach var="bp" items="${points}">
					<option value="${bp.pointid}">
						${bp.pointname}
					</option>
				</c:forEach>
			</select>
	    </c:if>
	    <c:if test="${endpoint != null}">
	    	<select name="edptid" value="${endpoint.pointid}">
				<option value="">
					请选择
				</option>
				<c:forEach var="bp" items="${points}">
					<option value="${bp.pointid}">
						${bp.pointname}
					</option>
				</c:forEach>
			</select>
	    </c:if>
    </td>
    </tr>
    <tr>
    <td>下单时间</td><td><input name="sendtime" class="easyui-datetimebox" type="text" data-options="required:true" value="${order.sendtime}"></td>
    <td>预计时间</td><td><input name="exptime" class="easyui-datebox" type="text" data-options="required:true" value="${order.exptime}"></td>
    </tr>
    <tr><td>状态</td>
    	<td>
	    	<select id="state" name="state" class="easyui-combobox" panelHeight="auto" style="width:130px;" data-options="required:true" value="${order.state}">
				<option value="待审核">待审核</option>
				<option value="入库">入库</option>
			</select>
		</td>
		</tr>
    </table>
    <div>
    	<c:if test="${order == null}">
    		<input type="button" class="easyui-linkbutton c1" value="提交" onclick="tijiao()"/>
    		<input type="button" class="easyui-linkbutton c1" value="重置" onclick="reset()"/>
    	</c:if>
    </div>
    </div>
    </form>
  </body>
</html>
