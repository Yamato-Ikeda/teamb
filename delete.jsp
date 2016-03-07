<%@ page pageEncoding="Windows-31J"
	contentType="text/html;charset=Windows-31J" %>

<html>
<head><title>削除ページ</title></head>
<body>
	<h1>投稿番号と削除用パスワードを入力してください</h1>
	<form method='post' action='deleteresult'>
	投稿番号<input type='text' name='post_number'>
	削除用パス<input type='text' name='delete_key'>
	<input type='submit' value='登録'>
	</form>
	<p>${result}</p>
	<a href="index">掲示板に戻る</a>
</body>
</html>