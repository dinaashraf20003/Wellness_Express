package UI;

import com.example.pharmacysystem.PharmacyApplication;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.io.IOException;

import static Services.AuthService.clientLogin;

public class ClientLogin {

    @FXML
    private PasswordField PassTxt;

    @FXML
    private TextField EmailTxt;

    @FXML
    private ImageView BackBtn;

    @FXML
    private Button LoginBtn;

    @FXML
    private Button SignUpBtn;

    @FXML
    private Label CredLabel;

    @FXML
    void BackBtnClicked(MouseEvent event) throws IOException {
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
    void LoginBtnClicked(ActionEvent event) throws Exception {

        try
        {
            clientLogin(EmailTxt.getText(), PassTxt.getText());
            Node source = (Node)  event.getSource();
            Stage stage  = (Stage) source.getScene().getWindow();
            stage.close();

            FXMLLoader fxmlLoader = new FXMLLoader(PharmacyApplication.class.getResource("Homepage.fxml"));
            Scene scene = new Scene(fxmlLoader.load());
            stage.setTitle("Wellness Express");
            stage.setScene(scene);
            stage.show();
        }
        catch(Exception ex)
        {
            CredLabel.setVisible(true);
        }
    }

    @FXML
    void SignUpBtnClicked(ActionEvent event) throws IOException {
        Node source = (Node)  event.getSource();
        Stage stage  = (Stage) source.getScene().getWindow();
        stage.close();

        FXMLLoader fxmlLoader = new FXMLLoader(PharmacyApplication.class.getResource("SignUp.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setTitle("Wellness Express");
        stage.setScene(scene);
        stage.show();
    }

}
