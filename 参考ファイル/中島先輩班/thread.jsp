<%@ page pageEncoding="Windows-31J"
	import="java.util.*,bean.*"
	contentType="text/html;charset=Windows-31J"%>
	

<html>
<head>
	<link href="css/style2.css" rel="stylesheet" type="text/css" />
	<title>スレッド作成</title>
</head>
<body>
		<a href="index.html"><img src="img/zhuti.png"></a>
		<div class="text" style=" text-align:center;">
		<h1>スレッド作成フォーム</h1>
		<a href="/testbb/">トップ＞</a>
		<a href="/testbb/selectthread">スレッド選択＞</a>
		<hr>
		<br>
		<form method='Post' action='newthread'>
		タイトル：<input type='text' name='title' placeholder="全角50文字まで">
		<select name='cat'>
		<option value="学校生活">学校生活</option>
		<option value="就職">就職</option>
		<option value="雑談">雑談</option>
		</select>
		<br>
		<br>
		名前:<input type='text' name='name' placeholder="名無し（全角15文字まで）"><br>
		<textarea name='text' cols='50' rows='5' placeholder="全角2000文字まで"></textarea><br><br>
		<input type='submit' value='スレッド作成'>
	</form>

</body>
</html>