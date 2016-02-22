<%@ page pageEncoding="Windows-31J"
	import="java.util.*,bean.*"
	contentType="text/html;charset=Windows-31J"
%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
	<title>＜管理者＞スレッド選択</title>
	<link href="css/font.css" rel="stylesheet" type="text/css" />
		<a href="index.html"><img src="img/zhuti.png"></a>

</head>
<body>
	<br>
	<div class="text" style=" text-align:center;">

	<h1> 管理者画面 </h1>
	<a href="/testbb">トップ＞</a>
	<a href="/testbb/selectthread">スレッド選択＞</a>
	<hr>

	<div class="table" style=" align:center;">
	<h2>スレッド一覧</h2>
	<p>※ラジオボタンで削除するスレッドを選択して削除ボタンを押してください</p>
	<table border="1" cellpadding="0" cellspacing="0"  background="img/tablehaike.jpg" align="center">
	<tr><th>スレ番号</th> <th>タイトル</th> <th>カテゴリ</th> <th>レス数</th> </tr>
	
	<form method="Post" action="ThDeleteSer">
		
		<c:forEach var="tb" items="${al}">
			<tr>
	            	<td>	<input type="radio" name="threNo" value="${tb.threadNo}"> <c:out value="${tb.threadNo}"/></tb>
				<td> <a href="/testbb/showadminthread?thread=${tb.threadNo}"> <c:out value="${tb.title}" /> </a> </td>
				<td> <c:out value="${tb.category}" /> </td>
				<td> <c:out value="${tb.contentsCount}" /> </td>
			</tr>
		</c:forEach>
		
		</div>
		</table>
	<br>
	<hr>
	<p style="color:red">※削除は取り消せません。よく確認の上削除してください。</p>
	<input type="submit" value="削除">
	</form>
	</div>
	
	
</body>
</html>