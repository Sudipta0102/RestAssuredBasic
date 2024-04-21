package com.pojo;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ResponsePojo {
	
	@JsonProperty ("name")
	private String name;
	
	@JsonProperty ("job")
	private String job;
	
	@JsonProperty ("id")
	private int id;
	
	@JsonProperty ("createdAt")
	private String date;
	
	public ResponsePojo() {
		// TODO Auto-generated constructor stub
	}
	
	public ResponsePojo(String name, String job, int id, String date) {

		this.name = name;
		this.job = job;
		this.id = id;
		this.date = date;
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

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	
	
}
