package TRY;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



/**
 * Servlet implementation class Log
 */
@WebServlet("/Log")
public class ManagerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Queryuser query=new Queryuser();
		List<user> list = null;
		try {
			list = query.query();
		} catch (Exception e) {
			e.printStackTrace();
		}
		request.setAttribute("lis", list);
		RequestDispatcher dis=request.getRequestDispatcher("ManagerFile.jsp");
		dis.forward( request,  response);
	}

}
