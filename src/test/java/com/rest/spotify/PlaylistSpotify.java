package com.rest.spotify;

import static org.hamcrest.Matchers.*;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.filter.log.LogDetail;
import io.restassured.http.ContentType;

public class PlaylistSpotify {
	
	String access_token = "BQDb4-KzsdzVXzXSGuLom2DmZkIJMWu5vRf_jSsIfYz7m7Di47xXm_Y83CKSXIrK9TrVyrmliYONiseLMcNtcbIamT5TFRBJINuVAHi-ebOq9dsup2zJk82iMqFhVK8iXh-skgkmDMBLZwjwNHrZ-5WiHe7TjN7cf3-ILhXW5KBcnFOJTl4WviSMF06ohpcB09SiAr8ljOxNVKvc0JTjYd5s_8ZQDG4YqJZZp3-d5lsJrESvMAZ6-3zdEj_PldeQiEf7nlAAkwMvHal6";

	@BeforeClass
	void setup() {
		
		RequestSpecBuilder spec = new RequestSpecBuilder();
		spec.setBaseUri("https://api.spotify.com/")
			.setAccept(ContentType.JSON)
			.setBasePath("v1/")
			.addHeader("Authorization", "Bearer "+access_token)
			.log(LogDetail.ALL);		
		RestAssured.requestSpecification = spec.build();
		
		
		ResponseSpecBuilder specRes = new ResponseSpecBuilder();		
		specRes.log(LogDetail.ALL);
		RestAssured.responseSpecification = specRes.build();
	}
	
	
	@Test
	void createPlaylist() {
		
		String payload = "{\r\n"
				+ "    \"name\": \"New Pseudo Playlist\",\r\n"
				+ "    \"description\": \"New Pseudo playlist description\",\r\n"
				+ "    \"public\": false\r\n"
				+ "}";
		
		RestAssured
			.given()
			.body(payload)
			.when()
			.post("users/31y6ngggfbesnfygkvmleaduvz7q/playlists")
			.then()
			.statusCode(201)
			.body("name", equalTo("New Pseudo Playlist"));
		
	
		System.out.println("------------------- THE END --------------------");
	}
	
	@Test
	void getPlaylist() {
		
		RestAssured
			.when()
			.get("playlists/2vuw3zxpvp34NoI64gRueY")
			.then()
			.statusCode(200);
	}
}
