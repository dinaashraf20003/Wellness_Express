package Models;

import java.util.ArrayList;

public class Cart {
    private ArrayList<Item> list = new ArrayList<>();
    public void addItem(Item item){
        list.add(item);
    }
    public void removeItem(Item item){
        list.remove(item);
    }
    public float totalCost(){
        float sum =0;
        Item x;
        for(int i=0;i< list.size(); i++){
            x =list.get(i);
            sum+= x.price;
        }
        return sum;
    }

}
