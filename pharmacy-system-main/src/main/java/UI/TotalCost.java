package UI;

import Models.Order;
import Services.OrderService;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import org.bson.types.ObjectId;

import java.net.URL;
import java.util.Date;
import java.util.ResourceBundle;

public class TotalCost implements Initializable {

    @FXML
    public Label TotalCostLabel;
    @FXML
    public Label OrderStatusLabel;

    @FXML
    public Label NumberOfItemsLabel;

    @FXML
    public Label DateOfOrderLabel;


    public static StringProperty CostLabelText = new SimpleStringProperty();

    public static ObjectId OrderId;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        TotalCostLabel.textProperty().bind(CostLabelText);
        try {
          Order newOrder =  OrderService.getOrderById(OrderId);
          System.out.println(newOrder.getTotalCost());
          OrderStatusLabel.setText("Status: "+ newOrder.getStatus().toString());
          NumberOfItemsLabel.setText("Number of Items: " + newOrder.getItems().size());
          DateOfOrderLabel.setText("Created at: " + newOrder.getDateOfOrder());
        }
        catch(Exception e) {
            System.out.println(e.getMessage());
        }
    }

}