package com.lti.model;

import java.io.Serializable;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
//import javax.persistence.OneToOne;
import javax.persistence.Table;


//Column declaration
@Entity
@Table(name = "STUDENT_DETAILS")
public class StudentDetails implements Serializable{
	
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "STUDENT_APPLICATION_NO")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long studentApplicationNo;
	
	@Column(name = "STUDENT_NAME")
	private String  studentName;
	
	@Column(name ="STUDENT_STATE")
	private String state;
	
	@Column(name="DISTRICT")
	private String district;

	@Column(name="BLOCK_NO")
	private String blockNo;
	
	@Column(name="STREET_NO")
	private long streetNo;
	
	@Column(name="HOUSE_NO")
	private long houseNo;
	
	@Column(name="PINCODE")//string
	private String pinCode;
	
	@Column(name = "TUITION_FEE")
	private Double tuitionFee;
	
	@Column(name="ADMISSION_FEE")
	private double admissionFee;
	
	@Column(name="OTHER_FEE")
	private double otherFee;
	
	@Column(name="BANK_NAME")
	private String bankName;
	
	@Column(name = "BANK_ACCOUNT_NO")
	private String bankAccountNo;//string
	
	@Column(name="BANK_IFSC_CODE")//string 
	private String bankIfscCode;
	
	@Column(name="STUDENT_RELIGION")
	private String studentReligion;
	
	@Column(name="STUDENT_CATEGORY")
	private String studentCategory;
	
	@Column(name="STUDENT_FATHER_NAME")
	private String studentFatherName;
	
	@Column(name="STUDENT_MOTHER_NAME")
	private String studentMotherName;
	
	@Column(name="STUDENT_FAMILY_INCOME")
	private long studentFamilyIncome;
	
	@Column(name="STUDENT_COURSE")
	private String studentCourse;
	
	@Column(name="STUDENT_YEAR")
	private int studentYear;
	
	@Column(name="MODE_OF_STUDY")
	private String modeOfStudy;
	
	@Column(name="COURSE_START_DATE")
	private Date courseStartDate;
	
	@Column(name="STUDENT_PREV_COURSE")
	private String studentPrevCourse;
	
	@Column(name="STUDENT_PREV_PASSING_YEAR")
	private long studentPrevPassingYear;
	
	@Column(name="STUDENT_PREV_PERCENT")
	private double studentPrevPercent;
	
	@Column(name="STUDENT_10_ROLL_NO")//string
	private String student10RollNo;
	
	@Column(name="STUDENT_10_BOARD_NAME")
	private String student10BoardName;

	@Column(name="STUDENT_10_PASSING_YEAR")//long
	private long student10PassingYear;
	
	@Column(name="STUDENT_10_PERCENT") 
	private double student10Percent;
	
	@Column(name="STUDENT_12_ROLL_NO")//string
	private String student12RollNo;
	
	@Column(name="STUDENT_12_BOARD")
	private String student12Board;

	@Column(name="STUDENT_12_PASSING_YEAR")//long
	private long student12PassingYear;
	
	@Column(name="STUDENT_12_PERCENT") 
	private double student12Percent;
	
	@Column(name="DISABILITY")
	private String disability;  
	
	@Column(name="DISABILITY_TYPE")
	private String disabilityType;
	
	@Column(name="DISABILITY_PERCENTAGE")
	private double disabilityPercentage;
	
	@Column(name="STUDENT_MARITAL_STATUS")
	private String studentMaritalStatus;
	
	@Column(name="PARENT_PROFESSION")
	private String parentProfession;
	
	@Column(name="DOMICILE_CERTIFICATE")
	private String domicileCertificate;
	
	@Column(name="STUDENT_PHOTOGRAPH")
	private String studentPhotograph;
	
	@Column(name="INSTITUTE_ID_CARD")
	private String instituteIdCard;
	
	@Column(name="INCOME_CERTIFICATE")
	private String incomeCertificate;  
	
	@Column(name="PREVIOUS_YEAR_MARKSHEET")
	private String previousYearMarksheet;
	
	@Column(name="BANK_PASSBOOK")
	private String bankPassbook;
	
	@Column(name="FEE_RERCEIPT")
	private String feeReceipt;
	
	@Column(name="AADHAR_CARD")
	private String aadharCard;
	
	@Column(name="MARK_SHEET_10")
	private String markSheet10;
	
	@Column(name="MARK_SHEET_12")
	private String markSheet12;
	
	@Column(name = "SCHOLARSHIP_TYPE")
	private String scholarshipType; 
	
	@Column(name="BONAFIDE_CERTIFICATE")
	private String bonafideCertificate;
	
	@Column(name = "APPLICATION_STATUS")
	private String applicationStatus;
	
	@ManyToOne
	@JoinColumn(name="STUDENT_AADHAR_NO")
	private StudentRegistrationDetails registration;
	
	
	
	
	//Default Constructor
	public StudentDetails()
	{
		
	}
	
	
	// Generating Constructors Using Fields
	
	public StudentDetails(long studentApplicationNo, String studentName, String state, String district, String blockNo, long streetNo,
			long houseNo, String pinCode, Double tuitionFee, double admissionFee, double otherFee, String bankName,
			String bankAccountNo, String bankIfscCode, String studentReligion, String studentCategory,
			String studentFatherName, String studentMotherName, long studentFamilyIncome, String studentCourse,
			int studentYear, String modeOfStudy, Date courseStartDate, String studentPrevCourse,
			long studentPrevPassingYear, double studentPrevPercent, String student10RollNo, String student10BoardName,
			long student10PassingYear, double student10Percent, String student12RollNo, String student12Board,
			long student12PassingYear, double student12Percent, String disability, String disabilityType,
			double disabilityPercentage, String studentMaritalStatus, String parentProfession,
			String domicileCertificate, String studentPhotograph, String instituteIdCard, String incomeCertificate,
			String previousYearMarksheet, String bankPassbook, String feeReceipt, String aadharCard, String markSheet10,
			String markSheet12, String scholarshipType, String bonafideCertificate) {
		super();
		this.studentApplicationNo = studentApplicationNo;
		this.studentName = studentName;
		this.state = state;
		this.district = district;
		this.blockNo = blockNo;
		this.streetNo = streetNo;
		this.houseNo = houseNo;
		this.pinCode = pinCode;
		this.tuitionFee = tuitionFee;
		this.admissionFee = admissionFee;
		this.otherFee = otherFee;
		this.bankName = bankName;
		this.bankAccountNo = bankAccountNo;
		this.bankIfscCode = bankIfscCode;
		this.studentReligion = studentReligion;
		this.studentCategory = studentCategory;
		this.studentFatherName = studentFatherName;
		this.studentMotherName = studentMotherName;
		this.studentFamilyIncome = studentFamilyIncome;
		this.studentCourse = studentCourse;
		this.studentYear = studentYear;
		this.modeOfStudy = modeOfStudy;
		this.courseStartDate = courseStartDate;
		this.studentPrevCourse = studentPrevCourse;
		this.studentPrevPassingYear = studentPrevPassingYear;
		this.studentPrevPercent = studentPrevPercent;
		this.student10RollNo = student10RollNo;
		this.student10BoardName = student10BoardName;
		this.student10PassingYear = student10PassingYear;
		this.student10Percent = student10Percent;
		this.student12RollNo = student12RollNo;
		this.student12Board = student12Board;
		this.student12PassingYear = student12PassingYear;
		this.student12Percent = student12Percent;
		this.disability = disability;
		this.disabilityType = disabilityType;
		this.disabilityPercentage = disabilityPercentage;
		this.studentMaritalStatus = studentMaritalStatus;
		this.parentProfession = parentProfession;
		this.domicileCertificate = domicileCertificate;
		this.studentPhotograph = studentPhotograph;
		this.instituteIdCard = instituteIdCard;
		this.incomeCertificate = incomeCertificate;
		this.previousYearMarksheet = previousYearMarksheet;
		this.bankPassbook = bankPassbook;
		this.feeReceipt = feeReceipt;
		this.aadharCard = aadharCard;
		this.markSheet10 = markSheet10;
		this.markSheet12 = markSheet12;
		this.scholarshipType = scholarshipType;
		this.bonafideCertificate = bonafideCertificate;
		this.setApplicationStatus("Pending");
	}
	
	
	//Generating getters and Setters

	public String getBonafideCertificate() {
		return bonafideCertificate;
	}

	public void setBonafideCertificate(String bonafideCertificate) {
		this.bonafideCertificate = bonafideCertificate;
	}
	
	public String getStudentName() {
		return studentName;
	}


	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}


	public String getApplicationStatus() {
		return applicationStatus;
	}


	public void setApplicationStatus(String applicationStatus) {
		this.applicationStatus = applicationStatus;
	}


	public long getStudentApplicationNo() {
		return studentApplicationNo;
	}


	public void setStudentApplicationNo(long studentApplicationNo) {
		this.studentApplicationNo = studentApplicationNo;
	}


	public String getState() {
		return state;
	}


	public void setState(String state) {
		this.state = state;
	}


	public String getDistrict() {
		return district;
	}


	public void setDistrict(String district) {
		this.district = district;
	}


	public long getStreetNo() {
		return streetNo;
	}


	public void setStreetNo(long streetNo) {
		this.streetNo = streetNo;
	}


	public long getHouseNo() {
		return houseNo;
	}


	public void setHouseNo(long houseNo) {
		this.houseNo = houseNo;
	}


	public String getPinCode() {
		return pinCode;
	}


	public void setPinCode(String pinCode) {
		this.pinCode = pinCode;
	}


	public Double getTuitionFee() {
		return tuitionFee;
	}


	public void setTuitionFee(Double tuitionFee) {
		this.tuitionFee = tuitionFee;
	}


	public double getAdmissionFee() {
		return admissionFee;
	}


	public void setAdmissionFee(double admissionFee) {
		this.admissionFee = admissionFee;
	}


	public double getOtherFee() {
		return otherFee;
	}


	public void setOtherFee(double otherFee) {
		this.otherFee = otherFee;
	}


	public String getBankName() {
		return bankName;
	}


	public void setBankName(String bankName) {
		this.bankName = bankName;
	}


	public String getBankAccountNo() {
		return bankAccountNo;
	}


	public void setBankAccountNo(String bankAccountNo) {
		this.bankAccountNo = bankAccountNo;
	}


	public String getBankIfscCode() {
		return bankIfscCode;
	}


	public void setBankIfscCode(String bankIfscCode) {
		this.bankIfscCode = bankIfscCode;
	}


	public String getStudentReligion() {
		return studentReligion;
	}


	public void setStudentReligion(String studentReligion) {
		this.studentReligion = studentReligion;
	}


	public String getStudentCategory() {
		return studentCategory;
	}


	public void setStudentCategory(String studentCategory) {
		this.studentCategory = studentCategory;
	}


	public String getStudentFatherName() {
		return studentFatherName;
	}


	public void setStudentFatherName(String studentFatherName) {
		this.studentFatherName = studentFatherName;
	}


	public String getStudentMotherName() {
		return studentMotherName;
	}


	public void setStudentMotherName(String studentMotherName) {
		this.studentMotherName = studentMotherName;
	}


	public String getStudentCourse() {
		return studentCourse;
	}


	public void setStudentCourse(String studentCourse) {
		this.studentCourse = studentCourse;
	}


	public int getStudentYear() {
		return studentYear;
	}


	public void setStudentYear(int studentYear) {
		this.studentYear = studentYear;
	}


	public String getModeOfStudy() {
		return modeOfStudy;
	}


	public void setModeOfStudy(String modeOfStudy) {
		this.modeOfStudy = modeOfStudy;
	}




	public String getStudent10BoardName() {
		return student10BoardName;
	}


	public void setStudent10BoardName(String student10BoardName) {
		this.student10BoardName = student10BoardName;
	}


	public long getStudent10PassingYear() {
		return student10PassingYear;
	}


	public void setStudent10PassingYear(long student10PassingYear) {
		this.student10PassingYear = student10PassingYear;
	}

	public String getBlockNo() {
		return blockNo;
	}


	public void setBlockNo(String blockNo) {
		this.blockNo = blockNo;
	}


	public long getStudentFamilyIncome() {
		return studentFamilyIncome;
	}


	public void setStudentFamilyIncome(long studentFamilyIncome) {
		this.studentFamilyIncome = studentFamilyIncome;
	}


	public Date getCourseStartDate() {
		return courseStartDate;
	}


	public void setCourseStartDate(Date courseStartDate) {
		this.courseStartDate = courseStartDate;
	}


	public String getStudentPrevCourse() {
		return studentPrevCourse;
	}


	public void setStudentPrevCourse(String studentPrevCourse) {
		this.studentPrevCourse = studentPrevCourse;
	}


	public long getStudentPrevPassingYear() {
		return studentPrevPassingYear;
	}


	public void setStudentPrevPassingYear(long studentPrevPassingYear) {
		this.studentPrevPassingYear = studentPrevPassingYear;
	}


	public double getStudentPrevPercent() {
		return studentPrevPercent;
	}


	public void setStudentPrevPercent(double studentPrevPercent) {
		this.studentPrevPercent = studentPrevPercent;
	}


	public String getStudent10RollNo() {
		return student10RollNo;
	}


	public void setStudent10RollNo(String student10RollNo) {
		this.student10RollNo = student10RollNo;
	}


	public double getStudent10Percent() {
		return student10Percent;
	}


	public void setStudent10Percent(double student10Percent) {
		this.student10Percent = student10Percent;
	}


	public String getStudent12RollNo() {
		return student12RollNo;
	}


	public void setStudent12RollNo(String student12RollNo) {
		this.student12RollNo = student12RollNo;
	}


	public String getStudent12Board() {
		return student12Board;
	}


	public void setStudent12Board(String student12Board) {
		this.student12Board = student12Board;
	}


	public double getStudent12Percent() {
		return student12Percent;
	}


	public void setStudent12Percent(double student12Percent) {
		this.student12Percent = student12Percent;
	}


	public long getStudent12PassingYear() {
		return student12PassingYear;
	}


	public void setStudent12PassingYear(long student12PassingYear) {
		this.student12PassingYear = student12PassingYear;
	}

	public String getDisability() {
		return disability;
	}


	public void setDisability(String disability) {
		this.disability = disability;
	}


	public String getDisabilityType() {
		return disabilityType;
	}


	public void setDisabilityType(String disabilityType) {
		this.disabilityType = disabilityType;
	}


	public double getDisabilityPercentage() {
		return disabilityPercentage;
	}


	public void setDisabilityPercentage(double disabilityPercentage) {
		this.disabilityPercentage = disabilityPercentage;
	}


	public String getStudentMaritalStatus() {
		return studentMaritalStatus;
	}


	public void setStudentMaritalStatus(String studentMaritalStatus) {
		this.studentMaritalStatus = studentMaritalStatus;
	}


	public String getParentProfession() {
		return parentProfession;
	}


	public void setParentProfession(String parentProfession) {
		this.parentProfession = parentProfession;
	}


	public String getDomicileCertificate() {
		return domicileCertificate;
	}


	public void setDomicileCertificate(String domicileCertificate) {
		this.domicileCertificate = domicileCertificate;
	}


	public String getStudentPhotograph() {
		return studentPhotograph;
	}


	public void setStudentPhotograph(String studentPhotograph) {
		this.studentPhotograph = studentPhotograph;
	}


	public String getInstituteIdCard() {
		return instituteIdCard;
	}


	public void setInstituteIdCard(String instituteIdCard) {
		this.instituteIdCard = instituteIdCard;
	}


	public String getIncomeCertificate() {
		return incomeCertificate;
	}


	public void setIncomeCertificate(String incomeCertificate) {
		this.incomeCertificate = incomeCertificate;
	}


	public String getPreviousYearMarksheet() {
		return previousYearMarksheet;
	}


	public void setPreviousYearMarksheet(String previousYearMarksheet) {
		this.previousYearMarksheet = previousYearMarksheet;
	}


	public String getBankPassbook() {
		return bankPassbook;
	}


	public void setBankPassbook(String bankPassbook) {
		this.bankPassbook = bankPassbook;
	}


	public String getFeeReceipt() {
		return feeReceipt;
	}


	public void setFeeReceipt(String feeReceipt) {
		this.feeReceipt = feeReceipt;
	}


	public String getAadharCard() {
		return aadharCard;
	}


	public void setAadharCard(String aadharCard) {
		this.aadharCard = aadharCard;
	}


	public String getMarkSheet10() {
		return markSheet10;
	}


	public void setMarkSheet10(String markSheet10) {
		this.markSheet10 = markSheet10;
	}


	public String getMarkSheet12() {
		return markSheet12;
	}


	public void setMarkSheet12(String markSheet12) {
		this.markSheet12 = markSheet12;
	}


	public String getScholarshipType() {
		return scholarshipType;
	}


	public void setScholarshipType(String scholarshipType) {
		this.scholarshipType = scholarshipType;
	}


	public StudentRegistrationDetails getRegistration() {
		return registration;
	}
	
	public void setRegistration(StudentRegistrationDetails registration) {
		this.registration = registration;
	}

	//To string Method

	@Override
	public String toString() {
		return "StudentDetails [studentApplicationNo=" + studentApplicationNo + ", studentName=" + studentName
				+ ", state=" + state + ", district=" + district + ", blockNo=" + blockNo + ", streetNo=" + streetNo
				+ ", houseNo=" + houseNo + ", pinCode=" + pinCode + ", tuitionFee=" + tuitionFee + ", admissionFee="
				+ admissionFee + ", otherFee=" + otherFee + ", bankName=" + bankName + ", bankAccountNo="
				+ bankAccountNo + ", bankIfscCode=" + bankIfscCode + ", studentReligion=" + studentReligion
				+ ", studentCategory=" + studentCategory + ", studentFatherName=" + studentFatherName
				+ ", studentMotherName=" + studentMotherName + ", studentFamilyIncome=" + studentFamilyIncome
				+ ", studentCourse=" + studentCourse + ", studentYear=" + studentYear + ", modeOfStudy=" + modeOfStudy
				+ ", courseStartDate=" + courseStartDate + ", studentPrevCourse=" + studentPrevCourse
				+ ", studentPrevPassingYear=" + studentPrevPassingYear + ", studentPrevPercent=" + studentPrevPercent
				+ ", student10RollNo=" + student10RollNo + ", student10BoardName=" + student10BoardName
				+ ", student10PassingYear=" + student10PassingYear + ", student10Percent=" + student10Percent
				+ ", student12RollNo=" + student12RollNo + ", student12Board=" + student12Board
				+ ", student12PassingYear=" + student12PassingYear + ", student12Percent=" + student12Percent
				+ ", disability=" + disability + ", disabilityType=" + disabilityType + ", disabilityPercentage="
				+ disabilityPercentage + ", studentMaritalStatus=" + studentMaritalStatus + ", parentProfession="
				+ parentProfession + ", domicileCertificate=" + domicileCertificate + ", studentPhotograph="
				+ studentPhotograph + ", instituteIdCard=" + instituteIdCard + ", incomeCertificate="
				+ incomeCertificate + ", previousYearMarksheet=" + previousYearMarksheet + ", bankPassbook="
				+ bankPassbook + ", feeReceipt=" + feeReceipt + ", aadharCard=" + aadharCard + ", markSheet10="
				+ markSheet10 + ", markSheet12=" + markSheet12 + ", scholarshipType=" + scholarshipType
				+ ", bonafideCertificate=" + bonafideCertificate + ", applicationStatus=" + applicationStatus
				+ ", registration=" + registration + "]";
	}


	
}
