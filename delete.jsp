<%@ page pageEncoding="Windows-31J"
	contentType="text/html;charset=Windows-31J" %>

<html>
<head>
	<title>削除ページ</title>
	<link rel="stylesheet" href="css/index.css">
</head>
<body>
	<p>投稿番号と削除用パスワードを入力してください</p>
	<form method='post' action='deleteresult'>
	投稿番号<input required type='text' name='post_number'>
	削除用パス<input type='text' name='delete_key'>
	<input type='submit' value='削除'>
	</form>
	<p>${result}</p>
	<a href="index">掲示板に戻る</a>
</body>
</html>