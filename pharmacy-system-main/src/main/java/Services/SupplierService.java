package Services;

import Models.Enums.Type;
import Models.InventoryItem;
import Models.Supplier;
import Singletons.Database;
import com.mongodb.client.MongoCollection;
import org.bson.Document;
import org.bson.types.ObjectId;
import java.util.ArrayList;
import java.util.Date;

import static com.mongodb.client.model.Filters.eq;

public abstract class SupplierService {
    private static MongoCollection suppliers = Database.getUniqueInstance().database.getCollection("suppliers");


    public static ArrayList<Supplier> getAllSuppliers() {
        var suppliers2 = suppliers.find();
        ArrayList<Document> docsList = new ArrayList<Document>();
        ArrayList<Supplier> suppliersList = new ArrayList();
        suppliers2.forEach(doc->docsList.add((Document) doc));
        docsList.forEach(doc->suppliersList.add(
                new Supplier(
                        (String)doc.get("address"),
                        (String)doc.get("phoneNumber"),
                        (String)doc.get("email"),
                        (String)doc.get("name"),
                        (Type)doc.get("type"))
        ));
        return suppliersList;
    }


    public static Supplier getSupplierById(ObjectId id) {
        var item = suppliers.find(eq("_id", id));
        Document doc = (Document) item.first();
        Supplier item2 = new Supplier(
                (String)doc.get("address"),
                (String)doc.get("phoneNumber"),
                (String)doc.get("email"),
                (String)doc.get("name"),
                (Type)doc.get("type"));

        return item2;
    }

    public static void createSupplier(Supplier supplierObj) {
        Document doc = new Document("name", supplierObj.name)
                .append("type", supplierObj.type)
                .append("address", supplierObj.address)
                .append("email", supplierObj.email)
                .append("phoneNumber", supplierObj.phoneNumber);
        suppliers.insertOne(doc);
        return;
    }


    public static ArrayList<Supplier> getSuppliersByType(Type type) {
        var items = suppliers.find(eq("type", type));
        ArrayList<Document> docsList = new ArrayList<Document>();
        ArrayList<Supplier> itemsList = new ArrayList();
        items.forEach(doc->docsList.add((Document) doc));
        docsList.forEach(doc->itemsList.add(
                new Supplier(
                        (String)doc.get("address"),
                        (String)doc.get("phoneNumber"),
                        (String)doc.get("email"),
                        (String)doc.get("name"),
                        (Type)doc.get("type"))));
        return itemsList;
    }

}
