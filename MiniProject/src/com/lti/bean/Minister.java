package com.lti.bean;

import java.time.LocalDate;

public class Minister {
	private int cid;
	private String cname;
	private String cstate;
	private String cqual;
	private LocalDate cenddate;
	private String cparty;
	
	public Minister() {}

	public Minister(int cid, String cname, String cstate, String cqual, LocalDate cenddate, String cparty) {
		super();
		this.cid = cid;
		this.cname = cname;
		this.cstate = cstate;
		this.cqual = cqual;
		this.cenddate = cenddate;
		this.cparty = cparty;
	}

	public int getCid() {
		return cid;
	}

	public void setCid(int cid) {
		this.cid = cid;
	}

	public String getCname() {
		return cname;
	}

	public void setCname(String cname) {
		this.cname = cname;
	}

	public String getCstate() {
		return cstate;
	}

	public void setCstate(String cstate) {
		this.cstate = cstate;
	}

	public String getCqual() {
		return cqual;
	}

	public void setCqual(String cqual) {
		this.cqual = cqual;
	}

	public LocalDate getCenddate() {
		return cenddate;
	}

	public void setCenddate(LocalDate cenddate) {
		this.cenddate = cenddate;
	}

	public String getCparty() {
		return cparty;
	}

	public void setCparty(String cparty) {
		this.cparty = cparty;
	}

	@Override
	public String toString() {
		return "Minister [cid=" + cid + ", cname=" + cname + ", cstate=" + cstate + ", cqual=" + cqual + ", cenddate="
				+ cenddate + ", cparty=" + cparty + "]";
	}
	
}
