package homeworks.homework07.task1;

public class Product {
    private String nameProduct;
    private double price;

    public Product(String nameProduct, double price) {
        this.setNameProduct(nameProduct);
        this.setPrice(price);
    }

    public String getNameProduct() {
        return nameProduct;
    }

    public void setNameProduct(String nameProduct) {
        if (!nameProduct.isEmpty()) {
            this.nameProduct = nameProduct;
            boolean allDigits = true;
            for (char c: nameProduct.toCharArray()) {
                if (!Character.isDigit(c)) {
                    allDigits = false;
                    break;
                }
            }
            if (allDigits) {
                throw new IllegalArgumentException("Имя не может состоять только из цифр");
            }
            String trimmed = nameProduct.trim();
            if (trimmed.length() < 3) {
                throw new IllegalArgumentException("Название продкукта не может быть меньше 3 символов");
            }
        } else {
            throw new IllegalArgumentException("Имя не может быть пустым");
        }
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
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
        return Double.compare(price, product.price) == 0 && nameProduct.equals(product.nameProduct);
    }

    @Override
    public int hashCode() {
        int result = nameProduct.hashCode();
        result = 31 * result + Double.hashCode(price);
        return result;
    }
}
