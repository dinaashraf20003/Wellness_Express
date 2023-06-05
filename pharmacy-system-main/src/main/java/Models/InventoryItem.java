package Models;

import Models.Enums.Type;
import java.util.Date;

public class InventoryItem extends  Item {
    private Date expiryDate;
    private String supplier;
    private int stock;
    private double concentration;
    private Type type;


    public InventoryItem(Date expiryDate, String supplier, int stock, double concentration, Type type, double price, String img, String name) {
        super(price, img, name);
        this.expiryDate = expiryDate;
        this.supplier = supplier;
        this.stock = stock;
        this.concentration = concentration;
        this.type = type;
    }

    public Date getExpiryDate() {
        return expiryDate;
    }

    public String getSupplier() {
        return supplier;
    }

    public int getStock() {
        return stock;
    }

    public double getConcentration() {
        return concentration;
    }

    public Type getType() {
        return type;
    }

    public void increaseStock(int increaseAmount) {
        this.stock += increaseAmount;
        //TODO: increase stock in DB
    }

    public void decreaseStock(int decreaseAmount) {
        this.stock -= decreaseAmount;
        //TODO: decrease stock in DB
    }

    @Override
    public String toString() {
        return this.ID + "\n" + this.name + "\n" + this.supplier + "\n" + this.price + "\n" + "\n" + this.concentration;
    }
}
