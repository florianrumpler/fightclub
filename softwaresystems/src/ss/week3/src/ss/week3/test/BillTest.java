package ss.week3.test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import ss.week3.hotel.*;

public class BillTest {
	private Bill bill;

	@Before
	public void setUp() {
		bill = new Bill(System.out);
		assertTrue(bill.getSum() == 0);
	}
	
	@Test
	public void testNewItem() {
		bill.newItem(new PricedSafe(15.45));
		assertTrue(Math.abs(bill.getSum() - 15.45) < 0.0001);
		bill.newItem(new PricedSafe(16.00));
		assertFalse(Math.abs(bill.getSum() - 15.45) < 0.0001); 
		bill.newItem(new PricedRoom(101, 50.61, 15.45));
		assertTrue(Math.abs(bill.getSum() - 82.06) < 0.0001);
		bill.getSum();
		bill.close();
	}
}
