package com.companyname.utils;


import java.nio.file.Files;
import java.nio.file.Paths;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import com.companyname.restassured.RESTCalls;


public  class PayloadConvertor {
	private static Logger log = LogManager.getLogger(PayloadConvertor.class.getName());
	public static String generatePayloadString(String fileName) 
	{
		log.info("Inside payload function");
		String filePath = System.getProperty("user.dir")+"\\Payloads\\"+fileName;
		try
		{
		return new String(Files.readAllBytes(Paths.get(filePath)));
		}
		catch(Exception e)
		{
			log.error(e);
			return null;
		}
	}
}
