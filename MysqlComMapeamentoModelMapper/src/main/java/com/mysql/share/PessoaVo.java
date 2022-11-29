package com.mysql.share;

import java.io.Serializable;



public class PessoaVo implements Serializable {

	private static final long serialVersionUID = 1L;

	private Long id;

	private String firstName;

	private String lastName;

	private String address;

	private String gender;

	public PessoaVo() {

	}

	public PessoaVo(String firstName, String lastName, String address, String gender) {

		this.firstName = firstName;
		this.lastName = lastName;
		this.address = address;
		this.gender = gender;
	}

	
	public PessoaVo(Long id, String firstName, String lastName, String address, String gender) {
		
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.address = address;
		this.gender = gender;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFistName() {
		return firstName;
	}

	public void setFistName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

}
