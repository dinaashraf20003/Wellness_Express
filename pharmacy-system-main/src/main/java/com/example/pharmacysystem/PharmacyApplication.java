package com.example.pharmacysystem;

import Services.ItemService;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.io.IOException;
import Singletons.Database;
import org.bson.types.ObjectId;

public class PharmacyApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(PharmacyApplication.class.getResource("Welcome.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setTitle("Wellness Express");
        stage.setScene(scene);
        stage.show();
        Database db = Database.getUniqueInstance();
       // ItemService.getItemById(new ObjectId("647902800db4f50f6687eaa4"));
    }

    public static void main(String[] args) {
        launch();
    }
    //dinaaaa
}