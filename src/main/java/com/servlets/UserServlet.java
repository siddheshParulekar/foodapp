package com.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.model.FoodImpl;
import com.model.UserImpl;
import com.pojo.Food;
import com.pojo.User;

/**
 * Servlet implementation class UserServlet
 */
@WebServlet("/UserServlet")
public class UserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		HttpSession session=request.getSession();
		String userAction=request.getParameter("act");
		UserImpl impl = new UserImpl();
		if(userAction.equalsIgnoreCase("getall")) {
			List<User> userList= impl.getAllFood(); // db is connected here
			session.setAttribute("uList", userList);
			response.sendRedirect("UserList.jsp"); // fresh new request
		}// getall
	     else if(userAction.equalsIgnoreCase("delete")) {
			String username=request.getParameter("username");
			//System.out.println(id);
			boolean b=impl.deleteFood(username);
			if(b) {
				response.sendRedirect("UserServlet?act=getall");//			}
		       }
	     }
		else if(userAction.equalsIgnoreCase("foodupdate")) {
			System.out.println("food update.....");
			int id1=Integer.parseInt(request.getParameter("id"));
			//System.out.println(id1);
			//Food food=impl.getFoodById(id1);
			//session.setAttribute("food", food);
			//System.out.println(food);
			//System.out.println("un food update");
			response.sendRedirect("UpdateFood.jsp");
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter pw=response.getWriter();
		String userAction=request.getParameter("act");
		UserImpl impl=new UserImpl();
		pw.write("Hello");
		doGet(request, response);
		if(userAction.equalsIgnoreCase("registerAction"))
		{
			String name=request.getParameter("name");	
			String emailId=request.getParameter("mail");
			String username=request.getParameter("uname");
			String password=request.getParameter("pass");
			double contact=Double.parseDouble(request.getParameter("contact"));
			
			
			User user=new User();
			user.setName(name);
			user.setEmailId(emailId);
			user.setUsername(username);
			user.setPassword(password); 
			user.setContact(contact);
			System.out.println(user);
			
			boolean b=impl.register(user);
			if(b)
				response.sendRedirect("Register.html");
				//pw.print("You are registered successfully.......");
			else
				pw.print("Something went wrong.....");
		}
		else if(userAction.equalsIgnoreCase("loginAction")) {
			// do the controlling logic for login
			
			String username=request.getParameter("username");
			String password=request.getParameter("passWord");
			 HttpSession session=request.getSession();  
		     session.setAttribute("uname",username);  
			
			String name=impl.login(username,password);
			if(name!=null)
				//pw.print("You are logged in successfully....... Welcome "+name);
				response.sendRedirect("index.jsp");// new page loaded by server
			else
			//	pw.print("Something went wrong.....");
				response.sendRedirect("Error.html");
			
		}
		else if (userAction.equalsIgnoreCase("changePasswordAction")) {
			// change password
			String username = request.getParameter("username");
			String password = request.getParameter("oldpass");
			String name = impl.login(username, password);
			
			System.out.println();

			if (name != null) {
				User user = new User();
				String newpassword = request.getParameter("newpass");
				user.setPassword(newpassword);
				boolean b = impl.changepass(username,newpassword);
				response.sendRedirect("Register.html");
			}
				
//				pw.print("You are logged in successfully....... Welcome "+name);
			else
//				pw.print("login something want wronge....");
				response.sendRedirect("Error.html");
		}else if (userAction.equalsIgnoreCase("changeContactAction")) {
			// change password
			String username = request.getParameter("username");
			String password = request.getParameter("oldpass");
			String name = impl.login(username, password);
			
			System.out.println();

			if (name != null) {
				User user = new User();
				double contact=Double.parseDouble(request.getParameter("newcont"));
				user.setContact(contact);
				boolean b = impl.changecont(username,contact);
				response.sendRedirect("index.html");
			}
				
//				pw.print("You are logged in successfully....... Welcome "+name);
			else
//				pw.print("login something want wronge....");
				response.sendRedirect("Error.html");
		}else if (userAction.equalsIgnoreCase("changeEmailAction")) {
			// change password
			String username = request.getParameter("username");
			String password = request.getParameter("oldpass");
			String name = impl.login(username, password);
			
			System.out.println();

			if (name != null) {
				User user = new User();
				String newemailId = request.getParameter("newemail");
				user.setEmailId(newemailId);
				boolean b = impl.changeEmail(username,newemailId);
				response.sendRedirect("index.html");
			}
				
//				pw.print("You are logged in successfully....... Welcome "+name);
			else
//				pw.print("login something want wronge....");
				response.sendRedirect("Error.html");
		}
	}

}
