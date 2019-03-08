<!-- 罗昕 问题添加 -->
<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8" isELIgnored="false"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>问题添加</title>
<link rel="stylesheet" type="text/css" href="css/css.css" />
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
		<div id="content_body" style="color: #7f7e7f">
			<form action="http://localhost:8080/Questionare/QueAddServlet"
				method="post">
				<table>
					<tr>
						<td>ID   ： </td>
						<td><input name="id" class="add_input"/></td>
					</tr>
					<tr>
						<td>问题  ：</td>
						<td><input name="content" class="add_input"/></td>
					</tr>
					<tr>
						<td>选项A：</td>
						<td><input name="context1" class="add_input"/></td>
					</tr>
					<tr>
						<td>选项B：</td>
						<td><input name="context2" class="add_input"/></td>
					</tr>
					<tr>
						<td>选项C：</td>
						<td><input name="context3" class="add_input"/></td>
					</tr>
					<tr>
						<td>选项D：</td>
						<td><input name="context4" class="add_input"/></td>
					</tr>
				</table>
				<input type="submit" value="添加">
			</form>
		</div>
	</div>
</body>
</html>