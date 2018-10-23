package entities;

import javax.persistence.*;

@Entity
@Table
public class Item {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long ID;

    @Column(name = "ITEM_NAME", unique = true, nullable = false)
    private String name;

    @Column(name = "DESCRIPTION")
    private String description;

    @Column(name = "PRICE", nullable = false)
    private Float price;

    @Column(name = "AVAILABLE", columnDefinition = "BIT", length = 1, nullable = false)
    private boolean available;

    @Column(name = "AMOUNT", nullable = false)
    private int amount;

    public Item() {
    }

    public Long getID() {
        return ID;
    }
    public String getName() {
        return name;
    }
    public String getDescription() {
        return description;
    }
    public Float getPrice() {
        return price;
    }
    public boolean isAvailable() {
        return available;
    }
    public int getAmount() {
        return amount;
    }

    public void setID(Long ID) {
        this.ID = ID;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    public void setPrice(Float price) {
        this.price = price;
    }
    public void setAvailable(boolean available) {
        this.available = available;
    }
    public void setAmount(int amount) {
        this.amount = amount;
    }

    @Override
    public String toString() {
        return "Item{" +
                "ID=" + ID +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", price=" + price +
                ", available=" + available +
                ", amount=" + amount +
                '}';
    }
}
