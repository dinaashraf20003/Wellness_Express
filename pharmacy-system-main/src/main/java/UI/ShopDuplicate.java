package UI;

import Models.Enums.OrderStatus;
import Models.Enums.Type;
import Models.InventoryItem;
import Models.Order;
import Models.OrderItem;
import Services.OrderService;
import com.example.pharmacysystem.PharmacyApplication;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import org.bson.types.ObjectId;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.Objects;

import static Services.ItemService.getAllItems;
import static Services.OrderService.createOrder;
import static UI.TotalCost.CostLabelText;
import static UI.TotalCost.OrderId;

import static java.lang.Math.ceil;

public class ShopDuplicate {

    @FXML
    private Button AboutUsBtn;

    @FXML
    private Button AddBtn1;

    @FXML
    private Button AddBtn2;

    @FXML
    private Button AddBtn3;

    @FXML
    private Button AddBtn4;

    @FXML
    private ImageView BackBtn;

    @FXML
    private Button CartBtn;

    @FXML
    private Button HomeBtn;

    @FXML
    private Label Name1;

    @FXML
    private Label Name2;

    @FXML
    private Label Name3;

    @FXML
    private Label Name4;

    @FXML
    private ImageView NextBtn;

    @FXML
    private Label Price1;

    @FXML
    private Label Price2;

    @FXML
    private Label Price3;

    @FXML
    private Label Price4;

    @FXML
    private TextField Qty1;

    @FXML
    private TextField Qty2;

    @FXML
    private TextField Qty3;

    @FXML
    private TextField Qty4;

    @FXML
    private Button TrackOrderBtn;

    @FXML
    private Label Type1;

    @FXML
    private Label Type2;

    @FXML
    private Label Type3;

    @FXML
    private Label Type4;

    @FXML
    private ImageView view1;

    @FXML
    private ImageView view2;

    @FXML
    private ImageView view3;

    @FXML
    private ImageView view4;

    @FXML
    private Label QtyLabel1;

    @FXML
    private Label QtyLabel2;

    @FXML
    private Label QtyLabel3;

    @FXML
    private Label QtyLabel4;

    public int page = 0;



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
//        Node source = (Node)  event.getSource();
//        Stage stage  = (Stage) source.getScene().getWindow();
//        stage.close();
//
//        FXMLLoader fxmlLoader = new FXMLLoader(PharmacyApplication.class.getResource("Shop2.fxml"));
//        Scene scene = new Scene(fxmlLoader.load());
//        stage.setTitle("Wellness Express");
//        stage.setScene(scene);
//        stage.show();
        ArrayList<InventoryItem> items = getAllItems();

        int size = items.size();

        if((int)ceil(size/4.0)-1==page)
        {
            page = 0;
        }
        else
        {
            page++;
        }

        view1.setImage(new Image(items.get(page*4).img));
        Name1.setText(items.get(page*4).name);
        Price1.setText(String.valueOf(items.get(page*4).price));
        Type1.setText(String.valueOf(items.get(page*4).getType()));

        if(page*4+1 >= size)
        {
            view2.setVisible(false);
            view3.setVisible(false);
            view4.setVisible(false);

            Name2.setVisible(false);
            Name3.setVisible(false);
            Name4.setVisible(false);

            Price2.setVisible(false);
            Price3.setVisible(false);
            Price4.setVisible(false);

            Type2.setVisible(false);
            Type3.setVisible(false);
            Type4.setVisible(false);

            AddBtn2.setVisible(false);
            AddBtn3.setVisible(false);
            AddBtn4.setVisible(false);

            Qty2.setVisible(false);
            Qty3.setVisible(false);
            Qty4.setVisible(false);

            QtyLabel2.setVisible(false);
            QtyLabel3.setVisible(false);
            QtyLabel4.setVisible(false);
        }

        else if(page*4+2 >= size)
        {
            view2.setVisible(true);
            view2.setImage(new Image(items.get(page*4+1).img));
            view3.setVisible(false);
            view4.setVisible(false);

            Name2.setVisible(true);
            Name2.setText(items.get(page*4+1).name);
            Name3.setVisible(false);
            Name4.setVisible(false);

            Price2.setVisible(true);
            Price2.setText(String.valueOf(items.get(page*4+1).price));
            Price3.setVisible(false);
            Price4.setVisible(false);

            Type2.setVisible(true);
            Type2.setText(String.valueOf(items.get(page*4+1).getType()));
            Type3.setVisible(false);
            Type4.setVisible(false);

            AddBtn2.setVisible(true);
            AddBtn3.setVisible(false);
            AddBtn4.setVisible(false);

            Qty2.setVisible(true);
            Qty3.setVisible(false);
            Qty4.setVisible(false);

            QtyLabel2.setVisible(true);
            QtyLabel3.setVisible(false);
            QtyLabel4.setVisible(false);
        }

        else if(page*4+3 >= size)
        {
            view2.setVisible(true);
            view3.setVisible(true);
            view2.setImage(new Image(items.get(page*4+1).img));
            view3.setImage(new Image(items.get(page*4+2).img));
            view4.setVisible(false);

            Name2.setVisible(true);
            Name3.setVisible(true);
            Name2.setText(items.get(page*4+1).name);
            Name3.setText(items.get(page*4+2).name);
            Name4.setVisible(false);

            Price2.setVisible(true);
            Price3.setVisible(true);
            Price2.setText(String.valueOf(items.get(page*4+1).price));
            Price3.setText(String.valueOf(items.get(page*4+2).price));
            Price4.setVisible(false);

            Type2.setVisible(true);
            Type3.setVisible(true);
            Type2.setText(String.valueOf(items.get(page*4+1).getType()));
            Type3.setText(String.valueOf(items.get(page*4+2).getType()));
            Type4.setVisible(false);

            AddBtn2.setVisible(true);
            AddBtn3.setVisible(true);
            AddBtn4.setVisible(false);

            Qty2.setVisible(true);
            Qty3.setVisible(true);
            Qty4.setVisible(false);

            QtyLabel2.setVisible(true);
            QtyLabel3.setVisible(true);
            QtyLabel4.setVisible(false);
        }
        else
        {
            view2.setVisible(true);
            view3.setVisible(true);
            view4.setVisible(true);
            view1.setImage(new Image(items.get(page*4).img));
            view2.setImage(new Image(items.get(page*4+1).img));
            view3.setImage(new Image(items.get(page*4+2).img));
            view4.setImage(new Image(items.get(page*4+3).img));

            Name2.setVisible(true);
            Name3.setVisible(true);
            Name4.setVisible(true);
            Name1.setText(items.get(page*4).name);
            Name2.setText(items.get(page*4+1).name);
            Name3.setText(items.get(page*4+2).name);
            Name4.setText(items.get(page*4+3).name);

            Price2.setVisible(true);
            Price3.setVisible(true);
            Price4.setVisible(true);
            Price1.setText(String.valueOf(items.get(page*4).price));
            Price2.setText(String.valueOf(items.get(page*4+1).price));
            Price3.setText(String.valueOf(items.get(page*4+2).price));
            Price4.setText(String.valueOf(items.get(page*4+3).price));

            Type2.setVisible(true);
            Type3.setVisible(true);
            Type4.setVisible(true);
            Type1.setText(String.valueOf(items.get(page*4).getType()));
            Type2.setText(String.valueOf(items.get(page*4+1).getType()));
            Type3.setText(String.valueOf(items.get(page*4+2).getType()));
            Type4.setText(String.valueOf(items.get(page*4+3).getType()));

            AddBtn2.setVisible(true);
            AddBtn3.setVisible(true);
            AddBtn4.setVisible(true);

            Qty2.setVisible(true);
            Qty3.setVisible(true);
            Qty4.setVisible(true);

            QtyLabel2.setVisible(true);
            QtyLabel3.setVisible(true);
            QtyLabel4.setVisible(true);
        }
    }

    @FXML
    void BackBtnClicked(MouseEvent event) {
        ArrayList<InventoryItem> items = getAllItems();

        int size = items.size();

        if(page==0)
        {
            page = (int)ceil(size/4.0)-1;
        }
        else
        {
            page--;
        }

        view1.setImage(new Image(items.get(page*4).img));
        Name1.setText(items.get(page*4).name);
        Price1.setText(String.valueOf(items.get(page*4).price));
        Type1.setText(String.valueOf(items.get(page*4).getType()));

        if(page*4+1 >= size)
        {
            view2.setVisible(false);
            view3.setVisible(false);
            view4.setVisible(false);

            Name2.setVisible(false);
            Name3.setVisible(false);
            Name4.setVisible(false);

            Price2.setVisible(false);
            Price3.setVisible(false);
            Price4.setVisible(false);

            Type2.setVisible(false);
            Type3.setVisible(false);
            Type4.setVisible(false);

            AddBtn2.setVisible(false);
            AddBtn3.setVisible(false);
            AddBtn4.setVisible(false);

            Qty2.setVisible(false);
            Qty3.setVisible(false);
            Qty4.setVisible(false);

            QtyLabel2.setVisible(false);
            QtyLabel3.setVisible(false);
            QtyLabel4.setVisible(false);
        }

        else if(page*4+2 >= size)
        {
            view2.setVisible(true);
            view2.setImage(new Image(items.get(page*4+1).img));
            view3.setVisible(false);
            view4.setVisible(false);

            Name2.setVisible(true);
            Name2.setText(items.get(page*4+1).name);
            Name3.setVisible(false);
            Name4.setVisible(false);

            Price2.setVisible(true);
            Price2.setText(String.valueOf(items.get(page*4+1).price));
            Price3.setVisible(false);
            Price4.setVisible(false);

            Type2.setVisible(true);
            Type2.setText(String.valueOf(items.get(page*4+1).getType()));
            Type3.setVisible(false);
            Type4.setVisible(false);

            AddBtn2.setVisible(true);
            AddBtn3.setVisible(false);
            AddBtn4.setVisible(false);

            Qty2.setVisible(true);
            Qty3.setVisible(false);
            Qty4.setVisible(false);

            QtyLabel2.setVisible(true);
            QtyLabel3.setVisible(false);
            QtyLabel4.setVisible(false);
        }

        else if(page*4+3 >= size)
        {
            view2.setVisible(true);
            view3.setVisible(true);
            view2.setImage(new Image(items.get(page*4+1).img));
            view3.setImage(new Image(items.get(page*4+2).img));
            view4.setVisible(false);

            Name2.setVisible(true);
            Name3.setVisible(true);
            Name2.setText(items.get(page*4+1).name);
            Name3.setText(items.get(page*4+2).name);
            Name4.setVisible(false);

            Price2.setVisible(true);
            Price3.setVisible(true);
            Price2.setText(String.valueOf(items.get(page*4+1).price));
            Price3.setText(String.valueOf(items.get(page*4+2).price));
            Price4.setVisible(false);

            Type2.setVisible(true);
            Type3.setVisible(true);
            Type2.setText(String.valueOf(items.get(page*4+1).getType()));
            Type3.setText(String.valueOf(items.get(page*4+2).getType()));
            Type4.setVisible(false);

            AddBtn2.setVisible(true);
            AddBtn3.setVisible(true);
            AddBtn4.setVisible(false);

            Qty2.setVisible(true);
            Qty3.setVisible(true);
            Qty4.setVisible(false);

            QtyLabel2.setVisible(true);
            QtyLabel3.setVisible(true);
            QtyLabel4.setVisible(false);
        }
        else
        {
            view2.setVisible(true);
            view3.setVisible(true);
            view4.setVisible(true);
            view1.setImage(new Image(items.get(page*4).img));
            view2.setImage(new Image(items.get(page*4+1).img));
            view3.setImage(new Image(items.get(page*4+2).img));
            view4.setImage(new Image(items.get(page*4+3).img));

            Name2.setVisible(true);
            Name3.setVisible(true);
            Name4.setVisible(true);
            Name1.setText(items.get(page*4).name);
            Name2.setText(items.get(page*4+1).name);
            Name3.setText(items.get(page*4+2).name);
            Name4.setText(items.get(page*4+3).name);

            Price2.setVisible(true);
            Price3.setVisible(true);
            Price4.setVisible(true);
            Price1.setText(String.valueOf(items.get(page*4).price));
            Price2.setText(String.valueOf(items.get(page*4+1).price));
            Price3.setText(String.valueOf(items.get(page*4+2).price));
            Price4.setText(String.valueOf(items.get(page*4+3).price));

            Type2.setVisible(true);
            Type3.setVisible(true);
            Type4.setVisible(true);
            Type1.setText(String.valueOf(items.get(page*4).getType()));
            Type2.setText(String.valueOf(items.get(page*4+1).getType()));
            Type3.setText(String.valueOf(items.get(page*4+2).getType()));
            Type4.setText(String.valueOf(items.get(page*4+3).getType()));

            AddBtn2.setVisible(true);
            AddBtn3.setVisible(true);
            AddBtn4.setVisible(true);

            Qty2.setVisible(true);
            Qty3.setVisible(true);
            Qty4.setVisible(true);

            QtyLabel2.setVisible(true);
            QtyLabel3.setVisible(true);
            QtyLabel4.setVisible(true);
        }
    }

    int qt1, qt2, qt3, qt4;
    ArrayList<OrderItem> order = new ArrayList<>();
    @FXML
    void AddBtn1Clicked(ActionEvent event) throws Exception {
        qt1 = Integer.parseInt(Qty1.getText());

        ArrayList<InventoryItem> items = getAllItems();

        if(qt1>items.get(page*4).getStock()) throw new Exception("Exceeding Stock Limit!");
        else
        {
            order.add(new OrderItem(qt1, items.get(page*4).price, items.get(page*4).img, items.get(page*4).ID ,items.get(page*4).name));
        }

    }

    @FXML
    void AddBtn2lClicked(ActionEvent event) throws Exception {
        qt2 = Integer.parseInt(Qty2.getText());
        ArrayList<InventoryItem> items = getAllItems();

        if(qt2>items.get(page*4+1).getStock()) throw new Exception("Exceeding Stock Limit!");
        else
        {
            order.add(new OrderItem(qt2, items.get(page*4+1).price, items.get(page*4+1).img, items.get(page*4+1).ID ,items.get(page*4+1).name));
        }

    }

    @FXML
    void AddBtn3Clicked(ActionEvent event) throws Exception {
        qt3 = Integer.parseInt(Qty3.getText());
        ArrayList<InventoryItem> items = getAllItems();

        if(qt3>items.get(page*4+2).getStock()) throw new Exception("Exceeding Stock Limit!");
        else
        {
            order.add(new OrderItem(qt3, items.get(page*4+2).price, items.get(page*4+2).img, items.get(page*4+2).ID ,items.get(page*4+2).name));
        }

    }

    @FXML
    void AddBtn4Clicked(ActionEvent event) throws Exception {
        qt4 = Integer.parseInt(Qty4.getText());
        ArrayList<InventoryItem> items = getAllItems();

        if(qt4>items.get(page*4+3).getStock()) throw new Exception("Exceeding Stock Limit!");
        else
        {
            order.add(new OrderItem(qt4, items.get(page*4+3).price, items.get(page*4+3).img, items.get(page*4+3).ID ,items.get(page*4+3).name));
        }

    }

    @FXML
    void CheckOutBtnClicked(ActionEvent event) throws IOException {
        Node source = (Node)  event.getSource();
        Stage stage  = (Stage) source.getScene().getWindow();
        stage.close();
        try {
            Order cartOrder = new Order(OrderStatus.PROCESSING, new Date(), order);


            ObjectId id = OrderService.createOrder(cartOrder);
            OrderId = id;

            FXMLLoader fxmlLoader = new FXMLLoader(PharmacyApplication.class.getResource("TotalCost.fxml"));
            Scene scene = new Scene(fxmlLoader.load());

            CostLabelText.set("EGP " + String.valueOf(cartOrder.getTotalCost()));
            stage.setTitle("Receipt");
            stage.setScene(scene);
            stage.show();
        } catch(Exception e) {
            System.out.println(e.getMessage());
        }
    }

}
