package homeworks.homework09.race;

import homeworks.homework09.car.Car;

import java.util.List;

public class TimeLimitRace extends Race{
    private int goldTime;

    public TimeLimitRace(int length, String route, int prizeFund, List<Car> members, int goldTime) {
        super(length, route, prizeFund, members);
        this.goldTime = goldTime;
    }

    public TimeLimitRace() {
    }

    public int getGoldTime() {
        return goldTime;
    }

    public void setGoldTime(int goldTime) {
        this.goldTime = goldTime;
    }

    public String timeLimitRace(Car car) {
        return car.getBrand() + " выйграл в гонке на время";
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;

        TimeLimitRace that = (TimeLimitRace) o;
        return goldTime == that.goldTime;
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + goldTime;
        return result;
    }

    @Override
    public String toString() {
        return "TimeLimitRace{" +
                "goldTime=" + goldTime +
                "} " + super.toString();
    }
}
