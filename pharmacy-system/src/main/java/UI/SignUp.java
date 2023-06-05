package UI;


import Models.Client;
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
import java.util.Objects;

import static Services.ClientService.createClient;

public class SignUp {

    @FXML
    private TextField AddressTxt;

    @FXML
    private ImageView BackBtn;

    @FXML
    private PasswordField ConfirmTxt;

    @FXML
    private TextField EmailTxt;

    @FXML
    private TextField NameTxt;

    @FXML
    private PasswordField PassTxt;

    @FXML
    private TextField PhoneTxt;

    @FXML
    private Button SignUpBtn;

    @FXML
    private Label WarningMsg;

    @FXML
    void BackBtnClicked(MouseEvent event) throws IOException {
        Node source = (Node)  event.getSource();
        Stage stage  = (Stage) source.getScene().getWindow();
        stage.close();

        FXMLLoader fxmlLoader = new FXMLLoader(PharmacyApplication.class.getResource("ClientLogin.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setTitle("Wellness Express");
        stage.setScene(scene);
        stage.show();

    }

    @FXML
    void SignUpBtnClicked(ActionEvent event) throws IOException {

        try
        {
            if(Objects.equals(PassTxt.getText(), ConfirmTxt.getText()))
            {
                Client c = new Client(NameTxt.getText(), EmailTxt.getText(), PassTxt.getText(), AddressTxt.getText(), PhoneTxt.getText());
                createClient(c);
                Node source = (Node)  event.getSource();
                Stage stage  = (Stage) source.getScene().getWindow();
                stage.close();

                FXMLLoader fxmlLoader = new FXMLLoader(PharmacyApplication.class.getResource("Homepage.fxml"));
                Scene scene = new Scene(fxmlLoader.load());
                stage.setTitle("Wellness Express");
                stage.setScene(scene);
                stage.show();
            }
            else
            {
                WarningMsg.setText("Password Mismatch!");
                WarningMsg.setVisible(true);
            }
        }
        catch(Exception ex)
        {
            WarningMsg.setText("Already Existing Email!");
            WarningMsg.setVisible(true);
        }
    }

}
