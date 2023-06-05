package Models;

import Models.Enums.OrderStatus;
import Models.Enums.PaymentMethod;
import Models.Interfaces.Payment;

import java.util.ArrayList;
import java.util.Date;

public class Order implements Payment {
    private OrderStatus status;
    private Date dateOfOrder;
    private float totalCost = 0;
    private PaymentMethod paymentMethod;
    private ArrayList<OrderItem> items;

    public OrderStatus getStatus() {
        return status;
    }

    public void updateStatus() throws Exception{
        switch (status) {
            case PROCESSING: {
                this.status = OrderStatus.READYFORDELIVERY;
                break;
            }
            case READYFORDELIVERY: {
                this.status = OrderStatus.ONTHEWAY;
                break;
            }
            case ONTHEWAY: {
                this.status = OrderStatus.DELIVERED;
                break;
            }
            default:
                throw new Exception("The order is already Delivered. Cannot update status");
        }
    }

    public Date getDateOfOrder() {
        return dateOfOrder;
    }
    public float getTotalCost() {
        return totalCost;
    }

    public PaymentMethod getPaymentMethod() {
        return paymentMethod;
    }

    public ArrayList<OrderItem> getItems() {
        return items;
    }

    public void addItem(OrderItem item) {
        this.items.add(item);
    }

    public void Pay(CreditCard card) throws Exception{
        if(this.totalCost > card.getBalance()) {
            throw new Exception("Not Enough Balance!");
        }
        card.decreaseBalance(this.totalCost);

        this.paymentMethod = PaymentMethod.CARD;
    }

    public void Pay(Cash cash) {
        this.paymentMethod = PaymentMethod.CASH;
    }
    @Override
    public String toString() {
        return "Total Cost: " + this.totalCost + "\n" + "Status: " + this.status + "\n" + "Payment method: " + this.paymentMethod;
    }

    public Order(OrderStatus status, Date dateOfOrder, ArrayList<OrderItem> items) {
        this.status = OrderStatus.PROCESSING;
        this.dateOfOrder = dateOfOrder;
        this.items = items;
        for(int i =0; i< items.size(); i++) {
            OrderItem currentItem = items.get(i);
            this.totalCost += currentItem.price * currentItem.quantity;
        }
        paymentMethod = PaymentMethod.CASH;
    }
}
