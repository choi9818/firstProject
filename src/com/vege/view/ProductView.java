package com.vege.view;

import java.util.List;

import com.vege.model.ProductDTO;

public class ProductView {
	public static void display(List<ProductDTO> prolist) {
		for(ProductDTO product:prolist) {
			System.out.println(product);
		}
	}
}
