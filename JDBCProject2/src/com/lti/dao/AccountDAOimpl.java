package com.lti.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import com.lti.bean.Account;

public class AccountDAOimpl implements AccountDAO {
	private Connection con;
	@Override
	public boolean insertAccount(Account ob) {
		Boolean inserted=false;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException e1) {
			e1.printStackTrace();
		}
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String username="hr";
		String password="hr";
		try {
			con = DriverManager.getConnection(url,username,password);
			System.out.println("Connected");
			PreparedStatement ps1=con.prepareStatement("insert into Account values(?,?,?,?)");
			ps1.setInt(1, ob.getAid());
			ps1.setString(2, ob.getAname());
			//ps1.setDate(3, null);//ob.getDob());
			ps1.setDate(3,Date.valueOf(ob.getDob()));
			ps1.setDouble(4, ob.getBalance());
			int i=ps1.executeUpdate();
			System.out.println("Records inserted is"+i);
			
			inserted=true;
		}
		catch(SQLException e){
			System.out.println(e.getMessage());
			inserted=false;
		}
		finally {
			try {
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return inserted;
	}

	@Override
	public boolean updateAccount(Account ob) {
		Boolean updated_flag = false;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException e1) {
			e1.printStackTrace();
		}
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String username="hr";
		String password="hr";
		try {
			con = DriverManager.getConnection(url,username,password);
			System.out.println("Connected");
			PreparedStatement ps1=con.prepareStatement("update account set aname=?,dob=?,balance=? where aid=?");

			ps1.setString(1, ob.getAname());
			ps1.setDate(2,Date.valueOf(ob.getDob()));
			ps1.setDouble(3, ob.getBalance());
			ps1.setInt(4, ob.getAid());

			int i=ps1.executeUpdate();
			System.out.println(i+"records updated");
			
			updated_flag = true;
		}
		catch(SQLException e){
			System.out.println(e.getMessage());
			updated_flag = false;
		}
		finally {
			try {
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return updated_flag;
	}

	@Override
	public boolean deleteAccount(Account ob) {
		
		return false;
	}

	@Override
	public Account getAccountById(int aid) {
		Account ob = new Account();
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException e1) {
			e1.printStackTrace();
		}
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String username="hr";
		String password="hr";
		try {
			con = DriverManager.getConnection(url,username,password);
			System.out.println("Connected");
			PreparedStatement ps1=con.prepareStatement("select from account where aid=?");
			ps1.setInt(1, aid);

			ResultSet rs = ps1.executeQuery();
			ob.setAid(rs.getInt(1));
			ob.setAname(rs.getString(2));
			ob.setDob(rs.getDate(3).toLocalDate());
			ob.setBalance(rs.getDouble(4));
		}
		catch(SQLException e){
			System.out.println(e.getMessage());
		}
		finally {
			try {
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return ob;
	}

	@Override
	public List<Account> getAllAccount() {
		List<Account> acclist=new ArrayList<Account>();
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException e1) {
			e1.printStackTrace();
		}
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String username="hr";
		String password="hr";
		try {
			con = DriverManager.getConnection(url,username,password);
			System.out.println("Connected");
			PreparedStatement ps1=con.prepareStatement("select * from Account");
			ResultSet rs = ps1.executeQuery();
			while(rs.next()) {
				Account ob = new Account();
				ob.setAid(rs.getInt(1));
				ob.setAname(rs.getString(2));
				ob.setDob(rs.getDate(3).toLocalDate());
				ob.setBalance(rs.getDouble(4));
				acclist.add(ob);
			}
		}
		catch(SQLException e){
			System.out.println(e.getMessage());
		}
		finally {
			try {
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return acclist;
	}

}
