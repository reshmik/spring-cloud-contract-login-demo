package io.pivotal.userlogin;

public class UserLoginSetupRequestV1 {
	private String username;

	private String password;
	
	private String authcode;
	
	public UserLoginSetupRequestV1() {
	}

	public UserLoginSetupRequestV1(UserLoginV1 userlogin) {
		this.username = userlogin.getUsername();
		this.password = userlogin.getpassword();
		this.authcode = userlogin.getAuthcode();
	}

	public String getAuthcode() {
		return authcode;
	}

	public void setAuthcode(String authcode) {
		this.authcode = authcode;
	}

	public String getusername() {
		return username;
	}

	public void setusername(String username) {
		this.username = username;
	}

	public String getpassword() {
		return password;
	}

	public void setpassword(String password) {
		this.password = password;
	}

}
