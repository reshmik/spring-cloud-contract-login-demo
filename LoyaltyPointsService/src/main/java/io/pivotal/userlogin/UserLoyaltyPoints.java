package io.pivotal.userlogin;

public class UserLoyaltyPoints {

	private UserCheckStatus userCheckStatus;

	private int points;

	public UserLoyaltyPoints() {
	}

	public UserLoyaltyPoints(UserCheckStatus userCheckStatus, int points) {
		this.userCheckStatus = userCheckStatus;
		this.points = points;
	}

	public UserCheckStatus getuserStatus() {
		return userCheckStatus;
	}

	public void setuserLoginCheckStatus(UserCheckStatus userCheckStatus) {
		this.userCheckStatus = userCheckStatus;
	}

	public int getPoints() {
		return points;
	}

	public void setPoints(int points) {
		this.points = points;
	}
}
