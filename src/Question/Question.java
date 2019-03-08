package Question;

import java.util.List;

public class Question {
	public static void main(String[] args) {
	}

	String id;
	String content;
	List<Answer> list;

	public Question(String id, String content, List<Answer> list) {
		super();
		this.id = id;
		this.content = content;
		this.list = list;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public List<Answer> getList() {
		return list;
	}

	public void setList(List<Answer> list) {
		this.list = list;
	}

	Question() {
		super();
	}
}