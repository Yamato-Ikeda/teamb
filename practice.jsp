<%@ page pageEncoding="Windows-31J"
	contentType="text/html;charset=Windows-31J" %>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
<link rel="stylesheet" href="css/index.css">
<title>�f�����K</title>
</head>
<body>
	<h1>�f�����K</h1>
	
	<%
	int pageNo = 1;
	String SPageNo = request.getParameter("thread");
	if(SPageNo != null){
		pageNo = Integer.parseInt(SPageNo);
	}
	request.setAttribute("APageNo",pageNo);
	%>
	<!-- �u���̃y�[�W�ցv�u�O�̃y�[�W�ցv�̃����N�̐���Ɏg���B
	int�ϐ���pageNo�́Aa�^�O����thread�p�����[�^�̒l�̎w��Ɏg���B
		thread�̃p�����[�^�����M����Ă��Ȃ��Ȃ�A1�ɂ���B
	�A�g���r���[�g��APageNo�́Ac:if�̏����i�u�O�̃y�[�W�ցv��\�����邩�j�Ŏg�p����B	
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
								���O
								<input name="user_name" size="18" value="" maxlength="25"> 
							</td>
							<td align="left" nowrap="">
								Email 
								<input name="email_address" size="22" value="" style="ime-mode:disabled" maxlength="50">
							</td>
						</tr>
						<tr>
							<td align="right" nowrap="">
								�폜�p�p�X���[�h
								<input name="delete_key" value="" style="ime-mode:disabled" maxlength="5">
							</td>
							<td align="left" nowrap="">
								<p>
									�摜�@<input type="file" name="image" size="50">
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
								<font size="2">���}���̕��������͂��Ă��������B</font>
							</td>
							�F�ؖ�����-->
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
								<font color="red">��</font>���b�Z�[�W(�^�O�g�p�s��)
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
								<input type="submit" value=" �� �M ">
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
		<a href ="index?thread=<%=pageNo-1%>">�O�̃y�[�W��</a>
	</c:if>
	<a href ="index?thread=<%=pageNo+1%>">���̃y�[�W��</a>
	<div align="right"><a href="delete">�R�����g�̍폜</a></div>
	
	<hr>
	<table class="t" width="50%" border="1">
		<c:forEach var="cb" items="${al}">
		<tr>
			<c:if test="${!cb.delete_flag}" >
			
				<td><c:out value="${cb.post_number}"/></td>
				<td><c:out value="${cb.user_name}"/></td>
				<td><c:out value="${cb.date}"/></td></tr><tr>
				<td width="200"><pre><c:out value="${cb.message}"/></pre></td></tr><tr>
				<c:if test="${!empty cb.image && cb.image != 'null'}" >
				<td><a href="images/${cb.image}" target="_blank"><img src="images/small/${cb.image}" alt="�摜" title="���e���ꂽ�摜"></a></td>
				</c:if>
			</c:if>
		</tr>
		</c:forEach>
	</table>
	<hr>
	<c:if test="${APageNo > 1}" >
		<a href ="index?thread=<%=pageNo-1%>">�O�̃y�[�W��</a>
	</c:if>
	<a href ="index?thread=<%=pageNo+1%>">���̃y�[�W��</a>
</body>
</html>