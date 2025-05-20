package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import model.Purchase;
import utility.DBUtility;

public class DaopurchaseImpl implements DaoPurchase {
	DBUtility db = new DBUtility();
	

	@Override
	public void insertPurchase(Purchase purchase) {
		Connection con = db.connect();
		String sql ="INSERT INTO purchase (customer_id, product_id, quantity, purchase_date) VALUES (?, ?, ?, ?)";
		try {
			PreparedStatement pstmt = con.prepareStatement(sql);
			
			pstmt.setInt(1, purchase.getCustomerId());
			pstmt.setInt(2,purchase.getProductId());
			pstmt.setInt(3, purchase.getQuantity());
			pstmt.setString(4, purchase.getPurchaseDate().toString());
			pstmt.executeUpdate();
			System.out.println("Purchase Insert Successfully!!");
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		db.close();
	}
		
	}


