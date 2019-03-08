package Question;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class QueQuery {
	public static void main(String[] args) {

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
				String id1 = res1.getString(1);//题号
				String que_id = res1.getString(2);//选项
				String context = res1.getString(3);
				//int num=TestConnection.selectCount(que_id, id1);//选项，题号,该题该选项选择人数
				//Answer answer = new Answer(id1, que_id, context, num);
				Answer answer = new Answer(id1, que_id, context);
				list1.add(answer);
				//System.out.println("list1"+list1);
			}
			Question question = new Question(id, content, list1);
			list.add(question);
			//System.out.println("list"+list);
		}
		return list;
	}

	public void QuestionEdit(String id, String content, String context1, String context2, String context3,
			String context4) throws SQLException, Exception {
		String[] myList = { context1, context2, context3, context4 };
		String sql = "update question_id set content=? where id=?";
		Class.forName("com.mysql.cj.jdbc.Driver");
		String url = "jdbc:mysql://127.0.0.1:3306/questionare?useUnicode=true&characterEncoding=utf8&serverTimezone=UTC";
		Connection con = DriverManager.getConnection(url, "root", "root111222");
		PreparedStatement pre = con.prepareStatement(sql);
		pre.setString(2, id);
		pre.setString(1, content);
		pre.execute();
		for (int i = 0; i < 4; i++) {
			String sql1 = "UPDATE question_num SET context = ? WHERE id = ?&&QUE_ID=?";
			Class.forName("com.mysql.cj.jdbc.Driver");
			PreparedStatement pre1 = con.prepareStatement(sql1);
			String context = myList[i];
			pre1.setString(1, context);
			char ch='A';
			ch=(char) (ch+i);
			String n = String.valueOf(ch);
			pre1.setString(3,n);
			pre1.setString(2, id);
			pre1.execute();
		}
	}

	public List<Question> Questionqueryone(String id) throws SQLException, Exception {
		String sql = "select * from question_num where ID=?";
		String sql1 = "select * from question_id where id=?";
		Class.forName("com.mysql.cj.jdbc.Driver");
		String url = "jdbc:mysql://127.0.0.1:3306/questionare?useUnicode=true&characterEncoding=utf8&serverTimezone=UTC";
		Connection con = DriverManager.getConnection(url, "root", "root111222");
		PreparedStatement pre = con.prepareStatement(sql);
		pre.setString(1, id);
		ResultSet res = pre.executeQuery();// 缁夎濮╅崗澶嬬垼閿涘苯鍨介弬顓濈瑓娑擄拷鐞涘本婀佸▽鈩冩箒閺佺増宓�
		List<Question> list = new ArrayList<Question>();
		List<Answer> list1 = new ArrayList<Answer>();
		while (res.next()) {
			String id1 = res.getString(1);
			String que_id = res.getString(2);
			String context = res.getString(3);
			Answer answer = new Answer(id1, que_id, context);
			list1.add(answer);
		}
		
		PreparedStatement pre1 = con.prepareStatement(sql1);
		pre1.setString(1, id);
		ResultSet res1 = pre1.executeQuery();
		while (res1.next()) {
			String id2 = res1.getString(1);
			String content = res1.getString(2);
			Question question = new Question(id2, content, list1);
			list.add(question);
		}
		return list;
	}

	public void Questionadd(String id, String content, String context1, String context2, String context3,
			String context4) throws Exception {
		String[] myList = { context1, context2, context3, context4 };
		String sql = "INSERT INTO question_id  VALUES (?,?) ";
		Class.forName("com.mysql.cj.jdbc.Driver");
		String url = "jdbc:mysql://127.0.0.1:3306/questionare?useUnicode=true&characterEncoding=utf8&serverTimezone=UTC";
		Connection con = DriverManager.getConnection(url, "root", "root111222");
		PreparedStatement pre = con.prepareStatement(sql);
		pre.setString(1, id);
		pre.setString(2, content);
		pre.execute();
		for (int i = 0; i < 4; i++) {
			String sql1 = "INSERT INTO question_num  VALUES (?,?,?)";
			Class.forName("com.mysql.cj.jdbc.Driver");
			PreparedStatement pre1 = con.prepareStatement(sql1);
			pre1.setString(1, id);
			char ch='A';
			ch=(char) (ch+i);
			String n = String.valueOf(ch);
			pre1.setString(2,n);
			String context = myList[i];
			pre1.setString(3, context);
			pre1.execute();
		}
	}

	public void Questiondelete(String id) throws Exception {
		String sql = "DELETE FROM question_id WHERE id = ? ";
		String sql1 = "DELETE FROM question_num WHERE id = ? ";
		Class.forName("com.mysql.cj.jdbc.Driver");
		String url = "jdbc:mysql://127.0.0.1:3306/questionare?useUnicode=true&characterEncoding=utf8&serverTimezone=UTC";
		Connection con = DriverManager.getConnection(url, "root", "root111222");
		PreparedStatement pre = con.prepareStatement(sql);
		PreparedStatement pre1 = con.prepareStatement(sql1);
		pre.setString(1, id);
		pre1.setString(1, id);
		pre.execute();
		pre1.execute();
	}
	//查讯结果
	public static List<Question> queryResult() throws SQLException, Exception {
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
				String id1 = res1.getString(1);//题号
				String que_id = res1.getString(2);//选项
				String context = res1.getString(3);
				//int num=TestConnection.selectCount(que_id, id1);//选项，题号,该题该选项选择人数
				//Answer answer = new Answer(id1, que_id, context, num);
				Answer answer = new Answer(id1, que_id, context);
				list1.add(answer);
				//System.out.println("list1"+list1);
			}
			Question question = new Question(id, content, list1);
			list.add(question);
			//System.out.println("list"+list);
		}
		return list;
	}
}
