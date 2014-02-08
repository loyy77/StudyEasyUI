<html>
	<head><title>添加图书</title>
	<#include "common/easyui_import.ftl">
	</head>
	<body>
	
		添加：<br/>
	<form action="${request.getContextPath()}/fm/book_add">
	
	书名：<input type="text" name="book.bname" value=""/><br/>
	类型：<input type="text" name="book.bTypeId" value=""/><br/>
	出版社：<input type="text" name="book.bComy" value=""/><br/>
	出版日期：<input type="text" name="book.bComData" value=""/><br/>
	备注：<input type="text" name="book.beg" value=""/><br/>
	
	<input type="submit" value="添加"/><input type="reset"/>
	</form>
	</body>
</html>