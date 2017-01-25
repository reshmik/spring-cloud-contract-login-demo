package io.pivotal;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cloud.contract.stubrunner.spring.AutoConfigureStubRunner;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit4.SpringRunner;

import io.pivotal.userlogin.UserLogin;
import io.pivotal.userlogin.UserLoginCheckStatus;
import io.pivotal.userlogin.UserLoginSetupResult;
import io.pivotal.userlogin.UserLoginV1;



@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.NONE)
@AutoConfigureStubRunner(ids = {"io.pivotal:loginsetupserver:+:stubs:6565"}, workOffline = true)
@DirtiesContext
public class LoginClientApplicationTests {

	@Autowired
	private LoginClientApplication loginSetUpClientApp;

	@Test
	public void contextLoads() {
	}

//	@Test
//	public void shouldSuccessful() {
//		RestTemplate restTemplate = new RestTemplate();
//		ResponseEntity<String> response = restTemplate.getForEntity("http://localhost:6565/hello", String.class);
//		assertThat(response.getStatusCode(), equalTo(HttpStatus.OK));
//	}
//	
	
	@Test
	public void shouldSuccessfullySetPassword() {
		// given:
		UserLogin userlogin = new UserLogin("reshmi","123");
	    // when:
		UserLoginSetupResult userloginResult = loginSetUpClientApp.userLoginSetupApp(userlogin);
		// then:
		assertThat(userloginResult.getuserLoginCheckStatus()).isEqualTo(UserLoginCheckStatus.OK);
		 assertThat(userloginResult.getRejectionReason()).isEqualTo("NO_REASON");
	}

	@Test
	public void shouldSuccessfullySetPasswordV1() {
		// given:
		UserLoginV1 userloginv1 = new UserLoginV1("cloudnativemeetup","123","123");
	    // when:
		UserLoginSetupResult userloginResultv1 = loginSetUpClientApp.userLoginSetupAppV1(userloginv1);
		// then:
		assertThat(userloginResultv1.getuserLoginCheckStatus()).isEqualTo(UserLoginCheckStatus.OK);
		 assertThat(userloginResultv1.getRejectionReason()).isEqualTo("NO_REASON");
	}

}
