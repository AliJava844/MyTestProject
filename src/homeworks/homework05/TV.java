package homeworks.homework05;

import java.util.Objects;

public class TV {

    private String model;
    private int numberChanel;
    private int volume;
    private boolean isOn;

    public TV(String model, int numberChanel, int volume, boolean isOn) {
        this.model = model;
        this.numberChanel = numberChanel;
        this.volume = volume;
        this.isOn = isOn;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getNumberChanel() {
        return numberChanel;
    }

    public void setNumberChanel(int numberChanel) {
        this.numberChanel = numberChanel;
    }

    public int getVolume() {
        return volume;
    }

    public void setVolume(int volume) {
        this.volume = volume;
    }

    public boolean isOn() {
        return isOn;
    }

    public void setOn(boolean on) {
        isOn = on;
    }

    @Override
    public String toString() {
        return "TV{" +
                "model='" + model + '\'' +
                ", numberChanel=" + numberChanel +
                ", volume=" + volume +
                ", isOn=" + isOn +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        TV tv = (TV) o;
        return numberChanel == tv.numberChanel && volume == tv.volume && isOn == tv.isOn && Objects.equals(model, tv.model);
    }

    @Override
    public int hashCode() {
        return Objects.hash(model, numberChanel, volume, isOn);
    }
}
