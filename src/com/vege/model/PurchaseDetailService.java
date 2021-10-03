package com.vege.model;

import java.util.List;

public class PurchaseDetailService {
	PurchaseDetailDAO dao = new PurchaseDetailDAO();
	
	public List<PurchaseDetailResultVO> totalPrice(int purchase_num, String phone_num, String customer_name){
		return dao.totalPrice(purchase_num, phone_num, customer_name);
		
	}
}
