package ss.week3;

public class Format {
	
	public Format() {
		
	}
	
	public static void printLine (String text, double amount) {
		System.out.printf("%-15s %10.2f %n", text, amount);
	}
	
	public static void main (String[] args) {
		printLine("textl", 1.00);
		printLine("other text", -12.12);
		printLine("something", 0.20);
	}
}