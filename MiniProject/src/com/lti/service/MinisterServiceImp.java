package com.lti.service;

import java.time.LocalDate;
import java.util.List;

import com.lti.bean.Minister;
import com.lti.dao.MinisterDAO;
import com.lti.dao.MinisterDAOImp;

public class MinisterServiceImp implements MinisterService{
	private MinisterDAO dao = new MinisterDAOImp();
	@Override
	public boolean addMinister(Minister m) {
		return dao.insertMinister(m);
	}

	@Override
	public List<Minister> displayAll() {
		return dao.displayMinister();
	}

	@Override
	public List<Minister> displayWithK() {	
		return dao.displayMinisterWithK();
	}

	@Override
	public boolean update(int m, LocalDate d) {
		return dao.updateMinister(m,d);
	}

	@Override
	public boolean delete(String m) {
		return dao.deleteMinister(m);
	}	
}
