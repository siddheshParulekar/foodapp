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
 * Servlet implementation class FoodServlet
 */
@WebServlet("/FoodServlet")
public class FoodServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FoodServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session=request.getSession();
		String userAction=request.getParameter("act");
		FoodImpl impl = new FoodImpl();
		if(userAction.equalsIgnoreCase("getall")) {
			List<Food> foodList= impl.getAllFood(); // db is connected here
			session.setAttribute("fList", foodList);
			response.sendRedirect("FoodList.jsp"); // fresh new request
		}// getall
	     else if(userAction.equalsIgnoreCase("delete")) {
			int id=Integer.parseInt(request.getParameter("id"));
			System.out.println(id);
			boolean b=impl.deleteFood(id);
			if(b) {
				response.sendRedirect("FoodServlet?act=getall");//			}
		       }
	     }
		else if(userAction.equalsIgnoreCase("foodupdate")) {
			System.out.println("food update.....");
			int id1=Integer.parseInt(request.getParameter("id"));
			//System.out.println(id1);
			Food food=impl.getFoodById(id1);
			session.setAttribute("food", food);
			System.out.println(food);
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
		FoodImpl impl = new FoodImpl();
		
		doGet(request, response);
		if(userAction.equalsIgnoreCase("addFoodAction"))
		{
			String name=request.getParameter("name");	
			
			double price=Double.parseDouble(request.getParameter("price"));
			int fid = Integer.parseInt(request.getParameter("Id"));
			
			
			Food food = new Food();
			//User user=new User();
			food.setName(name);
			food.setPrice(price);
			food.setFoodId(fid);
			
			System.out.println(food);
			
			boolean b=impl.addFood(food);
			if(b)
				//response.sendRedirect("index.html");
				pw.print("Food added successfully.......");
			else
				pw.print("Something went wrong.....");
		}
		else if(userAction.equalsIgnoreCase("update")) {
			int fId=Integer.parseInt(request.getParameter("fId")); // existing
			String Name=request.getParameter("fName");
			double price=Double.parseDouble(request.getParameter("fPrice"));
			
			Food food=new Food(Name,price,fId);
			boolean b=impl.updateFood(food);
			if(b) {
				response.sendRedirect("FoodServlet?act=getall"); // fresh new req to same Servlet, doGet
			}
			else {
				response.sendRedirect("Error.jsp");
			}
		}
	}

}
