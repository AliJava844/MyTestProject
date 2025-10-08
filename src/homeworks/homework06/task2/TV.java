package homeworks.homework06.task2;

import java.util.List;

public class TV {
    private String model;
    private int volume;
    private boolean isOn;
    private List<Channel> channels;

    public TV(String model, int volume, boolean isOn, List<Channel> channels) {
        this.model = model;
        this.volume = volume;
        this.isOn = isOn;
        this.channels = channels;
    }

    public void turnOn() {
        if (isOn == true) {
            System.out.println("Телевизор уже включен");
        } else {
            isOn = true;
            System.out.println("Телевизор включен");
        }
    }

    public void turnOff() {
        if (isOn == false) {
            System.out.println("Телевизор уже выключен");
        } else {
            isOn = false;
            System.out.println("Телевизор выключен");
        }
    }

    public void nextChannel(Channel channel) {
        if (isOn == true) {
            int i = channel.getNumberChan();
            i++;
            if (i > 4) {
                channel.setNumberChan(0);
            }
            channel.setNumberChan(i);
            System.out.println(model + " Переключен на канал: " + channel.getNumberChan());
        }
    }

    public void previousChannel(Channel channel) {
        if (isOn == true) {
            int i = channel.getNumberChan();
            i--;
            if (i < 0) {
                channel.setNumberChan(4);
            }
            channel.setNumberChan(i);
            System.out.println(model + " Переключен на канал: " + channel.getNumberChan());
        }
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
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

    public List<Channel> getChannels() {
        return channels;
    }

    public void setChannels(List<Channel> channels) {
        this.channels = channels;
    }



    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;

        TV tv = (TV) o;
        return volume == tv.volume && isOn == tv.isOn && model.equals(tv.model) && channels.equals(tv.channels);
    }

    @Override
    public int hashCode() {
        int result = model.hashCode();
        result = 31 * result + volume;
        result = 31 * result + Boolean.hashCode(isOn);
        result = 31 * result + channels.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "TV{" +
                "model='" + model + '\'' +
                ", volume=" + volume +
                ", isOn=" + isOn +
                ", channels=" + channels +
                '}';
    }
}
