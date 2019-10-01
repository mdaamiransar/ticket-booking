package com.ticketbooking.vo;

public class PassengerContact {

	private String bp;
	private String dp;
	private String email;
	private String mobile;
	private String idProof;
	
	public String getBp() {
		return bp;
	}
	public void setBp(String bp) {
		this.bp = bp;
	}
	public String getDp() {
		return dp;
	}
	public void setDp(String dp) {
		this.dp = dp;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getIdProof() {
		return idProof;
	}
	public void setIdProof(String idProof) {
		this.idProof = idProof;
	}
	
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	
	@Override
	public String toString() {
		return "PassengerContact [bp=" + bp + ", dp=" + dp + ", email=" + email + ", mobile=" + mobile + ", idProof="
				+ idProof + "]";
	}
	
}
