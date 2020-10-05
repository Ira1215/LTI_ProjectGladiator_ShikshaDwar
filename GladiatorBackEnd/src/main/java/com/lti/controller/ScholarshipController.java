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
import com.lti.model.InstitueLogin;
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

	//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	@Autowired
	private ScholarshipService service;
	MailServiceImpl mail = new MailServiceImpl();

	//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	// STUDENT
	// SIGNUP

	// http://localhost:9091/ShikshaDwar/users/student/login
	@PostMapping(path = "student/login")
	public void addStudentLogin(@RequestBody StudentLogin studentLogin) {
		service.addStudentLogin(studentLogin);
	}

	// STUDENT
	// PORTAL REGISTRATION

	// http://localhost:9091/ShikshaDwar/users/student/registration
	@PostMapping(path = "student/registration")
	public Status addStudent(@RequestBody StudentRegistrationDetails studentRegistration) {
		try {
			service.addStudentRegistration(studentRegistration);
			if (mail.mailValidate(studentRegistration.getLogin().getStudentEmailId())) {
				mail.send(studentRegistration.getLogin().getStudentEmailId(), "REGISTRATION SUCCESSFULL",
						"<b>CONGRATULATIONS !</b> You have Successfully Registered with ShikshaDwaar<br><p>Hope We will serve you better</p>");
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
	// SCHOLARSHIP APPLICATION

	// http://localhost:9091/ShikshaDwar/users/student/application
	@PostMapping(path = "student/application")
	public void addStudentApplication(@RequestBody StudentDetails studentApplication) {
		service.addStudent(studentApplication);
	}

	/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	// Read Values

	// http://localhost:9091/ShikshaDwar/users/student/loginDetails
	@GetMapping(path = "student/loginDetails")
	public List<StudentLogin> findAllStudentLogin() {
		List<StudentLogin> s = service.getAllStudentLogin();
		return s;
	}

	// http://localhost:9091/ShikshaDwar/users/student/applicationStatus/{studentApplicationNo}
	@GetMapping(path = "student/applicationStatus/{studentApplicationNo}")
	public String findStudentStatus(@PathVariable long studentApplicationNo) {
		StudentDetails s = service.getStudentByApplication(studentApplicationNo);
		String status = s.getApplicationStatus();
		return status;
	}

	/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

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

	// http://localhost:9091/ShikshaDwar/users/institute/registrationStatus/{instituteCode}
	@GetMapping(path = "institute/registrationStatus/{instituteCode}")
	public String findInstituteStatus(@PathVariable String instituteCode) {
		Institute i = service.getinstituteByInstituteCode(instituteCode);
		String status = i.getRegistrationStatus();
		return status;
	}

	// Update Module

	//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	// NODAL + MINISTRY PASSWORD UPDATE AND VERIFY

	// http://localhost:9091/ShikshaDwar/users/admin/loginDetails
	@GetMapping(path = "admin/loginDetails")
	public List<AdminLogin> findAllAdminLogin() {
		List<AdminLogin> a = service.getAllAdminLogin();
		return a;
	}

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

	// Update Methods

	// http://localhost:9091/ShikshaDwar/users/nodal/approveStudent/{studentApplicationNo}
	@PutMapping(path = "nodal/approveStudent/{studentApplicationNo}")
	public void approveStudentApplication(@PathVariable long studentApplicationNo) {
		StudentDetails s = service.getStudentByApplication(studentApplicationNo);
		s.setApplicationStatus("Approved By Nodal");
		service.modifyStudentStatus(s);
	}

	// http://localhost:9091/ShikshaDwar/users/nodal/rejectStudent/{studentApplicationNo}
	@PutMapping(path = "nodal/rejectStudent/{studentApplicationNo}")
	public void rejectStudentApplication(@PathVariable long studentApplicationNo) {
		StudentDetails s = service.getStudentByApplication(studentApplicationNo);
		s.setApplicationStatus("Rejected");
		service.modifyStudentStatus(s);
	}

	// http://localhost:9091/ShikshaDwar/users/nodal/approveInstitute/{instituteCode}
	@PutMapping(path = "nodal/approveInstitute/{instituteCode}")
	public void approveInstituteRegistration(@PathVariable String instituteCode) {
		Institute i = service.getinstituteByInstituteCode(instituteCode);
		i.setRegistrationStatus("Approved By Nodal");
		service.modifyInstituteStatus(i);
	}

	// http://localhost:9091/ShikshaDwar/users/nodal/rejectInstitute/{instituteCode}
	@PutMapping(path = "nodal/rejectInstitute/{instituteCode}")
	public void rejectInstituteRegistration(@PathVariable String instituteCode) {
		Institute i = service.getinstituteByInstituteCode(instituteCode);
		i.setRegistrationStatus("Rejected");
		service.modifyInstituteStatus(i);
	}

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

	// Update methods
	// http://localhost:9091/ShikshaDwar/users/ministry/approveStudent/{studentApplicationNo}
	@PutMapping(path = "ministry/approveStudent/{studentApplicationNo}")
	public void approveStudentApplicationByMinistry(@PathVariable long studentApplicationNo) {
		StudentDetails s = service.getStudentByApplication(studentApplicationNo);
		s.setApplicationStatus("Approved");
		service.modifyStudentStatus(s);
	}

	// Reject
	// http://localhost:9091/ShikshaDwar/users/ministry/rejectStudent/{studentApplicationNo}
	@PutMapping(path = "ministry/rejectStudent/{studentApplicationNo}")
	public void rejectStudentApplicationByMinistry(@PathVariable long studentApplicationNo) {
		StudentDetails s = service.getStudentByApplication(studentApplicationNo);
		s.setApplicationStatus("Rejected");
		service.modifyStudentStatus(s);
	}

	// Institute Status Updates
	// http://localhost:9091/ShikshaDwar/users/ministry/approveInstitute/{instituteCode}
	@PutMapping(path = "ministry/approveInstitute/{instituteCode}")
	public void approveInstituteRegistrationByMinistry(@PathVariable String instituteCode) {
		Institute i = service.getinstituteByInstituteCode(instituteCode);
		i.setRegistrationStatus("Approved");
		service.modifyInstituteStatus(i);
	}

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
	public ResponseEntity<String> loginInstitute(@RequestBody InstitueLogin login) {
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
	public void updateInstitutePassword(@PathVariable String diseCode, @RequestBody InstitueLogin instituteLogin) {
		InstitueLogin i = service.getInstituteByDise(diseCode);
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
