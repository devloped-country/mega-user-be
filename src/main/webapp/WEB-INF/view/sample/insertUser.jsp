<%@ page contentType="text/html; charset=UTF-8"%>

<%@ include file="/WEB-INF/layout/header.jsp" %>

<center>
<h1>회원 입력</h1>
<hr>
<form action="insertUser.do" method="post">
<table border="1" cellpadding="0" cellspacing="0">
<tr>
	<td bgcolor="orange" width="90">아이디</td>
	<td><input type="text" name="id" size="12"/></td>
</tr>
<tr>
	<td bgcolor="orange">비밀번호</td>
	<td><input type="password" name="password" size="12"/></td>
</tr>
<tr>
	<td bgcolor="orange">이름</td>
	<td><input type="text" name="name" size="30"/></td>
</tr>
<tr>
	<td bgcolor="orange">권한</td>
	<td>
		<input type="radio" name="role" value="USER" checked/>USER 
		<input type="radio" name="role" value="ADMIN"/>ADMIN
	</td>
</tr>
<tr>
	<td colspan="2" align="center">
		<input type="submit" value="회원가입"/>
		<input type="reset" value="가입취소"/>
	</td>
</tr>
</table>
</form>
</center>

<%@ include file="/WEB-INF/layout/footer.jsp" %>

