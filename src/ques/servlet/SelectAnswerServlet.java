package ques.servlet;
//查询用户答题情况
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class SelectAnswerServlet
 */
public class SelectAnswerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//查询指定用户答题情况
		request.setCharacterEncoding("utf-8");// 网页到程序的数据传输格式
		response.setContentType("text/html;charset=utf-8");// 程序到网页的文本传输格式
		List<UserOption> list=new ArrayList<UserOption>();
		String account=request.getParameter("account");
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
		//转发请求
				RequestDispatcher rdis=request.getRequestDispatcher("userAnswer.jsp");
				rdis.forward(request, response);
	}

}
