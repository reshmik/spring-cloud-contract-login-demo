package io.pivotal;

import io.restassured.module.mockmvc.RestAssuredMockMvc;
import org.junit.Before;


public class CustomerprofileserviceBase {

    @Before
    public void setup() {
        RestAssuredMockMvc.standaloneSetup(new LoginController());
    }

    public void assertThatRejectionReasonIsNull(Object rejectionReason) {
        assert rejectionReason == null;
    }

}
