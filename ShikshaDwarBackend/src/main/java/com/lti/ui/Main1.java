/*package com.lti.ui;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.lti.model.InstitueLogin;
import com.lti.model.Institute;
import com.lti.model.InstituteApplicationStatus;
import com.lti.model.StudentDetails;
import com.lti.model.StudentLogin;
import com.lti.model.StudentRegistrationDetails;

public class Main1 {
	
	@SuppressWarnings("deprecation")
	public static void main(String[] args) {
		
		EntityManagerFactory factory= Persistence.createEntityManagerFactory("JPA-PU");
		EntityManager entityManager=factory.createEntityManager();
		
		//Student Portal registration
		StudentRegistrationDetails s1=new StudentRegistrationDetails();
		s1.setStudentAadharNo("444412579871");
		s1.setStudentName("Snayasish Kumar");
		s1.setStudentGender("Male");
		s1.setStudentMobile("8597586252");
		s1.setStudentInstitution("UPES");
		s1.setStudentDob(new Date(1997,11,7));
		
		//Student Login details
		StudentLogin l1=new StudentLogin("Snayasishkmr@gmail.com","abcd1234");
		
		//Login details mapped for Student
		s1.setLogin(l1);
		
		
		//Student First Scholarship application
		StudentDetails app1= new StudentDetails();
		app1.setState("West Bengal");
		app1.setDistrict("UTAH");
		app1.setBlockNo("E Block");
		app1.setStreetNo(101);
		app1.setHouseNo(9);
		app1.setPinCode(700092);
		app1.setTuitionFee(600000.00);
		app1.setAdmissionFee(70000.0);
		app1.setOtherFee(10000);
		app1.setBankName("Standard Chartered Bank");
		app1.setBankAccountNo(222567568);
		app1.setBankIfscCode(180097621);
		app1.setStudentReligion("Hindu");
		app1.setStudentCategory("General");
		app1.setStudentFatherName("Gautam Kumar");
		app1.setStudentMotherName("Jharna Kumar");
		app1.setStudentFamilyIncome(100000);
		app1.setStudentCourse("Btech");
		app1.setStudentYear(2020);
		app1.setModeOfStudy("ClassRoom Program");
		app1.setCourseStartDate(new Date(2016,7,11));
		app1.setStudentPrevCourse("No Course before this");
		app1.setStudentPrevPassingYear(2020);
		app1.setStudentPrevPercent(83.6);
		app1.setStudent10RollNo(1519605);
		app1.setStudent10BoardName("CBSE");
		app1.setStudent10PassingYear(2013);
		app1.setStudent10Percent(92.00);
		app1.setStudent12RollNo(16109087);
		app1.setStudent12Board("CBSE");
		app1.setStudent12PassingYear(2015);
		app1.setStudent12Percent(85.00);
		app1.setDisability("NO");
		app1.setDisabilityType("No disability");
		app1.setDisabilityPercentage(0.0);
		app1.setStudentMaritalStatus("Unmarried");
		app1.setParentProfession(" JCO at Indian Army");
		app1.setDomicileCertificate("To be uploaded");
		app1.setStudentPhotograph("To be uploaded");
		app1.setInstituteIdCard("Id card to be Uploaded");
		app1.setIncomeCertificate("to verify your category");
		app1.setPreviousYearMarksheet("To be Uploaded");
		app1.setBankPassbook("To be uploaded");
		app1.setFeeReceipt("To be uploaded");
		app1.setAadharCard("To be uploaded");
		app1.setMarkSheet10("To be Uploaded");
		app1.setMarkSheet12("To be Uploaded");
		app1.setScholarshipType("POST MATRIC SCHOLARSHIP");
		app1.setApplicationStatus("Pending");
		app1.setBonafideCertificate("to be uploaded by institute");
		
		//First application mapped with student
		app1.setRegistration(s1);
	
		
		//Institute Login
		InstitueLogin login1= new InstitueLogin("UKUPES12", "pass");
		
		//Institute Registration
		Institute reg1= new Institute();
		reg1.setInstituteCode("UPES12");
		reg1.setInstituteName("UPES");
		reg1.setInstituteCategory("Private");
		reg1.setInstituteLocation("Urban");
		reg1.setInstituteType("Affiliated");
		reg1.setAffiliatedUniState("Uttarakhand");
		reg1.setAffiliatedUniboard("UGC");
		reg1.setYearAdmissionStarted(new Date(2001,7,11));
		reg1.setUniAffiliationCerti("to be uploaded");
		reg1.setInstituteEstbCerti("to be uploaded");
		reg1.setAddressLine1("UPES");
		reg1.setAddressLine2("Bidholi");
		reg1.setInstituteState("UK");
		reg1.setDistrict("Dehradun");
		reg1.setCity("Dehradun");
		reg1.setPincode(248007);
		reg1.setInstituteHeadName("kamal Bansal");
		reg1.setInstituteHeadContact("9000090000");
		
		s1.setInstitute(reg1);
		
		//Institute Application Status
		InstituteApplicationStatus regStatus=new InstituteApplicationStatus();
		regStatus.setRegistrationStatus("Pending");
		
		//Institute mapped with status table
		regStatus.setInstitute(reg1);
		
		//Login mapped with institute registration
		reg1.setLogin(login1);
		
		
		Set<StudentDetails> application=new HashSet<>();
		application.add(app1);  //application 1 Added Successfully
		s1.setApplication(application);
		
		Set<StudentRegistrationDetails> students = new HashSet<>();
		students.add(s1); //Student 1 mapped to institute
		reg1.setStudents(students);


		entityManager.getTransaction().begin();
		entityManager.persist(l1);
		entityManager.persist(login1);
		entityManager.persist(s1);
		entityManager.persist(app1);
		entityManager.persist(reg1);
		entityManager.persist(regStatus);
		entityManager.getTransaction().commit();
		
	}

}
*/