<%@ page pageEncoding="Windows-31J"
	import="java.util.*,bean.*"
	contentType="text/html;charset=Windows-31J"%>
	
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
	<title>＜管理者＞${tb.title}</title>
	<link href="css/font.css" rel="stylesheet" type="text/css" />
</head>
<body>
	
	<%
		ThreadBean tb = (ThreadBean)request.getAttribute("tb");
		ArrayList contentsList = tb.getContentsList();
		request.setAttribute("conList",contentsList); 
	%>
	
	<h1>管理者画面</h1>
	<a href="/testbb">トップ＞</a>
	<a href="/testbb/selectthread">スレッド選択＞</a>

	<hr>
	<p>※ラジオボタンで削除したい投稿を選択して削除ボタンを押してください</p>
	<h2> ${tb.title} </h2>
	<h4>カテゴリ：${tb.category}</h4>

	
	<form method='Post' action='condelete'>
		<c:forEach var="cb" items="${conList}">
			<input type="radio" name="conNo" value="${cb.contentNo}"><c:out value="${cb.contentNo}"/>
			<c:out value="${cb.name}"/>
			<c:out value="${cb.date}"/><br>
			<pre><c:out value="${cb.text}"/></pre> <br>
		</c:forEach>
	
	<hr><hr>
	<input type="hidden" name="threadNo" value="${tb.threadNo}">
	<input type="submit" value="削除">
	</form>

</body>
</html>