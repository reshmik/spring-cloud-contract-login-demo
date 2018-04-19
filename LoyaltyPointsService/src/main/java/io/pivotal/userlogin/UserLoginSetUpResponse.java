package io.pivotal.userlogin;

public class UserLoginSetUpResponse {

	private UserCheckStatus userCheckStatus;



	private int points;

	public UserLoginSetUpResponse() {
	}

	public UserCheckStatus getUserLoginSetUpStatus() {
		return userCheckStatus;
	}

	public void setUserCheckStatus(UserCheckStatus userCheckStatus) {
		this.userCheckStatus = userCheckStatus;
	}

	public int getPoints() {
		return points;
	}

	public void setPoints(int points) {
		this.points = points;
	}
}
