package io.pivotal;

import org.junit.Before;

import com.jayway.restassured.module.mockmvc.RestAssuredMockMvc;

public class LoginWebClientBase {
	
	@Before
    public void setup() {
        RestAssuredMockMvc.standaloneSetup(new LoginController());
    }


    public void assertThatRejectionReasonIsNull(Object rejectionReason) {
        assert rejectionReason == null;
    }

}
