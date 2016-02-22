<%@ page pageEncoding="Windows-31J"
	import="java.util.*,bean.*"
	contentType="text/html;charset=Windows-31J"
%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<html>
<head>
	<title>スレッド一覧</title>
	<link href="css/style2.css" rel="stylesheet" type="text/css" />
</head>
<body>
	
	<a href="index.html"><img src="img/zhuti.png"></a>
	
	<style type="text/css">
	#biaoge{
		margin:6px;
	padding:2px;
		text-align:center;
	}

	#biaoge table{
		margin:0px auto;
	}
	</style>
	
	<div class="text" style=" text-align:center;">

	<hr>
	
	<h1>スレッド一覧</h1>
	
	<c:if test="${ fn:length(al) < 100}" >
		&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp
		&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp
		&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp
		&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp
		&nbsp&nbsp&nbsp&nbsp&nbsp
		
		<a href="threadnew"><img src="img/button1.png" alt="スレッド作成コーナーへ" ></a>
	</c:if>
	<c:if test="${ fn:length(al) >= 100 }" >
		スレッド数が上限を超えました。<a href="showthread?thread=11">管理者</a>へ報告してください。
	</c:if>
	
	</div>
	<div id="biaoge">
	

	<table border="1" cellpadding="0" cellspacing="0"  background="img/tablehaike.jpg">
		<tr> <th>タイトル</th> <th>カテゴリ</th> <th>レス数</th> </tr>
		<c:forEach var="tb" items="${al}">
			<tr>
				<td> <a href="/testbb/showthread?thread=${tb.threadNo}"> <c:out value="${tb.title}" /> </a> </td>
				<td> <c:out value="${tb.category}" /> </td>
				<td> <c:out value="${tb.contentsCount}" /> </td>
			</tr>
		</c:forEach>
	</table>
	<br>
		&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp
		&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp
		&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp
		&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp
		&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp
		&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp
		&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp
		&nbsp&nbsp&nbsp&nbsp
		
		<input type="button" onclick="location.href='LoginTest.html' "value='管理者ログインページへ'>
		
	<br><br>

	</div>

</body>
</html>