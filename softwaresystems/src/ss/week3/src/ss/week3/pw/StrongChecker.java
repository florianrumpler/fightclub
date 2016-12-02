package ss.week3.pw;

public class StrongChecker extends BasicChecker {
	public static final String INITPASS = "Password1";
	
	@Override
	public boolean acceptable(String password) {
		return (super.acceptable(password) && Character.isLetter(password.charAt(0)) && Character.isDigit(password.charAt(password.length())));
	}
	
	@Override
	public String generatePassword() {
		return INITPASS;
	}
}