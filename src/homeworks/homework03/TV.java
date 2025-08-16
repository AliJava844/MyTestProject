package homeworks.homework03;

public class TV {
    private String model;
    private double diagonal;
    private int price;
    private String matrix;

    public TV(String model, double diagonal, int price, String matrix) {
        this.model = model;
        this.diagonal = diagonal;
        this.price = price;
        this.matrix = matrix;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public double getDiagonal() {
        return diagonal;
    }

    public void setDiagonal(double diagonal) {
        this.diagonal = diagonal;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getMatrix() {
        return matrix;
    }

    public void setMatrix(String matrix) {
        this.matrix = matrix;
    }

    @Override
    public String toString() {
        return "TV{" +
                "model='" + model + '\'' +
                ", diagonal=" + diagonal +
                ", price=" + price +
                ", matrix='" + matrix + '\'' +
                '}';
    }

}
