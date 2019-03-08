<!--罗昕  管理用户界面-->
<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8" isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
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
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>管理员界面</title>
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
			<DIV>
				<form action="http://localhost:8080/Questionare/QueryoneServlet"
					method="post">
					用户名名称： <input name="id" class="add_input"> <input type="submit" value="查询">
					<a href="http://localhost:8080/Questionare/AddFile.jsp"
						style="text-decoration: none">新增</a>
				</form>
				<table border="1" cellpadding="10" frame="void" width="500px">
					<thead>
						<tr>
							<th align="center" style="border: none">用户名</th>
							<th align="center" style="border: none">用户密码</th>
							<th align="center" style="border: none">操作</th>
						</tr>
						<c:forEach var="user" items="${lis}">
							<tr>
								<td>${user.account}</td>
								<td>${user.password}</td>
								<td><a
									href="http://localhost:8080/Questionare/EditFile.jsp?id=${user.account}">编辑</a>
								</td>
								<td><a
									href="http://localhost:8080/Questionare/DeleteUser?id=${user.account }">删除</a>
								</td>
							</tr>
						</c:forEach>
					</thead>
				</table>
			</DIV>
			<!-- 指定用户答题情况查询 -->
			<c:if test="${not empty account}">
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
							<td align="center">${choose.id}</td>
							<td align="center">${choose.option}</td>
						</tr>
					</c:forEach>
				</table>
			</c:if>
		</div>
	</div>
</body>
</html>