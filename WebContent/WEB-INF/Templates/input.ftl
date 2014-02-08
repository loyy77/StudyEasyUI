<html>
<head><title>登录</title>
<#include "common/easyui_import.ftl">

<script type="text/javascript">
$(function(){

	$('#w').window('open');
});
</script>

<style type="text/stylesheet" >
*{
	font-size:12px;
}
body {
    font-family:helvetica,tahoma,verdana,sans-serif;
    padding:20px;
    font-size:13px;
    margin:0;
}
h2 {
    font-size:18px;
    font-weight:bold;
    margin:0;
    margin-bottom:15px;
}
.demo-info{
	background:#FFFEE6;
	color:#8F5700;
	padding:12px;
}
.demo-tip{
	width:16px;
	height:16px;
	margin-right:8px;
	float:left;
}
</style>
<!--居中-->
<script>
	$(function(){
	
	var agent=navigator.userAgent.toLowerCase();
	//alert(agent);
	var webkit=/webkit/.test(agent);
	if(webkit||/chrome/.test(agent)||(/mozilla/.test(agent)&&/firefox/.test(agent))){
	
	
	
	
	//获取model window的宽度
	
	var width=$("#w").width();
	var ffWidth=$("#tab1").width();
	var margin=width/2-ffWidth/2;
	    $("#tab1").css("margin-left",margin);
	};
	
	$("input[type='text']").width(150);
	$("input[type='password']").width(150);
	
	
	if($.browser.mozilla){
		$(".panel").css("top",137);
		$(".window-shadow").css("top",137);
		/*$(".window-mask").css("top",200);*/
	}
	});



    function onResize(){
        alert("ss");
        var width=$("#w").width();
        var ffWidth=$("#tab1").width();
        var margin=width/2-ffWidth/2;
        $("#tab1").css("margin-left",margin);
    };
</script>
	</head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<body>
<#--
	<h2>登录</h2>
	    登录次数：
				${count!"0"}
		-->


	
	<div id="w" class="easyui-window" title="用户登录" data-options="modal:true,closed:false,collapsible:false,minimizable:false,maximizable:false,closable:false,onResize:function(){}" style="width:500px;height:300px;padding:0px;">
	<form id="ff" action="${request.getContextPath()}/fm/login" method="post">
      <div id="continer" style="margin-left:auto;margin-right:auto;width:460px;">
      <div id="tt" style="text-align:center;margin-top:40px;margin-left:auto;margin-right:auto;width:460px">
        <table id="tab1">
            <tr style="line-height:30px"><td style="text-align:right;"><@s.text name="form.label.username"/></td><td><input class="easyui-validatebox" type="text" name="username" data-options="required:true"/></td></tr>
            <tr style="line-heigth:30px"><td style="text-align:right;"><@s.text name="form.label.password"/></td><td><input class="easyui-validatebox" type="password" name="password" data-options="required:true"/></td></tr>
        </table>
	  </div>
	
	<div id="" style="text-align:center;padding:5px">
	<a href="javascript:void(0)" class="easyui-linkbutton" onclick="submitForm()">提交</a>
	<a href="javascript:void(0)" class="easyui-linkbutton" onclick="clearForm()">清除</a>
    </div>
	</div>
    </form>

	</div>
	
	<script>
		function submitForm(){
		
			$('#ff').form("submit",{
				url:'${request.getContextPath()}/fm/login',
				onSubmit:function(){},
				success:function(data){
				 $("body").html(data);
				}
			});
		
			
			
		}
		function clearForm(){
			$('#ff').form('clear');
		}
	</script>
</body>
</html>
