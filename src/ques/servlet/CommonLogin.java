package ques.servlet;
//钟鑫
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CommonLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//		登录
		String account = request.getParameter("Lname");
		String psw = request.getParameter("Lpassword");
		System.out.printf(account+"\t"+psw);
		request.setAttribute("account", account);
			try {
				//连接数据库
				Class.forName("com.mysql.cj.jdbc.Driver");
				String url = "jdbc:mysql://localhost:3306/questionare?useUnicode=true&characterEncoding=utf8&serverTimezone=UTC&useSSL=false";
				Connection con = DriverManager.getConnection(url,"root","root111222");
				
				//	确认用户名密码是否正确
				PrintWriter write = response.getWriter();
				response.setCharacterEncoding("utf-8");
					String sql1 = "select * from user where account='"+account+"'and password ='"+psw+"'";
					PreparedStatement pre1= con.prepareStatement(sql1);
					ResultSet res1 =pre1.executeQuery();
					if(res1.next()){
						System.out.println("登录成功");
						request.setAttribute("password", true);		//密码正确标识符
						request.setAttribute("account", account);
						
						write.write("ok");	
					}
					else{
						//	密码错误
						request.setAttribute("password", false);	//密码错误标识符
						write.write("false");

					}
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}
}
			

		
	