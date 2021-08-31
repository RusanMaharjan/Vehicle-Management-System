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
@Table(name = "vehicleMaintenance")
public class VehicleMaintenance extends Auditable<String> {
		
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@ManyToOne
	@JoinColumn(name="vehicleid", insertable=false, updatable=false)
	private Vehicle vehicle;
	private Integer vehicleid;
	
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date startDate;
	
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date endDate;
	
	private String price;
	
	@ManyToOne
	@JoinColumn(name="supplierid", insertable=false, updatable=false)
	private Supplier supplier;
	private Integer supplierid;
	
	private String remarks;
	
	
	//all arguments constructor
	public VehicleMaintenance(int id, Vehicle vehicle, int vehicleid, Date startDate, Date endDate, String price, Supplier supplier, int supplierid, String remarks) {
		this.id = id;
		this.vehicle = vehicle;
		this.vehicleid = vehicleid;
		this.startDate = startDate;
		this.endDate = endDate;
		this.price = price;
		this.supplier = supplier;
		this.supplierid = supplierid;
		this.remarks = remarks;
	}
	
	
	//no arguments constructor
	public VehicleMaintenance() {
		
	}


	//getter and setter method
	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public Vehicle getVehicle() {
		return vehicle;
	}


	public void setVehicle(Vehicle vehicle) {
		this.vehicle = vehicle;
	}


	public Integer getVehicleid() {
		return vehicleid;
	}


	public void setVehicleid(Integer vehicleid) {
		this.vehicleid = vehicleid;
	}


	public Date getStartDate() {
		return startDate;
	}


	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}


	public Date getEndDate() {
		return endDate;
	}


	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}


	public String getPrice() {
		return price;
	}


	public void setPrice(String price) {
		this.price = price;
	}


	public Supplier getSupplier() {
		return supplier;
	}


	public void setSupplier(Supplier supplier) {
		this.supplier = supplier;
	}


	public Integer getSupplierid() {
		return supplierid;
	}


	public void setSupplierid(Integer supplierid) {
		this.supplierid = supplierid;
	}


	public String getRemarks() {
		return remarks;
	}


	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}	
}
