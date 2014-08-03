package com.example.tests;

public class ValueObject {
	
	public String name;
	public String header;
	public String footer;
	
	public ValueObject() {		
	}

	public ValueObject(String groupname, String header, String footer) {
		this.name = groupname;
		this.header = header;
		this.footer = footer;
	}
	
}