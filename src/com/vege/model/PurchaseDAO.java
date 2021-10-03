package com.vege.model;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import com.vege.util.DBUtil;

public class PurchaseDAO {
	public int purchaseInsert(CustomerDTO customer, List<PurchaseDetailDTO> detailList) {
		String sql = "insert into purchase (purchase_num, purchase_date, phone_num) "
				+ " values(seq_num.nextval,sysdate,'" + customer.getPhone_num() + "')";
		
		String sql2 = "select seq_num.currval from dual";
		Connection conn = DBUtil.dbConnect();// DB연결
		Statement st = null, st2= null,st3= null;
		int result = 0, purchase_num=0;
		ResultSet rs = null;
		try {
			conn.setAutoCommit(false);// 자동 커밋 막는 코드
			st = conn.createStatement(); 
			result = st.executeUpdate(sql);
			
			st2 = conn.createStatement();
			rs = st2.executeQuery(sql2);
			while(rs.next()) {
				purchase_num = rs.getInt(1);
			}
			for(PurchaseDetailDTO detail:detailList) {
				String sql3 = "insert into purchase_detail(purchase_detail_num,purchase_num,product_num,purchase_quantity) "
						+ " values(seq_denum.nextval,"+purchase_num +"," + detail.getProduct_num() 
						+ "," + detail.getPurchase_quantity() + ")";
				result = st.executeUpdate(sql3);
			}	
			conn.commit();			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBUtil.dbClose(conn, st, null);
		}
		return purchase_num;
	}
}
