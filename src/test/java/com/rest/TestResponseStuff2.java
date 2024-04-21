package com.rest;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.config.LogConfig;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class TestResponseStuff2 {

	@BeforeClass
	void setup() {
		
		// RestAssured.requestSpecification static var. doesn't need to create the RequestSpecification
		// interface instance at the class level.
		
		RestAssured.requestSpecification = RestAssured.given().baseUri("https://reqres.in")
				 .contentType(ContentType.JSON); 
		
	}
	
	@Test
	void basictest() {
		
		Response response = 
				RestAssured
				.given()
				.config(RestAssured.config.logConfig(LogConfig.logConfig().blacklistHeader("Transfer-Encoding", "Connection")))
				.when()
				.get("/api/users/2")
				.then()
				.extract()
				.response();
				
		System.out.println(response.getStatusLine());
		
	}
}
