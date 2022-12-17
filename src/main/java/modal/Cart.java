package modal;

public class Cart{
	private Product p;
	private int quantity;
	
	public Cart() {
		super();
	}

	public Cart(Product p, int quantity) {
		super();
		this.p = p;
		this.quantity = quantity;
	}

	public Product getP() {
		return p;
	}

	public void setP(Product p) {
		this.p = p;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	@Override
	public String toString() {
		return "Cart [p=" + p + ", quantity=" + quantity + "]";
	}
	
	
}
