package control;

import java.io.IOException; 
import java.sql.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.Dao;
import modal.Bill;
import modal.Category;

@WebServlet("/billservlet")
public class BillServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public BillServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
		
		Dao dao = new Dao();
		List<Bill> list = dao.getSumMoney();
		List<Category> cateList = dao.getSumMoneyCate();
		
		request.setAttribute("listS", list);
		request.setAttribute("listC", cateList);
		request.getRequestDispatcher("charts.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		doGet(request, response);
	}

}
