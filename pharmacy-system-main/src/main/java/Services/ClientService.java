package Services;

import Models.Client;
import Models.Enums.Priority;
import Singletons.Database;
import com.mongodb.client.MongoCollection;
import org.bson.Document;
import org.bson.types.ObjectId;
import java.util.ArrayList;
import static com.mongodb.client.model.Filters.eq;

public class ClientService {

    private static MongoCollection clients = Database.getUniqueInstance().database.getCollection("clients");

    public static ArrayList<Client> getAllClients() {
        var employees1 = clients.find();
        ArrayList<Document> docsList = new ArrayList<Document>();
        ArrayList<Client> clientsList = new ArrayList();
        employees1.forEach(doc-> docsList.add((Document) doc));
        docsList.forEach(doc-> clientsList.add(
                new Client(
                        (String)doc.get("name"),
                        (String)doc.get("email"),
                        (String)doc.get("_id"),
                        (String)doc.get("password"),
                        (String)doc.get("address"),
                        (String)doc.get("phoneNumber")
        )));
        return clientsList;
    }

    public static Client getClientById(ObjectId id) {
        var clients1 = clients.find(eq("_id", id));
        Document doc = (Document) clients1.first();
        Client client = new Client(
                (String)doc.get("name"),
                (String)doc.get("email"),
                (String)doc.get("_id"),
                (String)doc.get("password"),
                (String)doc.get("address"),
                (String)doc.get("phoneNumber")
        );
        return client;
    }

    public static void createClient(Client newClient) throws Exception {
        var clients1 = clients.find(eq("email", newClient.getEmail()));
        Document doc = (Document) clients1.first();
        if(doc != null) throw new Exception("This email is already used!");
        Document doc2 = new Document("name", newClient.getName())
                .append("email", newClient.getEmail())
                .append("address", newClient.getAddress())
                .append("password", newClient.getPassword())
                .append("phoneNumber", newClient.getPhoneNumber());

        clients.insertOne(doc2);
        return;
    }

    public static ArrayList<Client> getClientsByImportance(Priority priority) {
        var items = clients.find(eq("priority", priority));
        ArrayList<Document> docsList = new ArrayList<Document>();
        ArrayList<Client> clientsList = new ArrayList();
        items.forEach(doc-> docsList.add((Document) doc));
        docsList.forEach(doc-> clientsList.add(
                new Client(
                        (String)doc.get("name"),
                        (String)doc.get("email"),
                        (String)doc.get("_id"),
                        (String)doc.get("password"),
                        (String)doc.get("address"),
                        (String)doc.get("phoneNumber")
                )));
        return clientsList;
    }
}
