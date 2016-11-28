package ss.week1;

/**
 * Created by willem on 21-11-16.
 */
public class Password extends java.lang.Object {
    public static final java.lang.String INITIAL = "1234567";
    private String password;

    public Password(){
        password = INITIAL;
    }

    public boolean acceptable (java.lang.String password) {
        if (password.length() < 6 || password.contains(" "))
            return false;
        return true;
    }

    public boolean setWord (java.lang.String oldPass, java.lang.String newPass) {
        if (testWord(oldPass) && acceptable(newPass)){
            password = newPass;
            return true;
        }else{
            return false;
        }
    }

    public boolean testWord (java.lang.String password) {
        if (this.password.equals(password))
            return true;
        return false;
    }
}
