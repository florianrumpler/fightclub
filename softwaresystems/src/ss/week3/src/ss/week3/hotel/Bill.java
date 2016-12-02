package ss.week3.hotel;

import java.io.PrintStream;
		
public class Bill {
	private PrintStream theOutStream;
	private double price;
	
	public Bill(PrintStream theOutStream){
		this.theOutStream = theOutStream;
		price = 0;
	}
	
	public interface Item{
		
		public double getAmount();
		public String toString();
		
	}
	
	public void newItem(Item item) {
		if (item != null) {
			price = item.getAmount() + price;
			theOutStream.printf("New item added: %-20s %n", item.toString());
		}
	}
	
	public double getSum() {
		return price;
	}
	
	public void close() {
		theOutStream.printf("%n   Bill closed: %49s %16.2f %n", "The total price of this bill is:", getSum());
	}
}