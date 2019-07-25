package com.lti.dao;

import java.time.LocalDate;
import java.util.List;

import com.lti.bean.Minister;

public interface MinisterDAO {
	public boolean insertMinister(Minister m);
	public List<Minister> displayMinister();
	public List<Minister> displayMinisterWithK();
	public boolean updateMinister(int m, LocalDate d);
	public boolean deleteMinister(String m);
}
