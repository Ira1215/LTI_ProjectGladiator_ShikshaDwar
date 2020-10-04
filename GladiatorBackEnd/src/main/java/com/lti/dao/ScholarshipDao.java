package com.lti.dao;

import java.util.List;

import com.lti.model.AdminLogin;
import com.lti.model.InstitueLogin;
import com.lti.model.Institute;
import com.lti.model.StudentDetails;
import com.lti.model.StudentLogin;
import com.lti.model.StudentRegistrationDetails;

public interface ScholarshipDao {
	
	//STUDENT MODULE 
	//Add Values to DataBase
	public int createStudentLogin(StudentLogin studentLogin);
	public int createStudentRegistration(StudentRegistrationDetails studentRegistration);
	public int createStudent(StudentDetails studentApplication);
	//Read Values from database
	public StudentLogin readStudentLoginByEmail(String studentEmailId);
	public List<StudentLogin> readAllStudentLogin();
	public StudentDetails readStudentByApplication(long studentApplicationNo);
	//Update Values in database
	public void updateStudentPassword(StudentLogin studentLogin);
	public void updateStudentStatus(StudentDetails studentApplication);
	
	
	//INSTITUTE MODULE
	//Add Values to DataBase
	public int createInstituteLogin(InstitueLogin instituteLogin);
	public int createInstitute(Institute instituteApplication);
	//Read Values from database
	public InstitueLogin readInstituteByDise(String diseCode);
	public List<InstitueLogin> readAllInstituteLogin();
	public Institute readInstituteByInstituteCode(String instituteCode);
	public List<StudentDetails> readStudentForInstitute(String applicationStatus);
	public List<StudentRegistrationDetails> readStudentByInstitute(String instituteCode);
	//Update Values in database
	public void updateInstitutePassword(InstitueLogin instituteLogin);
	public void updateInstituteStatus(Institute institute);
	
	
	//NODAL OFFICER MODULE
	//Read Values from database
	public AdminLogin readAdminById(String username);
	public List<AdminLogin> readAllAdminLogin();
	public List<Institute> readInsituteForNodal();	
	public List<StudentDetails> readStudentForNodal();
	//Update Methods
	public void updateAdminPassword(AdminLogin adminLogin);
	
	

	//MINISTRY MODULE
	//Read Values from database
	public List<Institute> readInstituteForMinistry();
	public List<StudentDetails> readStudentForMinistry();
}
