package ques.servlet;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class SelectServlet
 */
public class SelectServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");// 网页到程序的数据传输格式
		response.setContentType("text/html;charset=utf-8");// 程序到网页的文本传输格式
		String account = request.getParameter("account");
		Question ques=null;
		Option option=null;
		List<Question> list=new ArrayList<Question>();
		
		try {	
			String sql="select *  from question_id ";
			ResultSet rs=TestConnection.selectDB(sql);
			while(rs.next()) {
				List<Option> list_o=new ArrayList<Option>();
				String id =rs.getString(1);
				String content=rs.getString(2);
				//System.out.println(id);
				//System.out.println(content);
				ResultSet rs_num=TestConnection.selectById(id);
				while(rs_num.next()) {
					String queId=rs_num.getString(2);
					String option1=rs_num.getString(3);
					option=new Option(id, queId, option1);
					list_o.add(option);	
				}
				//System.out.println(list_o);
				ques=new Question(id,content, list_o);
				list.add(ques);
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		request.setAttribute("account", account);
		request.setAttribute("list", list);
		//转发请求
		RequestDispatcher rdis=request.getRequestDispatcher("user.jsp");
		rdis.forward(request, response);
	}

}
