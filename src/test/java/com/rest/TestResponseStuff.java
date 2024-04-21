package com.rest;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.config.LogConfig;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class TestResponseStuff {

	RequestSpecification reqspec;
	
	@BeforeClass	
	void setup() {
		
		reqspec = RestAssured.given().baseUri("https://reqres.in")
									 .contentType(ContentType.JSON); 			
		
	}
	
	@Test
	void basictest() {
		
		Response response = 
				RestAssured
				.given()
				.config(RestAssured.config.logConfig(LogConfig.logConfig().blacklistHeader("Transfer-Encoding", "Connection")))
				.spec(reqspec)
				.when()
				.get("/api/users/2")
				.then()
				.extract()
				.response();
				
		System.out.println(response.getContentType());
		
	}
	
}
