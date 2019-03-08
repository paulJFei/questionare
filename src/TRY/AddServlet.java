package TRY;

import java.io.IOException;
import java.sql.PreparedStatement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class AddServlet
 */
public class AddServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		String account = request.getParameter("account");
		String password1 = request.getParameter("password1");
		String password2 = request.getParameter("password2");

		if (password1.equals(password2)) {
			System.out.println(account);
			String password = password1;
			Queryuser query = new Queryuser();
			try {
				PreparedStatement pre = query.add(account, password);// 调用方法添加用户
				pre.execute();
			} catch (Exception e) {
				e.printStackTrace();
			}
			RequestDispatcher dis = request.getRequestDispatcher("ManagerServlet");
			dis.forward(request, response);
		} else {
			System.out.println(123);
		}
	}

}
