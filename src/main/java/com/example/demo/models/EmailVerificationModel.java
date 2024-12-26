package com.example.demo.models;

public class EmailVerificationModel {

	String _id;
	String email;

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	String otp;
	public String get_id() {
		return _id;
	}
	public void set_id(String email) {
		this._id = email;
	}
	public String getOtp() {
		return otp;
	}
	public void setOtp(String otp) {
		this.otp = otp;
	}
	
	
	
}
