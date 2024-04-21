package com.rest;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.config.LogConfig;
import io.restassured.config.RestAssuredConfig;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class TestResponseStuff3 {

	@BeforeClass
	void setup() {
		
		RequestSpecBuilder builder = new RequestSpecBuilder();
		
		builder.setBaseUri("https://reqres.in")
			   .setContentType(ContentType.JSON);
		
		RestAssured.requestSpecification = builder.build();
		
	}
	
//	@Test
//	void basictest{
//		
//		RestAssured
//			.given()
//			.config(RestAssuredConfig.config().logConfig(LogConfig.logConfig().blacklistHeader("Connection")))
//			.when()
//			.get("/api/users/2")
//			.then()
//			.statusCode(200);
//		
//	}
	
	
	@Test
	void basictest() {
		
		Response response = 
				RestAssured
				.given()
				.config(RestAssuredConfig.config().logConfig(LogConfig.logConfig().blacklistHeader("Connection")))
				.when()
				.get("/api/users/2")
				.then()
				.log().everything()
				.extract()
				.response();
				
		System.out.println(response.getStatusLine());
		
	}
}
