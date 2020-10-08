package com.lti.dto;

public class StudentForInstituteDto {
	
	private String studentName;
	private String studentAadharNo;
	private String studentReligion;
	private String studentCategory;
	private String studentFatherName;
	private String studentMotherName;
	private long studentFamilyIncome;
	private String studentCourse;
	private int studentYear;
	private String studentPrevCourse;
	private long studentPrevPassingYear;
	private double studentPrevPercent;
	private double student10Percent;
	private double student12Percent;
	private String scholarshipType; 
	
	public StudentForInstituteDto() {
		
	}

	public StudentForInstituteDto(String studentName, String studentAadharNo, String studentReligion,
			String studentCategory, String studentFatherName, String studentMotherName, long studentFamilyIncome,
			String studentCourse, int studentYear, String studentPrevCourse, long studentPrevPassingYear,
			double studentPrevPercent, double student10Percent, double student12Percent, String scholarshipType) {
		super();
		this.studentName = studentName;
		this.studentAadharNo = studentAadharNo;
		this.studentReligion = studentReligion;
		this.studentCategory = studentCategory;
		this.studentFatherName = studentFatherName;
		this.studentMotherName = studentMotherName;
		this.studentFamilyIncome = studentFamilyIncome;
		this.studentCourse = studentCourse;
		this.studentYear = studentYear;
		this.studentPrevCourse = studentPrevCourse;
		this.studentPrevPassingYear = studentPrevPassingYear;
		this.studentPrevPercent = studentPrevPercent;
		this.student10Percent = student10Percent;
		this.student12Percent = student12Percent;
		this.scholarshipType = scholarshipType;
	}

	public String getStudentName() {
		return studentName;
	}

	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}

	public String getStudentAadharNo() {
		return studentAadharNo;
	}

	public void setStudentAadharNo(String studentAadharNo) {
		this.studentAadharNo = studentAadharNo;
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

	public long getStudentFamilyIncome() {
		return studentFamilyIncome;
	}

	public void setStudentFamilyIncome(long studentFamilyIncome) {
		this.studentFamilyIncome = studentFamilyIncome;
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

	public double getStudent10Percent() {
		return student10Percent;
	}

	public void setStudent10Percent(double student10Percent) {
		this.student10Percent = student10Percent;
	}

	public double getStudent12Percent() {
		return student12Percent;
	}

	public void setStudent12Percent(double student12Percent) {
		this.student12Percent = student12Percent;
	}

	public String getScholarshipType() {
		return scholarshipType;
	}

	public void setScholarshipType(String scholarshipType) {
		this.scholarshipType = scholarshipType;
	}
	
}
