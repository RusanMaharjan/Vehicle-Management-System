package com.project.fleetapp.models;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

@MappedSuperclass
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
@Table(name = "commonObject")
public class CommonObject extends Auditable<String>{
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column
	private int id;
	private String description;
	private String details;
	
	//all argument constructors
	public CommonObject(int id, String description, String details) {
		this.id = id;
		this.description = description;
		this.details = details;
	}

	//no argument constructors
	public CommonObject() {
		
	}

	//getter and setter methods
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getDetails() {
		return details;
	}

	public void setDetails(String details) {
		this.details = details;
	}

	//generate to string method
	@Override
	public String toString() {
		return "CommonObject [id=" + id + ", description=" + description + ", details=" + details + "]";
	}
	
	
}
