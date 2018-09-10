package com.companyname.utils;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class TestUtils {
	private static Logger log = LogManager.getLogger(TestUtils.class.getName());
	
	public static String getReponseString(Response response)
	{
		log.info("Converting response to string");
		String strResponse = response.getBody().asString();
		log.debug(strResponse);
		return strResponse;
		
	}
	public static JsonPath jsonParser(String response)
	{
		log.info("Parsing String response to json");
		JsonPath jsonResponse = new JsonPath(response);
		log.debug(jsonResponse);
		return jsonResponse;
	}
	public static int getStatusCode(Response response)
	{
		log.info("Get status code");
	int statusCode = response.getStatusCode();
	log.debug(statusCode);
	return statusCode;
	}
	
	public static String getStatusMessage(Response response)
	{
		log.info("Fet status message");
		String message = response.getStatusLine();
		log.debug(message);
		return(message);
	}
}
