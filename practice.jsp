<%@ page pageEncoding="Windows-31J"
	contentType="text/html;charset=Windows-31J" %>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
<link rel="stylesheet" href="css/index.css">
<title>掲示板練習</title>
</head>
<body>
	<h1>掲示板練習</h1>
	
	<%
	int pageNo = 1;
	String SPageNo = request.getParameter("thread");
	if(SPageNo != null){
		pageNo = Integer.parseInt(SPageNo);
	}
	request.setAttribute("APageNo",pageNo);
	%>
	<!-- 「次のページへ」「前のページへ」のリンクの制御に使う。
	int変数のpageNoは、aタグ内のthreadパラメータの値の指定に使う。
		threadのパラメータが送信されていないなら、1にする。
	アトリビュートのAPageNoは、c:ifの条件（「前のページへ」を表示するか）で使用する。	
	-->
	
<table border="0" cellpadding="0" cellspacing="0">
	
	<tbody>
	
		<form action="writecontents" method="Post" enctype="multipart/form-data"><!--  enctype="multipart/form-data" -->
		
		<tr>
			<td valign="top">
				<input type="hidden" name="MAX_FILE_SIZE" value="1048576">
				<input type="hidden" name="f" value="1">
				<br>
				<table border="0" cellpadding="4" cellspacing="0">
					<tbody>
						<tr>
							<td align="right" nowrap="">
								名前
								<input name="user_name" size="18" value="" maxlength="25"> 
							</td>
							<td align="left" nowrap="">
								Email 
								<input name="email_address" size="22" value="" style="ime-mode:disabled" maxlength="50">
							</td>
						</tr>
						<tr>
							<td align="right" nowrap="">
								削除用パスワード
								<input name="delete_key" value="" style="ime-mode:disabled" maxlength="5">
							</td>
							<td align="left" nowrap="">
								<p>
									画像　<input type="file" name="image" size="50">
								</p>
							</td>
						</tr>
						<tr>
							<!--
							<td align="right" nowrap="" valign="top">
								<img src="/captcha.php?PHPSESSID=2b46f06d623a8716298293029c227d15">
							</td>
							<td>
								<input type="text" maxlength="10" name="keystring">
								<br>
								<font size="2">左図中の文字列を入力してください。</font>
							</td>
							認証未実装-->
						</tr>
					</tbody>
				</table>
			</td>
		</tr>
		<tr>
			<td align="center">
				<table border="0" cellpadding="5" cellspacing="0">
					<tbody>
						<tr>
							<td valign="middle">
								<font color="red">※</font>メッセージ(タグ使用不可)
								<br>
								<textarea required name="message" cols="60" rows="6" maxlength="500"></textarea>
							</td>
						</tr>
					</tbody>
				</table>
			</td>
		</tr>
		<tr>
			<td colspan="2">
				<table border="0" cellpadding="5" cellspacing="0" width="100%">
					<tbody>
						<tr>
							<td align="right">
								<input type="submit" value=" 送 信 ">
							</td>
						</tr>
					</tbody>
				</table>
			</td>
		</tr>
		
		</form>
		
	</tbody>
	
</table>
	<c:if test="${APageNo > 1}" >
		<a href ="index?thread=<%=pageNo-1%>">前のページへ</a>
	</c:if>
	<a href ="index?thread=<%=pageNo+1%>">次のページへ</a>
	<div align="right"><a href="delete">コメントの削除</a></div>
	
	<hr>
	
	<c:forEach var="cb" items="${al}">
		<table class="t" width="50%" border="0">
			<tr>
				<c:if test="${!cb.delete_flag}" >
				
					<td><c:out value="${cb.post_number}"/></td>
					<td><c:out value="${cb.user_name}"/></td>
					<td><c:out value="${cb.date}"/></td></tr><tr>
					<td colspan="3" width="600"><c:out value="${cb.message}"/></td></tr><tr>
						<c:if test="${!empty cb.image && cb.image != 'null'}" >
							<td colspan="3"><a href="images/${cb.image}" target="_blank"><img src="images/small/${cb.image}" alt="画像" title="投稿された画像"></a></td>
						</c:if>
				</c:if>
			</tr>
		
		</table>
			<br><br>
	</c:forEach>
	
	<hr>
	<c:if test="${APageNo > 1}" >
		<a href ="index?thread=<%=pageNo-1%>">前のページへ</a>
	</c:if>
	<a href ="index?thread=<%=pageNo+1%>">次のページへ</a>
</body>
</html>