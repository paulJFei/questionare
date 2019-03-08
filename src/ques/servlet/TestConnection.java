package ques.servlet;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Question.Answer;
import Question.Question;

public class TestConnection {
	public static void main(String[] args) throws Exception {
		Connection con = TestConnection.linkDB();
		String sql = "select  count(distinct(acount)) from answer_user";
		PreparedStatement pre = con.prepareStatement(sql);
		ResultSet rs = pre.executeQuery();
		while (rs.next()) {
			int i = rs.getInt(1);
			System.out.println(i);
		}
		List<Question> list = TestConnection.queryquestion();
		System.out.print(list);

		
	}

	// 查询指定题目的指定选项的答题人数
	public static int selectCount(String option, String id) throws ClassNotFoundException, SQLException {
		Connection con = TestConnection.linkDB();
		String sql_1 = "SELECT count(*) FROM `answer_user` a WHERE a.option =? and id=?";
		PreparedStatement pre_1 = con.prepareStatement(sql_1);
		pre_1.setString(1, option);
		pre_1.setString(2, id);
		ResultSet rs_1 = pre_1.executeQuery();
		float i = 0;
		while (rs_1.next()) {
			i = rs_1.getInt(1);
		}
		con.close();
		return (int) i;

	}

	// 连接数据库
	public static Connection linkDB() throws ClassNotFoundException, SQLException {
		String url = "jdbc:mysql://localhost:3306/questionare?useUnicode=true&characterEncoding=utf8&serverTimezone=UTC&useSSL=false";
		Class.forName("com.mysql.cj.jdbc.Driver");// 驱动加载
		Connection con = DriverManager.getConnection(url, "root", "root111222");// 连接到数据库
		return con;
	}

	// 查询数据库
	public static ResultSet selectDB(String sql) throws ClassNotFoundException, SQLException {
		Connection con = TestConnection.linkDB();
		PreparedStatement pre = con.prepareStatement(sql);
		ResultSet rs = pre.executeQuery();
		return rs;
	}

	// 利用用户id删除数据库记录
	public static void deleteUser(String account) throws ClassNotFoundException, SQLException {
		Connection con = TestConnection.linkDB();
		String sql = "delete from user where account=?";
		PreparedStatement pre = con.prepareStatement(sql);
		pre.setString(1, account);
		pre.execute();
		con.close();
	}

	// 利用题目id查询问题选项数据库记录，question_num
	public static ResultSet selectById(String id) throws ClassNotFoundException, SQLException {
		Connection con = TestConnection.linkDB();
		String sql = "select * from question_num where ID=?";
		PreparedStatement pre = con.prepareStatement(sql);
		pre.setString(1, id);
		ResultSet rs = pre.executeQuery();
		return rs;
	}

	// 向用户提交答案数据库添加记录
	public static void saveAnswer(String account, String id, String option)
			throws ClassNotFoundException, SQLException {
		String sql = "insert into answer_user value(?,?,?)";
		Connection con = TestConnection.linkDB();
		PreparedStatement pre = con.prepareStatement(sql);// SQL 语句被预编译并存储在 PreparedStatement 对象中。然后可以使用此对象多次高效地执行该语句。
		pre.setString(1, account);// id赋值给数据库第一列
		pre.setString(2, id);
		pre.setString(3, option);
		pre.execute();
		con.close();
	}

	// 向问题描述数据库添加内容
	public static void saveContent(String id, String content) throws ClassNotFoundException, SQLException {
		String sql = "insert into question_id value(?,?)";// 向问题描述数据库中添加数据
		Connection con = TestConnection.linkDB();
		PreparedStatement pre = con.prepareStatement(sql);
		pre.setString(1, id);// 给问题描述数据库添加数据
		pre.setString(2, content);
		pre.execute();
		con.close();
	}

	// 向问题选项数据库添加内容
	public static void saveOption(String id, String queId, String option) throws ClassNotFoundException, SQLException {
		String sql = "insert into question_num value(?,?,?)";// 向问题选项数据库中添加数据选项的sql语句
		Connection con = TestConnection.linkDB();
		PreparedStatement pre = con.prepareStatement(sql);// 执行向问题选项数据库中添加数据选项的sql语句
		pre.setString(1, id);
		pre.setString(2, queId);
		pre.setString(3, option);
		pre.execute();
		con.close();
	}

	// 在答案数据库中查找指定用户的答题情况
	public static List<UserOption> selectAnswer(String account) throws ClassNotFoundException, SQLException {
		UserOption uo = new UserOption();
		String sql = "select * from answer_user where acount=? ";
		Connection con = TestConnection.linkDB();
		PreparedStatement pre = con.prepareStatement(sql);// 在答案数据库中执行查询制定用户答案的sql语句
		pre.setString(1, account);
		ResultSet res = pre.executeQuery();
		List<UserOption> list = new ArrayList<UserOption>();
		while (res.next()) {
			String id = res.getString(2);
			String option = res.getString(3);
			uo = new UserOption(account, id, option);
			list.add(uo);
		}
		con.close();
		return list;
	}

	public static List<Question> queryquestion() throws SQLException, Exception {
		String sql = "select * from question_id ORDER BY id";
		Class.forName("com.mysql.cj.jdbc.Driver");
		String url = "jdbc:mysql://127.0.0.1:3306/questionare?useUnicode=true&characterEncoding=utf8&serverTimezone=UTC";
		Connection con = DriverManager.getConnection(url, "root", "root111222");
		PreparedStatement pre = con.prepareStatement(sql);
		ResultSet res = pre.executeQuery();// 缁夎濮╅崗澶嬬垼閿涘苯鍨介弬顓濈瑓娑擄拷鐞涘本婀佸▽鈩冩箒閺佺増宓�
		List<Question> list = new ArrayList<Question>();
		while (res.next()) {
			String id = res.getString(1);
			String content = res.getString(2);// 閺屻儴顕楅崜宥勮⒈妞わ拷
			String sql1 = "select * from question_num where id=? ORDER BY id";
			Connection con1 = DriverManager.getConnection(url, "root", "root111222");
			PreparedStatement pre1 = con1.prepareStatement(sql1);// 閺屻儴顕楅柅澶愩��
			pre1.setString(1, id);
			ResultSet res1 = pre1.executeQuery();
			List<Answer> list1 = new ArrayList<Answer>();
			while (res1.next()) {
				String id1 = res1.getString(1);// 题号
				String que_id = res1.getString(2);// 选项
				String context = res1.getString(3);
				int num = TestConnection.selectCount(que_id, id1);// 选项，题号,该题该选项选择人数
				Answer answer = new Answer(id1, que_id, context, num);
				// Answer answer = new Answer(id1, que_id, context);
				list1.add(answer);
				// System.out.println("list1"+list1);
			}
			Question question = new Question(id, content, list1);
			list.add(question);
			// System.out.println("list"+list);
		}
		return list;
	}
}
