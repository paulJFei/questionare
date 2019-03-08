package TRY;

public class user {
	private String account;
	
	private String password;
	
	public String getAccount() {
		return account;
	}
	public void setAccount(String account) {
		this.account = account;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	public user(String account, String password) {
		super();
		this.account = account;
		this.password = password;
	}
}

	
