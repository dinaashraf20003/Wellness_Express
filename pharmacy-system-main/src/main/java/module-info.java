module com.example.pharmacysystem {
    requires javafx.controls;
    requires javafx.fxml;
    requires org.mongodb.driver.sync.client;
    requires org.mongodb.bson;
    requires org.mongodb.driver.core;


    opens com.example.pharmacysystem to javafx.fxml;
    exports com.example.pharmacysystem;
    exports UI;
    opens UI to javafx.fxml;
}