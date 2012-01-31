<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<html>
<head>
<fmt:setBundle basename="messages" />
<c:set var="t" value="true" />
<title><fmt:message key="title" /></title>
</head>
<body>
<form action="/demo/search" method=post>
<center>
<table cellpadding=4 cellspacing=2 border=0>
	<tr>
		<th width="45%">Description</th>
		<th width="55%">Detail</th>
	</tr>
	<tr>
		<td><fmt:message key="setup.name" /></td>
		<td><input type="text" name="name" value="${param['name']}"
			size=15 maxlength=20></td>
	</tr>
	<tr>
		<td><fmt:message key="setup.description" /></td>
		<td><input type="text" name="description"
			value="${param['description']}" size=15 maxlength=20></td>
	</tr>
</table>
</center>
<input type="submit" value="Submit"> 
<input type="reset" value="Reset" ></form>

<table class="borderAll">
	<tr>
		<th><fmt:message key="label.hero.name" /></th>
		<th><fmt:message key="label.hero.description" /></th>
		<th><fmt:message key="label.hero.play" /></th>
	</tr>
	<c:forEach var="hero" items="${searchlist}" varStatus="status">
		<tr class="${status.index%2==0?'even':'odd'}">
			<td class="nowrap">${hero.name}</td>
			<td class="nowrap">${hero.description}</td>
			<td class="nowrap">${hero.play}</td>
		</tr>
	</c:forEach>
</table>
</body>
</html>