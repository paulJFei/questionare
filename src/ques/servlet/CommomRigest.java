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

public class CommomRigest extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String account = request.getParameter("Rname");
		String psw = request.getParameter("Rpassword");
		//检测数据
		System.out.printf(account+"\t"+psw);
			
		try {	
			//连接数据库
			Class.forName("com.mysql.cj.jdbc.Driver");
			String url = "jdbc:mysql://localhost:3306/questionare?useUnicode=true&characterEncoding=utf8&serverTimezone=UTC&useSSL=false";
			Connection con = DriverManager.getConnection(url,"root","root111222");
			
			//		检测用户名是否重复
			String sql="select * from user where account ='"+account+"'";
			PreparedStatement pre = con.prepareStatement(sql);
			ResultSet res = pre.executeQuery();
			System.out.println("get");
			if(res.next()){
				System.out.println("用户名已被使用");
			}
			else{
				//		用户名未被使用,可注册
				String sql1= "insert into user values(?,?)";
				PreparedStatement pre1 = con.prepareStatement(sql1);		
				pre1.setString(1, account);
				pre1.setString(2, psw);
				pre1.execute();
				
				//注册完毕
				System.err.println("注册完毕");
				request.setAttribute("regist", true);
				PrintWriter write = response.getWriter();
				write.write("ok");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
