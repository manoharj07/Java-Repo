package com.lti.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.lti.bean.College;

public class CollegeDAOImp implements CollegeDAO{
	private Connection con;
	@Override
	public boolean insertCollege(College ob) {
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
			PreparedStatement ps1=con.prepareStatement("insert into college values(?,?,?,?,?,?)");
			ps1.setInt(1, ob.getCid());
			ps1.setString(2,ob.getCname());
			ps1.setString(3,ob.getCoursetype());
			ps1.setString(4,ob.getCity());
			ps1.setDouble(5,ob.getFees());
			ps1.setInt(6, ob.getPincode()); 
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
	public List<College> collegesInMumbai() {
		List<College> clist = new ArrayList<College>();
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
			PreparedStatement ps1=con.prepareStatement("select * from college where coursetype='engg' and city='Mumbai'");
			ResultSet rs = ps1.executeQuery();

			while(rs.next()) {
				College m = new College();
				m.setCid(rs.getInt(1));
				m.setCname(rs.getString(2));
				m.setCoursetype(rs.getString(3));
				m.setCity(rs.getString(4));
				m.setFees(rs.getDouble(5));
				m.setPincode(rs.getInt(6));
				clist.add(m);
			}
			System.out.println("Insertion succesful");
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
		return clist;
	}

	@Override
	public List<College> displayAllColleges() {
		List<College> clist = new ArrayList<College>();
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
			PreparedStatement ps1=con.prepareStatement("select * from college");
			ResultSet rs = ps1.executeQuery();

			while(rs.next()) {
				College m = new College();
				m.setCid(rs.getInt(1));
				m.setCname(rs.getString(2));
				m.setCoursetype(rs.getString(3));
				m.setCity(rs.getString(4));
				m.setFees(rs.getDouble(5));
				m.setPincode(rs.getInt(6));
				clist.add(m);
			}
			System.out.println("Insertion succesful");
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
		return clist;
	}

	@Override
	public boolean updateCollegeFees(String cname, double new_fees) {
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
			PreparedStatement ps1=con.prepareStatement("update college set fees=? where cname=?");

			ps1.setDouble(1,new_fees);
			ps1.setString(2,cname);
			ps1.executeUpdate();
			
			System.out.println("Updating succesful");
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
	public boolean deleteCollege(int cid) {
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
			PreparedStatement ps1=con.prepareStatement("delete from college where cid=?");
			ps1.setInt(1,cid);
			ps1.executeUpdate();
			
			System.out.println("Deleting succesful");
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