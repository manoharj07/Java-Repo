package com.lti.service;

import java.util.List;

import com.lti.bean.Account;

public interface AccountService {
	public boolean createNewAccount(Account ob);
	public List<Account> getAllAccounts();
	public boolean withdraw(Account ob, double amount);
	public boolean deleteAccount(Account ob);
	public Account getMyAccount(int accno);
	
}
