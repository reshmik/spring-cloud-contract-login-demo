package io.pivotal.userlogin;

public class UserLoginSetupResult {

	private UserLoginCheckStatus userLoginCheckStatus;

	private String rejectionReason;

	public UserLoginSetupResult() {
	}

	public UserLoginSetupResult(UserLoginCheckStatus userLoginCheckStatus, String rejectionReason) {
		this.userLoginCheckStatus = userLoginCheckStatus;
		this.rejectionReason = rejectionReason;
	}

	public UserLoginCheckStatus getuserLoginCheckStatus() {
		return userLoginCheckStatus;
	}

	public void setuserLoginCheckStatus(UserLoginCheckStatus userLoginCheckStatus) {
		this.userLoginCheckStatus = userLoginCheckStatus;
	}

	public String getRejectionReason() {
		return rejectionReason;
	}

	public void setRejectionReason(String rejectionReason) {
		this.rejectionReason = rejectionReason;
	}
}
