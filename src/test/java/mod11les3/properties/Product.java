package mod11les3.properties;

import java.math.BigDecimal;

public class Product {
    private BigDecimal price;
    private String header;
    private String description;

    public Product(BigDecimal price, String header, String description) {
        this.price = price;
        this.header = header;
        this.description = description;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public String getHeader() {
        return header;
    }

    public String getDescription() {
        return description;
    }

    @Override
    public String toString() {
        return "Product{" +
                "price=" + price +
                ", header='" + header + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
