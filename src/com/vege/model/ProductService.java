package com.vege.model;

import java.util.List;

public class ProductService {
	ProductDAO dao = new ProductDAO();
	
	public List<ProductDTO> selectAll() {
		return dao.selectAll();
	}
}
