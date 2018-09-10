package com.companyname.createissue;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.companyname.restassured.BaseTest;
import com.companyname.restassured.LoginTest;
import com.companyname.restassured.RESTCalls;
import com.companyname.utils.PayloadConvertor;
import com.companyname.utils.uRI;

import io.restassured.response.Response;

public class CreateIssue {

	private String sessionId;
	Response response;
	//private static Logger log = LogManager.getLogger(CreateIssue.class.getName());

	@BeforeMethod
	public void setup()
	{
		 sessionId = BaseTest.doLogin();
	}
	@Test
	public void createIssue()
	{
		//log.info("Testing create isue");
		String URL = uRI.getEndPoint("/rest/api/2/issue");
		String CreateIssuePayload = PayloadConvertor.generatePayloadString("createBug.json");
		response = RESTCalls.POSTrequest(URL, CreateIssuePayload,sessionId);
		
	}
}
