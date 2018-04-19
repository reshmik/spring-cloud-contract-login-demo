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


@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.NONE)
@AutoConfigureStubRunner(ids = {"io.pivotal:loginservice:+:stubs:6565"}, workOffline = true)
@DirtiesContext
public class LoginWebClientApplicationTests {

	@Autowired
	private LoginWebClientBase loginSetUpClientApp;
	
	@Test
	public void shouldSuccessfullyTestLogin() {
		// given:
		UserLogin userlogin = new UserLogin("cfsummit","123");
	    // when:
		UserLoginSetupResult userloginResult = loginSetUpClientApp.userLoginSetupApp(userlogin);
		// then:
		assertThat(userloginResult.getuserLoginCheckStatus()).isEqualTo(UserLoginCheckStatus.OK);
		 assertThat(userloginResult.getRejectionReason()).isEqualTo("NO_REASON");
	}

	@Test
	public void contextLoads() {
	}

}
