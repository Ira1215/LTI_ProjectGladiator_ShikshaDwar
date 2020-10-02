/*package com.lti.ui;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.lti.model.InstitueLogin;
import com.lti.model.Institute;


public class Main {
	
	public static void main(String[] args) {
		
		EntityManagerFactory factory= Persistence.createEntityManagerFactory("JPA-PU");
		EntityManager entityManager=factory.createEntityManager();
		
		InstitueLogin l1= new InstitueLogin("UPES12", "pass");
		Institute reg1= new Institute();
		reg1.setDiseCode("UKUPES12");
		reg1.setInstituteName("UPES");
		reg1.setInstituteCategory("Private");
		reg1.setInstituteLocation("Urban");
		reg1.setInstituteType("Affiliated");
		reg1.setAffiliatedUniversityState("Uttarakhand");
		reg1.setAffiliatedUniversityBoardName("UGC");
		reg1.setYearAdmissionStarted(new Date(2001,7,11));
		reg1.setUniversityAffiliationCertificate("to be uploaded");
		reg1.setInstituteEstablishmentCertificate("to be uploaded");
		reg1.setAddressLine1("UPES");
		reg1.setAddressLine2("Bidholi");
		reg1.setInstituteState("UK");
		reg1.setDistrict("Dehradun");
		reg1.setCity("Dehradun");
		reg1.setPincode(248007);
		reg1.setInstituteHeadName("kamal Bansal");
		reg1.setInstituteHeadContact("9000090000");
		
		reg1.setLogin(l1);
		
		entityManager.getTransaction().begin();
		entityManager.persist(l1);
		entityManager.persist(reg1);
		entityManager.getTransaction().commit();
		}
}*/
