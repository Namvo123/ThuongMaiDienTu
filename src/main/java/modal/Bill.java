package modal;

import java.sql.Date;

public class Bill {
	private String id;
	private String date;
	private double billPrice;
	
	public Bill() {
		super();
	}

	public Bill(String id, String date, double billPrice) {
		super();
		this.id = id;
		this.date = date;
		this.billPrice = billPrice;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public double getBillPrice() {
		return billPrice;
	}

	public void setBillPrice(double billPrice) {
		this.billPrice = billPrice;
	}

	@Override
	public String toString() {
		return "Bill [id=" + id + ", date=" + date + ", billPrice=" + billPrice + "]";
	}


	
	
}
