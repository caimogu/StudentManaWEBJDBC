<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!-- 标签库，需要导入jar包，standard-1.1.2.jar 还需要jstl-1.2.jar-->
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>   

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>显示学生列表页面</title>
</head>
<body>

<table width="600" border="1">
<tr>
	<th>学生编号</th>
	<th>学号姓名</th>
	<th>学生成绩</th>
	<th>操作</th>
</tr>
<c:forEach items="${studentList}" var="s">
	<tr>
		<td>${s.id}</td>
		<td>${s.name}</td>
		<td>${s.score}</td>
		<td><a href="student.do?a=del&id=${s.id}">删除</a>
			<a href="student.do?a=modify&id=${s.id}">修改</a>
		</td>
	</tr>
</c:forEach>
</table>

<a href="javascript:history.go(-1);">返回</a>

</body>
</html>