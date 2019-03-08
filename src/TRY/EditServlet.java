package TRY;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class EditServlet
 */
public class EditServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		String account = request.getParameter("id");
		String password1 = request.getParameter("password1");
		String password2 = request.getParameter("password2");
		System.out.println(password1+"\t"+password2);
		if (password1.equals(password2)) {
			String password = password1;
			Queryuser query = new Queryuser();
			try {
				query.Edit(account, password);
			} catch (Exception e) {
				e.printStackTrace();
			}
			RequestDispatcher dis = request.getRequestDispatcher("ManagerServlet");
			dis.forward(request, response);
		}
		else{
			System.out.println(123);
		}
	}
}
