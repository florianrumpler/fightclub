package ss.week3;

/**
 * Class password
 * @author Jesper and Willem
 * @version 1.0.0
 */

public class Password {
	
	private String password;
	
	public static final String INITIAL = "password";
	
	public Password() {
		password = INITIAL;
	}
	
	public boolean acceptable(String suggestion) {
		return !(suggestion.length() < 6 || suggestion.contains(" "));
	}
	
	/*@ pure */ public boolean testWord(String test) {
		return test.equals(password);
	}

    public boolean setWord(String oldpass, String newpass) {
    	if (testWord(oldpass) && acceptable(newpass)) {
    		password = new String(newpass);
    	    return true;
    	}
    	else {
    	    return false;
    	}
    }
}