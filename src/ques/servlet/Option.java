package ques.servlet;

public class Option {
	
	private String id;
	private String queId;
	private String option1;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getQueId() {
		return queId;
	}
	public void setQueId(String queId) {
		this.queId = queId;
	}
	public String getOption1() {
		return option1;
	}
	public void setOption1(String option1) {
		this.option1 = option1;
	}
	public Option(String id, String queId, String option1) {
		super();
		this.id = id;
		this.queId = queId;
		this.option1 = option1;
	}
	public Option() {
		super();
	}
	@Override
	public String toString() {
		return "Option [id=" + id + ", queId=" + queId + ", option1=" + option1 + "]";
	}
	
}
