package com.vege.view;

import java.util.List;

import com.vege.model.CustomerDTO;

public class CustomerView {
	public static void display(List<CustomerDTO> customerlist) {
		for(CustomerDTO customer:customerlist) {
			System.out.println(customer);
		}
	}
}
