package com.rest;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

public class TestFirst {

	@Test
	public void testFirst() {
		given()
		.when()
		.then();
	}
}
