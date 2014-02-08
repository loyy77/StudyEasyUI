<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<html>
<head>
<title>登录</title>
</head>
<body>
   <s:text name="Missing.message"/>
	<form action="logintest">
	<s:text name="username"></s:text><input type="text" name="username"/>
	<s:text name="password"></s:text><input type="password" name="password"/>
	<input type="submit" value="提交"/>
	</form>
</body>
</html>
