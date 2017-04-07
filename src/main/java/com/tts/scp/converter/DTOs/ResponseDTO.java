package com.tts.scp.converter.DTOs;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;

@JsonRootName(value = "d")
public class ResponseDTO {
	
	
	private String lastName;
	private String address;
	private String cellPhone;
	private String firstName;
	private String city;
	private String country;
	@JsonProperty("custappattachment")
	private AttachmentDTO attachments;
	
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
	public String getCellPhone() {
		return cellPhone;
	}
	public void setCellPhone(String cellPhone) {
		this.cellPhone = cellPhone;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}

	public AttachmentDTO getAttachments() {
		return attachments;
	}

	public void setAttachments(AttachmentDTO attachments) {
		this.attachments = attachments;
	}




}
