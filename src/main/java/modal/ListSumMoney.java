package modal;

public class ListSumMoney {
	private int year;
	private int money;
	
	public ListSumMoney() {
		super();
	}

	public ListSumMoney(int year, int money) {
		super();
		this.year = year;
		this.money = money;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public int getMoney() {
		return money;
	}

	public void setMoney(int money) {
		this.money = money;
	}

	@Override
	public String toString() {
		return "ListSumMoney [year=" + year + ", money=" + money + "]";
	}

	
}
