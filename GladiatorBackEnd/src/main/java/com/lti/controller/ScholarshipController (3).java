package com.lti.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lti.controller.ScholarshipController.Status;
import com.lti.controller.ScholarshipController.Status.StatusType;
import com.lti.model.AdminLogin;
import com.lti.model.InstituteLogin;
import com.lti.model.Institute;
import com.lti.model.StudentDetails;
import com.lti.model.StudentLogin;
import com.lti.model.StudentRegistrationDetails;
import com.lti.service.MailServiceImpl;
import com.lti.service.ScholarshipService;

@RestController
@CrossOrigin
@RequestMapping(path = "users")
public class ScholarshipController {

	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	@Autowired
	private ScholarshipService service;
	MailServiceImpl mail = new MailServiceImpl();

	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	// STUDENT
	// SIGNUP
	// Tested

	// http://localhost:9091/ShikshaDwar/users/student/AddLogin
	@PostMapping(path = "student/AddLogin")
	public void addStudentLogin(@RequestBody StudentLogin studentLogin) {
		service.addStudentLogin(studentLogin);
	}

	// STUDENT
	// PORTAL REGISTRATION
	// Tested

	// http://localhost:9091/ShikshaDwar/users/student/registration/{email}
	@PostMapping(path = "student/registration/{email}")
	public Status addStudent(@PathVariable String email, @RequestBody StudentRegistrationDetails studentRegistration) {
		try {
			service.addStudentRegistration(studentRegistration);
			if (mail.mailValidate(email)) {
				mail.send(email, "REGISTRATION SUCCESSFUL",
						"<b>CONGRATULATIONS!!</b> You have Successfully Registered with ShikshaDwaar<br><p>Hope We will serve you better</p>");
			}
			Status status = new Status();
			status.setStatus(StatusType.SUCCESS);
			status.setMessage("REGISTRATION SUCCESSFUL");
			return status;
		} catch (Exception e) {
			Status status = new Status();
			status.setStatus(StatusType.FAILURE);
			status.setMessage(e.getMessage());
			return status;
		}

	}

	// STUDENT
	// APPLY FOR SCHOLARSHIP APPLICATION
	// Tested

	// http://localhost:9091/ShikshaDwar/users/student/ApplyScholarship/{email}
	@PostMapping(path = "/student/ApplyScholarship/{email}")
	public Status addStudentApplication(@PathVariable String email, @RequestBody StudentDetails studentApplication) {
		try {
			StudentLogin l = service.getStudentLoginByEmail(email);
			if (l.getStudent() != null) {
				service.addStudent(studentApplication, l.getStudent(), l, l.getStudent().getInstitute());
			}
			mail.send(email, "SCHOLARSHIP APPLICATION SUCCESSFUL",
					"<b> Congratulations!! </b>You have successfully applied for "
							+ studentApplication.getScholarshipType() + "<br><p>Your Application Tracking Id is: "
							+ studentApplication.getStudentApplicationNo() + "</p>");
			Status status = new Status();
			status.setStatus(StatusType.SUCCESS);
			status.setMessage("SCHOLARSHIP APPLICATION SUCCESSFUL");
			return status;
		} catch (Exception e) {
			Status status = new Status();
			status.setStatus(StatusType.FAILURE);
			status.setMessage(e.getMessage());
			return status;
		}

	}

	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	// STUDENT
	// CHECK STATUS
	// Tested

	// http://localhost:9091/ShikshaDwar/users/student/applicationStatus/{studentApplicationNo}
	@GetMapping(path = "/student/applicationStatus/{studentApplicationNo}")
	public String findStudentStatus(@PathVariable long studentApplicationNo) {
		StudentDetails s = service.getStudentByApplication(studentApplicationNo);
		String status = s.getApplicationStatus();
		return status;
	}

	// STUDENT
	// GET ALL STUDENT LOGIN DETAILS
	// Tested

	// http://localhost:9091/ShikshaDwar/users/allStudentLogin
	@GetMapping(path = "/allStudentLogin")
	public List<StudentLogin> findAllStudentLogin() {
		return service.getAllStudentLogin();
	}

	// STUDENT
	// GET ALL STUDENT REGISTRATION DETAILS
	// Tested

	// http://localhost:9091/ShikshaDwar/users/allStudentRegistration
	@GetMapping(path = "/allStudentRegistration")
	public List<StudentRegistrationDetails> findAllStudentRegistration() {
		return service.getAllStudentRegistration();
	}

	/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	// INSTITUTE MODULE
	// SIGNUP
	// Tested

	// http://localhost:9091/ShikshaDwar/users/institute/AddLogin
	@PostMapping(path = "institute/AddLogin")
	public void addInstituteLogin(@RequestBody InstituteLogin instituteLogin) {
		System.out.println("Add Institue login service called");
		service.addInstituteLogin(instituteLogin);
	}

	// INSTITUTE MODULE
	// REGISTRATION
	// Tested

	// http://localhost:9091/ShikshaDwar/users/institute/registration/{diseCode}
	@PostMapping(path = "institute/registration/{diseCode}")
	public Status addInstituteRegistration(@PathVariable String diseCode, @RequestBody Institute instituteApplication) {
		try {
			InstituteLogin i = service.getInstituteByDise(diseCode);
			if (i.getInstitute() == null) {
				service.addInstitute(instituteApplication, i);
			}
			Status status = new Status();
			status.setStatus(StatusType.SUCCESS);
			status.setMessage("REGISTRATION SUCCESSFUL");
			return status;
		} catch (Exception e) {
			Status status = new Status();
			status.setStatus(StatusType.FAILURE);
			status.setMessage(e.getMessage());
			return status;
		}

	}

	/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	// INSTITUTE
	// CHECK STATUS
	// Tested

	// http://localhost:9091/ShikshaDwar/users/institute/registrationStatus/{instituteCode}
	@GetMapping(path = "institute/registrationStatus/{instituteCode}")
	public String findInstituteStatus(@PathVariable String instituteCode) {
		Institute i = service.getinstituteByInstituteCode(instituteCode);
		String status = i.getRegistrationStatus();
		return status;
	}

	// INSTITUTE
	// GET ALL INSTITUTE LOGIN DETAILS
	// Tested

	// http://localhost:9091/ShikshaDwar/users/allInsituteLogin
	@GetMapping(path = "/allInsituteLogin")
	public List<InstituteLogin> findAllInstituteLogin() {
		return service.getAllInstituteLogin();
	}

	// INSTITUTE
	// GET ALL APPROVED INSTITUTE CODES
	//Tested

	// http://localhost:9091/ShikshaDwar/users/approvedInstituteCodes
	@GetMapping(path = "/approvedInstituteCodes")
	public List<String> findAllApprovedInstituteCode() {
		return service.getAllApprovedInstituteCode();
	}
	
	//INSTITUTE
	//FETCH STUDENT APPLICATION FOR INSTITUTE 
	
	// http://localhost:9091/ShikshaDwar/users/institute/fetchStudent/{instituteCode}
	@GetMapping(path = "/institute/fetchStudent/{instituteCode}")
	public List<StudentDetails> fetchStudentForInstitute(@PathVariable String instituteCode)
	{
		return service.getStudentForInstitute(instituteCode);
	}

	///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	// INSTITUTE
	// APPROVE STUDENT APPLICATION
	// Tested

	// http://localhost:9091/ShikshaDwar/users/institute/approveStudent/{studentApplicationNo}
	@PutMapping(path = "/institute/approveStudent/{studentApplicationNo}")
	public void approveStudentApplicationByInstitute(@PathVariable long studentApplicationNo) {
		StudentDetails s = service.getStudentByApplication(studentApplicationNo);
		s.setApplicationStatus("Approved By Institute");
		service.modifyStudentStatus(s);
	}

	// INSTITUTE
	// REJECT STUDENT APPLICATION
	// Tested

	// http://localhost:9091/ShikshaDwar/users/institute/rejectStudent/{studentApplicationNo}
	@PutMapping(path = "/institute/rejectStudent/{studentApplicationNo}")
	public void rejectStudentApplicationByInstitute(@PathVariable long studentApplicationNo) {
		StudentDetails s = service.getStudentByApplication(studentApplicationNo);
		s.setApplicationStatus("Rejected");
		service.modifyStudentStatus(s);
	}

	//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	// NODAL MODULE
	// Read Methods

	// http://localhost:9091/ShikshaDwar/users/nodal/studentApplication
	@GetMapping(path = "nodal/studentApplication")
	public List<StudentDetails> fetchStudentForNodal() {
		List<StudentDetails> s = service.getStudentForNodal();
		return s;
	}

	// http://localhost:9091/ShikshaDwar/users/nodal/instituteAplication
	@GetMapping(path = "nodal/instituteAplication")
	public List<Institute> fetchInstituteForNodal() {
		List<Institute> i = service.getInstituteForNodal();
		return i;
	}

	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	// NODAL
	// APPROVE STUDENT APPLICATION
	// Tested

	// http://localhost:9091/ShikshaDwar/users/nodal/approveStudent/{studentApplicationNo}
	@PutMapping(path = "nodal/approveStudent/{studentApplicationNo}")
	public void approveStudentApplication(@PathVariable long studentApplicationNo) {
		StudentDetails s = service.getStudentByApplication(studentApplicationNo);
		s.setApplicationStatus("Approved By Nodal");
		service.modifyStudentStatus(s);
	}

	// NODAL
	// REJECT STUDENT APPLICATION
	// Tested

	// http://localhost:9091/ShikshaDwar/users/nodal/rejectStudent/{studentApplicationNo}
	@PutMapping(path = "nodal/rejectStudent/{studentApplicationNo}")
	public void rejectStudentApplication(@PathVariable long studentApplicationNo) {
		StudentDetails s = service.getStudentByApplication(studentApplicationNo);
		s.setApplicationStatus("Rejected");
		service.modifyStudentStatus(s);
	}

	// NODAL
	// APPROVE INSTITUTE APPLICATION
	// Tested

	// http://localhost:9091/ShikshaDwar/users/nodal/approveInstitute/{instituteCode}
	@PutMapping(path = "nodal/approveInstitute/{instituteCode}")
	public void approveInstituteRegistration(@PathVariable String instituteCode) {
		Institute i = service.getinstituteByInstituteCode(instituteCode);
		i.setRegistrationStatus("Approved By Nodal");
		service.modifyInstituteStatus(i);
	}

	// NODAL
	// REJECT INSTITUTE APPLICATION
	// Tested

	// http://localhost:9091/ShikshaDwar/users/nodal/rejectInstitute/{instituteCode}
	@PutMapping(path = "nodal/rejectInstitute/{instituteCode}")
	public void rejectInstituteRegistration(@PathVariable String instituteCode) {
		Institute i = service.getinstituteByInstituteCode(instituteCode);
		i.setRegistrationStatus("Rejected");
		service.modifyInstituteStatus(i);
	}

	/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	// MINISTRY MODULE
	// Read Values

	// http://localhost:9091/ShikshaDwar/users/ministry/studentApplication
	@GetMapping(path = "ministry/studentApplication")
	public List<StudentDetails> fetchStudentsForMinistry() {
		List<StudentDetails> s = service.getStudentForMinistry();
		return s;
	}

	// http://localhost:9091/ShikshaDwar/users/ministry/instituteApplication
	@GetMapping(path = "ministry/instituteApplication")
	public List<Institute> fetchInstituteForMinistry() {
		List<Institute> i = service.getInstituteForMinistry();
		return i;
	}

	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	// MINISTRY
	// APPROVE STUDENT APPLICATION
	// Tested

	// http://localhost:9091/ShikshaDwar/users/ministry/approveStudent/{studentApplicationNo}
	@PutMapping(path = "ministry/approveStudent/{studentApplicationNo}")
	public void approveStudentApplicationByMinistry(@PathVariable long studentApplicationNo) {
		StudentDetails s = service.getStudentByApplication(studentApplicationNo);
		s.setApplicationStatus("Approved");
		service.modifyStudentStatus(s);
	}

	// MINISTRY
	// REJECT STUDENT APPLICATION
	// Tested

	// http://localhost:9091/ShikshaDwar/users/ministry/rejectStudent/{studentApplicationNo}
	@PutMapping(path = "ministry/rejectStudent/{studentApplicationNo}")
	public void rejectStudentApplicationByMinistry(@PathVariable long studentApplicationNo) {
		StudentDetails s = service.getStudentByApplication(studentApplicationNo);
		s.setApplicationStatus("Rejected");
		service.modifyStudentStatus(s);
	}

	// MINISTRY
	// APPROVE INSTITUTE APPLICATION
	// Tested

	// http://localhost:9091/ShikshaDwar/users/ministry/approveInstitute/{instituteCode}
	@PutMapping(path = "ministry/approveInstitute/{instituteCode}")
	public void approveInstituteRegistrationByMinistry(@PathVariable String instituteCode) {
		Institute i = service.getinstituteByInstituteCode(instituteCode);
		i.setRegistrationStatus("Approved");
		service.modifyInstituteStatus(i);
	}

	// MINISTRY
	// REJECT INSTITUTE APPLICATION
	// Tested

	// http://localhost:9091/ShikshaDwar/users/ministry/rejectInstitute/{instituteCode}
	@PutMapping(path = "/ministry/rejectInstitute/{instituteCode}")
	public void rejectInstituteRegistrationByMinistry(@PathVariable String instituteCode) {
		Institute i = service.getinstituteByInstituteCode(instituteCode);
		i.setRegistrationStatus("Rejected");
		service.modifyInstituteStatus(i);
	}

	///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	// LOGIN SERVICE
	// STUDENT

	// http://localhost:9091/ShikshaDwar/users/student/login
	@PostMapping(path = "/student/login")
	public ResponseEntity<String> loginStudent(@RequestBody StudentLogin login) {
		boolean result = service.verifyStudentLogin(login);
		if (result) {
			return ResponseEntity.ok("Login Success");
		} else {
			return ResponseEntity.notFound().build();
		}
	}

	// INSTITUTE

	// http://localhost:9091/ShikshaDwar/users/institute/login
	@PostMapping(path = "/institute/login")
	public ResponseEntity<String> loginInstitute(@RequestBody InstituteLogin login) {
		boolean result = service.verifyInstituteLogin(login);
		if (result) {
			return ResponseEntity.ok("Login Success");
		} else {
			return ResponseEntity.notFound().build();
		}
	}

	// NODAL LOGIN

	// http://localhost:9091/ShikshaDwar/users/nodal/login
	@PostMapping(path = "/nodal/login")
	public ResponseEntity<String> loginNodal(@RequestBody AdminLogin login) {
		boolean result = service.verifyAdminLogin(login);
		if (result) {
			return ResponseEntity.ok("Login Success");
		} else {
			return ResponseEntity.notFound().build();
		}
	}

	// MINISTRY LOGIN

	// http://localhost:9091/ShikshaDwar/users/ministry/login
	@PostMapping(path = "/ministry/login")
	public ResponseEntity<String> loginMinistry(@RequestBody AdminLogin login) {
		boolean result = service.verifyAdminLogin(login);
		if (result) {
			return ResponseEntity.ok("Login Success");
		} else {
			return ResponseEntity.notFound().build();
		}
	}

	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	// STUDENT
	// FORGOT PASSWORD OTP

	// http://localhost:9091/ShikshaDwar/users/student/ForgotPassword/GetOtp/{email}
	@GetMapping("/student/ForgotPassword/GetOtp/{email}")
	public String getOtp(@PathVariable String email) {
		String cotp = service.generateOTP();
		mail.send(email, "OTP For Password Regeneration", "<p>Your <b>One Time Password</b> is : " + cotp + "</p>");
		return cotp;
	}

	// STUDENT
	// PASSWORD RESET

	// http://localhost:9091/ShikshaDwar/users/student/ResetPassword/{studentEmailId}
	@PutMapping(path = "student/ResetPassword/{studentEmailId}")
	public void updateStudentPassword(@PathVariable String studentEmailId, @RequestBody StudentLogin studentLogin) {
		StudentLogin s = service.getStudentLoginByEmail(studentEmailId);
		s.setStudentPassword(studentLogin.getStudentPassword());
		service.modifyStudentPassword(s);
	}

	// INSTITUTE
	// PASSWORD RESET

	// http://localhost:9091/ShikshaDwar/users/institute/ResetPassword/{diseCode}
	@PutMapping(path = "institute/ResetPassword/{diseCode}")
	public void updateInstitutePassword(@PathVariable String diseCode, @RequestBody InstituteLogin instituteLogin) {
		InstituteLogin i = service.getInstituteByDise(diseCode);
		i.setInstituePassword(instituteLogin.getInstituePassword());
		service.modifyInstitutePassword(i);
	}

	// NODAL
	// PASSWORD RESET

	// http://localhost:9091/ShikshaDwar/users/nodal/ResetPassword/{username}
	@PutMapping(path = "nodal/ResetPassword/{username}")
	public void updateNodalPassword(@PathVariable String username, @RequestBody AdminLogin adminLogin) {
		AdminLogin a = service.getAdminById(username);
		a.setPassword(adminLogin.getPassword());
		service.modifyAdminPassword(a);
	}

	// MINISTRY
	// PASSWORD RESET

	// http://localhost:9091/ShikshaDwar/users/ministry/ResetPassword/{username}
	@PutMapping(path = "ministry/ResetPassword/{username}")
	public void updateMinistryPassword(@PathVariable String username, @RequestBody AdminLogin adminLogin) {
		AdminLogin a = service.getAdminById(username);
		a.setPassword(adminLogin.getPassword());
		service.modifyAdminPassword(a);
	}

	///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	public static class Status {

		private StatusType status;
		private String message;

		public static enum StatusType {
			SUCCESS, FAILURE;
		}

		public StatusType getStatus() {
			return status;
		}

		public void setStatus(StatusType status) {
			this.status = status;
		}

		public String getMessage() {
			return message;
		}

		public void setMessage(String message) {
			this.message = message;
		}

	}

	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

}
