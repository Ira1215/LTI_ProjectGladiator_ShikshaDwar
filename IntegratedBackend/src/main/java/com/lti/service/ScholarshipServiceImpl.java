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
public class ScholarshipServiceImpl implements ScholarshipService {

	/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	@Autowired
	private ScholarshipDaoImpl dao = null;

	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	// STUDENT
	// ADD STUDENT LOGIN DETAILS

	@Transactional(propagation = Propagation.REQUIRED)
	@Override
	public void addStudentLogin(StudentLogin studentLogin) {
		dao.createStudentLogin(studentLogin);
	}

	// STUDENT
	// ADD STUDENT REGISTRATION DETAILS

	@Transactional(propagation = Propagation.REQUIRED)
	@Override
	public void addStudentRegistration(StudentRegistrationDetails studentRegistration) {
		dao.createStudentRegistration(studentRegistration);
	}

	// STUDENT
	// ADD STUDENT SCHOLARSHIP APPLICATION DETAILS

	@Transactional(propagation = Propagation.REQUIRED)
	@Override
	public void addStudent(StudentDetails studentApplication, StudentRegistrationDetails student, StudentLogin login, Institute institute) {
		student.setLogin(login);
		student.setInstitute(institute);
		studentApplication.setRegistration(student);
		dao.createStudent(studentApplication);
		
	}

	
	
	//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	// READ METHODS
	@Override
	public StudentLogin getStudentLoginByEmail(String studentEmailId) {
		return dao.readStudentLoginByEmail(studentEmailId);
	}
	
	@Override
	public StudentDetails getStudentByApplication(long studentApplicationNo) {
		return dao.readStudentByApplication(studentApplicationNo);
	}

	// UPDATE METHOD
	@Transactional(propagation = Propagation.REQUIRED)
	@Override
	public void modifyStudentPassword(StudentLogin studentLogin) {
		dao.updateStudentPassword(studentLogin);
	}

	// INSTITUTE MODULE
	// ADD METHODS

	@Transactional(propagation = Propagation.REQUIRED)
	@Override
	public void addInstituteLogin(InstitueLogin instituteLogin) {
		dao.createInstituteLogin(instituteLogin);
	}

	@Transactional(propagation = Propagation.REQUIRED)
	@Override
	public void addInstitute(Institute instituteApplication, InstitueLogin login) {
		instituteApplication.setLogin(login);
		dao.createInstitute(instituteApplication);
	}

	// READ METHODS

	@Override
	public InstitueLogin getInstituteByDise(String diseCode) {
		return dao.readInstituteByDise(diseCode);
	}


	@Override
	public Institute getinstituteByInstituteCode(String instituteCode) {
		return dao.readInstituteByInstituteCode(instituteCode);
	}

	// UPDATE METHODS

	@Transactional(propagation = Propagation.REQUIRED)
	@Override
	public void modifyInstitutePassword(InstitueLogin instituteLogin) {
		dao.updateInstitutePassword(instituteLogin);
	}

	// NODAL OFFICER MODULE
	// Read Methods
	@Override
	public AdminLogin getAdminById(String username) {
		return dao.readAdminById(username);
	}

	@Override
	public List<StudentDetails> getStudentForNodal() {
		return dao.readStudentForNodal();
	}

	@Override
	public List<Institute> getInstituteForNodal() {
		return dao.readInsituteForNodal();
	}

	// Update Methods
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

	// MINISTRY MODULE
	// Read Values

	@Override
	public List<StudentDetails> getStudentForMinistry() {
		return dao.readStudentForMinistry();
	}

	@Override
	public List<Institute> getInstituteForMinistry() {
		return dao.readInstituteForMinistry();
	}

	///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	// LOGIN SERVICE
	// STUDENT LOGIN

	@Override
	public boolean verifyStudentLogin(StudentLogin login) {
		try {
			StudentLogin l = dao.readStudentLoginByEmail(login.getStudentEmailId());
			if (l.getStudentPassword().equals(login.getStudentPassword())) {
				return true;
			}
		} catch (Exception e) {
			return false;
		}
		return false;
	}

	// INSTITUTE LOGIN

	@Override
	public boolean verifyInstituteLogin(InstitueLogin login) {
		try {
			InstitueLogin i = dao.readInstituteByDise(login.getDiseCode());
			if (i.getInstituePassword().equals(login.getInstituePassword())) {
				return true;
			}
		} catch (Exception e) {
			return false;
		}
		return false;
	}

	// ADMIN LOGIN
	@Override
	public boolean verifyAdminLogin(AdminLogin login) {
		try {
			AdminLogin a = dao.readAdminById(login.getUsername());
			if (a.getPassword().equals(login.getPassword())) {
				return true;
			}
		} catch (Exception e) {
			return false;
		}
		return false;
	}

	//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	// OTP SERVICE
	// FORGOT PASSWORD FOR STUDENT

	@Override
	public String generateOTP() {
		int randomPin = (int) (Math.random() * 900000) + 100000;
		String otp = String.valueOf(randomPin);
		return otp;
	}

	
	

	//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
}
