package homeworks.homework06.task2;

import java.util.List;

public class Channel {
    private String nameChan;
    private int numberChan;
    private List<Program> programs;

    public Channel(String nameChan, int numberChan, List<Program> programs) {
        this.nameChan = nameChan;
        this.numberChan = numberChan;
        this.programs = programs;
    }

    public String getNameChan() {
        return nameChan;
    }

    public void setNameChan(String nameChan) {
        this.nameChan = nameChan;
    }

    public int getNumberChan() {
        return numberChan;
    }

    public void setNumberChan(int numberChan) {
        this.numberChan = numberChan;
    }

    public List<Program> getPrograms() {
        return programs;
    }

    public void setPrograms(List<Program> programs) {
        this.programs = programs;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;

        Channel channel = (Channel) o;
        return numberChan == channel.numberChan && nameChan.equals(channel.nameChan) && programs.equals(channel.programs);
    }

    @Override
    public int hashCode() {
        int result = nameChan.hashCode();
        result = 31 * result + numberChan;
        result = 31 * result + programs.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "Channel{" +
                "nameChan='" + nameChan + '\'' +
                ", numberChan=" + numberChan +
                ", programs=" + programs +
                '}';
    }
}
