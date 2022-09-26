package com.servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.pojo.Cart;
import com.pojo.Food;

import com.model.CartImpl;

/**
 * Servlet implementation class CartServlet
 */
@WebServlet("/CartServlet")
public class CartServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CartServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();
		String uname = (String) session.getAttribute("uname");
		String CartActions = request.getParameter("act");
		CartImpl cartdao = new CartImpl();
		if(CartActions!= null &&  CartActions.equalsIgnoreCase("showcart")) {
			List<Food> cartList = cartdao.showCart(uname);
			session.setAttribute("cartList", cartList);
			System.out.println("cart :"+cartList);
			response.sendRedirect("CartList.jsp");
		}
		else if(CartActions!= null &&  CartActions.equalsIgnoreCase("addToCart")) {
			if(uname!=null) {
				System.out.print("In add to cart");
				int foodid = Integer.parseInt(request.getParameter("id"));
				Cart cart = new Cart();
				cart.setUsername(uname);
				cart.setFoodId(foodid);
				cart.setFoodQuantity(1);
				cart.setTotalPrice(0);
				boolean b = cartdao.addToCart(cart);
				System.out.print(b);
				if(b)
					response.sendRedirect("index.jsp");
				else
					System.out.println("fail...");
			}
		}
		else if(CartActions!= null &&  CartActions.equalsIgnoreCase("removefood")) {
			if(uname!=null) {
				System.out.println("remove food post m");
				int foodid = Integer.parseInt(request.getParameter("id"));
				Cart cart = new Cart();
				cart.setFoodId(foodid);
				cart.setUsername(uname);
				boolean b = cartdao.deleteCart(cart)
;
				if(b) {
					List<Food> cartList = cartdao.showCart(uname);
					session.setAttribute("cartList", cartList);
					response.sendRedirect("CartList.jsp");
				}
				else
					System.out.println("fail...");
			}
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
		String CartActions = request.getParameter("act");
		HttpSession session = request.getSession();
		String uname = (String) session.getAttribute("uname");
		CartImpl cartdao = new CartImpl();
		if(CartActions!= null &&  CartActions.equalsIgnoreCase("update")) {
			int quantity =  Integer.parseInt(request.getParameter("quantity"));
			int foodId =  Integer.parseInt(request.getParameter("foodId"));
			double totalPrice =  Double.parseDouble(request.getParameter("totalPrice"));
			System.out.println("Q:"+quantity+"fid"+foodId+"tp:"+totalPrice);
			Cart cart = new Cart();
			cart.setFoodId(foodId);
			cart.setFoodQuantity(quantity);
			cart.setTotalPrice(totalPrice);
			cart.setUsername(uname);
			
			boolean b = cartdao.updateCart(cart)
;
			if(b)
				response.sendRedirect("CartList.jsp");
			else
				System.out.println("fail...");
		
		}
	}

}
