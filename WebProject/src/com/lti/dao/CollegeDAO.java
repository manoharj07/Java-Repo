package com.lti.dao;

import java.util.List;

import com.lti.bean.College;

public interface CollegeDAO {
	public boolean insertCollege(College ob);
	public List<College> collegesInMumbai();
	public List<College> displayAllColleges();
	public boolean updateCollegeFees(String cname, double new_fees);
	public boolean deleteCollege(int cid);
}