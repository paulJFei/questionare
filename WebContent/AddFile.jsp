<!-- 罗昕添加用户界面 -->
<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8" isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>添加用户</title>
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
			<form action="http://localhost:8080/Questionare/AddServlet"
				method="post">
				<table>
					<tr>
						<td>用户名：</td>
						<td><input type="text" name="account" class="add_input" /></td>
					</tr>
					<tr>
						<td>用户密码：</td>
						<td><input type="password" name="password1" class="add_input"/></td>
					</tr>
					<tr>
						<td>确认密码：</td>
						<td><input type="password" name="password2" class="add_input"/></td>
					</tr>
				</table>
				<input type="submit" value="注册">
			</form>
		</div>
	</div>
</body>
</html>