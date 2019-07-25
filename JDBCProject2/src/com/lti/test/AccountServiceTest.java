package com.lti.test;

import static org.junit.Assert.assertFalse;
import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.lti.bean.Account;
import com.lti.service.AccountService;
import com.lti.service.AccountServiceimpl;

class AccountServiceTest {
		AccountService service;
		
		@BeforeAll
		public static void before()
		{
			System.out.println("before class");
		}
		
		@AfterAll
		public static void after()
		{
			System.out.println("after class");
		}
		@BeforeEach
		public void beforeTest()
		{
			System.out.println("before each test");
			service=new AccountServiceimpl();
			
		}
		
		@BeforeEach
		public void beforeTest1()
		{
			System.out.println("Before each test");
			service=new AccountServiceimpl();
			
		}
		
		@AfterEach
		public void afterTest()
		{
			System.out.println("After each test");
			service=null;
			
		}
	@Test
	void testcase1() {
		System.out.println("Testcase 1");
		AccountService service= new AccountServiceimpl();
		Account ob =new Account(201,"Mikesh",LocalDate.now(),70000.00);
		//Assertions.assertEquals(true, service.createNewAccount(ob));
		assertEquals(true, service.createNewAccount(ob));
		
		assertFalse(service.createNewAccount(ob));  //
	}
	@Test
	void testcase2()
	{
		System.out.println("Testcase 2");
		AccountService service=new AccountServiceimpl();
		assertNotNull(service.getAllAccounts());
		assertTrue(service.getAllAccounts().size()>1);
	}
	
}
