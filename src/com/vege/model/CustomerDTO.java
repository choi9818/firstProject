package com.vege.model;

import java.sql.Date;

public class CustomerDTO {
	private String phone_num, customer_name, address;
	Date birth;
	
	public CustomerDTO() {
		
	}

	public CustomerDTO(String phone_num, Date birth, String customer_name, String address) {
		super();
		this.phone_num = phone_num;
		this.birth = birth;
		this.customer_name = customer_name;
		this.address = address;
	}

	public String getPhone_num() {
		return phone_num;
	}

	public void setPhone_num(String phone_num) {
		this.phone_num = phone_num;
	}

	public Date getBirth() {
		return birth;
	}

	public void setBirth(Date birth) {
		this.birth = birth;
	}

	public String getCustomer_name() {
		return customer_name;
	}

	public void setCustomer_name(String customer_name) {
		this.customer_name = customer_name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	@Override
	public String toString() {
		return "CustomerDTO [phone_num=" + phone_num + ", birth=" + birth + ", customer_name=" + customer_name
				+ ", address=" + address + "]";
	}

	
	
	
}
