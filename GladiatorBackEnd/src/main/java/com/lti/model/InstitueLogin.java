package com.lti.model;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "INSTITUTE_LOGIN")
public class InstitueLogin implements Serializable {
	
	@Id
	@Column(name = "DISE_CODE")
	private String diseCode;
	
	@Column(name = "INSTITUTE_PASSWORD")
	private String instituePassword;
	
	//Default Constructor
	public InstitueLogin() {
		
	}
	
	//Parameterized Constructor
	public InstitueLogin(String diseCode, String instituePassword) {
		super();
		this.diseCode = diseCode;
		this.instituePassword = instituePassword;
	}

	
	//Getter and setter
	public String getDiseCode() {
		return diseCode;
	}

	public void setDiseCode(String diseCode) {
		this.diseCode = diseCode;
	}

	public String getInstituePassword() {
		return instituePassword;
	}

	public void setInstituePassword(String instituePassword) {
		this.instituePassword = instituePassword;
	}

	//toString Method
	@Override
	public String toString() {
		return "InstitueLogin [diseCode=" + diseCode + ", instituePassword=" + instituePassword + "]";
	}
	
}