package ss.week3;

public class Multiplication implements OperatorWithIdentity {
	
	@Override
	public int operate(int left, int right) {
		return left * right;
	}
	
	@Override
	public int identity() {
		return 1;
	}
	
	public static void main(String[] args) {
		OperatorWithIdentity op = new Multiplication();
		System.out.println(op.operate(2,op.identity()));
	}
}