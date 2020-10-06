package com.lti.model;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.stereotype.Component;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Component
@Entity
@Table(name = "STUDENT_REGISTRATION_DETAILS")
public class StudentRegistrationDetails implements Serializable {
	
	@Id
	@Column(name="STUDENT_AADHAR_NO")
	private String studentAadharNo;
	
	@Column(name = "STUDENT_NAME")
	private String studentName;
	
	@Column(name = "STUDENT_GENDER")
	private String studentGender;
	
	@Column(name = "STUDENT_MOBILE")
	private String studentMobile;
	
	@Column(name = "STUDENT_INSTITUTION")
	private String studentInstitution;
	
	@Temporal(TemporalType.DATE)
	@Column(name="STUDENT_DOB")
	private Date studentDob;
	
	@OneToOne
	@JoinColumn(name = "STUDENT_EMAIL")
	//@JsonBackReference
	private StudentLogin login;

	@JsonManagedReference
	@OneToMany(mappedBy = "registration", cascade = CascadeType.ALL)
	private Set<StudentDetails> application;
	
	@ManyToOne
	@JoinColumn(name = "INSTITUTE_CODE")
	private Institute institute;
	
	//Default constructor
	public StudentRegistrationDetails()
	{
		
	}
	
	//Parameterized Constructor
	public StudentRegistrationDetails(String studentName, String studentGender, String studentMobile,
			String studentInstitution, String studentAadharNo) {
		super();
		this.studentName = studentName;
		this.studentGender = studentGender;
		this.studentMobile = studentMobile;
		this.studentInstitution = studentInstitution;
		this.studentAadharNo = studentAadharNo;
	}

	//Getter Setter
	public String getStudentName() {
		return studentName;
	}

	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}

	public String getStudentGender() {
		return studentGender;
	}

	public void setStudentGender(String studentGender) {
		this.studentGender = studentGender;
	}

	public String getStudentMobile() {
		return studentMobile;
	}

	public void setStudentMobile(String studentMobile) {
		this.studentMobile = studentMobile;
	}

	public String getStudentInstitution() {
		return studentInstitution;
	}

	public void setStudentInstitution(String studentInstitution) {
		this.studentInstitution = studentInstitution;
	}

	public Date getStudentDob() {
		return studentDob;
	}

	public void setStudentDob(Date date) {
		this.studentDob = date;
	}

	public String getStudentAadharNo() {
		return studentAadharNo;
	}

	public void setStudentAadharNo(String studentAadharNo) {
		this.studentAadharNo = studentAadharNo;
	}
	
	//@JsonBackReference
	public StudentLogin getLogin() {
		return login;
	}

	public void setLogin(StudentLogin login) {
		this.login = login;
	}

	//@JsonManagedReference
	public Set<StudentDetails> getApplication() {
		return application;
	}

	public void setApplication(Set<StudentDetails> application) {
		this.application = application;
	}
	
	//@JsonBackReference
	public Institute getInstitute() {
		return institute;
	}

	public void setInstitute(Institute institute) {
		this.institute = institute;
	}


	
	//toString Method
	@Override
	public String toString() {
		return "StudentRegistrationDetails [studentAadharNo=" + studentAadharNo + ", studentName=" + studentName
				+ ", studentGender=" + studentGender + ", studentMobile=" + studentMobile + ", studentInstitution="  
				+ studentInstitution + ", studentDob=" + studentDob + "]";
	}

	
}
