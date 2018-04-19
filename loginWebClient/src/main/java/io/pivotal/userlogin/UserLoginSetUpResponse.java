package io.pivotal.userlogin;

public class UserLoginSetUpResponse {

	private UserLoginCheckStatus userLoginCheckStatus;

	private String rejectionReason;

	public UserLoginSetUpResponse() {
	}

	public UserLoginCheckStatus getUserLoginSetUpStatus() {
		return userLoginCheckStatus;
	}

	public void setUserLoginCheckStatus(UserLoginCheckStatus userLoginCheckStatus) {
		this.userLoginCheckStatus = userLoginCheckStatus;
	}

	public String getRejectionReason() {
		return rejectionReason;
	}

	public void setRejectionReason(String rejectionReason) {
		this.rejectionReason = rejectionReason;
	}
}
