package com.vege.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.vege.util.DBUtil;

public class CustomerDAO {
	public int customerInsert(CustomerDTO customer) {
		String sql = "insert into customer values(?, ?, ?, ?)";
		Connection conn = DBUtil.dbConnect();// DB연결
		PreparedStatement st = null;
		int result = 0;

		try {
			st = conn.prepareStatement(sql);
			st.setString(1, customer.getPhone_num());
			st.setString(2, customer.getCustomer_name());
			st.setDate(3, customer.getBirth());
			st.setString(4, customer.getAddress());
			result = st.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBUtil.dbClose(conn, st, null);
		}
		return result;
	}
	
	public CustomerDTO login(String phone_num, String customer_name) {
		CustomerDTO customer = null;
		String sql = "select * from customer where phone_num = ?"
				+ " and customer_name = ?";
		Connection conn = DBUtil.dbConnect();// DB연결
		PreparedStatement st = null;
		ResultSet rs = null;

		try {
			st = conn.prepareStatement(sql);
			st.setString(1, phone_num);
			st.setString(2, customer_name);
			rs = st.executeQuery();
			if(rs.next()){
				customer = new CustomerDTO(phone_num, null, customer_name, null);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBUtil.dbClose(conn, st, null);
		}
		return customer;
	}
	
}
