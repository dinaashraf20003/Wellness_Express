package UI;

import com.example.pharmacysystem.PharmacyApplication;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;

public class Cart {

    @FXML
    private Button AboutsUsBtn;

    @FXML
    private Button HomeBtn;

    @FXML
    private Button ShopBtn;

    @FXML
    private Button TrackOrderBtn;

    @FXML
    void AboutUsBtnClicked(ActionEvent event) throws IOException {
        Node source = (Node)  event.getSource();
        Stage stage  = (Stage) source.getScene().getWindow();
        stage.close();

        FXMLLoader fxmlLoader = new FXMLLoader(PharmacyApplication.class.getResource("AboutUs.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setTitle("Wellness Express");
        stage.setScene(scene);
        stage.show();

    }

    @FXML
    void HomeBtnClicked(ActionEvent event) throws IOException {
        Node source = (Node)  event.getSource();
        Stage stage  = (Stage) source.getScene().getWindow();
        stage.close();

        FXMLLoader fxmlLoader = new FXMLLoader(PharmacyApplication.class.getResource("Homepage.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setTitle("Wellness Express");
        stage.setScene(scene);
        stage.show();

    }

    @FXML
    void ShopBtnClicked(ActionEvent event) throws IOException {
        Node source = (Node)  event.getSource();
        Stage stage  = (Stage) source.getScene().getWindow();
        stage.close();

        FXMLLoader fxmlLoader = new FXMLLoader(PharmacyApplication.class.getResource("ShopDuplicate.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setTitle("Wellness Express");
        stage.setScene(scene);
        stage.show();

    }

    @FXML
    void TrackOrderBtnClicked(ActionEvent event) throws IOException {
        Node source = (Node)  event.getSource();
        Stage stage  = (Stage) source.getScene().getWindow();
        stage.close();

        FXMLLoader fxmlLoader = new FXMLLoader(PharmacyApplication.class.getResource("TrackOrder.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setTitle("Wellness Express");
        stage.setScene(scene);
        stage.show();

    }

}
