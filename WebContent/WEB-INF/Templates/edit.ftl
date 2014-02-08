<html>
	<head><title>编辑图书</title></head>
	<body>
	
		编辑：<br/>
	<form action="${request.getContextPath()}/fm/book_edit">
	编号：${book.bid}<br/>
	书名：<input type="text" name="book.bname" value="${book.bname}"/><br/>
	类型：<input type="text" name="book.bTypeId" value="${book.bTypeId}"/><br/>
	出版社：<input type="text" name="book.bComy" value="${book.bComy}"/><br/>
	出版日期：<input type="text" name="book.bComData" value=""/><#--${book.bComData}--><br/>
	备注：<input type="text" name="book.beg" value="${book.beg}"/><br/>
	
	</form>
	<input type="submit" value="提交更新"/>
	</body>
</html>