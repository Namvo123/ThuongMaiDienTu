package modal;

import java.sql.Date;

public class User {
	private int uId;
	private String username;
	private String password;
	private Date birthday;
	private String sex;
	private String email;
	private String phone;
	private String address;
	
	public User() {
		super();
	}

	public User(int uId, String username, String password, Date birthday, String sex, String email, String phone,
			String address) {
		super();
		this.uId = uId;
		this.username = username;
		this.password = password;
		this.birthday = birthday;
		this.sex = sex;
		this.email = email;
		this.phone = phone;
		this.address = address;
	}

	public int getuId() {
		return uId;
	}

	public void setuId(int uId) {
		this.uId = uId;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	@Override
	public String toString() {
		return "User [uId=" + uId + ", username=" + username + ", password=" + password + ", birthday=" + birthday
				+ ", sex=" + sex + ", email=" + email + ", phone=" + phone + ", address=" + address + "]";
	}
	
	
	
}
