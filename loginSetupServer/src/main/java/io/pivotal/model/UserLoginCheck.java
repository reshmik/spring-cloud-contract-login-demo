package io.pivotal.model;

public class UserLoginCheck {

		private String username;

		private String password;
		
		private String authcode;
		

		public String getAuthcode() {
			return authcode;
		}

		public void setAuthcode(String authcode) {
			this.authcode = authcode;
		}

		public UserLoginCheck() {
		}

		public String getUserName() {
			return username;
		}

		public void setUserName(String username) {
			this.username = username;
		}

		public String getPassword() {
			return password;
		}

		public void setPassword(String password) {
			this.password = password;
		}
	}

