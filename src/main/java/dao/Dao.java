package dao;

import java.sql.Connection; 
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import database.ConnectDB;
import modal.Bill;
import modal.Cart;
import modal.Category;
import modal.Detail;
import modal.Product;
import modal.User;

public class Dao {
	Connection conn = null;
	PreparedStatement ps = null;
	ResultSet rs = null;
	
	public List<Product> getProduct() {
		List<Product> list = new ArrayList<>();
		String query = "select * from products";
		
		try {
			conn = new ConnectDB().getConnect();
			ps = conn.prepareStatement(query);
			rs = ps.executeQuery();
			while(rs.next()) {
				list.add(new Product(rs.getInt(1), 
						rs.getString(2), 
						rs.getInt(5),
						rs.getString(6),
						rs.getString(7)));
			}
		} catch (Exception e) {
		}
		
		return list;
	}
	
	// add to cart
	public Product getProductById(int id) {
		Product p = new Product();
		String query = "select * from products where pId = ?";
		try {
			conn = new ConnectDB().getConnect();
			ps = conn.prepareStatement(query);
			ps.setInt(1, id);
			rs = ps.executeQuery();
			while(rs.next()) {
				p = new Product(rs.getInt(1), 
						rs.getString(2), 
						rs.getDouble(5), 
						rs.getString(6), 
						rs.getString(7));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return p;
	}
	
	// detail
	public Detail getDetailProductById(int id) {
		Detail d = new Detail();
		String query = "select detail.pID, [name], price, [image], [description], slide1, slide2, slide3 \r\n"
				+ "from products, detail\r\n"
				+ "where products.pID = detail.pID and detail.pID = ?";
		try {
			conn = new ConnectDB().getConnect();
			ps = conn.prepareStatement(query);
			ps.setInt(1, id);
			rs = ps.executeQuery();
			while(rs.next()) {
				d = new Detail(rs.getInt(1), rs.getString(2), 
								rs.getDouble(3), 
								rs.getString(4), 
								rs.getString(5), 
								rs.getString(6), 
								rs.getString(7), 
								rs.getString(8));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return d;
	}
	
	// Thống kê biểu đồ cột doanh thu của cửa hàng theo tuỳ chọn thời gian
	public List<Bill> getSumMoney() {
		List<Bill> list = new ArrayList<Bill>();
 		String query = "select (YEAR(ngayban)) as Năm, sum(bill.tongtien) as tongtien from bill group by (YEAR(ngayban))";
		
		try {
			conn = new ConnectDB().getConnect();
			ps = conn.prepareStatement(query);
			rs = ps.executeQuery();
			while(rs.next()) {
				list.add(new Bill(rs.getInt(1), rs.getDouble(2)));
			}
		} catch (Exception e) {

		}
		return list;
	}
	
	// Thống kê biểu đồ tròn doanh thu của cửa hàng trong một tháng theo loại danh mục hàng hoá  
	public List<Category> getSumMoneyCate() {
		List<Category> list = new ArrayList<Category>();
 		String query = "select category.type_name, sum(bill.tongtien) as tongtien \r\n"
 				+ "from bill, category \r\n"
 				+ "where bill.type_id = category.type_id  and (MONTH(ngayban)) = 12 \r\n"
 				+ "group by category.type_name";
		
		try {
			conn = new ConnectDB().getConnect();
			ps = conn.prepareStatement(query);
			rs = ps.executeQuery();
			while(rs.next()) {
				list.add(new Category(rs.getString(1), rs.getInt(2)));
			}
		} catch (Exception e) {

		}
		return list;
	}

	
	// update user
	public void updateUser(User u) {
		String query = "\r\n"
				+ "update users set password=N'?', ngaysinh='?', gioitinh=N'?', email=N'?', soDT='?', diachi=N'?' where username=N'?'";
		try {
			conn = new ConnectDB().getConnect();
			ps = conn.prepareStatement(query);
			ps.setString(1, u.getPassword());
			ps.setDate(2, u.getBirthday());
			ps.setString(3, u.getSex());
			ps.setString(4, u.getEmail());
			ps.setString(5, u.getPhone());
			ps.setString(6, u.getAddress());
			ps.setString(7, u.getUsername());
			ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	public User getUser(String username) {
		String query = "select * from users where username = '" + username + "'";
		User u = new User();
		try {
			conn = new ConnectDB().getConnect();
			ps = conn.prepareStatement(query);
			rs = ps.executeQuery();
			while (rs.next()) {
				u = new User(rs.getInt(1), 
						rs.getString(2), 
						rs.getString(3), 
						rs.getDate(4), 
						rs.getString(5), 
						rs.getString(6), 
						rs.getString(7), 
						rs.getString(8));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return u;
	}
	
	public boolean insertBill(Bill bill) {
		boolean result = false;
		try {
			String query = "insert into bill (pID, type_id, uID, quantity, tongtien) values (?, ?, ?, ?, ?)";
			ps = conn.prepareStatement(query); 
			ps.setInt(1, bill.getpID());
			ps.setInt(2, bill.getcID()); 
			ps.setInt(3, bill.getuID()); 
			ps.setInt(4, bill.getQuantity());
			ps.setDouble(5, bill.getBillPrice()); 
			ps.executeUpdate();
			result = true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}
	
	public static void main(String[] args) {
		Dao dao = new Dao();
		List<Bill> list = dao.getSumMoney();
		Detail p = dao.getDetailProductById(1);
		User u = dao.getUser("hunu");
//		System.out.println(p);
		for(Bill l : list) {
			System.out.println(l);
		}
	}
}
