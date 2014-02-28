package com.darcstarsolutions.finance.cramer;

import static org.hamcrest.core.Is.*;
import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class UserAccountTest {
	
	private UserAccount userAccount;

	@Before
	public void setUp() throws Exception {
		userAccount = new UserAccount();
	}

	@After
	public void tearDown() throws Exception {
		userAccount = null;
	}

	@Test
	public void testGetName() {
		assertThat(userAccount.getName(), is(""));
	}

	@Test
	public void testSetName() {
		userAccount.setName("test");
		assertThat(userAccount.getName(), is("test"));
	}

	@Test
	public void testGetPassword() {
		assertThat(userAccount.getPassword(), is(""));
	}

	@Test
	public void testSetPassword() {
		userAccount.setPassword("test");
		assertThat(userAccount.getPassword(), is("test"));
	}

}
