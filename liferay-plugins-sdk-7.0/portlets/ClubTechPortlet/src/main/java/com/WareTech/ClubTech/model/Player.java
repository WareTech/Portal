package com.WareTech.ClubTech.model;

import java.time.format.DateTimeFormatter;

public class Player
{
	final static public DateTimeFormatter DATE_TIME_FORMATTER = DateTimeFormatter.ofPattern("yyyyMMdd"); 

	protected Long id;
	protected String firstname;
	protected String lastname;
	protected String dni;
	protected String birthdate;
	protected String category;
	protected String year;
	protected String status;
	protected String code;

	public Player(){}
	
	public Player(String firstname, String lastname, String dni, String birthdate, String category, String year, String status, String code) 
	{
		this(null, firstname, lastname, dni, birthdate, category, year, status, code);
	}
	
	public Player(Long id, String firstname, String lastname, String dni, String birthdate, String category, String year, String status, String code) 
	{
		this.id = id;
		this.firstname = firstname;
		this.lastname = lastname;
		this.dni = dni;
		this.birthdate = birthdate;
		this.category = category;
		this.year = year;
		this.status = status;
		this.code = code;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getFirstname() {
		return firstname;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	public String getDni() {
		return dni;
	}
	public void setDni(String dni) {
		this.dni = dni;
	}
	public String getBirthdate() {
		return birthdate;
	}
	public void setBirthdate(String birthdate) {
		this.birthdate = birthdate;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public String getYear() {
		return year;
	}
	public void setYear(String year) {
		this.year = year;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	
}
