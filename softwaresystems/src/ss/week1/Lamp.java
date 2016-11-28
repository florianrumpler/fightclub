package ss.week1;

/**
 * Created by willem on 16-11-16.
 */
public class Lamp {
    private int setting = 0;
    private int off = 0;
    private int low = 1;
    private int med = 2;
    private int high = 3;

    public String getSetting() {
        switch (this.setting) {
            case 0:
                return "Off";
            case 1:
                return "Low";
            case 2:
                return "Medium";
            case 3:
                return "High";
        }
        return "Error; Setting not in bounds";
    }

    public void setSetting(int newSetting) {
        this.setting = newSetting;
    }

    public void switchSetting() {
        setting = (setting + 1) % (high + 1);
    }
}
