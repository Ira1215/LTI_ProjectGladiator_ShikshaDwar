package com.lti.service;

import java.util.List;

import com.lti.model.AdminLogin;
import com.lti.model.InstituteLogin;
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
	public StudentDetails getStudentByApplication(long studentApplicationNo);
	
	public List<StudentLogin> getAllStudentLogin();
	public List<StudentRegistrationDetails> getAllStudentRegistration();

	// Update Values in database
	public void modifyStudentPassword(StudentLogin studentLogin);

	public void modifyStudentStatus(StudentDetails studentApplication);

	///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	
	// INSTITUTE MODULE
	// Add Values to DataBase
	public void addInstituteLogin(InstituteLogin instituteLogin);

	public void addInstitute(Institute instituteApplication, InstituteLogin login);

	// Read Values from database
	public InstituteLogin getInstituteByDise(String diseCode);
	public Institute getinstituteByInstituteCode(String instituteCode);
	public List<InstituteLogin> getAllInstituteLogin();
	public List<String> getAllApprovedInstituteCode();
	public List<StudentDetails> getStudentForInstitute(String instituteCode);
	
	// Update Values in database
	public void modifyInstitutePassword(InstituteLogin instituteLogin);

	public void modifyInstituteStatus(Institute institute);

	/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	
	// NODAL OFFICER MODULE
	// Read Values from database
	public AdminLogin getAdminById(String username);


	public List<StudentDetails> getStudentForNodal(String username);

	public List<Institute> getInstituteForNodal(String username);

	// Update Methods
	public void modifyAdminPassword(AdminLogin adminLogin);

	/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	
	// MINISTRY MODULE
	// Read Values
	public List<StudentDetails> getStudentForMinistry();

	public List<Institute> getInstituteForMinistry();
	
	

	// STUDENT LOGIN
	public boolean verifyStudentLogin(StudentLogin login);

	// INSTITUTE LOGIN
	public boolean verifyInstituteLogin(InstituteLogin login);

	// ADMIN LOGIN
	public boolean verifyAdminLogin(AdminLogin login);
	
	
	// OTP GENERATE SERVICE
	public String generateOTP();

}
