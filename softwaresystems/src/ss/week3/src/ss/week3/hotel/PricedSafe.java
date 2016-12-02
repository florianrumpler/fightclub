package ss.week3.hotel;

public class PricedSafe extends Safe implements Bill.Item {
	private double price;
	private String text;
	
	public PricedSafe(double price) {
		this.price = price;
		this.text = "Safe";
	}
	
	public double getAmount() {
		return price;
	}
	
	public String toString() {
		return String.format("%10s       %-40s %8.2f", text, "The price of this safe per use is:", price);
	}
}