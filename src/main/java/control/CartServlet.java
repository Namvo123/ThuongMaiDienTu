package control;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import modal.Cart;
import modal.Product;

@WebServlet("/cart")
public class CartServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private List<Cart> cart = new ArrayList<Cart>();

    public CartServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
		
		String command = request.getParameter("command");
		String id = request.getParameter("id");
		HttpSession session = request.getSession();
		if(command.equals("addCart")) {
			Product p = new Product(Integer.parseInt(id), "", 0.0, "", "");
			addToCart(p);
			
			// can tao session de luu tru gia tri
			session.setAttribute("cart", cart);
			response.sendRedirect("index.jsp");
		} else {
			if(command.equals("deleteCart")) {
				Product p = new Product(Integer.parseInt(id), "", 0.0, "", "");
				deleteFromCart(p); 
				
				session.setAttribute("cart", cart);
				response.sendRedirect("cart.jsp");
			} else {
				if(command.equals("removeCart")) {
					Product p = new Product(Integer.parseInt(id), "", 0.0, "", "");
					removeFromCart(p); 
					
					session.setAttribute("cart", cart);
					response.sendRedirect("cart.jsp");
				} else {
					if(command.equals("setCart")) {
						Product p = new Product(Integer.parseInt(id), "", 0.0, "", "");
						setCart(p, Integer.parseInt((String) request.getParameter("quantity"))); 
						
						session.setAttribute("cart", cart);
						response.sendRedirect("cart.jsp");
					} else {
						if(command.equals("removeCartIndex")) {
							Product p = new Product(Integer.parseInt(id), "", 0.0, "", "");
							removeFromCart(p); 
							
							session.setAttribute("cart", cart);
							response.sendRedirect("index.jsp");
						}else {
							if(command.equals("addFromCart")) {
								Product p = new Product(Integer.parseInt(id), "", 0.0, "", "");
								addFromCart(p); 
								
								session.setAttribute("cart", cart);
								response.sendRedirect("cart.jsp");
							} else {
								if(command.equals("addDetailCart")) {
									Product p = new Product(Integer.parseInt(id), "", 0.0, "", "");
									addFromCart(p); 
									
									session.setAttribute("cart", cart);
									response.sendRedirect("cart.jsp");
								}
							}
						} 
					}
				}
			}
		}
	}

	private String setCart(Product p, int s) {
		for(Cart item : cart) {
			if(item.getP().getId() == p.getId()) {
				item.setQuantity(s);
				return "cart";
			}
		}
		Cart c = new Cart();
		c.setP(p);
		c.setQuantity(s);
		cart.add(c);
		return "cart";
	}

	private String removeFromCart(Product p) {
		for(Cart item : cart) {
			if(item.getP().getId() == p.getId()) {
				cart.remove(item);
				return "cart";
			} 
		}
		return "cart"; 
	}
	
	// phuong thuc giam bot 1 san pham khoi trong gio hang
	public String deleteFromCart(Product p) {
		for(Cart item : cart) {
			if(item.getP().getId() == p.getId() && item.getQuantity() > 1) {
				item.setQuantity(item.getQuantity() - 1);
				return "cart";
			}
			if(item.getP().getId() == p.getId() && item.getQuantity() == 1) {
				cart.remove(item);
				return "cart";
			}
		}
		return "cart";
	}
	
	// phuong thuc them san pham moi vao trong gio hang
	public String addToCart(Product p) {
		for(Cart item : cart) {
			if(item.getP().getId() == p.getId()) {
				item.setQuantity(item.getQuantity() + 1);
				return "cart";
			}
		}
		Cart c = new Cart();
		c.setP(p);
		c.setQuantity(1);
		cart.add(c);
		return "cart";
	}
	
	public String addFromCart(Product p) {
		for(Cart item : cart) {
			if(item.getP().getId() == p.getId()) {
				item.setQuantity(item.getQuantity() + 1);
				return "cart";
			}
		}
		Cart c = new Cart();
		c.setP(p);
		c.setQuantity(1);
		cart.add(c);
		return "cart";
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		doGet(request, response);
	}

}
