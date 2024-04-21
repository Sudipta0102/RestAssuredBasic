package com.rest;

import org.hamcrest.Matchers;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.config.LogConfig;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class ReqresGet {
	
	RequestSpecification reqSpec;
	
	@BeforeClass
	void setup() {
		
		reqSpec = RestAssured.given()
				.baseUri("https://reqres.in/")
				.contentType(ContentType.JSON);
		
	}
	
	
//	  @Test(priority = 0) 
//	  void basicTest() {
//	  
//	  RestAssured 
//	  .given()
//	  .spec(reqSpec)
//	  .when()
//	  .get("api/unknown/23") 
//	  .then() 
//	  .log().ifValidationFails()
//	  .statusCode(200) 
//	 // .header("content-type", "application/json; charset=utf-8")
//	  .body("page", Matchers.equalTo(1));
//	  
//	  }
	 
	
	
	// blacklisting header
	
	@Test(priority = 2) 
	void basictest1() {
		
		
		RestAssured
			.given()
			.spec(reqSpec)
			.config(RestAssured.config.logConfig(LogConfig.logConfig().blacklistHeader("Content-Type")))
			.when()
			.get("api/users/2")
			.then()
			.statusCode(200)
			.header("Connection", "keep-alive")
			.body("data.last_name", Matchers.equalTo("Weaver"));
				
	}

	@Test(priority = 3) 
	void basicTest2() {
														
		RestAssured
		.given()
		.spec(reqSpec)
		.config(RestAssured.config.logConfig(LogConfig.logConfig().blacklistHeader("Transfer-Encoding", "Connection")))
		.when()
		.get("api/users/2")
		.then()
		.log().everything()
		.body("data.id", Matchers.equalTo(2));
				
		
	}
	
}
