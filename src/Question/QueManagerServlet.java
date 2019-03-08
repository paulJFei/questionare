package Question;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class QueManagerServlet
 */
public class QueManagerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Question> list = null;
		try {
			list = QueQuery.queryquestion();
		} catch (Exception e) {
			e.printStackTrace();
		}
		request.setAttribute("lis", list);
		RequestDispatcher dis=request.getRequestDispatcher("QuestionManagerFile.jsp");
		dis.forward( request,  response);
	}

}
