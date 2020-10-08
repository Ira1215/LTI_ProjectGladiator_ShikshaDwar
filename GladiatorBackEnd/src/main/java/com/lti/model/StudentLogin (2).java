package com.lti.model;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name = "STUDENT_LOGIN")
public class StudentLogin implements Serializable{
	@Id
	@Column(name="STUDENT_EMAIL_ID")
	private String studentEmailId;
	
	@Column(name="STUDENT_PASSWORD")
	private String studentPassword;
	
	//@JsonManagedReference
	@OneToOne(mappedBy = "login", fetch = FetchType.LAZY)
	private StudentRegistrationDetails student;
	
	//Default Constructor
	public StudentLogin()
	{
		
	}
	
	//Parameterized Constructor
	public StudentLogin(String studentEmailId, String studentPassword) {
		super();
		this.studentEmailId = studentEmailId;
		this.studentPassword = studentPassword;
	}
	
	//Getter and setter
	public String getStudentEmailId() {
		return studentEmailId;
	}
	public void setStudentEmailId(String studentEmailId) {
		this.studentEmailId = studentEmailId;
	}
	public String getStudentPassword() {
		return studentPassword;
	}
	public void setStudentPassword(String studentPassword) {
		this.studentPassword = studentPassword;
	}
	
	//@JsonManagedReference
	public StudentRegistrationDetails getStudent() {
		return student;
	}

	public void setStudent(StudentRegistrationDetails student) {
		this.student = student;
	}
	
	
	//toString Method
	@Override
	public String toString() {
		return "StudentLogin [studentEmailId=" + studentEmailId + ", studentPassword=" + studentPassword + "]";
	}

	
	

}
