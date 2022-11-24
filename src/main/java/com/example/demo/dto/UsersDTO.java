package com.example.demo.dto;


import java.util.Date;

import lombok.Data;

@Data
public class UsersDTO  { // implements Serializabe

    
	/**
	public int id;		
	
	
	public String firstname;
	
    
    public String lastname;
	
	
	public String username;
		
	
	public Date createdAT;
	
	
	public Date updatedAt;
	*/
	
	
	
	
	
    private int id;		
	
	
	private String firstname;
	
    
    private String lastname;
	
	
	private String username;
		
	
	private Date createdAT;
	
	
	private Date updatedAt;
	
	
//////Borrar gets and sets
	
	
	  public int getId() {
		return id;
	}
	  public void setId(int id) {
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


	public String getUsername() {
		return username;
	}


	public void setUsername(String username) {
		this.username = username;
	}


	public Date getCreatedAT() {
		return createdAT;
	}


	public void setCreatedAT(Date createdAT) {
		this.createdAT = createdAT;
	}


	public Date getUpdatedAt() {
		return updatedAt;
	}


	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}

	
	
}
