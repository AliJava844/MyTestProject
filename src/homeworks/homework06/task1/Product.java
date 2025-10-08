package homeworks.homework06.task1;

public class Product {
    private String nameProduct;
    private int price;

    public Product(String nameProduct, int price) {
        this.setNameProduct(nameProduct);
        this.setPrice(price);
    }

    public String getNameProduct() {
        return nameProduct;
    }

    public void setNameProduct(String nameProduct) {
        if (!nameProduct.isEmpty()) {
            this.nameProduct = nameProduct;
        } else {
            throw new IllegalArgumentException("Имя не может быть пустым");
        }
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        if (price > 0) {
            this.price = price;
        } else {
            throw new IllegalArgumentException("Деньги не" +
                    "могут быть отрицательными");
        }
    }

    @Override
    public String toString() {
        return "Product{" +
                "nameProduct='" + nameProduct + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;

        Product product = (Product) o;
        return price == product.price && nameProduct.equals(product.nameProduct);
    }

    @Override
    public int hashCode() {
        int result = nameProduct.hashCode();
        result = 31 * result + price;
        return result;
    }
}
