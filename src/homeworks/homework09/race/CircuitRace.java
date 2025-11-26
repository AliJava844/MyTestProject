package homeworks.homework09.race;

import homeworks.homework09.car.Car;

import java.util.List;

public class CircuitRace extends Race{
    private int laps;

    public CircuitRace(int length, String route, int prizeFund, List<Car> members, int laps) {
        super(length, route, prizeFund, members);
        this.laps = laps;
    }

    public CircuitRace() {
    }

    public int getLaps() {
        return laps;
    }

    public void setLaps(int laps) {
        this.laps = laps;
    }

    public String circuitRace(Car car) {
        return car.getBrand() + " выйграл на трассе";
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;

        CircuitRace that = (CircuitRace) o;
        return laps == that.laps;
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + laps;
        return result;
    }

    @Override
    public String toString() {
        return "CircuitRace{" +
                "laps=" + laps +
                "} " + super.toString();
    }
}
