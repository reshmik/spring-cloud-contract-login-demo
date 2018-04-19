package io.pivotal.model;

public class UserLoginCheckResult {

	private UserLoginCheckStatus userLoginCheckStatus;
	//private String userLoginCheckStatus;

	public int getPoints() {
		return points;
	}

	public void setPoints(int points) {
		this.points = points;
	}

	private int points;

	public UserLoginCheckResult() {
	}

	public UserLoginCheckResult(UserLoginCheckStatus userLoginCheckStatus, int points) {
		this.userLoginCheckStatus = userLoginCheckStatus;
		this.points = points;
	}

	public UserLoginCheckStatus getUserLoginCheckStatus() {
		return userLoginCheckStatus;
	}

	public void setUserLoginCheckStatus(UserLoginCheckStatus userLoginCheckStatus) {
		this.userLoginCheckStatus = userLoginCheckStatus;
	}

}
