package com.codingwithrufat.myapplication.models;

import java.util.Map;

public class Answer{
	private String date;
	private boolean success;
	private int timestamp;
	private String base;
	private Map<String, Double> rates;

	public String getDate(){
		return date;
	}

	public boolean isSuccess(){
		return success;
	}

	public int getTimestamp(){
		return timestamp;
	}

	public String getBase(){
		return base;
	}

	public Map<String, Double> getRates() {
		return rates;
	}
}
