package com.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.jdbc.MyConnection;
import com.pojo.Cart;
import com.pojo.Food;

public class CartImpl {

	
	public boolean addToCart(Cart cart) {
		boolean state= false;
		try(Connection conn = MyConnection.connect()) {
			
		String sql = "insert into cart(fid,username,quantity, totalPrice) values (?,?,?,?)";
		PreparedStatement pstmt=conn.prepareStatement(sql);
		pstmt.setInt(1, cart.getFoodId());
		pstmt.setString(2, cart.getUsername());
		pstmt.setInt(3, cart.getFoodQuantity());
		pstmt.setDouble(4, cart.getTotalPrice());
		int no = pstmt.executeUpdate();
		System.out.println(no)
;
		if(no>0) {
			state = true;
		}
		
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return state;
	}
	
	public List<Food> showCart(String username) {
		List<Food> lfood= new ArrayList<>();
		try(Connection conn = MyConnection.connect()) {
		String sql = "select * from cart inner join food on cart.fid= food.fid where username=?";
		PreparedStatement pstmt=conn.prepareStatement(sql);
		pstmt.setString(1, username);
		ResultSet rs = pstmt.executeQuery();
		while (rs.next()) {
			Food f = new Food();
			f.setFoodId(rs.getInt("fid"));
			f.setName(rs.getString("name"));
			f.setPrice(rs.getDouble("price"));
			//f.setType(rs.getString("type"));
			lfood.add(f);
			
		}
		} catch (ClassNotFoundException |SQLException  e) {
			e.printStackTrace();
		}
		return lfood;
	}
	public boolean deleteCart(Cart cart) {
		boolean state= false;
		try(Connection conn = MyConnection.connect()) {
						
			String sql = "delete from cart where fid=? and username=?";
			PreparedStatement pstmt =conn.prepareStatement(sql);
			pstmt.setInt(1,cart.getFoodId());
			pstmt.setString(2, cart.getUsername());
			int no = pstmt.executeUpdate();
			System.out.println(no)
;
			if(no>0) {
				state = true;
			}
		
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return state;
	}
	public boolean updateCart(Cart cart) {
		boolean state= false;
		try(Connection conn = MyConnection.connect()) {
						
			String sql = "update cart set  quantity=? ,totalPrice=?  where username=? and fid=?";
			PreparedStatement pstmt =conn.prepareStatement(sql);
			pstmt.setInt(1, cart.getFoodQuantity());
			pstmt.setDouble(2, cart.getTotalPrice());
			pstmt.setString(3, cart.getUsername());
			pstmt.setInt(4,cart.getFoodId());
			
			int no = pstmt.executeUpdate();
			System.out.println(no)
;
			if(no>0) {
				state = true;
			}
		
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return state;
	}

}
