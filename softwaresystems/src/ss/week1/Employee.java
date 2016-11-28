package ss.week1;

/**
 * Created by willem on 16-11-16.
 */
public class Employee {
    private int hours;
    private double rate;

    public double pay() {
        int normal;
        int overtime;
        if (hours > 40) {
            normal = 40;
            overtime = hours-40;
        }else{
            normal = hours;
            overtime = 0;
        }

        return ((normal * rate) + (overtime * 1.5 * rate));
    }

    public void setRate(double newRate) {
        rate = newRate;
    }

    public void setHours(int newHours) {
        hours = newHours;
    }
}
