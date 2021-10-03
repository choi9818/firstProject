package com.vege.model;

public class CustomerService {
	CustomerDAO dao = new CustomerDAO();
	
	public int customerInsert(CustomerDTO customer) {
		return dao.customerInsert(customer);
	}
	public CustomerDTO login(String phone_num, String customer_name) {
		return dao.login(phone_num, customer_name);
	}

}
