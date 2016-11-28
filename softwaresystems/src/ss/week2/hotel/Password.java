package ss.week2.hotel;

/**
 * Created by willem on 21-11-16.
 */
public class Password extends Object {
    public static final String INITIAL = "123456";
    private String password;

    public Password(){
        password = INITIAL;
    }

    public boolean acceptable (String password) {
        if (password.length() < 6 || password.contains(" "))
            return false;
        return true;
    }

    public boolean setWord (String oldPass, String newPass) {
        if (testWord(oldPass) && acceptable(newPass)){
            password = newPass;
            return true;
        }else{
            return false;
        }
    }

    public boolean testWord (String password) {
        if (this.password.equals(password))
            return true;
        return false;
    }
}
