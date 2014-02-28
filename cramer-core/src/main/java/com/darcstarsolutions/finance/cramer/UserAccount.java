package com.darcstarsolutions.finance.cramer;

import java.io.Serializable;

public class UserAccount implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String name;
	
	private String password;
	
	public UserAccount() {
		name =   "";
		password = "";
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}
