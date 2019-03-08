package TRY;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Queryuser {
	public static void main(String[] args) {
	}

	public List<user> query() throws SQLException, Exception {
		String sql = "select * from user";
		Class.forName("com.mysql.cj.jdbc.Driver");
		String url = "jdbc:mysql://127.0.0.1:3306/questionare?useUnicode=true&characterEncoding=utf8&serverTimezone=UTC";
		Connection con = DriverManager.getConnection(url, "root", "root111222");
		PreparedStatement pre = con.prepareStatement(sql);
		ResultSet res = pre.executeQuery();// 绉诲姩鍏夋爣锛屽垽鏂笅涓�琛屾湁娌℃湁鏁版嵁
		List<user> list = new ArrayList<user>();
		while (res.next()) {
			String account = res.getString(1);
			String password = res.getString(2);
			user user = new user(account, password);
			list.add(user);
		}
		return list;
	}

	public PreparedStatement add(String account, String password) throws Exception {
		String sql = "INSERT INTO user  VALUES (?, ?)";
		Class.forName("com.mysql.cj.jdbc.Driver");
		String url = "jdbc:mysql://127.0.0.1:3306/questionare?useUnicode=true&characterEncoding=utf8&serverTimezone=UTC";
		Connection con = DriverManager.getConnection(url, "root", "root111222");
		PreparedStatement pre = con.prepareStatement(sql);
		pre.setString(1, account);
		pre.setString(2, password);
		return pre;
	}

	public List<user> queryone(String account) throws SQLException, Exception {
		String sql = "select * from user where account=?";
		Class.forName("com.mysql.cj.jdbc.Driver");
		String url = "jdbc:mysql://127.0.0.1:3306/questionare?useUnicode=true&characterEncoding=utf8&serverTimezone=UTC";
		Connection con = DriverManager.getConnection(url, "root", "root111222");
		PreparedStatement pre = con.prepareStatement(sql);
		pre.setString(1, account);
		ResultSet res = pre.executeQuery();// 绉诲姩鍏夋爣锛屽垽鏂笅涓�琛屾湁娌℃湁鏁版嵁
		List<user> list = new ArrayList<user>();
		while (res.next()) {
			String id = res.getString(1);
			String password = res.getString(2);
			user user = new user(id, password);
			list.add(user);
		}
		return list;
	}
	
	public void Edit(String account,String password) throws SQLException, Exception {
		String sql = "UPDATE user SET password =?  WHERE account = ? ";
		Class.forName("com.mysql.cj.jdbc.Driver");
		String url = "jdbc:mysql://127.0.0.1:3306/questionare?useUnicode=true&characterEncoding=utf8&serverTimezone=UTC";
		Connection con = DriverManager.getConnection(url, "root", "root111222");
		PreparedStatement pre = con.prepareStatement(sql);
		pre.setString(1, password);
		pre.setString(2, account);
		pre.execute();
	}
	
	
}