package com.companyname.restassured;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import com.companyname.utils.PayloadConvertor;
import com.companyname.utils.TestUtils;
import com.companyname.utils.uRI;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class BaseTest {
	private static Logger log = LogManager.getLogger(BaseTest.class.getName());

	public static String doLogin() {

		Response response;
		log.info("Starting testcase : login");
		// Converting the payload as string
		String loginPayload = PayloadConvertor.generatePayloadString("JiraLogin.json");
		// Generating the the URL
		String endpointuRI = uRI.getEndPoint("/rest/auth/1/session");
		//Called the POSTrequest function
		response = RESTCalls.POSTrequest(endpointuRI, loginPayload);
		log.info(response.getBody().asString());
		//Converting the response to String usig getResponseString class
		String strResponse = TestUtils.getReponseString(response);
		JsonPath jsonPath = TestUtils.jsonParser(strResponse);
		String sessionId = jsonPath.getString("session.value");
		System.out.println("Jira Session ID:" + sessionId);
		return sessionId;
	}
}
