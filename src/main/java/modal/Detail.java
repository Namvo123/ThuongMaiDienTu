package modal;

public class Detail extends Product{
	private int dID;
	private String name;
	private double price;
	private String image;
	private String description;
	private String slide1;
	private String slide2;
	private String slide3;
	
	public Detail() {
		super();
	}

	public Detail(int dID, String name, double price, String image, String description, String slide1, String slide2,
			String slide3) {
		super();
		this.dID = dID;
		this.name = name;
		this.price = price;
		this.image = image;
		this.description = description;
		this.slide1 = slide1;
		this.slide2 = slide2;
		this.slide3 = slide3;
	}
	
	public int getdID() {
		return dID;
	}

	public void setdID(int dID) {
		this.dID = dID;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getSlide1() {
		return slide1;
	}

	public void setSlide1(String slide1) {
		this.slide1 = slide1;
	}

	public String getSlide2() {
		return slide2;
	}

	public void setSlide2(String slide2) {
		this.slide2 = slide2;
	}

	public String getSlide3() {
		return slide3;
	}

	public void setSlide3(String slide3) {
		this.slide3 = slide3;
	}

	@Override
	public String toString() {
		return "Detail [dID=" + dID + ", name=" + name + ", price=" + price + ", image=" + image + ", description="
				+ description + ", slide1=" + slide1 + ", slide2=" + slide2 + ", slide3=" + slide3 + "]";
	}
	
	
	
}
