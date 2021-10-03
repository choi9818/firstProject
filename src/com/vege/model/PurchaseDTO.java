package com.vege.model;

import java.sql.Date;

public class PurchaseDTO {
	private int purchase_num, phone_num;
	private Date purchase_date;
	
	PurchaseDTO() {
		
	}

	public PurchaseDTO(int purchase_num, int phone_num, Date purchase_date) {
		super();
		this.purchase_num = purchase_num;
		this.phone_num = phone_num;
		this.purchase_date = purchase_date;
	}

	public int getPurchase_num() {
		return purchase_num;
	}

	public void setPurchase_num(int purchase_num) {
		this.purchase_num = purchase_num;
	}


	public int getPhone_num() {
		return phone_num;
	}

	public void setPhone_num(int phone_num) {
		this.phone_num = phone_num;
	}

	public Date getPurchase_date() {
		return purchase_date;
	}

	public void setPurchase_date(Date purchase_date) {
		this.purchase_date = purchase_date;
	}

	@Override
	public String toString() {
		return "PurchaseDTO [purchase_num=" + purchase_num + ", phone_num=" + phone_num + ", purchase_date="
				+ purchase_date + "]";
	}
	
}
