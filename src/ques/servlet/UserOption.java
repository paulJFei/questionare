package ques.servlet;
//存放用户选择的答案
public class UserOption {
	private String account;
	private String id;
	private String option;

	public UserOption() {
		super();
	}

	public UserOption(String account, String id, String option) {
		super();
		this.account = account;
		this.id = id;
		this.option = option;
	}

	public String getAccount() {
		return account;
	}

	public void setAccount(String account) {
		this.account = account;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getOption() {
		return option;
	}

	public void setOption(String option) {
		this.option = option;
	}

}
