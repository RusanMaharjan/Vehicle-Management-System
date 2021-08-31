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

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
@Table(name = "vehicleMovement")
public class VehicleMovement {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@ManyToOne
	@JoinColumn(name="vehicleid", insertable=false, updatable=false)
	private Vehicle vehicle;
	private int vehicleid;
	
	@ManyToOne
	@JoinColumn(name="locationid1", insertable=false, updatable=false)
	private Location location1;
	private int locationid1;
	
	@DateTimeFormat(pattern = "yyyy-MM-dd")	
	private Date date1;
	
	@ManyToOne
	@JoinColumn(name="locationid2", insertable=false, updatable=false)
	private Location location2;
	private int locationid2;
	
	@DateTimeFormat(pattern = "yyyy-MM-dd")		
	private Date date2;

	private String remarks;
	
	//all argument constructor
	public VehicleMovement(int id, Vehicle vehicle, int vehicleid, Location location1, int locationid1, Date date1, Location location2, int locationid2, Date date2, String remarks) {
		this.id = id;
		this.vehicle = vehicle;
		this.vehicleid = vehicleid;
		this.location1 = location1;
		this.locationid1 = locationid1;
		this.date1 = date1;
		this.location2 = location2;
		this.locationid2 = locationid2;
		this.date2 = date2;
		this.remarks = remarks;
	}
	
	//no argument constructor or default constructor
	public VehicleMovement() {
		
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

	public int getVehicleid() {
		return vehicleid;
	}

	public void setVehicleid(int vehicleid) {
		this.vehicleid = vehicleid;
	}

	public Location getLocation1() {
		return location1;
	}

	public void setLocation1(Location location1) {
		this.location1 = location1;
	}

	public int getLocationid1() {
		return locationid1;
	}

	public void setLocationid1(int locationid1) {
		this.locationid1 = locationid1;
	}

	public Date getDate1() {
		return date1;
	}

	public void setDate1(Date date1) {
		this.date1 = date1;
	}

	public Location getLocation2() {
		return location2;
	}

	public void setLocation2(Location location2) {
		this.location2 = location2;
	}

	public int getLocationid2() {
		return locationid2;
	}

	public void setLocationid2(int locationid2) {
		this.locationid2 = locationid2;
	}

	public Date getDate2() {
		return date2;
	}

	public void setDate2(Date date2) {
		this.date2 = date2;
	}

	public String getRemarks() {
		return remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}	
}
