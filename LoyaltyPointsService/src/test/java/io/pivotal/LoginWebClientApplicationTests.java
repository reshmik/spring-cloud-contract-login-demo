package io.pivotal;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cloud.contract.stubrunner.spring.AutoConfigureStubRunner;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit4.SpringRunner;

import io.pivotal.userlogin.User;
import io.pivotal.userlogin.UserCheckStatus;
import io.pivotal.userlogin.UserLoyaltyPoints;


@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.NONE)
@AutoConfigureStubRunner(ids = {"io.pivotal:customerprofileservice:+:stubs:6565"}, workOffline = true)
@DirtiesContext
public class LoginWebClientApplicationTests {

	@Autowired
	private LoginWebClientBase loginSetUpClientApp;
	
	@Test
	public void shouldSuccessfullyTestLogin() {
		// given:
		User user = new User("reshmi","123");
	    // when:
		UserLoyaltyPoints userloyaltyPoints = loginSetUpClientApp.userLoyaltyPoints(user);
		// then:
		assertThat(userloyaltyPoints.getuserStatus()).isEqualTo(UserCheckStatus.GOLD);
		assertThat(userloyaltyPoints.getPoints()).isEqualTo(50000);
	}

	@Test
	public void contextLoads() {
	}

}
