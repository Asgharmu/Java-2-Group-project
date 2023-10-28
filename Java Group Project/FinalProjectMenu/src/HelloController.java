import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.SQLOutput;

/**

 The code defines a JavaFX controller class called "HelloController".
 This controller is responsible for managing the GUI components of
 a menu application. The GUI contains buttons, images, and labels
 that display various types of food items.
 Author: Sara McKim
 Date: 2023-04-03
 */
public class HelloController {

    @FXML
    protected Button alaskaroll;

    @FXML
    protected ImageView alaskarollimage;

    @FXML
    protected AnchorPane anchorpane;

    @FXML
    protected Button back;

    @FXML
    protected Rectangle background;

    @FXML
    protected Button beeftripe;

    @FXML
    protected ImageView beeftripeimage;

    @FXML
    protected Button bill;

    @FXML
    protected Button californiaroll;

    @FXML
    protected ImageView californiarollimage;

    @FXML
    protected Button cheesewontons;

    @FXML
    protected ImageView cheesewontonsimage;

    @FXML
    protected Button crab;

    @FXML
    protected Button crabroll;

    @FXML
    protected ImageView crabrollimage;

    @FXML
    protected ImageView crabsashimiimage;

    @FXML
    protected Button crabsticktempura;

    @FXML
    protected ImageView crabsticktempuraimage;

    @FXML
    protected Button crispyroll;

    @FXML
    protected ImageView crispyrollimage;

    @FXML
    protected ScrollPane dimsum;

    @FXML
    protected Button mangochicken;

    @FXML
    protected ImageView mangochickenimage;

    @FXML
    protected Label menulabel;

    @FXML
    protected Button porkdumplings;

    @FXML
    protected ImageView porkdumplingsimage;

    @FXML
    protected Button promotional;

    @FXML
    protected ScrollPane rolls;

    @FXML
    protected Button salmon;

    @FXML
    protected Button salmonroll;

    @FXML
    protected ImageView salmonrollimage;

    @FXML
    protected ImageView salmonsashimi;

    @FXML
    protected ScrollPane sashimi;

    @FXML
    protected Button scallop;

    @FXML
    protected ImageView scallopsashimiimage;

    @FXML
    protected Button scalloptempura;

    @FXML
    protected ImageView scalloptempuraimage;

    @FXML
    protected ImageView shrimpdumplingimage;

    @FXML
    protected Button shrimpdumplings;

    @FXML
    protected Button shrimptempura;

    @FXML
    protected ImageView shrimptempuraimage;

    @FXML
    protected Button snapper;

    @FXML
    protected ImageView snappersashimiimage;

    @FXML
    protected Button steamedbeefballs;

    @FXML
    protected ImageView steamedbeefballsimage;

    @FXML
    protected Button stickyriceinlotusleaf;

    @FXML
    protected ImageView stickyriceinlotusleafimage;

    @FXML
    protected Button tako;

    @FXML
    protected ImageView takosashimiimage;

    @FXML
    protected ScrollPane tempura;

    @FXML
    protected Button whitetuna;

    @FXML
    protected ImageView whitetunasashimiimage;

    @FXML
    protected ImageView yamtempuraimage;

    @FXML
    protected Button yamtempuraroll;

    @FXML
    protected Button yamtempuratempura;

    @FXML
    protected ImageView yamtempuratempuraimage;

    @FXML
    private Label welcomeText;

    @FXML
    protected void SeeBillButtonClick() {
        welcomeText.setText("Children 12 and Under Eat Free In All You Can Eat!");
    }
    //This method is used for when the user clicks promotions it directs user to the promotion GUI
    @FXML
    void promotionalButton(ActionEvent event) {
        Promotion promotion = new Promotion();
        try {
            promotion.start(new Stage());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    //Once the user hit the back button it will invoke the following method to redirect the user to menu
    @FXML
    void backButton(ActionEvent event) {
        Home home = new Home();
        try {
            home.start(new Stage());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    //This method is used for when the user clicks bill it directs user to the bill GUI
    @FXML
    void billButton(ActionEvent event) {
        Bill bill = new Bill();
        try {
            bill.start(new Stage());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    /*Following this method and onwards are the methods that will add data to the order.txt file
    * That will be used for putting the chosen items to the bill class*/
    @FXML
    public void eighteenthButton(ActionEvent event) {
        String order = "Salmon Sashimi";
        try {
            FileWriter writer = new FileWriter("order.txt", true);
            writer.write(order + "\n");
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    public void eighthbutton() {
        String order = "Yam Tempura";
        try {
            FileWriter writer = new FileWriter("order.txt", true);
            writer.write(order + "\n");
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    void elventhButton(ActionEvent event) {
        String order = "Shrimp Dumplings";
        try {
            FileWriter writer = new FileWriter("order.txt", true);
            writer.write(order + "\n");
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    void fifteenthButton(ActionEvent event) {
        String order = "Pork Dumplings";
        try {
            FileWriter writer = new FileWriter("order.txt", true);
            writer.write(order + "\n");
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    void fifthButton(ActionEvent event) {
        String order = "Crab Roll";
        try {
            FileWriter writer = new FileWriter("order.txt", true);
            writer.write(order + "\n");
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    void firstButton(ActionEvent event) {
        String order = "Yam Tempura Roll";
        try {
            FileWriter writer = new FileWriter("order.txt", true);
            writer.write(order + "\n");
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    void fourteenthButton(ActionEvent event) {
        String order = "Beef Tripe";
        try {
            FileWriter writer = new FileWriter("order.txt", true);
            writer.write(order + "\n");
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    void fourthButton(ActionEvent event) {
        String order = "Salmon Roll";
        try {
            FileWriter writer = new FileWriter("order.txt", true);
            writer.write(order + "\n");
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    void nineteenthButton(ActionEvent event) {
        String order = "Snapper Sashimi";
        try {
            FileWriter writer = new FileWriter("order.txt", true);
            writer.write(order + "\n");
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    void ninth(ActionEvent event) {
        String order = "Crab Stick Tempura";
        try {
            FileWriter writer = new FileWriter("order.txt", true);
            writer.write(order + "\n");
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    void secondButton(ActionEvent event) {
        String order = "California Roll";
        try {
            FileWriter writer = new FileWriter("order.txt", true);
            writer.write(order + "\n");
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    void seventeenthButton(ActionEvent event) {
        String order = "Sticky Rice in Lotus Leaf";
        try {
            FileWriter writer = new FileWriter("order.txt", true);
            writer.write(order + "\n");
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    void seventhButton(ActionEvent event) {
        String order = "Shrimp Tempura";
        try {
            FileWriter writer = new FileWriter("order.txt", true);
            writer.write(order + "\n");
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    void sixteenthButton(ActionEvent event) {
        String order = "Cheese Wontons";
        try {
            FileWriter writer = new FileWriter("order.txt", true);
            writer.write(order + "\n");
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    void sixthButton(ActionEvent event) {
        String order = "Crispy Roll";
        try {
            FileWriter writer = new FileWriter("order.txt", true);
            writer.write(order + "\n");
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    void tenthButton(ActionEvent event) {
        String order = "Scallop Tempura";
        try {
            FileWriter writer = new FileWriter("order.txt", true);
            writer.write(order + "\n");
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    void thirdButton(ActionEvent event) {
        String order = "Alaska Roll";
        try {
            FileWriter writer = new FileWriter("order.txt", true);
            writer.write(order + "\n");
            writer.close();
        } catch (IOException e){
            e.printStackTrace();
        }
    }

    @FXML
    void thirteenthButton(ActionEvent event) {
        String order = "Steamed Beef Balls";
        try {
            FileWriter writer = new FileWriter("order.txt", true);
            writer.write(order + "\n");
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    void twelfthButton(ActionEvent event) {
        String order = "Mango Chicken";
        try {
            FileWriter writer = new FileWriter("order.txt", true);
            writer.write(order + "\n");
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    void twentiethButton(ActionEvent event) {
        String order = "Scallop Sashimi";
        try {
            FileWriter writer = new FileWriter("order.txt", true);
            writer.write(order + "\n");
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    void twentySecondButton(ActionEvent event) {
        String order = "Crab Sashimi";
        try {
            FileWriter writer = new FileWriter("order.txt", true);
            writer.write(order + "\n");
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    void twentyfirstButton(ActionEvent event) {
        String order = "Tako";
        try {
            FileWriter writer = new FileWriter("order.txt", true);
            writer.write(order + "\n");
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    void twentythirdButton(ActionEvent event) {
        String order = "White Tuna Sashimi";
        try {
            FileWriter writer = new FileWriter("order.txt", true);
            writer.write(order + "\n");
            writer.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
