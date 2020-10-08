package com.lti.dao;

import java.util.List;

import com.lti.model.AdminLogin;
import com.lti.model.InstituteLogin;
import com.lti.model.Institute;
import com.lti.model.StudentDetails;
import com.lti.model.StudentLogin;
import com.lti.model.StudentRegistrationDetails;

public interface ScholarshipDao {
	
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	//STUDENT 
	//Add Values to DataBase
	public void createStudentLogin(StudentLogin studentLogin);
	public void createStudentRegistration(StudentRegistrationDetails studentRegistration);
	public void createStudent(StudentDetails studentApplication);
	
	/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	//STUDENT
	//Read Values from database
	public StudentLogin readStudentLoginByEmail(String studentEmailId);
	public StudentDetails readStudentByApplication(long studentApplicationNo);
	public List<StudentLogin> readAllStudentLogin();
	public List<StudentRegistrationDetails> readAllStudentRegistration();
	public StudentRegistrationDetails readStudentDetailsByEmail(String email);
	
	/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	
	//STUDENT
	//Update Values in database
	public void updateStudentPassword(StudentLogin studentLogin);
	public void updateStudentStatus(StudentDetails studentApplication);
	
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	
	
	
	
	///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	
	//INSTITUTE 
	//Add Values to DataBase
	public void createInstituteLogin(InstituteLogin instituteLogin);
	public void createInstitute(Institute instituteApplication);
	
	/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	
	//INSTITUTE
	//Read Values from database
	public InstituteLogin readInstituteByDise(String diseCode);
	public Institute readInstituteByInstituteCode(String instituteCode);
	public List<StudentDetails> readStudentForInstitute(String instituteCode);
	public List<String> readAllApprovedInstituteCode();
	public List<InstituteLogin> readAllInstituteLogin();
	public Institute readInstituteByDiseCode(String diseCode);
	
	/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	
	//INSTITUTE
	//Update Values in database
	public void updateInstitutePassword(InstituteLogin instituteLogin);
	public void updateInstituteStatus(Institute institute);
	
	//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	
	
	
	
	//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	
	//NODAL OFFICER MODULE
	//Read Values from database
	public AdminLogin readAdminById(String username);
	public List<Institute> readInsituteForNodal(String username);	
	public List<StudentDetails> readStudentForNodal(String username);
	//Update Methods
	public void updateAdminPassword(AdminLogin adminLogin);
	
	
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	
	//MINISTRY MODULE
	//Read Values from database
	public List<Institute> readInstituteForMinistry();
	public List<StudentDetails> readStudentForMinistry();

	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
}
