package homeworks.homework09.race;

import homeworks.homework09.car.Car;

import java.util.List;

public class Race {
    private int length;
    private String route;
    private int prizeFund;
    private List<Car> members;

    public Race(int length, String route, int prizeFund, List<Car> members) {
        this.length = length;
        this.route = route;
        this.prizeFund = prizeFund;
        this.members = members;
    }

    public Race() {
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public String getRoute() {
        return route;
    }

    public void setRoute(String route) {
        this.route = route;
    }

    public int getPrizeFund() {
        return prizeFund;
    }

    public void setPrizeFund(int prizeFund) {
        this.prizeFund = prizeFund;
    }

    public List<Car> getMembers() {
        return members;
    }

    public void setMembers(List<Car> members) {
        this.members = members;
    }

    public void addMembers(Car car){
        members.add(car);
    }

    public String casualRace(Car car) {
        return car.getBrand() + " выйграл в обычной гонке.";
    }

    public String  dragRace(Car car) {
        return car.getBrand() + " учавствует в гонке за самый мощный двигатель.";
    }

    public String  driftRace(Car car) {
        return car.getBrand() + " учавствует в дрифтовой гонке.";
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;

        Race race = (Race) o;
        return length == race.length && prizeFund == race.prizeFund && route.equals(race.route) && members.equals(race.members);
    }

    @Override
    public int hashCode() {
        int result = length;
        result = 31 * result + route.hashCode();
        result = 31 * result + prizeFund;
        result = 31 * result + members.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "Race{" +
                "length=" + length +
                ", route='" + route + '\'' +
                ", prizeFund=" + prizeFund +
                ", members=" + members +
                '}';
    }
}
