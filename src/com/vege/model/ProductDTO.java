package com.vege.model;

public class ProductDTO {
	private int product_num, product_price;
	private String product_name;
	
	ProductDTO() {
		
	}

	public ProductDTO(int product_num, int product_price, String product_name) {

		this.product_num = product_num;
		this.product_price = product_price;
		this.product_name = product_name;
	}

	public int getProduct_num() {
		return product_num;
	}

	public void setProduct_num(int product_num) {
		this.product_num = product_num;
	}

	public int getProduct_price() {
		return product_price;
	}

	public void setProduct_price(int product_price) {
		this.product_price = product_price;
	}

	public String getProduct_name() {
		return product_name;
	}

	public void setProduct_name(String product_name) {
		this.product_name = product_name;
	}

	@Override
	public String toString() {
		return product_num + "번 메뉴 " + product_name + "입니다. 가격은 " + product_price + "원입니다.";
	}
	
	
}
