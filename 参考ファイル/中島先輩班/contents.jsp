<%@ page pageEncoding="Windows-31J"
	import="java.util.*,bean.*"
	contentType="text/html;charset=Windows-31J"%>
	
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
	<title>${tb.title}</title>
	<link href="css/style2.css" rel="stylesheet" type="text/css" />
</head>
<body>

	<div id="header">
	</div>

	
	<%
		ThreadBean tb = (ThreadBean)request.getAttribute("tb");
		ArrayList contentsList = tb.getContentsList();
		request.setAttribute("conList",contentsList); 
	%>
	
	<h1> ${tb.title} </h1>
	<h3>カテゴリ：${tb.category}</h3>
	<a href="/testbb">トップ＞</a>
	<a href="/testbb/selectthread">スレッド選択＞</a>
	<a href="#footer">ページの一番下へ↓</a>
	
	<hr>
	<c:forEach var="cb" items="${conList}">
		<c:out value="${cb.contentNo}"/>:
		<c:out value="${cb.name}" />
		<c:out value="${cb.date}"/><br>
		<pre><c:out value="${cb.text}"/></pre> <br>
	</c:forEach>
	
	<hr><hr><br>
	
	<c:if test="${tb.contentsCount < 100}" >
		<form method='Post' action='writecontents'>
			名前:<input type='text' name='name' placeholder="名無し（全角15文字まで）"><br>
			<textarea name='text' cols='50' rows='5' placeholder="全角2000文字まで"></textarea><br><br>
			<input type='submit' value='書き込み'>
			<input type="hidden" name="threadNo" value="${tb.threadNo}">
			<input type="hidden" name="contentNo" value="${tb.contentsCount+1}">
		</form>
	</c:if>
	
	<c:if test="${tb.contentsCount >= 100}" >
		投稿数が上限を超えたのでこのスレッドには投稿できません。。。
		<br>
	</c:if>
	
	
	<div id="footer">
		<a href="#header">ページの一番上へ↑</a>
	</div>

</body>
</html>