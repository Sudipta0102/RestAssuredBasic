package com.pojo;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

//@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties
public class RequestPojo {

	@JsonProperty
	private String name;
	
	@JsonProperty
	//@JsonInclude(JsonInclude.Include.NON_EMPTY)
	@JsonIgnore
	private String job;
	
	public RequestPojo(String name, String job) {
		
		this.name = name;
		this.job = job;
		
	}
	
	public RequestPojo() {
		// TODO Auto-generated constructor stub
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getJob() {
		return job;
	}

	public void setJob(String job) {
		this.job = job;
	}
	
}
