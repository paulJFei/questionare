package ques.servlet;

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

public class MloginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//		登录
		String account_m = request.getParameter("Mname");
		String psw_m = request.getParameter("Mpassword");
		System.out.printf(account_m+"\t"+psw_m);
		request.setAttribute("account", account_m);
			try {
				//连接数据库
				Class.forName("com.mysql.cj.jdbc.Driver");
				String url = "jdbc:mysql://localhost:3306/questionare?useUnicode=true&characterEncoding=utf8&serverTimezone=UTC&useSSL=false";
				Connection con = DriverManager.getConnection(url,"root","root111222");
				
				//	确认用户名密码是否正确

					String sql1 = "select * from admin where account_m='"+account_m+"'and password_m ='"+psw_m+"'";
					PreparedStatement pre1= con.prepareStatement(sql1);
					ResultSet res1 =pre1.executeQuery();
					if(res1.next()){
						System.out.println("登录成功");
						request.setAttribute("password", true);		//密码正确标识符
						request.setAttribute("account", account_m);
						PrintWriter write = response.getWriter();
						write.write("ok");	
					}
					else{
						//	密码错误
						request.setAttribute("password", false);	//密码错误标识符
						
						
						
/*						RequestDispatcher dis = request.getRequestDispatcher("#");	//错误跳转页面
						dis.forward(request, response);*/
					}
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}

}
