package com.project.fleetapp.models;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;




@Entity
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
@Table (name="employee")
public class Employee {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column (name = "id")
	private int id;
	
	@ManyToOne
	@JoinColumn (name="employeetypeid", insertable=false, updatable=false)
	private EmployeeType employeeType;
	private int employeetypeid;
	
	private String username;
	
	@ManyToOne
	@JoinColumn (name="jobtitleid", insertable=false, updatable=false)
	private JobTitle jobTitle;
	private int jobtitleid;
	
	@ManyToOne
	@JoinColumn(name="countryid", insertable=false, updatable=false)
	private Country country;
	private int countryid;
	
	@ManyToOne
	@JoinColumn(name="stateid", insertable=false, updatable=false)
	private State state;
	private int stateid;
	
	@DateTimeFormat (pattern = "yyyy-MM-dd")
	private Date hireDate;
	
	@DateTimeFormat (pattern = "yyyy-MM-dd")
	private Date dateOfBirth;
	
	
	private String firstName;
	private String lastName;
	private String otherName;
	private String title;
	private String initials;
	private String socialSecurityNumber;
	private String gender;
	private String maritalStatus;
	private String city;
	private String address;
	private String phone;
	private String mobile;
	private String email;
	private String photo;
	
	//all args constructor
	public Employee(EmployeeType employeeType, int employeetypeid, String username, JobTitle jobTitle, int jobtitleid, 
			Date hireDate, Date dateOfBirth, int id, String firstName, String lastName, String otherName, String title, 
			String initials, 
			String socialSecurityNumber, String gender, String maritalStatus, Country country, int countryid,
			State state, int stateid, String city, String address, String phone, String mobile, String email,
			String photo) {
		
		
	this.employeeType = employeeType;
	this.employeetypeid = employeetypeid;
	this.username = username;
	this.jobTitle = jobTitle;
	this.jobtitleid = jobtitleid;
	this.hireDate = hireDate;
	this.dateOfBirth = dateOfBirth;
	this.id = id;
	this.firstName = firstName;
	this.lastName = lastName;
	this.otherName = otherName;
	this.title = title;
	this.socialSecurityNumber = socialSecurityNumber;
	this.gender = gender;
	this.maritalStatus = maritalStatus;
	this.country = country;
	this.countryid = countryid;
	this.state = state;
	this.stateid = stateid;
	this.city = city;
	this.address = address;
	this.phone = phone;
	this.mobile = mobile;
	this.email = email;
	this.photo = photo;
	}

	
	//no argument constructors
	public Employee() {
		
	}
	
	
	//getter and setter method
	public EmployeeType getEmployeeType() {
		return employeeType;
	}

	public void setEmployeeType(EmployeeType employeeType) {
		this.employeeType = employeeType;
	}

	public int getEmployeetypeid() {
		return employeetypeid;
	}

	public void setEmployeetypeid(int employeetypeid) {
		this.employeetypeid = employeetypeid;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public JobTitle getJobTitle() {
		return jobTitle;
	}

	public void setJobTitle(JobTitle jobTitle) {
		this.jobTitle = jobTitle;
	}

	public int getJobtitleid() {
		return jobtitleid;
	}

	public void setJobtitleid(int jobtitleid) {
		this.jobtitleid = jobtitleid;
	}

	public Country getCountry() {
		return country;
	}

	public void setCountry(Country country) {
		this.country = country;
	}

	public int getCountryid() {
		return countryid;
	}

	public void setCountryid(int countryid) {
		this.countryid = countryid;
	}

	public State getState() {
		return state;
	}

	public void setState(State state) {
		this.state = state;
	}

	public int getStateid() {
		return stateid;
	}

	public void setStateid(int stateid) {
		this.stateid = stateid;
	}

	public Date getHireDate() {
		return hireDate;
	}

	public void setHireDate(Date hireDate) {
		this.hireDate = hireDate;
	}

	public Date getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getOtherName() {
		return otherName;
	}

	public void setOtherName(String otherName) {
		this.otherName = otherName;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getInitials() {
		return initials;
	}

	public void setInitials(String initials) {
		this.initials = initials;
	}

	public String getSocialSecurityNumber() {
		return socialSecurityNumber;
	}

	public void setSocialSecurityNumber(String socialSecurityNumber) {
		this.socialSecurityNumber = socialSecurityNumber;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getMaritalStatus() {
		return maritalStatus;
	}

	public void setMaritalStatus(String maritalStatus) {
		this.maritalStatus = maritalStatus;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhoto() {
		return photo;
	}

	public void setPhoto(String photo) {
		this.photo = photo;
	}	
}
