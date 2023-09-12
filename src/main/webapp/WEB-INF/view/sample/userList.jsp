<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ include file="/WEB-INF/layout/header.jsp" %>

<center>

<table border="1" cellpadding="0" cellspacing="0" width="700">
<tr>
	<th bgcolor="orange" width="100">아이디</th>
	<th bgcolor="orange" width="200">비밀번호</th>
	<th bgcolor="orange" width="150">이름</th>
	<th bgcolor="orange" width="150">권한</th>
</tr>

<c:forEach var="user" items="${userList}">
<tr>
	<td>${user.id}</td>
	<td>${user.password }</td>
	<td>${user.name }</td>
	<td>${user.role }</td>
</tr>
</c:forEach>

</table>

<a href="insertUserForm.do">회원등록</a>&nbsp;&nbsp;&nbsp;

</center>

<%@ include file="/WEB-INF/layout/footer.jsp" %>
