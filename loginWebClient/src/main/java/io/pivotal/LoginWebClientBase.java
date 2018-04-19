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

import io.pivotal.userlogin.UserLogin;
import io.pivotal.userlogin.UserLoginCheckStatus;
import io.pivotal.userlogin.UserLoginSetUpResponse;
import io.pivotal.userlogin.UserLoginSetupRequest;
import io.pivotal.userlogin.UserLoginSetupRequestV1;
import io.pivotal.userlogin.UserLoginSetupResult;
import io.pivotal.userlogin.UserLoginV1;

@SpringBootApplication
public class LoginWebClientBase {

	private final RestTemplate restTemplate;
	
	private static final String USER_LOGIN_JSON =
			"application/json";
	private static final String USER_LOGIN_URL = "http://localhost:6565/weblogin";
	private static final String USER_LOGIN_URL_V1 = "http://localhost:6565/weblogin/v1";

	@Autowired
	public LoginWebClientBase(RestTemplateBuilder builder) {
		this.restTemplate = builder.build();
	}

	public UserLoginSetupResult userLoginSetupApp(UserLogin userLogin) {
		
		UserLoginSetupRequest request =
				new UserLoginSetupRequest(userLogin);

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

	private UserLoginSetupResult buildResponseFromUserLoginResult(UserLoginSetUpResponse response) {
		UserLoginCheckStatus applicationStatus = null;
		if (UserLoginCheckStatus.OK.equals(response.getUserLoginSetUpStatus())) {
			applicationStatus = UserLoginCheckStatus.OK;
		} 
		else {
			applicationStatus = UserLoginCheckStatus.NOT_OKAY;
		}

		return new UserLoginSetupResult(applicationStatus, response.getRejectionReason());
	}
	
	
public UserLoginSetupResult userLoginSetupAppV1(UserLoginV1 userLoginV1) {
		
		UserLoginSetupRequestV1 requestV1 =
				new UserLoginSetupRequestV1(userLoginV1);

		UserLoginSetUpResponse response =
				sendRequestToUserLoginServiceV1(requestV1);

		return buildResponseFromUserLoginResultV1(response);
	}

	private UserLoginSetUpResponse sendRequestToUserLoginServiceV1(UserLoginSetupRequestV1 requestV1) {
		HttpHeaders httpHeaders = new HttpHeaders();
		httpHeaders.add(HttpHeaders.CONTENT_TYPE, USER_LOGIN_JSON);

		// tag::client_call_server[]
		ResponseEntity<UserLoginSetUpResponse> response = restTemplate.exchange(USER_LOGIN_URL_V1, HttpMethod.PUT, new HttpEntity<>(requestV1,httpHeaders),UserLoginSetUpResponse.class);
		// end::client_call_server[]
		return response.getBody();
	}

	private UserLoginSetupResult buildResponseFromUserLoginResultV1(UserLoginSetUpResponse response) {
		UserLoginCheckStatus applicationStatus = null;
		if (UserLoginCheckStatus.OK.equals(response.getUserLoginSetUpStatus())) {
			applicationStatus = UserLoginCheckStatus.OK;
		} 
		else {
			applicationStatus = UserLoginCheckStatus.NOT_OKAY;
		}

		return new UserLoginSetupResult(applicationStatus, response.getRejectionReason());
	}

	public static void main(String[] args) {
		SpringApplication.run(LoginWebClientBase.class, args);
	}
}
