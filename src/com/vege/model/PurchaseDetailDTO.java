package com.vege.model;

public class PurchaseDetailDTO {
	private int purchase_detail_num, purchase_num, product_num, purchase_quantity;

	PurchaseDetailDTO(){
		
	}

	public PurchaseDetailDTO(int purchase_detail_num, int purchase_num, int product_num, int purchase_quantity) {
		super();
		this.purchase_detail_num = purchase_detail_num;
		this.purchase_num = purchase_num;
		this.product_num = product_num;
		this.purchase_quantity = purchase_quantity;
	}

	public int getPurchase_detail_num() {
		return purchase_detail_num;
	}

	public void setPurchase_detail_num(int purchase_detail_num) {
		this.purchase_detail_num = purchase_detail_num;
	}

	public int getPurchase_num() {
		return purchase_num;
	}

	public void setPurchase_num(int purchase_num) {
		this.purchase_num = purchase_num;
	}

	public int getProduct_num() {
		return product_num;
	}

	public void setProduct_num(int product_num) {
		this.product_num = product_num;
	}

	public int getPurchase_quantity() {
		return purchase_quantity;
	}

	public void setPurchase_quantity(int purchase_quantity) {
		this.purchase_quantity = purchase_quantity;
	}

	@Override
	public String toString() {
		return "PurchaseDetailDTO [purchase_detail_num=" + purchase_detail_num + ", purchase_num=" + purchase_num
				+ ", product_num=" + product_num + ", purchase_quantity=" + purchase_quantity + "]";
	}
	
	
}
