package io.pivotal.userlogin;


public class UserLoginSetupRequest {

	private String username;

	private String password;
	
	public UserLoginSetupRequest() {
	}

	public UserLoginSetupRequest(User userlogin) {
		this.username = userlogin.getUsername();
		this.password = userlogin.getpassword();
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
