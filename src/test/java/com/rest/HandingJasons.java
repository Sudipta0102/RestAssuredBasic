package com.rest;

import java.util.List;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.payload.Courses;

import io.restassured.path.json.JsonPath;

public class HandingJasons {
	
	@Test
	public void getCourseSize() {
		
		JsonPath json = new JsonPath(Courses.getCourses());
		
		int count = json.getInt("courses.size()");
		
		System.out.println("course count: "+count);
		
		System.out.println("courses: "+ json.getList("courses"));
		
		System.out.println("course names: "+ json.getList("courses.title"));
		
		List<Integer> course_prices = json.getList("courses.price");
		System.out.println("course prices: "+ course_prices);
		
		int firstCoursePrice = json.getInt("courses[0].price"); 
		System.out.println("First Course Price: "+ firstCoursePrice);
		
		// get the course name and corresponding course prices
		for(int i=0;i<count;i++) {
			System.out.println(json.getString("courses["+i+"].title") +" : "+ json.getInt("courses["+i+"].price"));
		}
		
		// find number of copies sold by RPA course
		for(int i=0;i<count;i++) {
			String courseName = json.get("courses["+i+"].title");
			if(courseName.equals("RPA")) {
				System.out.println("Copies sold for RPA:"+ json.get("courses["+i+"].copies"));
				break;
			}
		}
		
		//get sum of all course fees
		int actualSum = 0;
		int expectedSum = 135;
		for(int i=0;i<count;i++) {
			actualSum += json.getInt("courses["+i+"].price");
		}
		
		System.out.println("Price of all couses: " + actualSum);
		
		Assert.assertEquals(actualSum, expectedSum);
	}

}
