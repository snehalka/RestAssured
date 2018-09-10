package com.companyname.restassured;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.testng.Assert;

import com.companyname.utils.TestUtils;

import io.restassured.response.Response;


public class Assertions {
	private static Logger log = LogManager.getLogger(Assertions.class.getName());
	
	public static void verifyTrue(boolean flag)
	{
		Assert.assertTrue(flag);
		
	}
	public static void verifyFalse(boolean flag)
	{
		Assert.assertFalse(flag);
		
	}
	public static void verifyStatusCode(Response response,int status)
	{
		Assert.assertEquals(TestUtils.getStatusCode(response), status);
	}

	public static void verifyStatusMessage(Response response,int status)
	{
		Assert.assertEquals(TestUtils.getStatusCode(response), status);
	}

}
