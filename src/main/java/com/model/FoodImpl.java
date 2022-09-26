package com.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.dao.foodDao;
import com.jdbc.MyConnection;

import com.pojo.Food;

public class FoodImpl implements foodDao {

	@Override
	public boolean addFood(Food food) {
		// TODO Auto-generated method stub
		boolean state=false;
		try(Connection conn=MyConnection.connect()){		
			String sql="insert into food values (?,?,?)";
			PreparedStatement pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, food.getName());
			pstmt.setDouble(2, food.getPrice());
			pstmt.setInt(3, food.getFoodId());
			
			
			int no=pstmt.executeUpdate();
			System.out.println(no);
			if(no>0)
				state=true;

		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return state;
	}
	
	public List<Food> getAllFood() {
		   String sql="select * from food";
		   List<Food> empList=new ArrayList<>();
		   try (Connection connection=MyConnection.connect()){	  
				PreparedStatement pstatement=connection.prepareStatement(sql); // Statement
				ResultSet rset= pstatement.executeQuery();
				System.out.println(rset.getClass());
				// selected data is available in rset
					while(rset.next()) {
						int id=rset.getInt("fid");
						String name=rset.getString("name");
						double price=rset.getDouble("price");
						//String qual=rset.getString("qualification");
						Food emp=new Food(name,price,id);
						empList.add(emp);
					}
			} 
			  catch (ClassNotFoundException e) {
				e.printStackTrace();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			System.out.println("Connection Autoclosed");
			return empList;
		} // method ended
	
	public boolean  deleteFood(int foodId) {
		boolean b=false;
		String sql="delete from food where fid=?"; 
		try (Connection connection=MyConnection.connect()){	  
			PreparedStatement pstatement=connection.prepareStatement(sql);
			pstatement.setInt(1, foodId);
			System.out.println(pstatement);
			int no=pstatement.executeUpdate(); 
			System.out.println("Number of rows affected: "+no);
			if(no>0)
				b=true;
		} 
		  catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		System.out.println("Connection Autoclosed");
		return b;
	}
	public Food getFoodById(int foodId) {
		Food food=null;
		String sql="select * from food where fid=?";
		 try (Connection connection=MyConnection.connect()){	  
				PreparedStatement pstatement=connection.prepareStatement(sql);
				pstatement.setInt(1, foodId);
				System.out.println(pstatement);
				ResultSet rset= pstatement.executeQuery();
				while(rset.next()) {
					int fId=rset.getInt("fid");
					String name=rset.getString("name");
					double price=rset.getDouble("price");
				
					 food=new Food(name,price,fId);
				}
				
			} 
			  catch (ClassNotFoundException e) {
				e.printStackTrace();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			System.out.println("Connection Autoclosed");
			return food;
	}
	
	public boolean updateFood(Food food) {
		boolean b=false;
		String sql="update food set name=?,price=? where fid=?"; 
		try (Connection connection=MyConnection.connect()){	  
			PreparedStatement pstatement=connection.prepareStatement(sql);
			pstatement.setInt(3, food.getFoodId());
			pstatement.setString(1, food.getName());
			pstatement.setDouble(2, food.getPrice());
			
			System.out.println(pstatement);
			int no=pstatement.executeUpdate(); 
			System.out.println("Number of rows affected: "+no);
			if(no>0)
				b=true;
		} 
		  catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		System.out.println("Connection Autoclosed");
		return b;

	}
}


