<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="first" method="post">
		<input type="text" name="username">
		<button>点我发送数据</button>
	</form>
	<hr/>
	<c:forEach items="${xx }" var="us">
		${us.id }
		${us.username }
		${us.birthday }
		
	</c:forEach>
</body>
</html>