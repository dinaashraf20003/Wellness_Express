package Models;

public abstract class Item {
    public String name;
    public String ID;
    public double price;
    public String img;

    public Item(double price, String img, String name) {
        this.price = price;
        this.img = img;
        this.name = name;
    }
}
