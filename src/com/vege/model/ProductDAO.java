package com.vege.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.vege.util.DBUtil;

public class ProductDAO {
	public List<ProductDTO> selectAll() {
		List<ProductDTO> prolist = new ArrayList<>();
		String sql = "select * from product";
		Connection conn = DBUtil.dbConnect();// DB연결
		PreparedStatement st = null;
		ResultSet rs = null;
		try {
			st = conn.prepareStatement(sql); 
			rs = st.executeQuery();// rs:결과 받는
			while (rs.next()) {
				prolist.add(makePro(rs));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBUtil.dbClose(conn, st, rs);
		}
		return prolist;
	}

	private ProductDTO makePro(ResultSet rs) throws SQLException {
		ProductDTO pro = new ProductDTO();
		pro.setProduct_num(rs.getInt("Product_num"));
		pro.setProduct_name(rs.getString("Product_name"));
		pro.setProduct_price(rs.getInt("Product_price"));
		return pro;
	}
}
