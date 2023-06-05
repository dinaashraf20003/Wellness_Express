package Singletons;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoDatabase;

public class Database {
    private String databaseName = "pharmacy";
    private String connectionString = "mongodb+srv://oopproj:GUBYHEeenOzZ5Nlp@cluster0.dtubnmo.mongodb.net/?retryWrites=true&w=majority";

    public MongoDatabase database;

    private static Database uniqueInstance;

    private Database() {
        try {
            MongoClient mongoClient = MongoClients.create(connectionString);
            database = mongoClient.getDatabase(databaseName);
        }
        catch(Exception exception) {
            System.out.println(exception.getMessage());
        }
    }

    public static Database getUniqueInstance() {
        if(uniqueInstance==null) {
            uniqueInstance = new Database();
        }
        return uniqueInstance;
    }
}
