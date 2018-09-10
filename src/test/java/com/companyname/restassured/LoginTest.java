package com.companyname.restassured;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.testng.annotations.Test;
import com.companyname.utils.PayloadConvertor;
import com.companyname.utils.uRI;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class LoginTest {
	Response response;
	private static Logger log = LogManager.getLogger(LoginTest.class.getName());

	@Test
	public void doLogin() throws Exception {
		log.info("Starting testcase : login");
		// Converting the payload as string
		String loginPayload = PayloadConvertor.generatePayloadString("JiraLogin.json");
		// Generating the the URL
		String endpointuRI = uRI.getEndPoint("/rest/auth/1/session");
		//
		response = RESTCalls.POSTrequest(endpointuRI, loginPayload);
		String strResponse = response.getBody().asString();
		System.out.println("**************");
		System.out.println(strResponse);
		JsonPath jsonPath = new JsonPath(strResponse);
		String sessionId = jsonPath.getString("session.value");
		System.out.println(sessionId);

	}
}
