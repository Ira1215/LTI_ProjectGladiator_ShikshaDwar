package com.lti.model;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name ="INSTITUTE")
public class Institute implements Serializable {
	
	@Id
	@Column(name="INSTITUTE_CODE")
	private String instituteCode;
		
	@Column(name = "INSTITUTE_NAME")
	private String instituteName;
	
	@Column(name="INSTITUTE_CATEGORY")
	private  String instituteCategory;
	
	@Column(name="INSTITUTE_LOCATION")
	private String instituteLocation;
	
	@Column(name="INSTITUTE_TYPE")
	private String instituteType;
	
	@Column(name="AFFILIATED_UNI_STATE")
	private String affiliatedUniState;
	
	@Column(name="AFFILIATED_UNIBOARD")
	private String affiliatedUniboard;
	
	@Temporal(TemporalType.DATE)
	@Column(name="YEAR_ADMISSION_STARTED")
	private Date yearAdmissionStarted;
	
	@Column(name="UNI_AFFILIATION_CERTI")
	private String uniAffiliationCerti;   //to be uploaded
	
	@Column(name="INSTITUTE_ESTB_CERTI")
	private String instituteEstbCerti;  //to be uploaded
	
	@Column(name="ADDRESS_LINE1")
	private String addressLine1;
	
	@Column(name="ADDRESS_LINE2")
	private String addressLine2;
	
	@Column(name = "INSTITUTE_STATE")
	private String instituteState;
	
	@Column(name="DISTRICT")
	private String district;
	
	@Column(name="CITY")
	private String city;
	
	@Column(name = "PINCODE")
	private long pincode;
	
	@Column(name="INSTITUTE_HEAD_NAME")
	private String instituteHeadName;
	
	@Column(name = "INSTITUTE_HEAD_CONTACT")
	private String instituteHeadContact;

	@Column(name = "REGISTRATION_STATUS")
	private String registrationStatus="Pending";
	
	@OneToOne
	@JoinColumn(name="DISE_CODE")
	private InstitueLogin login;
	
	
	@OneToMany(mappedBy = "institute", cascade = CascadeType.ALL)
	private Set<StudentRegistrationDetails> students;
	
	
	//Default Constructor
	public Institute()
	{
		
	}

	//Parameterized Constructor
	public Institute(String instituteCode, String instituteName, String instituteCategory, String instituteLocation,
			String instituteType, String affiliatedUniState, String affiliatedUniboard, Date yearAdmissionStarted,
			String uniAffiliationCerti, String instituteEstbCerti, String addressLine1, String addressLine2,
			String instituteState, String district, String city, long pincode, String instituteHeadName,
			String instituteHeadContact) {
		super();
		this.instituteCode = instituteCode;
		this.instituteName = instituteName;
		this.instituteCategory = instituteCategory;
		this.instituteLocation = instituteLocation;
		this.instituteType = instituteType;
		this.affiliatedUniState = affiliatedUniState;
		this.affiliatedUniboard = affiliatedUniboard;
		this.yearAdmissionStarted = yearAdmissionStarted;
		this.uniAffiliationCerti = uniAffiliationCerti;
		this.instituteEstbCerti = instituteEstbCerti;
		this.addressLine1 = addressLine1;
		this.addressLine2 = addressLine2;
		this.instituteState = instituteState;
		this.district = district;
		this.city = city;
		this.pincode = pincode;
		this.instituteHeadName = instituteHeadName;
		this.instituteHeadContact = instituteHeadContact;
	}

	//Getter and Setter
	public String getInstituteCode() {
		return instituteCode;
	}

	public void setInstituteCode(String instituteCode) {
		this.instituteCode = instituteCode;
	}
	
	public String getInstituteName() {
		return instituteName;
	}

	public void setInstituteName(String instituteName) {
		this.instituteName = instituteName;
	}

	public String getInstituteCategory() {
		return instituteCategory;
	}

	public void setInstituteCategory(String instituteCategory) {
		this.instituteCategory = instituteCategory;
	}

	public String getInstituteLocation() {
		return instituteLocation;
	}

	public void setInstituteLocation(String instituteLocation) {
		this.instituteLocation = instituteLocation;
	}

	public String getInstituteType() {
		return instituteType;
	}

	public void setInstituteType(String instituteType) {
		this.instituteType = instituteType;
	}


	public Date getYearAdmissionStarted() {
		return yearAdmissionStarted;
	}

	public void setYearAdmissionStarted(Date yearAdmissionStarted) {
		this.yearAdmissionStarted = yearAdmissionStarted;
	}

	public String getAddressLine1() {
		return addressLine1;
	}

	
	public String getAffiliatedUniState() {
		return affiliatedUniState;
	}

	public void setAffiliatedUniState(String affiliatedUniState) {
		this.affiliatedUniState = affiliatedUniState;
	}

	public String getAffiliatedUniboard() {
		return affiliatedUniboard;
	}

	public void setAffiliatedUniboard(String affiliatedUniboard) {
		this.affiliatedUniboard = affiliatedUniboard;
	}

	public String getUniAffiliationCerti() {
		return uniAffiliationCerti;
	}

	public void setUniAffiliationCerti(String uniAffiliationCerti) {
		this.uniAffiliationCerti = uniAffiliationCerti;
	}

	public String getInstituteEstbCerti() {
		return instituteEstbCerti;
	}

	public void setInstituteEstbCerti(String instituteEstbCerti) {
		this.instituteEstbCerti = instituteEstbCerti;
	}

	public void setAddressLine1(String addressLine1) {
		this.addressLine1 = addressLine1;
	}

	public String getAddressLine2() {
		return addressLine2;
	}

	public void setAddressLine2(String addressLine2) {
		this.addressLine2 = addressLine2;
	}

	public String getInstituteState() {
		return instituteState;
	}

	public void setInstituteState(String instituteState) {
		this.instituteState = instituteState;
	}

	public String getDistrict() {
		return district;
	}

	public void setDistrict(String district) {
		this.district = district;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public long getPincode() {
		return pincode;
	}

	public void setPincode(long pincode) {
		this.pincode = pincode;
	}

	public String getInstituteHeadName() {
		return instituteHeadName;
	}

	public void setInstituteHeadName(String instituteHeadName) {
		this.instituteHeadName = instituteHeadName;
	}

	public String getInstituteHeadContact() {
		return instituteHeadContact;
	}

	public void setInstituteHeadContact(String instituteHeadContact) {
		this.instituteHeadContact = instituteHeadContact;
	}

	public InstitueLogin getLogin() {
		return login;
	}

	public void setLogin(InstitueLogin login) {
		this.login = login;
	}
	
	public Set<StudentRegistrationDetails> getStudents() {
		return students;
	}

	public void setStudents(Set<StudentRegistrationDetails> students) {
		this.students = students;
	}
	
	public String getRegistrationStatus() {
		return registrationStatus;
	}

	public void setRegistrationStatus(String registrationStatus) {
		this.registrationStatus = registrationStatus;
	}


	@Override
	public String toString() {
		return "Institute [instituteCode=" + instituteCode + ", instituteName=" + instituteName + ", instituteCategory="
				+ instituteCategory + ", instituteLocation=" + instituteLocation + ", instituteType=" + instituteType
				+ ", affiliatedUniState=" + affiliatedUniState + ", affiliatedUniboard=" + affiliatedUniboard
				+ ", yearAdmissionStarted=" + yearAdmissionStarted + ", uniAffiliationCerti=" + uniAffiliationCerti
				+ ", instituteEstbCerti=" + instituteEstbCerti + ", addressLine1=" + addressLine1 + ", addressLine2="
				+ addressLine2 + ", instituteState=" + instituteState + ", district=" + district + ", city=" + city
				+ ", pincode=" + pincode + ", instituteHeadName=" + instituteHeadName + ", instituteHeadContact="
				+ instituteHeadContact + ", registrationStatus=" + registrationStatus + "]";
	}

	
	
	
	
	
	

}
