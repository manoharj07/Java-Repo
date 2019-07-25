package com.lti.service;

import java.time.LocalDate;
import java.util.List;

import com.lti.bean.Minister;

public interface MinisterService {
	public boolean addMinister(Minister m); //a
	public List<Minister> displayAll(); //b
	public List<Minister> displayWithK(); //c
	public boolean update(int m, LocalDate d); //d
	public boolean delete(String m); //e
}
