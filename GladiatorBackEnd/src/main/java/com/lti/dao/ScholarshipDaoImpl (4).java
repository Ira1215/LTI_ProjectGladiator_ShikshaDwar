package com.lti.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.lti.dto.StudentForInstituteDto;
import com.lti.model.AdminLogin;
import com.lti.model.InstituteLogin;
import com.lti.model.Institute;
import com.lti.model.StudentDetails;
import com.lti.model.StudentLogin;
import com.lti.model.StudentRegistrationDetails;

@Repository
public class ScholarshipDaoImpl implements ScholarshipDao {

	@PersistenceContext
	private EntityManager entityManager;

	public ScholarshipDaoImpl() {

	}

	/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	// STUDENT
	// ADD STUDENT LOGIN TO DB

	@Transactional(propagation = Propagation.MANDATORY)
	@Override
	public void createStudentLogin(StudentLogin studentLogin) {
		entityManager.persist(studentLogin);
	}

	// STUDENT
	// ADD STUDENT REGISTRATION TO DB

	@Transactional(propagation = Propagation.MANDATORY)
	@Override
	public void createStudentRegistration(StudentRegistrationDetails studentRegistration) {
		entityManager.persist(studentRegistration);
	}

	// STUDENT
	// ADD STUDENT APPLICATION TO DB

	@Transactional(propagation = Propagation.MANDATORY)
	@Override
	public void createStudent(StudentDetails studentApplication) {
		entityManager.persist(studentApplication);
	}

	///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	// STUDENT
	// READ STUDENT BY EMAIL ID
	@Override
	public StudentLogin readStudentLoginByEmail(String studentEmailId) {
		return entityManager.find(StudentLogin.class, studentEmailId);
	}

	// STUDENT
	// READ STUDENT BY APLLICATION NUMBER

	@Override
	public StudentDetails readStudentByApplication(long studentApplicationNo) {
		return entityManager.find(StudentDetails.class, studentApplicationNo);
	}
	
	@Override
	public List<StudentLogin> readAllStudentLogin() {
		String jpql="select l from StudentLogin l";
		TypedQuery<StudentLogin> tquery= entityManager.createQuery(jpql, StudentLogin.class);
		return tquery.getResultList();
	}

	@Override
	public List<StudentRegistrationDetails> readAllStudentRegistration() {
		String jpql="select s from StudentRegistrationDetails s";
		TypedQuery<StudentRegistrationDetails> tquery= entityManager.createQuery(jpql, StudentRegistrationDetails.class);
		return tquery.getResultList();
	}

	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	// STUDENT
	// UPDATE STUDENT PASSWORD

	@Transactional(propagation = Propagation.MANDATORY)
	@Override
	public void updateStudentPassword(StudentLogin studentLogin) {
		entityManager.merge(studentLogin);
	}

	// STUDENT
	// UPDATE STUDENT STATUS

	@Transactional(propagation = Propagation.MANDATORY)
	@Override
	public void updateStudentStatus(StudentDetails studentApplication) {
		entityManager.merge(studentApplication);

	}

	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	// INSTITUTE
	// CREATE METHODS

	@Transactional(propagation = Propagation.MANDATORY)
	@Override
	public void createInstituteLogin(InstituteLogin instituteLogin) {
		entityManager.persist(instituteLogin);
	}

	@Transactional(propagation = Propagation.MANDATORY)
	@Override
	public void createInstitute(Institute instituteApplication) {
		entityManager.persist(instituteApplication);
	}

	///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	// READ METHODS

	@Override
	public InstituteLogin readInstituteByDise(String diseCode) {
		return entityManager.find(InstituteLogin.class, diseCode);
	}


	@Override
	public Institute readInstituteByInstituteCode(String instituteCode) {
		return entityManager.find(Institute.class, instituteCode);
	}

	@Override
	public List<StudentDetails> readStudentForInstitute(String instituteCode) {
		String jpql= "select s from StudentDetails s where s.registration.studentAadharNo IN(select r.studentAadharNo from StudentRegistrationDetails r where r.institute.instituteCode = :instituteCode) and s.applicationStatus='Pending'";                                          
		TypedQuery<StudentDetails> tquery= entityManager.createQuery(jpql, StudentDetails.class).setParameter("instituteCode", instituteCode);
		return tquery.getResultList();
	}
	
	@Override
	public List<String> readAllApprovedInstituteCode() {
		String jpql="select i.instituteCode from Institute i where i.registrationStatus='Approved'";
		TypedQuery<String> tquery= entityManager.createQuery(jpql, String.class);
		return tquery.getResultList();
	}

	@Override
	public List<InstituteLogin> readAllInstituteLogin() {
		String jpql="select i from InstituteLogin i";
		TypedQuery<InstituteLogin> tquery= entityManager.createQuery(jpql, InstituteLogin.class);
		return tquery.getResultList();
	}

	
	/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	// UPDATE METHODS
	@Transactional(propagation = Propagation.MANDATORY)
	@Override
	public void updateInstitutePassword(InstituteLogin instituteLogin) {
		entityManager.merge(instituteLogin);

	}

	// NODAL OFFICER MODULE
	// Read Method

	@Override
	public List<StudentDetails> readStudentForNodal(String username) {
		String jpql = "Select s from StudentDetails s where s.registration.studentAadharNo IN(select r.studentAadharNo from StudentRegistrationDetails r where r.institute.instituteCode IN(select i.instituteCode from Institute i where i.instituteState=:username)) and s.applicationStatus='Approved By Institute'";
		TypedQuery<StudentDetails> tquery = entityManager.createQuery(jpql, StudentDetails.class).setParameter("username", username);
		return tquery.getResultList();
	}

	@Override
	public List<Institute> readInsituteForNodal(String username) {
		String jpql = "Select i from Institute i where i.instituteState= :username and i.registrationStatus='Pending'";
		TypedQuery<Institute> tquery = entityManager.createQuery(jpql, Institute.class).setParameter("username", username);
		return tquery.getResultList();
	}

	@Override
	public AdminLogin readAdminById(String username) {
		return entityManager.find(AdminLogin.class, username);
	}


	// Update Methods

	@Transactional(propagation = Propagation.MANDATORY)
	@Override
	public void updateAdminPassword(AdminLogin adminLogin) {
		entityManager.merge(adminLogin);
	}

	@Transactional(propagation = Propagation.MANDATORY)
	@Override
	public void updateInstituteStatus(Institute institute) {
		entityManager.merge(institute);

	}

	// MINISTRY MODULE
	// Read Methods
	@Override
	public List<StudentDetails> readStudentForMinistry() {
		String jpql = "select s from StudentDetails s where s.applicationStatus='Approved by Nodal'";
		TypedQuery<StudentDetails> tquery = entityManager.createQuery(jpql, StudentDetails.class);
		return tquery.getResultList();
	}

	@Override
	public List<Institute> readInstituteForMinistry() {
		String jpql = "select i from Institute i where i.registrationStatus='Approved By Nodal'";
		TypedQuery<Institute> tquery = entityManager.createQuery(jpql, Institute.class);
		return tquery.getResultList();
	}

	
	

}
