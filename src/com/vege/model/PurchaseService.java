package com.vege.model;

import java.util.List;

public class PurchaseService {
	PurchaseDAO dao = new PurchaseDAO();
	
	public int purchaseInsert(CustomerDTO customer, List<PurchaseDetailDTO> detailList) {
		return dao.purchaseInsert(customer, detailList);
	}
}
