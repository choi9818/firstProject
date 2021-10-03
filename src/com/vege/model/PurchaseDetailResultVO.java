package com.vege.model;

public class PurchaseDetailResultVO {
	String product_name;
	int qua;
	int amount;
	String phone_num;
	String custname_name;

	public PurchaseDetailResultVO(String product_name, int qua, int amount, String phone_num, String custname_name) {
		super();
		this.product_name = product_name;
		this.qua = qua;
		this.amount = amount;
		this.phone_num = phone_num;
		this.custname_name = custname_name;
	}

	public String getProduct_name() {
		return product_name;
	}
	public void setProduct_name(String product_name) {
		this.product_name = product_name;
	}
	public int getQua() {
		return qua;
	}
	public void setQua(int qua) {
		this.qua = qua;
	}
	public int getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}
	@Override
	public String toString() {
		return "구매완료 목록 [메뉴 : " + product_name + ", 수량 : " + qua + ", 금액 : " + amount + "]";
	}
	
	
}
