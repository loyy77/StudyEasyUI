<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>

<html>
<head>
    <title>欢迎</title>
    <link href="<s:url value="/css/examplecss"/>" rel="stylesheet"
          type="text/css"/>
          
          
</head>

<body>
<h3>欢迎登录-图书管理系统</h3>
<ul>
	<li><a href="<%=request.getContextPath() %>/fm/login_input">登录</a></li>
   
</ul>

</body>
</html>
