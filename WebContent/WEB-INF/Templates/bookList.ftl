<html>
	<head>
	<title>图书列表</title>
	
<#include "common/easyui_import.ftl">



<script type="text/javascript">
	$(function(){
	
	});
</script>




	<script  type="text/javascript">
	var ctx='${request.getContextPath()}';

		function doDel(bid){
			if(confirm("确认删除")){
			    var param="?bid="+bid+"&book.bid="+bid;
			   window.location.href=ctx+"/fm/book_delete"+param;
			}
		}
		function toEdit(bid){
			var bookparam="?bid="+bid+"&book.bid="+bid;
			window.location.href=ctx+"/fm/book_toEdit"+bookparam;
		}
</script>
	</head>
	<body>
	<#--
	<a href="${request.getContextPath()}/fm/book_initdb">初始化数据</a>
		图书列表：<br/>
		<#list bookList as b>
			${b.bid},
			${b.bname!"none"},
			<#if b.beg??>
			${b.beg} 
			<#else>
			暂无
			</#if>
			<a href="javascript:doDel(${b.bid});" >删</a>&nbsp; &nbsp; <a href="javascript:toEdit(${b.bid});" >改</a><br/>
		</#list>
		
		-->
		
	
		<div style="margin:10px 0;"></div>
		
		<table id="dd" class="easyui-datagrid" title="图书列表" style="width:800px;height:550px"
			data-options="rownumbers:true,singleSelect:false,url:'${request.getContextPath()}/fmajax/bookAJAX_list',toolbar:toolbar">
		<thead>
			<tr>
			    <th data-options="field:'ck',checkbox:true"></th>
				<th data-options="field:'bid',width:80">图书编号</th>
				<th data-options="field:'bname',width:100">书名</th>
				<th data-options="field:'bTypeId',width:80,align:'right'">类别</th>
				<th data-options="field:'bComy',width:80,align:'right'">出版社</th>
				<th data-options="field:'bComData',width:240">出版日期</th>
				<th data-options="field:'beg',width:60,align:'center'">备注</th>
			</tr>
		</thead>
	</table>
	
	<script type="text/javascript">
		var editIndex;
		var url;
	
		var toolbar = [{
			text:'添加',
			iconCls:'icon-add',
			handler:function(){
				$('#fm1').form('clear');
				$("#dlg").dialog('open').dialog("setTitle","添加图书信息");
				$("#btn-ok").attr("onclick","addBook()");
		
			}
		},{
		text:'编辑',
			iconCls:'icon-edit',
			handler:function(){
			//编辑
			var row=$("#dd").datagrid("getSelected");
				if(row){
					$('#dlg').dialog('open').dialog("setTitle",'编辑图书信息');
					$('#fm1').form('load',row);
					url=ctx+"/fmajax/bookAJAX_edit?bid="+row.bid+"&book.bid="+row.bid;	
				}
			}
			
		},{
		    text:'删除',
			iconCls:'icon-remove',
			handler:function(){
			//删除
			var ss=[];
			var rows=$("#dd").datagrid("getSelections");
			
		
			for(var i=0;i<rows.length;i++){
				var row=rows[i];
				ss.push(row.bid);
			}
			alert(ss);
			
			$.getJSON(ctx+"/fmajax/bookAJAX_delete?bookIds="+ss,function(data){
				 if(data==null||data==""){
				   
				 	$.messager.alert("operator Info","删除成功");
				 	$("#dd").datagrid("reload");
				 }else{
				 	$.messager.alert("Operator Info","以下编号的图书删除失败："+data);
				 }
			});
				
			}
		},'-',{
			text:'保存',
			iconCls:'icon-save',
			handler:function(){alert('save')}
		}];
	
		/*保存编辑*/
		function saveBook(){
			$("#fm1").form("submit",{
				url:url,
				onSubmit:function(){
				  return $(this).form('validate');
				},
				success:function(data){
					var data=eval("("+data+")");
					var ok=data.result;
					if(ok){
						$.messager.alert("操作提示","修改成功");
						$('#dlg').dialog('close');
						$("#dd").datagrid("reload");
					}else{
						$.messager.alert("操作提示","修改失败");
					}
				}
			});
		}
		
		
		/*添加图书信息*/
		function addBook(){
			$("#fm1").form("submit",{
				url:ctx+"/fmajax/bookAJAX_add?"+$("#fm1").serialize(),
				onSubmit:function(){
				
			
				  return $(this).form('validate');
				  
				},
				success:function(data){
					var data=eval("("+data+")");
					var ok=data.result;
					if(ok){
						$.messager.alert("操作提示","成功");
						$('#dlg').dialog('close');
						$("#dd").datagrid("reload");
					}else{
						$.messager.alert("操作提示","失败");
					}
			}
			
			});
		}
	</script>
		
		<div id="dlg" class="easyui-dialog" style="width:400px;" closed="true" buttons="#dlg-buttons">
			<form id="fm1" method="post" novalidate>
				<div class="fitem">
					<label>书名：</label>
					<input name="bname" class="easyui-validatebox" required="true">
					
				</div>
				<div class="fitem">
					<label>图书类别：</label>
					<select name="bTypeId" class="easyui-combobox"  style="width:130px" required="true">
						<option value="1">1</option>
					    <option value="2">2</option>
					</select>
				</div>
				<div class="fitem">
					<label>出版社：</label>
					<select name="bComy" class="easyui-combobox"  style="width:130px"  required="true">
					<option value="1">1</option>
					<option value="2">2</option>
					</select>
					
				</div>
				<div class="fitem">
					<label>出版日期：</label>
					<input name="bComData" class="easyui-datebox" required="true">
					
				</div>
				<div class="fitem">
					<label>备注：</label>
					<input name="beg" class="easyui-validatebox" required="true">
					
				</div>
			</form>
		
		</div>
		<div id="dlg-buttons">
			<a href="javascript:void(0)" id="btn-ok" class="easyui-linkbutton" iconCls="icon-ok" onclick="saveBook()">保存</a>
			<a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-canel" onclick="javascript:$('#dlg').dialog('close');"/>取消</a>
		</div>
	
	
	</body>
</html>