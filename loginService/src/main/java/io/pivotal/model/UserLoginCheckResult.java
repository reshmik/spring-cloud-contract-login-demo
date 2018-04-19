package io.pivotal.model;

public class UserLoginCheckResult {

	private UserLoginCheckStatus userLoginCheckStatus;
	//private String userLoginCheckStatus;

	private String rejectionReason;

	public UserLoginCheckResult() {
	}

	public UserLoginCheckResult(UserLoginCheckStatus userLoginCheckStatus, String rejectionReason) {
		this.userLoginCheckStatus = userLoginCheckStatus;
		this.rejectionReason = rejectionReason;
	}

	public UserLoginCheckStatus getUserLoginCheckStatus() {
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
