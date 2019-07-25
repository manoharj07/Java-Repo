package com.lti.service;

import java.util.List;

import com.lti.bean.College;

public interface CollegeService {
	public boolean addCollege(College ob);
	public List<College> collegesInMumbaiEngg();
	public List<College> displayAllColleges();
	public boolean changeCollegeFees(String cname, double new_fees);
	public boolean removeCollege(int cid);
}