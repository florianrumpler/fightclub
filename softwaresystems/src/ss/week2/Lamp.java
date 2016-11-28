package ss.week2;

enum Setting  {Off, Low, Medium, High};

/**
 * A lamp with 3 settings plus an off-setting
 * @author Willem
 * @version 2.0.0
 */
public class Lamp {
    //@ private invariant switchAtInt == 4;
    private int switchAtInt = 4;

    private Setting setting = Setting.Off;

    /*@ pure */public java.lang.String getSetting() {
        return setting.toString();
    }

    //@ requires newSetting >= 0 && newSetting <= 3;
    //@ ensures getSetting == newSetting;
    public void setSetting(int newSetting) {
        switch (newSetting){
            case 1: setting = setting.Low;
                break;
            case 2: setting = setting.Medium;
                break;
            case 3: setting = setting.High;
                break;
            case 0: setting = setting.Off;
                break;
        }
    }

    //@ ensures /old(setting) == setting.Off ==> setting = setting.Low;
    //@ ensures /old(setting) == setting.Low ==> setting = setting.Medium;
    //@ ensures /old(setting) == setting.Medium ==> setting = setting.High;
    //@ ensures /old(setting) == setting.High ==> setting = setting.Off;
    public void switchSetting() {
        switch (setting){
            case Off: setting = setting.Low;
                break;
            case Low: setting = setting.Medium;
                break;
            case Medium: setting = setting.High;
                break;
            case High: setting = setting.Off;
                break;
        }
    }
}
