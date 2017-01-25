package io.pivotal.userlogin;

public class UserLoginV1 {
	private String username;
	private String password;
	private String authcode;
	public UserLoginV1() {
	}

	public UserLoginV1(String username, String password, String authcode) {
		this.username = username;
		this.password = password;
		this.authcode = authcode;
	}

	public String getAuthcode() {
		return authcode;
	}

	public void setAuthcode(String authcode) {
		this.authcode = authcode;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getpassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
}
