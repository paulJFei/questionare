<!--蒲建飞  -->
<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page isELIgnored="false"%>
<!-- 2.4版本默认启用el表达式，如果使用2.5版本，默认el表达式是关闭的 -->
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="css/css.css"/>   
<style type="text/css">
a {
	text-decoration: none
}

.menu_sub {
	background: #5b9bd4;
	color: white;
	height: 30px;
	width: 70px;
	border-radius: 7px;
}
</style>
</head>
<body>
	<div id="global">

		<div id="heading">
			<font size="30" color="white"> 问卷调查系统</font>
			<p valign="top" align="right">
				<font size="3" color="white">欢迎您，管理员[<a
					href="http://localhost:8080/Questionare/Login.html">退出</a>]
				</font>
			</p>
		</div>

		<div id="content_menu">
			<p>菜单管理</p>
			<a href="http://localhost:8080/Questionare/ManagerServlet"><input
				class="menu_sub" type="submit" value="用户管理"></a> <a
				href="http://localhost:8080/Questionare/QueManagerServlet"><input
				class="menu_sub" type="submit" value="问卷管理"></a>
		</div>
		<p>
			<strong>关于用户：${account }的答题情况</strong>
		</p>
		<table>
			<tr>
				<td>题目编号</td>
				<td>选项</td>
			</tr>
			<c:forEach var="choose" items="${list}">
				<tr>
					<td>${choose.id}</td>
					<td>${choose.option}</td>
				</tr>
			</c:forEach>
		</table>
	</div>
</body>
</html>