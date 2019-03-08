package Question;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class QueEditServlet
 */
public class QueEditServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
		String content = request.getParameter("content");
		String context1 = request.getParameter("context1");
		String context2 = request.getParameter("context2");
		String context3 = request.getParameter("context3");
		String context4 = request.getParameter("context4");

		QueQuery query = new QueQuery();
		try {
			query.QuestionEdit(id, content, context1, context2, context3, context4);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		RequestDispatcher dis = request.getRequestDispatcher("QueManagerServlet");
		dis.forward(request, response);
	}

}
