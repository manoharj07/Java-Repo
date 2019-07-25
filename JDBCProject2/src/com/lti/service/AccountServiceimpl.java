package com.lti.service;

import java.util.List;

import javax.print.attribute.DocAttribute;

import com.lti.bean.Account;
import com.lti.dao.AccountDAO;
import com.lti.dao.AccountDAOimpl;

public class AccountServiceimpl implements AccountService {
	private AccountDAO dao= new AccountDAOimpl();
	@Override 
	public boolean createNewAccount(Account ob) {
		return dao.insertAccount(ob);
	}
	@Override
	public List<Account> getAllAccounts() {
		return dao.getAllAccount();
	}
	@Override
	public boolean withdraw(Account ob, double amount) {
		double originalBalance = ob.getBalance();
		originalBalance-=amount;
		ob.setBalance(originalBalance);
		return dao.updateAccount(ob);
	}
	@Override
	public boolean deleteAccount(Account ob) {
		return dao.deleteAccount(ob);
	}
	@Override
	public Account getMyAccount(int accno) {
		return dao.getAccountById(accno);
	}
}
