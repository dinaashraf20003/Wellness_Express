package Services;

import Models.Employee;
import Models.Enums.Role;
import Models.InventoryItem;
import Singletons.Database;
import com.mongodb.client.MongoCollection;
import org.bson.Document;
import org.bson.types.ObjectId;

import java.util.ArrayList;

import static com.mongodb.client.model.Filters.eq;

public abstract class EmployeeService {
    private static MongoCollection employees = Database.getUniqueInstance().database.getCollection("employees");

    public static ArrayList<Employee> getAllEmployees() {
        var employees1 = employees.find();
        ArrayList<Document> docsList = new ArrayList<Document>();
        ArrayList<Employee> employeesList = new ArrayList();
        employees1.forEach(doc-> docsList.add((Document) doc));
        docsList.forEach(doc-> employeesList.add(
                new Employee(
                        (String)doc.get("name"),
                        (String)doc.get("email"),
                        (String)doc.get("id"),
                        (String)doc.get("password"),
                        Role.valueOf(doc.get("role").toString())
        )));
        return employeesList;
    }


    public static Employee getEmployeeById(ObjectId id) {
        var employees1 = employees.find(eq("_id", id));
        Document doc = (Document) employees1.first();
        Employee employee = new Employee(
                (String)doc.get("name"),
                (String)doc.get("email"),
                (String)doc.get("_id"),
                (String)doc.get("password"),
                Role.valueOf(doc.get("role").toString())
        );
        return employee;
    }
}
