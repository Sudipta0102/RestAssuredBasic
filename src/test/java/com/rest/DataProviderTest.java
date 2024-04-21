package com.rest;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.pojo.RequestPojo;
import com.pojo.ResponsePojo;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class DataProviderTest {
	
	@BeforeClass
	void setup() {
		
		RequestSpecBuilder specbuild = new RequestSpecBuilder();
		
		specbuild.setBaseUri("https://reqres.in")
				 .setContentType(ContentType.JSON);
		
		RestAssured.requestSpecification = specbuild.build();
		
	}
	
	@Test(dataProvider = "users")
	void basicPost(String name, String job) {
		
		RequestPojo req = new RequestPojo();
		req.setName(name);
		req.setJob(job);
		
		ResponsePojo pojores =
		RestAssured
			.given()
			.body(req)
			.log().body()
			.when()
			.post("/api/users")
			.then()
			.log().body()
			.extract()
			.response()
			.as(ResponsePojo.class);
		
		Assert.assertEquals(req.getName(), pojores.getName());
		Assert.assertTrue(pojores.getId()>0);
	}

	@DataProvider(name = "users")
	Object[][] getUser(){
		return new Object[][] {
			{"sam", "shop"},
			{"cam", "cop"},
			{"dam", "dop"},
			{"fam", "fap"},
			{"jam"}
		};	
	}
	
}
