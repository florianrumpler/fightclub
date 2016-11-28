package ss.week1;

/**
 * Created by willem on 16-11-16.
 */
public class DollarsAndCentsCounter {
    private int ammount;

    public int dollars() {
        if(this.ammount < 0) {
            System.out.println("Error; Dollars can't be less than 0");
            this.ammount = 0;
        }
        return this.ammount / 100;
    }

    public int cents() {
            return this.ammount % 100;
    }

    public void add (int dollars, int cents){
        this.ammount += dollars * 100 + cents;
    }

    public void reset () {
        this.ammount = 0;
    }
}
