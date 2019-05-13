package com.example.connectit;

public class signupmodel {
	int id;
	String name,pass;
	public signupmodel(String s1, String s2) {
		// TODO Auto-generated constructor stub
		this.name=s1;
		this.pass=s2;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPass() {
		return pass;
	}
	public void setPass(String pass) {
		this.pass = pass;
	}
	

}
