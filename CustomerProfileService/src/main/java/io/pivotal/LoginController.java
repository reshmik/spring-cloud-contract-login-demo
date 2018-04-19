package io.pivotal;

import static org.springframework.web.bind.annotation.RequestMethod.PUT;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.pivotal.model.UserLoginCheckResult;
import io.pivotal.model.UserLoginCheckStatus;
import io.pivotal.model.UserLoginCheck;

@RestController
public class LoginController {
	
private static final String USER_LOGIN_JSON = "application/json";

	@RequestMapping(
			value = "/customerprofileservice",
			method = PUT,
			consumes = USER_LOGIN_JSON,
			produces = USER_LOGIN_JSON)
	public UserLoginCheckResult userLoginCheck(@RequestBody UserLoginCheck userLoginCheck) {

		return new UserLoginCheckResult(UserLoginCheckStatus.GOLD, 50000);
	}


	
		private boolean passwordisCorrect(UserLoginCheck userLoginCheck) {
			return userLoginCheck.getPassword().matches("123");
		}


}
