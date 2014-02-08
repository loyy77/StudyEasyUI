<html>
<head><title>hello fm</title></head>

<body>hello,${username}<#if username="lsx">上帝你好</#if></body>
<ul style="display-style:none;">
<li><a href="${request.getContextPath()}/fm/book_toAdd" onclick="">添加</a></li>
<li><a href="${request.getContextPath()}/fm/book_list" onclick="">列表</a></li>
<br/>
${book}
${book.author.name}<br/>
${book.author.info}<br/>
${book.title}<br/>
<#assign ages={"Joe":232,"as":"sss"}+{"java":1.6,"c#":'ss'}>
${ages.Joe}

<#if (2 lt 3)>
22
</#if>
<#if (3 gt 2)>
33
</#if>
<#if (3 >2)>
333
</#if>
<br/>${r"<=&sadas>"?html}
<br/>${"asdafsd"?cap_first}
<br/>${"asdafsd"?upper_case}
<br/>${"AAAAdafsd"?lower_case}
<br/>${"     sss    s    "?trim}
<br/>${["hello","world"]?size}
</ul>


</html>
