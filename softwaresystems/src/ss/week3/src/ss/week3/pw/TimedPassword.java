package ss.week3.pw;

public class TimedPassword extends Password {
	
	public static final int DEFAULT = 1;
	private long validTime;
	private long time;
	
	public TimedPassword(int expirationTime) {
		time = System.currentTimeMillis();
		validTime = expirationTime;
	}
	
	public TimedPassword() {
		this(DEFAULT);
	}
	
	public boolean isExpired() {
		return System.currentTimeMillis() > time + (1000*validTime);
	}
	
	@Override
	public boolean setWord(String oldpass, String newpass) {
		if (super.setWord(oldpass, newpass)) {
			time = System.currentTimeMillis();
			return true;
		}
    	return false;
    }
	
}