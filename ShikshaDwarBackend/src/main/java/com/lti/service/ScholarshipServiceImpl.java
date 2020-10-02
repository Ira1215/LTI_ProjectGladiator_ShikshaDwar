package com.lti.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.lti.dao.ScholarshipDaoImpl;
import com.lti.model.AdminLogin;
import com.lti.model.InstitueLogin;
import com.lti.model.Institute;
import com.lti.model.StudentDetails;
import com.lti.model.StudentLogin;
import com.lti.model.StudentRegistrationDetails;

@Service("service")
@Scope(scopeName = "singleton")
public class ScholarshipServiceImpl implements ScholarshipService{

	@Autowired
	private ScholarshipDaoImpl dao=null;
	
	//STUDENT MODULE
	//ADD METHODS
	@Transactional(propagation = Propagation.REQUIRED)
	@Override
	public boolean addStudentLogin(StudentLogin studentLogin) {
		int result = dao.createStudentLogin(studentLogin);
		return (result==1)?true:false;
	}

	@Transactional(propagation = Propagation.REQUIRED)
	@Override
	public boolean addStudentRegistration(StudentRegistrationDetails studentRegistration) {
		int result= dao.createStudentRegistration(studentRegistration);
		return (result==1)?true:false;
	}

	@Transactional(propagation = Propagation.REQUIRED)
	@Override
	public boolean addStudent(StudentDetails studentApplication) {
		int result = dao.createStudent(studentApplication);
		return (result==1)?true:false;
	}

	//READ METHODS
	@Override
	public StudentLogin getStudentLoginByEmail(String studentEmailId) {
		return dao.readStudentLoginByEmail(studentEmailId);
	}
	
	@Override
	public List<StudentLogin> getAllStudentLogin() {
		return dao.readAllStudentLogin();
	}
	
	@Override
	public StudentDetails getStudentByApplication(long studentApplicationNo) {
		return dao.readStudentByApplication(studentApplicationNo);
	}

	//UPDATE METHOD
	@Transactional(propagation = Propagation.REQUIRED)
	@Override
	public void modifyStudentPassword(StudentLogin studentLogin) {
		dao.updateStudentPassword(studentLogin);
	}

	
	
	//INSTITUTE MODULE
	//ADD METHODS
	
	@Transactional(propagation = Propagation.REQUIRED)
	@Override
	public boolean addInstituteLogin(InstitueLogin instituteLogin) {
		int result= dao.createInstituteLogin(instituteLogin);
		return (result==1)?true:false;
	}

	@Transactional(propagation = Propagation.REQUIRED)
	@Override
	public boolean addInstitute(Institute instituteApplication) {
		int result= dao.createInstitute(instituteApplication);
		return (result==1)?true:false;
	}
	
	//READ METHODS
	
	@Override
	public InstitueLogin getInstituteByDise(String diseCode) {
		return dao.readInstituteByDise(diseCode);
	}
	
	@Override
	public List<InstitueLogin> getAllInstituteLogin() {
		return dao.readAllInstituteLogin();	
	}
	
	@Override
	public Institute getinstituteByInstituteCode(String instituteCode) {
			return dao.readInstituteByInstituteCode(instituteCode);
	}

	//UPDATE METHODS
	
	@Transactional(propagation = Propagation.REQUIRED)
	@Override
	public void modifyInstitutePassword(InstitueLogin instituteLogin) {
		dao.updateInstitutePassword(instituteLogin);
	}

	
	
	//NODAL OFFICER MODULE
	//Read Methods
	@Override
	public AdminLogin getAdminById(String username) {
		return dao.readAdminById(username);
	}
	
	@Override
	public List<AdminLogin> getAllAdminLogin() {
		return dao.readAllAdminLogin();	
	}
	
	@Override
	public List<StudentDetails> getStudentForNodal() {
		return dao.readStudentForNodal();
	}

	@Override
	public List<Institute> getInstituteForNodal() {
		return dao.readInsituteForNodal();
	}
	
	//Update Methods
	@Transactional(propagation = Propagation.REQUIRED)
	@Override
	public void modifyAdminPassword(AdminLogin adminLogin) {
		dao.updateAdminPassword(adminLogin);

	}

	@Transactional(propagation = Propagation.REQUIRED)
	@Override
	public void modifyStudentStatus(StudentDetails studentApplication) {
		dao.updateStudentStatus(studentApplication);
		
	}

	@Transactional(propagation = Propagation.REQUIRED)
	@Override
	public void modifyInstituteStatus(Institute institute) {
		dao.updateInstituteStatus(institute);
		
	}
	
}
