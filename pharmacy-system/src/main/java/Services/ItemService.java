package Services;
import Models.Enums.Type;
import Models.InventoryItem;
import Singletons.Database;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.model.Updates;
import org.bson.Document;
import org.bson.types.ObjectId;

import java.util.ArrayList;
import java.util.Date;

import static com.mongodb.client.model.Filters.eq;

public abstract class ItemService {
    private static MongoCollection inventoryItems = Database.getUniqueInstance().database.getCollection("inventoryItems");


    public static ArrayList<InventoryItem> getAllItems() {
        var items = inventoryItems.find();
        ArrayList<Document> docsList = new ArrayList<Document>();
        ArrayList<InventoryItem> itemsList = new ArrayList();
        items.forEach(doc->docsList.add((Document) doc));
        docsList.forEach(doc->itemsList.add(
                new InventoryItem(
                        (Date)doc.get("expiryDate"),
                        (String)doc.get("supplier"),
                        (int)doc.get("stock"),
                        (double)doc.get("concentration"),
                        Type.valueOf((String) doc.get("type")),
                        (double)doc.get("price"),
                        (String)doc.get("img"),
                        (String)doc.get("name"))
        ));
        return itemsList;
    }


    public static ArrayList<InventoryItem> getItemsByType(Type type) {
        var items = inventoryItems.find(eq("type", type));
        ArrayList<Document> docsList = new ArrayList<Document>();
        ArrayList<InventoryItem> itemsList = new ArrayList();
        items.forEach(doc->docsList.add((Document) doc));
        docsList.forEach(doc->itemsList.add(
                new InventoryItem(
                        (Date)doc.get("expiryDate"),
                        (String)doc.get("supplier"),
                        (int)doc.get("stock"),
                        (double)doc.get("concentration"),
                        Type.valueOf((String) doc.get("type")),
                        (double)doc.get("price"),
                        (String)doc.get("img"),
                        (String)doc.get("name"))
        ));
        return itemsList;
    }

    public static void createItem(InventoryItem item) {
        Document doc = new Document("name", item.name)
                .append("price", item.price)
                .append("type", item.getType())
                .append("supplier", item.getSupplier())
                .append("concentration", item.getConcentration())
                .append("expiryDate", item.getExpiryDate())
                .append("img", item.img)
                .append("stock", item.getStock());

        inventoryItems.insertOne(doc);
        return;
    }

    public static InventoryItem getItemById(ObjectId id) {
        var item = inventoryItems.find(eq("_id", id));
        Document doc = (Document) item.first();
        InventoryItem item2 = new InventoryItem(
                (Date)doc.get("expiryDate"),
                (String)doc.get("supplier"),
                (int)doc.get("stock"),
                (float)doc.get("concentration"),
                (Type)doc.get("type"),
                (float)doc.get("price"),
                (String)doc.get("img"),
                (String)doc.get("name"));

        return item2;
    }

    public static void increaseItemStock(ObjectId id, int addedStock) {
        var item = inventoryItems.findOneAndUpdate(eq("_id", id), Updates.inc("stock", addedStock));
        return;
    }

    public static void decreaseItemStock(ObjectId id, int removedStock) {
        var item = inventoryItems.findOneAndUpdate(eq("_id", id), Updates.inc("stock", removedStock));
        return;
    }

}
