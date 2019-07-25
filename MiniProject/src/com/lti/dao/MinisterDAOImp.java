package com.lti.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.lti.bean.Minister;

public class MinisterDAOImp implements MinisterDAO{
	private Connection con;
	@Override
	public boolean insertMinister(Minister m) {
		boolean inserted_flag=false;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String username="hr";
		String password="hr";
		try {
			con = DriverManager.getConnection(url,username,password);
			PreparedStatement ps1=con.prepareStatement("insert into chiefminister values(?,?,?,?,?,?)");
			ps1.setInt(1, m.getCid());
			ps1.setString(2,m.getCname());
			ps1.setString(3,m.getCstate());
			ps1.setString(4,m.getCqual());
			ps1.setDate(5,Date.valueOf(m.getCenddate()));
			ps1.setString(6,m.getCparty());
			ps1.executeUpdate();
			System.out.println("Insertion succesful");
			inserted_flag=true;
		}
		catch(SQLException e) {
			System.out.println(e.getMessage());
			inserted_flag=false;
		}
		finally {
			try {
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return inserted_flag;
	}

	@Override
	public List<Minister> displayMinister() {
		List<Minister> mlist = new ArrayList<Minister>();
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String username="hr";
		String password="hr";
		try {
			con = DriverManager.getConnection(url,username,password);
			PreparedStatement ps1=con.prepareStatement("select * from chiefminister");
			ResultSet rs = ps1.executeQuery();
			while(rs.next()) {
				Minister m = new Minister();
				m.setCid(rs.getInt(1));
				m.setCname(rs.getString(2));
				m.setCstate(rs.getString(3));
				m.setCqual(rs.getString(4));
				m.setCenddate(rs.getDate(5).toLocalDate());
				m.setCparty(rs.getString(6));
				mlist.add(m);
			}
			
		}
		catch(SQLException e) {
			System.out.println(e.getMessage());
		}
		finally {
			try {
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return mlist;
	}

	@Override
	public List<Minister> displayMinisterWithK() {
		List<Minister> mlist = new ArrayList<Minister>();
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String username="hr";
		String password="hr";
		try {
			con = DriverManager.getConnection(url,username,password);
			PreparedStatement ps1=con.prepareStatement("select * from chiefminister where cname like 'K%' or cname like 'k%'");
			ResultSet rs = ps1.executeQuery();
			while(rs.next()) {
				Minister m = new Minister();
				m.setCid(rs.getInt(1));
				m.setCname(rs.getString(2));
				m.setCstate(rs.getString(3));
				m.setCqual(rs.getString(4));
				m.setCenddate(rs.getDate(5).toLocalDate());
				m.setCparty(rs.getString(6));
				mlist.add(m);
			}
			
		}
		catch(SQLException e) {
			System.out.println(e.getMessage());
		}
		finally {
			try {
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return mlist;
	}

	@Override
	public boolean updateMinister(int m, LocalDate d) {
		boolean update_flag=false;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String username="hr";
		String password="hr";
		try {
			con = DriverManager.getConnection(url,username,password);
			PreparedStatement ps1=con.prepareStatement("update chiefminister set cenddate=? where cid=?");
			ps1.setDate(1, Date.valueOf(d));
			ps1.setInt(2, m);
			ps1.executeUpdate();
			update_flag=true;
		}
		catch(SQLException e) {
			System.out.println(e.getMessage());
			update_flag=false;
		}
		finally {
			try {
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return update_flag;
	}

	@Override
	public boolean deleteMinister(String m) {
		boolean delete_flag=false;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String username="hr";
		String password="hr";
		try {
			con = DriverManager.getConnection(url,username,password);
			PreparedStatement ps1=con.prepareStatement("delete from chiefminister where cstate=?");
			ps1.setString(1,m);
			ps1.executeUpdate();
			delete_flag=true;
		}
		catch(SQLException e) {
			System.out.println(e.getMessage());
			delete_flag=false;
		}
		finally {
			try {
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return delete_flag;
	}
	
}
