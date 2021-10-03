package com.vege.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.vege.util.DBUtil;

public class PurchaseDetailDAO {
	public List<PurchaseDetailResultVO> totalPrice(int purchase_num, String phone_num, String customer_name) {
		String sql = "select product_name, purchase_quantity, product_price * purchase_quantity, phone_num, customer_name"
				+ " from purchase_detail join product using(product_num) "
				+ " join purchase using(purchase_num) "
				+ " join customer using(phone_num)"
				+ " where purchase_num = ?"
				+ " and phone_num = ?"
				+ " and customer_name = ?";
		
		Connection conn = DBUtil.dbConnect();// DB¿¬°á
		PreparedStatement st = null;
		ResultSet rs = null;
		List<PurchaseDetailResultVO> detaillist = new ArrayList<>();
		try {
			st = conn.prepareStatement(sql);
			st.setInt(1, purchase_num);
			st.setString(2, phone_num);
			st.setString(3, customer_name);
			rs = st.executeQuery();
			while(rs.next()) {
				detaillist.add(new PurchaseDetailResultVO(rs.getString(1), rs.getInt(2), rs.getInt(3),rs.getString(4),rs.getString(5)));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			DBUtil.dbClose(conn, st, rs);
		}
		return detaillist;
		
	}
	
}
