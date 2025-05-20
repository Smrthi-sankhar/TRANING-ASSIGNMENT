package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import utility.DBUtility;

import model.Product;

public class DaoProductImpl  implements DaoProduct{
	DBUtility db = new DBUtility();

	@Override
	public void insertProduct(Product product) {
		Connection con = db.connect();
		String sql ="insert into product (name,price,category_Id) values (?,?,?)";
		try {
			PreparedStatement pstmt = con.prepareStatement(sql);
			
			pstmt.setString(1, product.getName());
			pstmt.setDouble(2,product.getPrice());
			pstmt.setDouble(3, product.getCategoryId());
			pstmt.executeUpdate();
			System.out.println("Product Insert Successfully!!");
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		db.close();
	}
	
	@Override
	public List<Product> getProductsByCategoryId(int categoryId) {
		Connection con = db.connect();
		 List<Product> list = new ArrayList<>();
	        String sql = "SELECT * FROM product WHERE category_id = ?";
	        try {
	             PreparedStatement ps = con.prepareStatement(sql); 
	            ps.setInt(1, categoryId);
	            ResultSet rs = ps.executeQuery();
	            while (rs.next()) {
	                Product p = new Product();
	                p.setProductId(rs.getInt("product_id"));
	                p.setName(rs.getString("name"));
	                p.setPrice(rs.getDouble("price"));
	                p.setCategoryId(rs.getInt("category_id"));
	                list.add(p);
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	        return list;
	    }
	
	


}

