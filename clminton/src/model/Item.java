package model;
import java.util.Objects;

public class Item {
    private String sku;
    private String itemName;
    private int price;
    private boolean tax;


    public Item() {
    }

    public Item(String sku, String itemName, int price, boolean tax) {
        this.sku = sku;
        this.itemName = itemName;
        this.price = price;
        this.tax = tax;
    }

    public String getSku() {
        return this.sku;
    }

    public void setSku(String sku) {
        this.sku = sku;
    }

    public String getItemName() {
        return this.itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public int getPrice() {
        return this.price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public boolean isTax() {
        return this.tax;
    }

    public boolean getTax() {
        return this.tax;
    }

    public void setTax(boolean tax) {
        this.tax = tax;
    }

    public Item sku(String sku) {
        setSku(sku);
        return this;
    }

    public Item itemName(String itemName) {
        setItemName(itemName);
        return this;
    }

    public Item price(int price) {
        setPrice(price);
        return this;
    }

    public Item tax(boolean tax) {
        setTax(tax);
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Item)) {
            return false;
        }
        Item item = (Item) o;
        return Objects.equals(sku, item.sku) && Objects.equals(itemName, item.itemName) && price == item.price && tax == item.tax;
    }

    @Override
    public int hashCode() {
        return Objects.hash(sku, itemName, price, tax);
    }

    @Override
    public String toString() {
        return "{" +
            " sku='" + getSku() + "'" +
            ", itemName='" + getItemName() + "'" +
            ", price='" + getPrice() + "'" +
            ", tax='" + isTax() + "'" +
            "}";
    }    
}



