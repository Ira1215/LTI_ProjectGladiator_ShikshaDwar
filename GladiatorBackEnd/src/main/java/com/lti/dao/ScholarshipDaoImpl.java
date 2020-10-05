package com.lti.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.lti.model.AdminLogin;
import com.lti.model.InstitueLogin;
import com.lti.model.Institute;
import com.lti.model.StudentDetails;
import com.lti.model.StudentLogin;
import com.lti.model.StudentRegistrationDetails;

@Repository
public class ScholarshipDaoImpl implements ScholarshipDao{
	
	@PersistenceContext
	private EntityManager entityManager;
	
	
	public ScholarshipDaoImpl() {
		
	}
	
	//STUDENT MODULE
	//CREATE METHODS
	@Transactional(propagation = Propagation.MANDATORY)
	@Override
	public int createStudentLogin(StudentLogin studentLogin) {
		entityManager.persist(studentLogin);
		return 1;
	}

	@Transactional(propagation = Propagation.MANDATORY)
	@Override
	public int createStudentRegistration(StudentRegistrationDetails studentRegistration) {
		entityManager.persist(studentRegistration);
		return 1;
	}

	@Transactional(propagation = Propagation.MANDATORY)
	@Override
	public int createStudent(StudentDetails studentApplication) {
		entityManager.persist(studentApplication);
		return 1;
	}
	//READ METHODS
	@Override
	public StudentLogin readStudentLoginByEmail(String studentEmailId) {
		return entityManager.find(StudentLogin.class, studentEmailId);
	}
	
	@Override
	public List<StudentLogin> readAllStudentLogin() {
		String jpql= "select s from StudentLogin s";
		TypedQuery<StudentLogin> tquery = entityManager.createQuery(jpql, StudentLogin.class);
		return tquery.getResultList();
	}
	
	@Override
	public StudentDetails readStudentByApplication(long studentApplicationNo) {
		return entityManager.find(StudentDetails.class, studentApplicationNo);
	}
	
	//UPDATE METHODS
	@Transactional(propagation = Propagation.MANDATORY)
	@Override
	public void updateStudentPassword(StudentLogin studentLogin) {
		entityManager.merge(studentLogin);
	}
	
	
	//INSTITUTE MODULE
	//CREATE METHODS

	@Transactional(propagation = Propagation.MANDATORY)
	@Override
	public int createInstituteLogin(InstitueLogin instituteLogin) {
		entityManager.persist(instituteLogin);
		return 1;
	}

	@Transactional(propagation = Propagation.MANDATORY)
	@Override
	public int createInstitute(Institute instituteApplication) {
		entityManager.persist(instituteApplication);
		return 1;
	}

	//READ METHODS

	@Override
	public InstitueLogin readInstituteByDise(String diseCode) {
		return entityManager.find(InstitueLogin.class, diseCode);
	}
	
	@Override
	public List<InstitueLogin> readAllInstituteLogin() {
		String jpql= "select i from InstituteLogin i";
		TypedQuery<InstitueLogin> tquery = entityManager.createQuery(jpql, InstitueLogin.class);
		return tquery.getResultList();
	}
	
	@Override
	public Institute readInstituteByInstituteCode(String instituteCode) {
		return entityManager.find(Institute.class, instituteCode);
	}

	@Override
	public List<StudentDetails> readStudentForInstitute(String instituteCode) {
		// TODO Auto-generated method stub
		return null;
	}

	//UPDATE METHODS
	@Transactional(propagation = Propagation.MANDATORY)
	@Override
	public void updateInstitutePassword(InstitueLogin instituteLogin) {
			entityManager.merge(instituteLogin);
			
	}
	
	
	//NODAL OFFICER MODULE
	//Read Method

	
	@Override
	public List<StudentDetails> readStudentForNodal() {
		String jpql="Select s from StudentDetails s where s.application_status='Approved By Institute'";
		TypedQuery<StudentDetails> tquery= entityManager.createQuery(jpql, StudentDetails.class);
		return tquery.getResultList();
	}
	
	@Override
	public List<Institute> readInsituteForNodal() {
		String jpql="Select i from Institute i where i.registration_status='Pending'";
		TypedQuery<Institute> tquery= entityManager.createQuery(jpql, Institute.class);
		return tquery.getResultList();
	}

	@Override
	public AdminLogin readAdminById(String username) {
		return entityManager.find(AdminLogin.class, username);
	}
	
	@Override
	public List<AdminLogin> readAllAdminLogin() {
		String jpql= "select a from AdminLogin a";
		TypedQuery<AdminLogin> tquery = entityManager.createQuery(jpql, AdminLogin.class);
		return tquery.getResultList();
	}
	
	//Update Methods
	
	@Transactional(propagation = Propagation.MANDATORY)
	@Override
	public void updateAdminPassword(AdminLogin adminLogin) {
		entityManager.merge(adminLogin);
	}

	@Transactional(propagation = Propagation.MANDATORY)
	@Override
	public void updateStudentStatus(StudentDetails studentApplication) {
		entityManager.merge(studentApplication);
		
	}

	@Transactional(propagation = Propagation.MANDATORY)
	@Override
	public void updateInstituteStatus(Institute institute) {
		entityManager.merge(institute);
		
	}
	


	//MINISTRY MODULE
	//Read Methods
	@Override
	public List<StudentDetails> readStudentForMinistry() {
		String jpql = "select s from StudentDetails s where s.application_status='Approved by Nodal'";
		TypedQuery<StudentDetails> tquery = entityManager.createQuery(jpql, StudentDetails.class);
		return tquery.getResultList();
	}

	
	@Override
	public List<Institute> readInstituteForMinistry() {
		String jpql = "select i from Institute i where i.registration_status='Approved By Nodal'";
		TypedQuery<Institute> tquery = entityManager.createQuery(jpql, Institute.class);
		return tquery.getResultList();
	}

	

	
	

	

	

	
	
		
		
}
