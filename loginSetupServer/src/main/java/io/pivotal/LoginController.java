package io.pivotal;

import static org.springframework.web.bind.annotation.RequestMethod.PUT;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.pivotal.model.UserLoginCheck;
import io.pivotal.model.UserLoginCheckResult;
import io.pivotal.model.UserLoginCheckStatus;
import io.pivotal.model.UserLoginCheckV1;

@RestController
public class LoginController {
	
	private static final String USER_LOGIN_JSON = "application/json";

	@RequestMapping(
			value = "/userlogin",
			method = PUT,
			consumes = USER_LOGIN_JSON,
			produces = USER_LOGIN_JSON)
	public UserLoginCheckResult userLoginCheck(@RequestBody UserLoginCheck userLoginCheck) {

		if (passwordContainsSpecialCharacters(userLoginCheck)) {
			return new UserLoginCheckResult(UserLoginCheckStatus.OK, "NO_REASON");
		}
		
		return new UserLoginCheckResult(UserLoginCheckStatus.NOT_OKAY, "CONTAINS_SPECIAL_CHARACTER");
	
	}

	//If it matches regex [a-zA-Z0-9 ]* then there is no special characters in it.
	private boolean passwordContainsSpecialCharacters(UserLoginCheck userLoginCheck) {
		//return userLoginCheck.getPassword().matches("[a-zA-Z0-9 ]*");
		return userLoginCheck.getPassword().matches("123");
	}

	@RequestMapping(
			value = "/userlogin/v1",
			method = PUT,
			consumes = USER_LOGIN_JSON,
			produces = USER_LOGIN_JSON)
	public UserLoginCheckResult userLoginCheckV1(@RequestBody UserLoginCheckV1 userLoginCheckV1) {

		if (passwordContainsSpecialCharacters(userLoginCheckV1)) {
			return new UserLoginCheckResult(UserLoginCheckStatus.OK, "NO_REASON");
		}
		
		return new UserLoginCheckResult(UserLoginCheckStatus.NOT_OKAY, "CONTAINS_SPECIAL_CHARACTER");
	
	}

	//If it matches regex [a-zA-Z0-9 ]* then there is no special characters in it.
	private boolean passwordContainsSpecialCharacters(UserLoginCheckV1 userLoginCheckV1) {
		//return userLoginCheck.getPassword().matches("[a-zA-Z0-9 ]*");
		return userLoginCheckV1.getPassword().matches("123");
	}


}
