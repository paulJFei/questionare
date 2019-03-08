package ques.servlet;

import java.util.List;

public class Question {
	private String id;
	private String content;
	private List<Option> list_o;

	public Question() {
		super();
	}

	public Question(String id, String content, List<Option> list_o) {
		this.id = id;
		this.content = content;
		this.list_o = list_o;
	}

	

	public List<Option> getList_o() {
		return list_o;
	}

	public void setList_o(List<Option> list_o) {
		this.list_o = list_o;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getContent() {
		return content;
	}

	@Override
	public String toString() {
		return "Question [id=" + id + ", content=" + content + ", list_o=" + list_o + "]";
	}
	

}
