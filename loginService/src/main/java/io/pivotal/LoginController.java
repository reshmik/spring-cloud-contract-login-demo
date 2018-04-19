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
			value = "/weblogin",
			method = PUT,
			consumes = USER_LOGIN_JSON,
			produces = USER_LOGIN_JSON)
	public UserLoginCheckResult userLoginCheck(@RequestBody UserLoginCheck userLoginCheck) {

		if (userLoginCheck.getAuthcode()!= null)
		{
			if(!userLoginCheck.getAuthcode().isEmpty() && authCodeContainsSpecialCharacters(userLoginCheck)) {
			return new UserLoginCheckResult(UserLoginCheckStatus.OK, "NO_REASON");
			}
		}
		else if(passwordisCorrect(userLoginCheck))
			return new UserLoginCheckResult(UserLoginCheckStatus.OK, "NO_REASON");	
		
		
		return new UserLoginCheckResult(UserLoginCheckStatus.NOT_OKAY, "INCORRECT_PASSWORD");
	
	}

	private boolean authCodeContainsSpecialCharacters(UserLoginCheck userLoginCheck) {
		return userLoginCheck.getAuthcode().matches("[0-9][0-9][0-9]");
	}
	
		private boolean passwordisCorrect(UserLoginCheck userLoginCheck) {
			return userLoginCheck.getPassword().matches("123");
		}


}
