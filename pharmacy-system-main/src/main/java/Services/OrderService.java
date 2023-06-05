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
                        OrderStatus.valueOf(doc.get("status").toString()),
                        (Date)doc.get("dateOfOrder"),
                        (ArrayList<OrderItem>)doc.get("items")
        )));
        return ordersList;
    }

    public static Order getOrderById(ObjectId id) {
        var order = orders.find(eq("_id", id));
        Document doc = (Document) order.first();
        ArrayList<OrderItem> items = new ArrayList<>();
        for (Document document : (ArrayList<Document>) doc.get("items")) {
            items.add(
                    new OrderItem(
                            (Integer) document.get("quantity"),
                            (Double) document.get("price"),
                            (String)document.get("img"),
                            "",
                            (String)document.get("name")));
        }
        Order order2 = new Order(
                OrderStatus.valueOf(doc.get("status").toString()),
                (Date)doc.get("dateOfOrder"),
                items);

        return order2;
    }



    public static ObjectId createOrder(Order orderObj) {
        System.out.println(orderObj.getStatus());
        System.out.println(orderObj.getDateOfOrder());
        System.out.println(orderObj.getTotalCost());
        System.out.println(orderObj.getPaymentMethod());
        System.out.println(orderObj.getItems());
        ArrayList<Document> orderItemsList = new ArrayList<>();
        orderObj.getItems().forEach(item -> orderItemsList.add(
                new Document("quantity", item.quantity)
                        .append("price", item.price)
                        .append("img", item.img)
                        .append("name", item.name)
        ));
        Document doc = new Document("status", orderObj.getStatus())
                .append("dateOfOrder", orderObj.getDateOfOrder())
                .append("totalCost", orderObj.getTotalCost())
                .append("paymentMethod", orderObj.getPaymentMethod())
                .append("items", orderItemsList);
        var insertResult = orders.insertOne(doc);
        System.out.println(insertResult.getInsertedId().asObjectId().getValue());
        return insertResult.getInsertedId().asObjectId().getValue();
    }



}
