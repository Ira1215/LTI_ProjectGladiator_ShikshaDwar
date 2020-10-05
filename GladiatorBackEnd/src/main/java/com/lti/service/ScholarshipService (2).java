package com.lti.service;

import java.util.List;

import com.lti.model.AdminLogin;
import com.lti.model.InstitueLogin;
import com.lti.model.Institute;
import com.lti.model.StudentDetails;
import com.lti.model.StudentLogin;
import com.lti.model.StudentRegistrationDetails;

public interface ScholarshipService {

	// STUDENT MODULE
	// Add Values to DataBase
	public void addStudentLogin(StudentLogin studentLogin);

	public void addStudentRegistration(StudentRegistrationDetails studentRegistration);

	public void addStudent(StudentDetails studentApplication, StudentRegistrationDetails student, StudentLogin login, Institute institute);

	// Read Values from database
	public StudentLogin getStudentLoginByEmail(String studentEmailId);
	
	public StudentRegistrationDetails getStudentByAadhar(String studentAadharNo);

	public StudentDetails getStudentByApplication(long studentApplicationNo);

	// Update Values in database
	public void modifyStudentPassword(StudentLogin studentLogin);

	public void modifyStudentStatus(StudentDetails studentApplication);

	// INSTITUTE MODULE
	// Add Values to DataBase
	public boolean addInstituteLogin(InstitueLogin instituteLogin);

	public boolean addInstitute(Institute instituteApplication);

	// Read Values from database
	public InstitueLogin getInstituteByDise(String diseCode);

	public List<InstitueLogin> getAllInstituteLogin();

	public Institute getinstituteByInstituteCode(String instituteCode);

	// Update Values in database
	public void modifyInstitutePassword(InstitueLogin instituteLogin);

	public void modifyInstituteStatus(Institute institute);

	// NODAL OFFICER MODULE
	// Read Values from database
	public AdminLogin getAdminById(String username);

	public List<AdminLogin> getAllAdminLogin();

	public List<StudentDetails> getStudentForNodal();

	public List<Institute> getInstituteForNodal();

	// Update Methods
	public void modifyAdminPassword(AdminLogin adminLogin);

	// MINISTRY MODULE
	// Read Values
	public List<StudentDetails> getStudentForMinistry();

	public List<Institute> getInstituteForMinistry();
	
	

	// STUDENT LOGIN
	public boolean verifyStudentLogin(StudentLogin login);

	// INSTITUTE LOGIN
	public boolean verifyInstituteLogin(InstitueLogin login);

	// ADMIN LOGIN
	public boolean verifyAdminLogin(AdminLogin login);
	
	
	// OTP GENERATE SERVICE
	public String generateOTP();

}
