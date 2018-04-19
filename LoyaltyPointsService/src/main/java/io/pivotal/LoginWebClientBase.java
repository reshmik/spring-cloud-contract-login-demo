package io.pivotal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import io.pivotal.userlogin.User;
import io.pivotal.userlogin.UserCheckStatus;
import io.pivotal.userlogin.UserLoginSetUpResponse;
import io.pivotal.userlogin.UserLoginSetupRequest;
import io.pivotal.userlogin.UserLoginSetupRequestV1;
import io.pivotal.userlogin.UserLoyaltyPoints;
import io.pivotal.userlogin.UserLoginV1;

@SpringBootApplication
public class LoginWebClientBase {

	private final RestTemplate restTemplate;
	
	private static final String USER_LOGIN_JSON =
			"application/json";
	private static final String USER_LOGIN_URL = "http://localhost:6565/customerprofileservice";

	@Autowired
	public LoginWebClientBase(RestTemplateBuilder builder) {
		this.restTemplate = builder.build();
	}

	public UserLoyaltyPoints userLoyaltyPoints(User user) {
		
		UserLoginSetupRequest request =
				new UserLoginSetupRequest(user);

		UserLoginSetUpResponse response =
				sendRequestToUserLoginService(request);

		return buildResponseFromUserLoginResult(response);
	}

	private UserLoginSetUpResponse sendRequestToUserLoginService(
			UserLoginSetupRequest request) {
		HttpHeaders httpHeaders = new HttpHeaders();
		httpHeaders.add(HttpHeaders.CONTENT_TYPE, USER_LOGIN_JSON);

		// tag::client_call_server[]
		ResponseEntity<UserLoginSetUpResponse> response = restTemplate.exchange(USER_LOGIN_URL, HttpMethod.PUT, new HttpEntity<>(request,httpHeaders),UserLoginSetUpResponse.class);
		// end::client_call_server[]
		System.out.println("response body = "+response.getBody());
		return response.getBody();
	}

	private UserLoyaltyPoints buildResponseFromUserLoginResult(UserLoginSetUpResponse response) {
		UserCheckStatus applicationStatus = null;
		if (UserCheckStatus.GOLD.equals(response.getUserLoginSetUpStatus())) {
			applicationStatus = UserCheckStatus.GOLD;
		} 
		else {
			applicationStatus = UserCheckStatus.GOLD;
		}

		return new UserLoyaltyPoints(applicationStatus, response.getPoints());
	}


	public static void main(String[] args) {
		SpringApplication.run(LoginWebClientBase.class, args);
	}
}
