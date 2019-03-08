package TRY;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ques.servlet.TestConnection;
import ques.servlet.UserOption;

/**
 * Servlet implementation class QueryoneServlet
 */
public class QueryoneServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		request.setCharacterEncoding("utf-8");// 网页到程序的数据传输格式
		response.setContentType("text/html;charset=utf-8");// 程序到网页的文本传输格式
		String account = request.getParameter("id");
		Queryuser query=new Queryuser();
		try {
			List<user> list=query.queryone(account);
			request.setAttribute("lis", list);
			request.setAttribute("account", account);
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		//指定用户成绩查询
		List<UserOption> list=new ArrayList<UserOption>();
		//String account=request.getParameter("account");
		try {
			list=TestConnection.selectAnswer(account);
			request.setAttribute("list", list);
			request.setAttribute("account", account);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		
		
		
		
		RequestDispatcher dis=request.getRequestDispatcher("ManagerFile.jsp");
		dis.forward( request,  response);
	}

}
