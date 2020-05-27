<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>总公司后台车辆信息维护页</title>
    
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
  
  <div title="添加车辆">
  		<div class="easyui-panel"  style="width:100%">
		<div style="padding:10px 60px 20px 60px"  align="center">
        <br/><br/>
	    <form id="carInfo" action="<%=basePath%>admin/addNewAuto.do" class="easyui-form" method="post" data-options="novalidate:true">
	    	<table cellpadding="5">
           		<tr>
	    			<td>车辆类型:</td>
	    			<td>
                    	<select name="autoType" class="easyui-combobox" style="height:30px; width:200px">
                        	<option selected>请选择</option>
                            <c:forEach var="ct" items="${carType}">
                            	<option value="${ct.cartypeid}">${ct.cartypename}</option>
                            </c:forEach>
                        </select>
                    </td>
	    		</tr>
	    		<tr>
	    			<td>车牌号:</td>
	    			<td><input class="easyui-textbox" type="text" name="autoid" data-options="required:true" style="height:30px; width:200px"/></td>
	    		</tr>
	    		
	    		<tr>
	    			<td>主驾驶员:</td>
	    			<td>
	    				<select name="maindriver" class="easyui-combobox" style="height:30px; width:200px">
                        	<option selected>请选择</option>
                            <c:forEach var="stf" items="${staff}">
                            	<option value="${stf.staffid}">${stf.staffname}</option>
                            </c:forEach>
                        </select>
	    				<!-- <input class="easyui-textbox" type="text" name="mainDriver" data-options="required:true" style="height:30px; width:200px"/> -->
	    			</td>
	    		</tr>
	    		<tr>
	    			<td>副驾驶员:</td>
	    			<td>
	    				<select name="seconddriver" class="easyui-combobox" style="height:30px; width:200px">
                        	<option selected>请选择</option>
                            <c:forEach var="stf" items="${staff}">
                            	<option value="${stf.staffid}">${stf.staffname}</option>
                            </c:forEach>
                        </select>
	    				<!-- <input class="easyui-textbox" type="text" name="secDriver" data-options="multiline:true" style="height:30px; width:200px"/> -->
	    			</td>
	    		</tr>
                <tr>
	    			<td>车辆载重:</td>
	    			<td><input class="easyui-textbox" type="text" name="cartweight"  value="0" style="height:30px; width:200px"/></td>
	    		</tr>
                <tr>
	    			<td>车辆体积:</td>
	    			<td><input class="easyui-textbox" type="text" name="carvol" value="0" style="height:30px; width:200px"/></td>
	    		</tr>
	    	</table>
	    </form>
	    <div style="text-align:center;padding:20px">
	    	<a href="javascript:void(0)" class="easyui-linkbutton" onclick="submit()">提交</a>
	    	<a href="javascript:void(0)" class="easyui-linkbutton" onclick="clear()">重置</a>
	    </div>
	    </div>
	</div>

  </div>

  <div title="车辆信息">	
  
  <div align="center">
					车牌号
					<input type="text" id="carNum" name="carNum" value="" />
					&nbsp;
					<input style="height: 30px; width: 50px" type="button" value="查询"
						onclick="queryCar()" />
				</div>
  
	<table id="CarInfor" class="easyui-datagrid" title="车辆信息" style="width:1145px;height:auto"
			data-options="
            	rownumbers:true,
				iconCls: 'icon-edit',
				singleSelect: true,
				toolbar: '#tb',
				method: 'get',
                pagination:true,
				onClickRow: onClickRow
			">
	</table>

	<div id="tb" style="height:auto">
		<a href="javascript:void(0)" class="easyui-linkbutton" data-options="iconCls:'icon-remove',plain:true" onclick="removeit()">删除</a>
	</div>
    
    <!--window弹出框  现隐藏 需要时弹出-->
   <div id="win" class="easyui-window" title="车辆信息" data-options="iconCls:'icon-save'" style="width:700px;height:auto;">
       <div class="easyui-panel" title="更改车辆信息" style="width:100%">
			<div style="padding:10px 60px 20px 60px">
	    	<form id="fff" action="<%=basePath%>companycontrol/CarUpdateSvl" class="easyui-form" method="post" data-options="novalidate:true">
	    	<table cellpadding="5">
	    		<tr>
	    			<td>车牌号:</td>
	    			<td><input class="easyui-textbox"  type="text" id="carNumb" name="autoid" data-options="required:true" readonly /></td>
	    		</tr>
	    		<tr>
	    			<td>主驾驶员:</td>
	    			<td>
	    				 <select id="driver11bb" name="maindriver" class="easyui-combobox" style="height:30px; width:200px">
                        	<option>请选择</option>
                            <c:forEach var="stf" items="${staff}">
                            	<option value="${stf.staffid}">${stf.staffname}</option>
                            </c:forEach>
                        </select>
	    			</td>
	    		</tr>
                <tr>
	    			<td>副驾驶:</td>
	    			<td>
	    				<select id="driver22bb" name="seconddriver" class="easyui-combobox" style="height:30px; width:200px">
                        	<option>请选择</option>
                            <c:forEach var="stf" items="${staff}">
                            	<option value="${stf.staffid}">${stf.staffname}</option>
                            </c:forEach>
                        </select>
	    			</td>
	    		</tr>
	    		<tr>
	    			<td>车型:</td>
	    			<td><input class="easyui-textbox" type="text" id="carType" name="carType" data-options="required:true" readonly/></td>
	    		</tr>        
                <tr>
	    			<td>车辆载重:</td>
	    			<td><input class="easyui-textbox" type="text" id="weight" name="cartweight"  data-options="required:true" ></td>
	    		</tr>
                 <tr>
	    			<td>车辆体积:</td>
	    			<td><input class="easyui-textbox" type="text" id="vol" name="carvol"  data-options="required:true" ></td>
	    		</tr>    			    		
	    	</table>
	    	</form>
	    	<div style="text-align:center;padding:5px">
	    	<a href="javascript:void(0)" class="easyui-linkbutton" onclick="submitForm()">提交</a>
	    	<a href="javascript:void(0)" class="easyui-linkbutton" onclick="clearForm()">重置</a>
	   		 </div>
	   	 </div>
		</div>
   </div>
  </div>
</div>
	<script type="text/javascript">
	
	
	function queryCar() {

		var url = "<%=basePath%>admin/getAutoInfo.do?carNum="
				+ $('#carNum').val();
	
		$('#CarInfor').datagrid('options').url = url;
		$('#CarInfor').datagrid('reload');

	}

	$(function(){
   		$('#CarInfor').datagrid({
			title:'车辆信息',									
			nowrap: false,
			striped: true,								
			url: null,
			rownumbers:true,
			loadMsg : 'processing, please wait …',
			pageList:[1,2,5,10],			
			columns:[[	
				{field :'no',checkbox : true},				
				{field:'autoid',title:'车牌号',align:'center',width:100},					
				{field:'autotypename',title:'车辆类型',align:'center',width:100},					
				{field:'driver1name',title:'主驾驶员',align:'center',width:100},					
				{field:'driver2name',title:'副驾驶员',align:'center',width:100},
				{field:'cartweight',title:'车辆载重',align:'center',width:100},
				{field:'carvol',title:'车辆体积',align:'center',width:100},
			]]					
		});			
    	}); 
	
	function submit(){
       $('#carInfo').form('submit', {        
		    success:function(data){   		      
		        if(data==1){
		           alert("添加车辆信息成功，请继续");
		           clear();
		        }else{
		           alert("网络异常，稍后再试");
		           //document.getElementById("submitAlert").innerHTML = "网络异常，稍后再试";
		        }
		        		          
		    }    
		}); 
    }    
		
		
		
	function clear(){
		$('#carInfo').form('clear');
	}
		
	var editIndex = undefined;		
	function onClickRow(index){
		if (editIndex != index){
			if (endEditing()){
				$('#dg').datagrid('selectRow', index)
						.datagrid('beginEdit', index);
				editIndex = index;
			} else {
				$('#dg').datagrid('selectRow', editIndex);
			}
		}
	}
		
	function removeit(){
		var carNum = $('#CarInfor').datagrid('getSelected')['no'];
		var r = confirm('请确认要删除此车辆吗?');
		if (r == true) {
		$.ajax( {
			type : "POST",
			dataType : "text",
			url : "<%=basePath%>admin/delAuto.do",
			data : "carNum="  + carNum,
			success : function(msg) {
				if(msg == 1){
					var r = confirm('删除成功');
						if(r == true){						  	
						queryCar();						 
						}
				}			
			}	
		});  
		
		}
	}
		
	$(function(){  	
		$('#win').window({    
			   
			modal:true
		});	
		$('#win').window('close');      		
   	});
    	
    	
    function onClickRow(index, row) {
		$('#win').window('open');
		var carNum = row["autoid"];
		var carSizeName = row["autotypename"];
		
		var driver1 = row["driver1name"];
		var driver2 = row["driver2name"];
		alert(driver1);
		alert(driver2);
		var carWeight = row["cartweight"];
		var carVol = row["carvol"];
		
		$("#carNumb").textbox('setValue', carNum);
		$("#carType").textbox('setValue', carSizeName);
		$("#weight").textbox('setValue', carWeight);
		$("#vol").textbox('setValue', carVol);
		
		$("##driver11bb option[text='" + driver1 + "']").attr("selected", "selected");  
		
		
	}
    				 		
		
		
	function submitForm(){
       $('#fff').form('submit', {        
		    success:function(data){   		      
		        if(data==1){
		           alert("修改车辆信息成功，请继续");
		           $('#win').window('close');
		         queryCar();
		        }else{
		           alert("网络异常，稍后再试");
		           //document.getElementById("submitAlert").innerHTML = "网络异常，稍后再试";
		        }
		        		          
		    }    
		}); 
    }    
		
		
	</script>
	
</body>
</html>

