package Models;


public class OrderItem extends Item {
    public int quantity;

    public OrderItem(int quantity, double price, String img, String id, String name) {
        super(price, img, name);
        this.quantity = quantity;
    }

    public double getCost() {
        return this.quantity * this.price;
    }
}
