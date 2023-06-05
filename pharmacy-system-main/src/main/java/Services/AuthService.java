package Services;

import Models.Client;
import Models.Employee;
import Models.Enums.Priority;
import Models.Enums.Role;
import Singletons.Database;
import com.mongodb.client.MongoCollection;
import org.bson.Document;

import java.util.Objects;

import static com.mongodb.client.model.Filters.eq;

public abstract class AuthService {
    private static MongoCollection clients = Database.getUniqueInstance().database.getCollection("clients");
    private static MongoCollection employees = Database.getUniqueInstance().database.getCollection("employees");


    public static Employee employeeLogin(String email, String password) throws Exception {
       var emp =  employees.find(eq("email", email));
       var doc = (Document)emp.first();

        if(doc == null) throw new Exception("This email does not exist");

        if(!Objects.equals(doc.get("password").toString(), password)) throw new Exception("Wrong password!");

           return  new Employee(
                   (String)doc.get("name"),
                   (String)doc.get("email"),
                   (String)doc.get("id"),
                   (String)doc.get("password"),
                   Role.valueOf(doc.get("role").toString()));
    }

    public static Client clientLogin(String email, String password) throws Exception {
        var emp =  clients.find(eq("email", email));

        var doc = (Document)emp.first();

        if(doc == null) throw new Exception("This email does not exist");


        if(!Objects.equals(doc.get("password").toString(), password)) throw new Exception("Wrong password!");

        return  new Client(
                (String)doc.get("name"),
                (String)doc.get("email"),
                (String)doc.get("id"),
                (String)doc.get("password"),
                (String)doc.get("address"),
                (String)doc.get("phoneNumber")
                );
    }
}
