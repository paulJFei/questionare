<!-- 罗昕问卷管理界面 -->
<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8" isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>

<%@page import="java.sql.Connection"%>
<%@page import="java.sql.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>问卷管理界面</title>
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
			<DIV>
				<form action="http://localhost:8080/Questionare/QueQueryoneServlet"
					method="post">
					问题ID： <input name="id" class="add_input"> <input type="submit" value="查询">
					<a href="http://localhost:8080/Questionare/QuestionAddFile.jsp"
						style="text-decoration: none">新增</a>
				</form>
				<table border="1" cellpadding="10" frame="void" width="700px">
					<thead>
						<tr>
							<th align="center" style="border: none">问题ID</th>
							<th align="center" style="border: none">问题内容</th>
							<th align="center" style="border: none">问题选项</th>
							<th align="center" style="border: none">操作</th>
						</tr>
						<c:forEach var="Question" items="${lis}">
							<tr>
								<td align="center">${Question.id}</td>
								<td align="center">${Question.content}</td>
								<td><c:forEach var="answer" items="${Question.list}">
									${answer.que_id}:${answer.context}<br>
										<%-- 	<%
									String url = "jdbc:mysql://localhost:3306/questionare?useUnicode=true&characterEncoding=utf8&serverTimezone=UTC&useSSL=false";
									Class.forName("com.mysql.cj.jdbc.Driver");// 驱动加载
									Connection con = DriverManager.getConnection(url, "root", "root111222");// 连接到数据库
									String sql_1="SELECT count(*) FROM `answer_user` a WHERE a.option =${answer.context} and id=${answer.que_id}";
									PreparedStatement pre_1 = con.prepareStatement(sql_1);
									ResultSet rs_1 = pre_1.executeQuery();
									float i = 0;
									while(rs_1.next()) {
										 i=rs_1.getInt(1);											 
									}	
									%>
									<p><%=i%></p><br> --%>
									</c:forEach></td>
								<td align="center"><a
									href="http://localhost:8080/Questionare/QuestionEditFile.jsp?id=${Question.id}">编辑</a></td>
								<td align="center"><a
									href="http://localhost:8080/Questionare/QuestiondeleteServlet?id=${Question.id}">删除</a></td>
							</tr>
						</c:forEach>
					</thead>
				</table>
			</DIV>
		</div>
	</div>
</body>
</html>