package com.lti.service;
import com.lti.dao.*;

import java.util.List;

import com.lti.bean.College;

public class CollegeServiceImp implements CollegeService{
	private CollegeDAO dao = new CollegeDAOImp();
	@Override
	public boolean addCollege(College ob) {
		return dao.insertCollege(ob);
	}

	@Override
	public List<College> collegesInMumbaiEngg() {
		return dao.collegesInMumbai();
	}

	@Override
	public List<College> displayAllColleges() {
		return dao.displayAllColleges();
	}

	@Override
	public boolean changeCollegeFees(String cname, double new_fees) {
		return dao.updateCollegeFees(cname,new_fees);
	}

	@Override
	public boolean removeCollege(int cid) {
		return dao.deleteCollege(cid);
	}
}

