package ss.week3.hotel;

public class PricedRoom extends Room implements Bill.Item {
	private double roomPrice;
	private String text;
	
	public PricedRoom(int roomNumber, double roomPrice, double safePrice) {
		super(roomNumber, new PricedSafe(safePrice));
		this.roomPrice = roomPrice;
		this.text = "Room";
	}
	
	public double getAmount() {
		return roomPrice;
	}
	
	@Override
	public String toString() {
		return String.format("%10s       %-40s %8.2f", text, "The price of this room per night is:", roomPrice);
	}
}