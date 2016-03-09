<%@ page pageEncoding="Windows-31J"
	contentType="text/html;charset=Windows-31J" %>

<html>
<head><title>管理者ページ</title></head>
<body>
	<h1>管理者用パスワードを入力してください</h1>
	<form method='post' action='deleteresult'>
	管理者パス<input type='text' name='admin_key'>
	<input type='submit' value='ログイン'>
	</form>
	<p>${result}</p>
	<a href="index">掲示板に戻る</a>
</body>
</html>
