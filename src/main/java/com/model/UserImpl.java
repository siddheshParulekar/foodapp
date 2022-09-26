package com.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.dao.userDao;
import com.jdbc.MyConnection;
import com.pojo.Food;
import com.pojo.User;

public class UserImpl implements userDao
{
	public boolean register(User user) {
		boolean state=false;
		try(Connection conn=MyConnection.connect()){		
			String sql="insert into prouser values (?,?,?,?,?)";
			PreparedStatement pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, user.getUsername());
			pstmt.setString(2, user.getName());
			pstmt.setString(3, user.getEmailId());
			pstmt.setString(4, user.getPassword());
			pstmt.setDouble(5, user.getContact());
			
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
	
	public String login (String uname, String pass) {
		//hari Hari@123
		String name=null;
		
		try(Connection conn=MyConnection.connect()){
			
		String sql="select *  from prouser where username=? and password=?";
		PreparedStatement pstmt=conn.prepareStatement(sql);
		pstmt.setString(1,uname);
		pstmt.setString(2,pass);	
		System.out.println(pstmt);
		ResultSet rs= pstmt.executeQuery();
		if(rs.next()) {
			name=rs.getString("name");
		}
		
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return name;
	}
	public boolean changepass(String username, String newpassword){
		boolean state= false;
				
		try(Connection conn=MyConnection.connect()){
			
		String sql="update prouser set password=? where username=?";
		PreparedStatement pstmt=conn.prepareStatement(sql);
		pstmt.setString(1,newpassword);	
		pstmt.setString(2,username);
		
		System.out.println(pstmt);
		int no = pstmt.executeUpdate();
		System.out.println(no);
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
	public boolean changecont(String username, double contact){
		boolean state= false;
				
		try(Connection conn=MyConnection.connect()){
			
		String sql="update prouser set contactNo=? where username=?";
		PreparedStatement pstmt=conn.prepareStatement(sql);
		pstmt.setDouble(1,contact);	
		pstmt.setString(2,username);
		
		System.out.println(pstmt);
		int no = pstmt.executeUpdate();
		System.out.println(no);
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
	public boolean changeEmail(String username, String newemailId){
		boolean state= false;
				
		try(Connection conn=MyConnection.connect()){
			
		String sql="update prouser set emailid=? where username=?";
		PreparedStatement pstmt=conn.prepareStatement(sql);
		pstmt.setString(1,newemailId);	
		pstmt.setString(2,username);
		
		System.out.println(pstmt);
		int no = pstmt.executeUpdate();
		System.out.println(no);
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
	
	public boolean  deleteFood(String username) {
		boolean b=false;
		String sql="delete from prouser where username=?"; 
		try (Connection connection=MyConnection.connect()){	  
			PreparedStatement pstatement=connection.prepareStatement(sql);
			pstatement.setString(1, username);
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
	public List<User> getAllFood() {
		   String sql="select * from prouser";
		   List<User> empList=new ArrayList<>();
		   try (Connection connection=MyConnection.connect()){	  
				PreparedStatement pstatement=connection.prepareStatement(sql); // Statement
				ResultSet rset= pstatement.executeQuery();
				System.out.println(rset.getClass());
				// selected data is available in rset
					while(rset.next()) {
						String username=rset.getString("username");
						String name=rset.getString("name");
						String email=rset.getString("emailid");
						String password=rset.getString("password");
						double contact=rset.getDouble("contactNo");
						//String qual=rset.getString("qualification");
						User user=new User(name,username,email,password,contact);
						empList.add(user);
					}
			} 
			  catch (ClassNotFoundException e) {
				e.printStackTrace();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			System.out.println("Connection Autoclosed");
			return empList;
		}
	
}