package com.companyname.restassured;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class RESTCalls 
{
	private static Logger log = LogManager.getLogger(RESTCalls.class.getName());
    public static Response GETrequest(String uRI)
    {
    	log.info("Inside GETRequest call");
    	RequestSpecification requestspecification = RestAssured.given();
    	requestspecification.contentType(ContentType.JSON);
    	Response response = requestspecification.get(uRI);
    	log.debug(requestspecification.log().all());
       return response;
    }
    public static Response POSTrequest(String uRI, String strJSON)
    {
    	log.info("Inside GETRequest call");
    	RequestSpecification requestspecification = RestAssured.given().body(strJSON);
    	requestspecification.contentType(ContentType.JSON);
    	Response response = requestspecification.post(uRI);
    	log.debug(requestspecification.log().all());
       return response;
    }
    
    public static Response POSTrequest(String uRI, String strJSON, String sessionId)
    {
    	log.info("Inside GETRequest call");
    	RequestSpecification requestspecification = RestAssured.given().body(strJSON);
    	requestspecification.contentType(ContentType.JSON);
    	requestspecification.header("cookie","JSESSIONID=" + sessionId+"");
    	Response response = requestspecification.post(uRI);
    	log.debug(requestspecification.log().all());
       return response;
    }
    public static Response PUT(String uRI, String strJSON)
    {
    	log.info("Inside GETRequest call");
    	RequestSpecification requestspecification = RestAssured.given().body(strJSON);
    	requestspecification.contentType(ContentType.JSON);
    	Response response = requestspecification.put(uRI);
    	log.debug(requestspecification.log().all());
       return response;
    }
    public static Response DELETErequest(String uRI, String strJSON)
    {
    	log.info("Inside GETRequest call");
    	RequestSpecification requestspecification = RestAssured.given().body(strJSON);
    	requestspecification.contentType(ContentType.JSON);
    	Response response = requestspecification.delete(uRI);
    	log.debug(requestspecification.log().all());
       return response;
    }
}
