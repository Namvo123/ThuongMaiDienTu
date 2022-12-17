package modal;

public class Category {
	private int cID;
	private String cName;
	private int sumMoney;
	
	public Category() {
		super();
	}

	public Category(String cName, int sumMoney) {
		super();
		this.cName = cName;
		this.sumMoney = sumMoney;
	}

	public int getcID() {
		return cID;
	}

	public void setcID(int cID) {
		this.cID = cID;
	}

	public String getcName() {
		return cName;
	}

	public void setcName(String cName) {
		this.cName = cName;
	}

	public int getSumMoney() {
		return sumMoney;
	}

	public void setSumMoney(int sumMoney) {
		this.sumMoney = sumMoney;
	}

	@Override
	public String toString() {
		return "Category [cName=" + cName + ", sumMoney=" + sumMoney + "]";
	}
	
}
