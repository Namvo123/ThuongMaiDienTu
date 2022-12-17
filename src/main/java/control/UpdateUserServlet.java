package control;

import java.io.IOException;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.Dao;
import modal.User;

@WebServlet("/updateUserServlet")
public class UpdateUserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public UpdateUserServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
		
		String uId = request.getParameter("uId");
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		
		Date birthday= null;
		try {
			birthday = new java.sql.Date((new SimpleDateFormat("yyyy-MM-dd").parse(request.getParameter("birthday"))).getTime());
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		String sex = request.getParameter("sex");
		String email = request.getParameter("email");
		String phone = request.getParameter("phone");
		String address = request.getParameter("address");
		
		String err = "";
		String url = "updateUser.jsp";
		
		if(password.equals("") || email.equals("") 
				|| phone.equals("") || address.equals("")) {
			err += "Please enter enough information!";
		}else {
			Pattern pattenObj = Pattern
					.compile("^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
							+ "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$");
			Matcher matcherObj = pattenObj.matcher(email);
			if(!matcherObj.matches()) {
				err += "Incorrect email format!";
			}else {
				Pattern pattenObj2 = Pattern
						.compile("(09)\\d{8}|(01)\\d{9}");
				Matcher matcherObj2 = pattenObj2.matcher(phone);
				if (!matcherObj2.matches()) {
					err += "Invalid phone number!";
				}
			}
			if(err.length() > 0) {
				request.setAttribute("err", err);
			}
			try {
				if(err.length() == 0) {
					User u = new User(Integer.parseInt(uId) ,username, password, birthday, sex, email, phone, address);
					Dao dao = new Dao();
					dao.updateUser(u);
					url = "index.jsp";
				}else {
					url = "updateUser.jsp";
				}
				RequestDispatcher rd = getServletContext()
						.getRequestDispatcher(url);
				rd.forward(request, response);
			} catch (Exception e) {
				e.printStackTrace();
				response.sendRedirect("/register.jsp");
			}
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		doGet(request, response);
	}

}
