package UI;

import Models.Enums.OrderStatus;
import com.example.pharmacysystem.PharmacyApplication;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ComboBox;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.List;

public class UpdateStatus {

    @FXML
    private Button HomeBtn;

    @FXML
    private Button LogOutBtn;

    @FXML
    private Button ManageBtn;

    @FXML
    private Button UpdateStatusBtn;

    @FXML
    void HomeBtnClicked(ActionEvent event) throws IOException {
        Node source = (Node)  event.getSource();
        Stage stage  = (Stage) source.getScene().getWindow();
        stage.close();

        FXMLLoader fxmlLoader = new FXMLLoader(PharmacyApplication.class.getResource("AdminPage.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setTitle("Wellness Express");
        stage.setScene(scene);
        stage.show();

    }

    @FXML
    void LogOutBtnClicked(ActionEvent event) throws IOException {
        Node source = (Node)  event.getSource();
        Stage stage  = (Stage) source.getScene().getWindow();
        stage.close();

        FXMLLoader fxmlLoader = new FXMLLoader(PharmacyApplication.class.getResource("Welcome.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setTitle("Wellness Express");
        stage.setScene(scene);
        stage.show();

    }

    @FXML
    void ManageBtnClicked(ActionEvent event) throws IOException {
        Node source = (Node)  event.getSource();
        Stage stage  = (Stage) source.getScene().getWindow();
        stage.close();

        FXMLLoader fxmlLoader = new FXMLLoader(PharmacyApplication.class.getResource("Manager.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setTitle("Wellness Express");
        stage.setScene(scene);
        stage.show();

    }

    @FXML
    void UpdateStatusBtnClicked(ActionEvent event) {

    }

}
