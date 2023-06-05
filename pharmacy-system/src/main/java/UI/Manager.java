package UI;

import com.example.pharmacysystem.PharmacyApplication;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

public class Manager {

    @FXML
    private Button AddBtn;

    @FXML
    private CheckBox Defected;

    @FXML
    private CheckBox Expired;

    @FXML
    private Button HomeBtn;

    @FXML
    private Button LogOutBtn;

    @FXML
    private TextField PrdctID_Add;

    @FXML
    private TextField PrdctID_Remove;

    @FXML
    private TextField PrdctName;

    @FXML
    private TextField PrdctType;

    @FXML
    private TextField Price;

    @FXML
    private TextField Qty;

    @FXML
    private Button RemoveBtn;

    @FXML
    private Button UpdateStatusBtn;

    @FXML
    private TextField imgPath;

    @FXML
    void AddBtnClicked(ActionEvent event) {

    }

    @FXML
    void DefectedChecked(ActionEvent event) {

    }

    @FXML
    void ExpiredChecked(ActionEvent event) {

    }

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
    void RemoveBtnClicked(ActionEvent event) {

    }

    @FXML
    void UpdateStatusBtnClicked(ActionEvent event) throws IOException {
        Node source = (Node)  event.getSource();
        Stage stage  = (Stage) source.getScene().getWindow();
        stage.close();

        FXMLLoader fxmlLoader = new FXMLLoader(PharmacyApplication.class.getResource("UpdateStatus.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setTitle("Wellness Express");
        stage.setScene(scene);
        stage.show();

    }

}
