package Team2.youngcha.hellospring.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.time.LocalDate;

@Entity
public class Menu {

    @Id
    private String dish;
    private int price;
    @Column(columnDefinition = "int default 0")
    private int salesCount;
    private int stock;
    private LocalDate lastRestockedDate;
    @Column(columnDefinition = "int default 100")
    private int restockRate;

    public int getRestockRate() {
        return restockRate;
    }

    public void setRestockRate(int restockRate) {
        this.restockRate = restockRate;
    }

    public String getDish() {
        return dish;
    }

    public void setDish(String dish) {
        this.dish = dish;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getSalesCount() {
        return salesCount;
    }

    public void setSalesCount(int salesCount) {
        this.salesCount = salesCount;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public LocalDate getLastRestockedDate() {
        return lastRestockedDate;
    }

    public void setLastRestockedDate(LocalDate lastRestockedDate) {
        this.lastRestockedDate = lastRestockedDate;
    }
}
