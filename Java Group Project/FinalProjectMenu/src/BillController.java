import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

/**

 The following program sets up a GUI application that presents the bill for a
 restaurant order. The graphical user interface
 features a table view that showcases all the items that were
 ordered and their prices, along with the subtotal and the grand total for the bill.
 Author: Mustafa Asghar
 Date: 2023-04-03
 */
public class BillController {

    @FXML
    private TableView<BillItem> Table;

    @FXML
    private TableColumn<BillItem, String> Items;

    @FXML
    private TableColumn<BillItem, Double> Price;

    @FXML
    private TextArea Subtotal;

    @FXML
    private TextArea Total;

    @FXML
    private GridPane gridPane;

    @FXML
    private Button Payment;

    //A method that will clear the file after the pay button is clicked
    @FXML
    void Payment(ActionEvent event) {
        try {
            FileWriter writer = new FileWriter("order.txt");
            writer.write("");
            writer.close();

            // Close the window
            Node source = (Node) event.getSource();
            Stage stage = (Stage) source.getScene().getWindow();
            stage.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //The method will take the user back to the menu once the back button is clicked
    @FXML
    void backButton2(ActionEvent event) {
        MenuApplication menu = new MenuApplication();
        try {
            menu.start(new Stage());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @FXML
    void initialize() {
        try {
            // Read the order from the order file
            List<BillItem> items = readCSV("order.txt");
            // Add the items to the table
            Table.getItems().addAll(items);

            // Check if any of the items have a discount keyword in their name
            List<String> keywords = Arrays.asList("New Years' Rolls", "New Years' Soup", "New Years' Noodles", "Seniors 65+ Eat 50% Off");
            boolean isDiscounted = items.stream()
                    .anyMatch(item -> keywords.contains(item.getName()));

            // Calculate the subtotal based on the price of the items and the discount factor
            double discountFactor = isDiscounted ? 0.5 : 1.0;
            double subtotal = items.stream()
                    .mapToDouble(BillItem::getPrice)
                    .sum() * discountFactor;

            // Set the subtotal and total text fields
            String subtotalFormatted = String.format("%.2f", subtotal);
            Subtotal.setText(subtotalFormatted);
            Total.setText(String.format("%.2f", subtotal * 1.15));

        } catch (Exception e) {
            e.printStackTrace();
        }

        // Set the cell value factories for the table columns
        Items.setCellValueFactory(new PropertyValueFactory<>("name"));
        Price.setCellValueFactory(new PropertyValueFactory<>("price"));
    }



    /*this method will get the info from order and add it to the billitem and then check for the following
    if statements*/
    private List<BillItem> readCSV(String filename) throws Exception {
        List<BillItem> items = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String currentLine;
            while ((currentLine = reader.readLine()) != null) {
                String[] row = currentLine.split(",");
                double price = 0;
                if (row[0].equalsIgnoreCase("Yam Tempura Roll")) {
                    price = 8.99;
                } else if (row[0].equalsIgnoreCase("California Roll")) {
                    price = 7.99;
                } else if (row[0].equalsIgnoreCase("Yam Tempura")) {
                    price = 6.99;
                } else if (row[0].equalsIgnoreCase("Steamed Beef Balls")) {
                    price = 5.99;
                } else if (row[0].equalsIgnoreCase("Crab Stick Tempura")) {
                    price = 3.99;
                } else if (row[0].equalsIgnoreCase("Scallop Tempura")) {
                    price = 5.99;
                } else if (row[0].equalsIgnoreCase("Shrimp Tempura")) {
                    price = 6.99;
                } else if (row[0].equalsIgnoreCase("Alaska Roll")) {
                    price = 9.99;
                } else if (row[0].equalsIgnoreCase("Salmon Roll")) {
                    price = 8.99;
                } else if (row[0].equalsIgnoreCase("Crab Roll")) {
                    price = 7.99;
                } else if (row[0].equalsIgnoreCase("Crispy Roll")) {
                    price = 6.99;
                } else if (row[0].equalsIgnoreCase("Shrimp Dumplings")) {
                    price = 4.99;
                } else if (row[0].equalsIgnoreCase("Mango Chicken")) {
                    price = 10.99;
                } else if (row[0].equalsIgnoreCase("Beef Tripe")) {
                    price = 6.99;
                } else if (row[0].equalsIgnoreCase("Pork Dumplings")) {
                    price = 5.99;
                } else if (row[0].equalsIgnoreCase("Cheese Wontons")) {
                    price = 4.99;
                } else if (row[0].equalsIgnoreCase("Salmon Sashimi")) {
                    price = 12.99;
                } else if (row[0].equalsIgnoreCase("Snapper Sashimi")) {
                    price = 10.99;
                } else if (row[0].equalsIgnoreCase("Scallop Sashimi")) {
                    price = 11.99;
                } else if (row[0].equalsIgnoreCase("Tako")) {
                    price = 9.99;
                } else if (row[0].equalsIgnoreCase("White Tuna Sashimi")) {
                    price = 12.99;
                } else if (row[0].equalsIgnoreCase("Sticky Rice in Lotus Leaf")) {
                    price = 3.99;
                } else if (row[0].equalsIgnoreCase("New Years' Rolls")){
                    price *= 0.5;
                } else if (row[0].equalsIgnoreCase("New Years' Soup")){
                    price *= 0.5;
                } else if (row[0].equalsIgnoreCase("New Years' Noodles")) {
                    price *= 0.5;
                } else if (row[0].equalsIgnoreCase("Children 8 and Under Eat Free:")) {
                    price = 0;
                } else if (row[0].equalsIgnoreCase("Seniors 65+ Eat 50% Off:")) {
                    price *= 0.5;
                }
                items.add(new BillItem(row[0], price));
            }
        }
        return items;
    }

    //A nested class containing the constructor as well as getters and setters
    public static class BillItem {
        private String name;
        private double price;

        public BillItem(String name, double price) {
            this.name = name;
            this.price = price;
        }

        public String getName() {
            return name;
        }

        public double getPrice() {
            return price;
        }
    }
}