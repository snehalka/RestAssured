package com.companyname.utils;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

public class uRI {
	private static Logger log = LogManager.getLogger(uRI.class.getName());
	public static final String uRI = "http://localhost:8081";
	
	public static String getEndPoint()
	{
		log.info("base uri" + uRI);
		return uRI;
	}

	public static String getEndPoint(String resources)
	{
		log.info("enpoint" + uRI + resources);

		return uRI + resources;
	}
}
