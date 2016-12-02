package ss.week3.pw;

public class BasicChecker implements Checker {
	public static final String INITPASS = "password";
	
	@Override
	public boolean acceptable(String password) {
		return !(password.length() < 6 || password.contains(" "));
	}
	
	@Override
	public String generatePassword() {
		return INITPASS;
	}
}