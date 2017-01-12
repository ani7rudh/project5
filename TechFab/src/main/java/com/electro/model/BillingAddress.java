package com.electro.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class BillingAddress implements Serializable {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

	private int billingAdddressId;
	
	private String streetAddress;
	private String flatNo;
	private String city;
	private String state;
	private String postalCode;
	
	@OneToOne
	private UserDetails userDetails;

	public int getBillingAdddressId() {
		return billingAdddressId;
	}

	public void setBillingAdddressId(int billingAdddressId) {
		this.billingAdddressId = billingAdddressId;
	}

	public String getStreetAddress() {
		return streetAddress;
	}

	public void setStreetAddress(String streetAddress) {
		this.streetAddress = streetAddress;
	}

	public String getFlatNo() {
		return flatNo;
	}

	public void setFlatNo(String flatNo) {
		this.flatNo = flatNo;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getPostalCode() {
		return postalCode;
	}

	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}

	public UserDetails getUserDetails() {
		return userDetails;
	}

	public void setUserDetails(UserDetails userDetails) {
		this.userDetails = userDetails;
	}

			
	
	
	

}
