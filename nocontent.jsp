<%@ page pageEncoding="Windows-31J"
	isErrorPage="true"
	contentType="text/html;charset=Windows-31J" %>

<html>
<head><title>入力内容不適合</title></head>
<body>
	<h1>例外のメッセージ：${pageContext.exception.massage}</h1>
	<h1>例外のタイプ：${pageContext.exception.class.name}</h1>
	
	<a href="input.jsp">入力内容が不適切です。入力し直してください。</a>
</body>
</html>