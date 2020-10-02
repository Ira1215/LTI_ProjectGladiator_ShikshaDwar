package com.lti.controller;

import java.util.List;

import javax.persistence.criteria.CriteriaBuilder.In;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lti.model.AdminLogin;
import com.lti.model.InstitueLogin;
import com.lti.model.Institute;
import com.lti.model.StudentDetails;
import com.lti.model.StudentLogin;
import com.lti.model.StudentRegistrationDetails;
import com.lti.service.ScholarshipService;

@RestController
@CrossOrigin
@RequestMapping(path = "users")
public class ScholarshipController {

	@Autowired
	private ScholarshipService service;

	// Student Module
	// Add Values

	// http://localhost:9091/ShikshaDwar/users/student/login
	@PostMapping(path = "student/login")
	public void addStudentLogin(@RequestBody StudentLogin studentLogin) {
		service.addStudentLogin(studentLogin);
	}

	// http://localhost:9091/ShikshaDwar/users/student/registration
	@PostMapping(path = "student/registration")
	public void addStudentRegistration(@RequestBody StudentRegistrationDetails studentRegistration) {
		service.addStudentRegistration(studentRegistration);

	}

	// http://localhost:9091/ShikshaDwar/users/student/application
	@PostMapping(path = "student/application")
	public void addStudent(@RequestBody StudentDetails studentApplication) {
		service.addStudent(studentApplication);
	}

	// Read Values

	// http://localhost:9091/ShikshaDwar/users/student/loginDetails
	@GetMapping(path = "student/loginDetails")
	public List<StudentLogin> findAllStudentLogin() {
		List<StudentLogin> s = service.getAllStudentLogin();
		return s;
	}
	
	// http://localhost:9091/ShikshaDwar/users/student/applicationStatus/{studentApplicationNo}
	@PutMapping(path = "student/applicationStatus/{studentApplicationNo}")
	public String findStudentStatus(@PathVariable long studentApplicationNo)
	{
		StudentDetails s= service.getStudentByApplication(studentApplicationNo);
		String status= s.getApplicationStatus();
		return status;
	}

	// Update Values

	// http://localhost:9091/ShikshaDwar/users/student/forgotPassword/{studentEmailId}
	@PutMapping(path = "student/forgotPassword/{studentEmailId}")
	public void updateStudentPassword(@PathVariable String studentEmailId, @RequestBody StudentLogin studentLogin) {
		StudentLogin s = service.getStudentLoginByEmail(studentEmailId);
		s.setStudentPassword(studentLogin.getStudentPassword());
		service.modifyStudentPassword(s);
	}

	// INSTITUTE MODULE
	// Add Values

	// http://localhost:9091/ShikshaDwar/users/institute/login
	@PostMapping(path = "institute/login")
	public void addInstituteLogin(@RequestBody InstitueLogin instituteLogin) {
		service.addInstituteLogin(instituteLogin);
	}

	// http://localhost:9091/ShikshaDwar/users/institute/registration
	@PostMapping(path = "institute/registration")
	public void addInstitute(@RequestBody Institute instituteApplication) {
		service.addInstitute(instituteApplication);
	}

	// Read Module

	// http://localhost:9091/ShikshaDwar/users/institute/loginDetails
	@GetMapping(path = "institute/loginDetails")
	public List<InstitueLogin> findAllInstituteLogin() {
		List<InstitueLogin> i = service.getAllInstituteLogin();
		return i;
	}

	//Update Module
	
	// http://localhost:9091/ShikshaDwar/users/institute/forgotPassword/{diseCode}
	@PutMapping(path = "institute/forgotPassword/{diseCode}")
	public void updateInstitutePassword(@PathVariable String diseCode, @RequestBody InstitueLogin instituteLogin) {
		InstitueLogin i = service.getInstituteByDise(diseCode);
		i.setInstituePassword(instituteLogin.getInstituePassword());
		service.modifyInstitutePassword(i);
	}

	//NODAL + MINISTRY PASSWORD UPDATE AND VERIFY
	// http://localhost:9091/ShikshaDwar/users/admin/forgotPassword/{username}
	@PutMapping(path = "admin/forgotPassword/{username}")
	public void updateAdminPassword(@PathVariable String username, @RequestBody AdminLogin adminLogin) {
		AdminLogin a = service.getAdminById(username);
		a.setPassword(adminLogin.getPassword());
		service.modifyAdminPassword(a);
	}

	// http://localhost:9091/ShikshaDwar/users/admin/loginDetails
	@GetMapping(path = "admin/loginDetails")
	public List<AdminLogin> findAllAdminLogin() {
		List<AdminLogin> a = service.getAllAdminLogin();
		return a;
	}
	
	//NODAL MODULE
	//Read Methods
	
	// http://localhost:9091/ShikshaDwar/users/nodal/studentApplication
	@GetMapping(path="nodal/studentApplication")
	public List<StudentDetails> fetchStudentForNodal()
	{
		List<StudentDetails> s= service.getStudentForNodal();
		return s;
	}
	
	// http://localhost:9091/ShikshaDwar/users/nodal/instituteAplication
	@GetMapping(path = "nodal/instituteAplication")
	public List<Institute> fetchInstituteForNodal()
	{
		List<Institute> i=service.getInstituteForNodal();
		return i;
	}
	
	//Update Methods
	
	// http://localhost:9091/ShikshaDwar/users/nodal/approveStudent/{studentApplicationNo}
	@PutMapping(path = "nodal/approveStudent/{studentApplicationNo}")
	public void approveStudentApplication(@PathVariable long studentApplicationNo)
	{
		StudentDetails s=service.getStudentByApplication(studentApplicationNo);
		s.setApplicationStatus("Approved By Nodal");
		service.modifyStudentStatus(s);
	}
	
	// http://localhost:9091/ShikshaDwar/users/nodal/rejectStudent/{studentApplicationNo}
	@PutMapping(path = "nodal/rejectStudent/{studentApplicationNo}")
	public void rejectStudentApplication(@PathVariable long studentApplicationNo)
	{
		StudentDetails s= service.getStudentByApplication(studentApplicationNo);
		s.setApplicationStatus("Rejected");
		service.modifyStudentStatus(s);
	}
	
	// http://localhost:9091/ShikshaDwar/users/nodal/approveInstitute/{instituteCode}
	@PutMapping(path = "nodal/approveInstitute/{instituteCode}")
	public void approveInstituteRegistration(@PathVariable String instituteCode)
	{
		Institute i= service.getinstituteByInstituteCode(instituteCode);
		i.setRegistrationStatus("Approved By Nodal");
		service.modifyInstituteStatus(i);
	}
	
	// http://localhost:9091/ShikshaDwar/users/nodal/rejectInstitute/{instituteCode}
	@PutMapping(path = "nodal/rejectInstitute/{instituteCode}")
	public void rejectInstituteRegistration(@PathVariable String instituteCode)
	{
		Institute i= service.getinstituteByInstituteCode(instituteCode);
		i.setRegistrationStatus("Rejected");
		service.modifyInstituteStatus(i);
	}

}
