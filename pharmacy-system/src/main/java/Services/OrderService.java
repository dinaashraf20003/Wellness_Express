package Services;

import Models.Enums.OrderStatus;
import Models.Enums.Type;
import Models.Order;
import Models.OrderItem;
import Models.Supplier;
import Singletons.Database;
import com.mongodb.client.MongoCollection;
import org.bson.Document;
import org.bson.types.ObjectId;

import java.util.ArrayList;
import java.util.Date;

import static com.mongodb.client.model.Filters.eq;

public class OrderService {
    private static MongoCollection orders = Database.getUniqueInstance().database.getCollection("orders");

    public static ArrayList<Order> getAllOrders() {
        var orders2 = orders.find();
        ArrayList<Document> docsList = new ArrayList();
        ArrayList<Order> ordersList = new ArrayList();
        orders2.forEach(doc-> docsList.add((Document) doc));
        docsList.forEach(doc-> ordersList.add(
                new Order(
                        (OrderStatus) doc.get("status"),
                        (Date)doc.get("dateOfOrder"),
                        (ArrayList<OrderItem>)doc.get("items")
        )));
        return ordersList;
    }

    public static Order getOrderById(ObjectId id) {
        var order = orders.find(eq("_id", id));
        Document doc = (Document) order.first();
        Order order2 = new Order(
                (OrderStatus) doc.get("status"),
                (Date)doc.get("dateOfOrder"),
                (ArrayList<OrderItem>)doc.get("items"));

        return order2;
    }



    public static void createOrder(Order orderObj) {
        Document doc = new Document("status", orderObj.getStatus())
                .append("dateOfOrder", orderObj.getDateOfOrder())
                .append("totalCost", orderObj.getTotalCost())
                .append("paymentMethod", orderObj.getPaymentMethod())
                .append("items", orderObj.getItems());
        orders.insertOne(doc);
        return;
    }



}
