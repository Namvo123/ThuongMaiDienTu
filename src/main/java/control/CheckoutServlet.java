package control;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.Dao;
import modal.Bill;
import modal.Cart;
import modal.Category;
import modal.User;

@WebServlet("/checkoutServlet")
public class CheckoutServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public CheckoutServlet() {
        super();
    }
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
		
			// get all cart products
			ArrayList<Cart> cart_list = (ArrayList<Cart>) request.getSession().getAttribute("cart");
		
			User user = (User) request.getSession().getAttribute("username");
			Category cate = new Category();
		
			if(cart_list != null && user != null) {
				for(Cart c : cart_list) {
					Bill bill = new Bill();
					bill.setpID(c.getId());  
					bill.setcID(cate.getcID());
					bill.setuID(user.getuId()); 
					bill.setQuantity(c.getQuantity()); 
					bill.setBillPrice(c.getSumMoney());
					
					Dao dao = new Dao();
					boolean result = dao.insertBill(bill);
					if(!result) break;
				}
				cart_list.clear();
				response.sendRedirect("index.jsp");
			}
			else {
				if(user == null) {
					response.sendRedirect("login.jsp");
				}
			}
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		doGet(request, response);
	}

}
