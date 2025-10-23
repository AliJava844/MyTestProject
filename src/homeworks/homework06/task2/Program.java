package homeworks.homework06.task2;

public class Program {
    private String nameProg;
    private int rating;
    private int viewersOfNumb;

    public Program(String nameProg, int rating, int viewersOfNumb) {
        this.nameProg = nameProg;
        this.rating = rating;
        this.viewersOfNumb = viewersOfNumb;
    }

    public String getNameProg() {
        return nameProg;
    }

    public void setNameProg(String nameProg) {
        this.nameProg = nameProg;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public int getViewersOfNumb() {
        return viewersOfNumb;
    }

    public void setViewersOfNumb(int viewersOfNumb) {
        this.viewersOfNumb = viewersOfNumb;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;

        Program program = (Program) o;
        return rating == program.rating && viewersOfNumb == program.viewersOfNumb && nameProg.equals(program.nameProg);
    }

    @Override
    public int hashCode() {
        int result = nameProg.hashCode();
        result = 31 * result + rating;
        result = 31 * result + viewersOfNumb;
        return result;
    }

    @Override
    public String toString() {
        return "Program{" +
                "nameProg='" + nameProg + '\'' +
                ", rating=" + rating +
                ", viewersOfNumb=" + viewersOfNumb +
                '}';
    }
}
