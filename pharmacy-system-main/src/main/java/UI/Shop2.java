package UI;

import com.example.pharmacysystem.PharmacyApplication;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.io.IOException;

public class Shop2 {

    @FXML
    private Button AboutUsBtn;

    @FXML
    private ImageView BackBtn;

    @FXML
    private Button CartBtn;

    @FXML
    private Button HomeBtn;

    @FXML
    private ImageView NextBtn;

    @FXML
    private Button TrackOrderBtn;

    @FXML
    private ImageView view1;

    @FXML
    private ImageView view2;

    @FXML
    private ImageView view3;

    @FXML
    private ImageView view4;

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
    void CartBtnClicked(ActionEvent event) throws IOException {
        Node source = (Node)  event.getSource();
        Stage stage  = (Stage) source.getScene().getWindow();
        stage.close();

        FXMLLoader fxmlLoader = new FXMLLoader(PharmacyApplication.class.getResource("Cart.fxml"));
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

    @FXML
    void NextBtnClicked(MouseEvent event) throws IOException {
        Node source = (Node)  event.getSource();
        Stage stage  = (Stage) source.getScene().getWindow();
        stage.close();

        FXMLLoader fxmlLoader = new FXMLLoader(PharmacyApplication.class.getResource("Shop3.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setTitle("Wellness Express");
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    void BackBtnClicked(MouseEvent event) throws IOException {
        Node source = (Node)  event.getSource();
        Stage stage  = (Stage) source.getScene().getWindow();
        stage.close();

        FXMLLoader fxmlLoader = new FXMLLoader(PharmacyApplication.class.getResource("Shop.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setTitle("Wellness Express");
        stage.setScene(scene);
        stage.show();

    }


}
