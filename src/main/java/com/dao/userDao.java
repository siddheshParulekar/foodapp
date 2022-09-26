package com.dao;

import com.pojo.User;

public interface userDao {

	
	public boolean register(User user);
	public String login (String uname, String pass);
	public boolean changepass(String username, String newpassword);
	public boolean changecont(String username, double contact);
	public boolean changeEmail(String username, String newemailId);
}
