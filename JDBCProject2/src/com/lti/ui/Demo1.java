package com.lti.ui;
import java.sql.*;
import java.time.LocalDate;
import java.util.List;

import com.lti.bean.Account;
import com.lti.service.AccountService;
import com.lti.service.AccountServiceimpl;

public class Demo1 {
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		AccountService service=new AccountServiceimpl();
		Account ob=new Account(999,"Pinky",LocalDate.of(1997,12,23),30000.00);
		service.createNewAccount(ob);
		service.withdraw(ob, 10000.00);
		//service.deleteAccount(ob); // Not implemented
		
		List<Account> alist=service.getAllAccounts();
		for(Account i:alist) System.out.println(i);
	}
}
