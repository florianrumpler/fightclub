package ss.week3.pw;

/**
 * Class password
 * @author Jesper and Willem
 * @version 1.0.0
 */

public class Password {
	
	private String password;
	public static final String factoryPassword = "password";
	private Checker checker;
	
	public Password(Checker checker) {
		password = factoryPassword;
		this.checker = checker;
	}
	
	public Password() { 
		this(new BasicChecker());
	}
	
	public boolean acceptable(String suggestion) {
		return checker.acceptable(suggestion);
	}
	
	/*@ pure */ public boolean testWord(String test) {
		return test.equals(password);
	}

    public boolean setWord(String oldpass, String newpass) {
    	if (testWord(oldpass) && checker.acceptable(newpass)) {
    		password = new String(newpass);
    	    return true;
    	}
    	else {
    	    return false;
    	}
    }
}