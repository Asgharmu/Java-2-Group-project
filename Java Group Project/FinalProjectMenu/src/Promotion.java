import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.TextFormatter;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.function.UnaryOperator;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.paint.Color;

/**

 this code creates a user interface using JavaFX that lets people view
 different promotions and input information about the participants.
 There's a class called "Promotion" that builds on the "Application" class
 and modifies its "start()" method, which is where the GUI application begins.
 Author: Taha Motiwala
 Date: 2023-04-03
 */
//The following class handles potential errors
class DataHandler {
    private Path SharedFile = Paths.get("order.txt");
    //Either looks for or creates a file called order.txt
    public DataHandler() {
        try {
            if (!Files.exists(SharedFile)) {
                Files.createFile(SharedFile);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    //The following path adds data to the file
    public void handlePromotionClicked(String promotion) {
        String addData = promotion + System.lineSeparator();
        try {
            Files.write(SharedFile, addData.getBytes(), StandardOpenOption.APPEND);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    //adds other data in the file
    public void handleParticipantsSubmitted(String promotion, String participants) {
        // Check if participants is not empty before writing to file
        if (!participants.isEmpty()) {
            String addData = promotion + System.lineSeparator();
            try {
                Files.write(SharedFile, addData.getBytes(), StandardOpenOption.APPEND);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

}

//The following is what will be displayed in to the GUI as well as its functionalities
public class Promotion extends Application {
    private DataHandler dataHandler = new DataHandler();

    private void showParticipantsDialog(String promotion, String participants) {
        Alert alert = new Alert(AlertType.INFORMATION);
        alert.setTitle("Promotion Participants");
        alert.setHeaderText(null);
        alert.setContentText("Number of participants for " + promotion + ": " + participants);
        alert.showAndWait();
    }
    //method creates a new TextField instance that only accepts numeric input using TextFormatter
    private TextField createNumericTextField() {
        TextField textBox = new TextField();
        UnaryOperator<TextFormatter.Change> filter = change -> {
            String newText = change.getControlNewText();
            if (newText.matches("\\d*")) { // Allow only digits (0-9)
                return change;
            } else {
                // Show an alert message if input is not an integer
                Alert alert = new Alert(Alert.AlertType.WARNING);
                alert.setTitle("Input Error");
                alert.setHeaderText(null);
                alert.setContentText("Input can only accept integers");
                alert.showAndWait();
                return null;
            }
        };
        textBox.setTextFormatter(new TextFormatter<>(filter));
        return textBox;
    }
    // The Followng creates Labels, TextFields, Buttons, and Images, and then adds them to different layouts
    // such as HBox and VBox.
    @Override
    public void start(Stage stage) throws Exception {
        // Create labels
        Label promotions = new Label("PROMOTIONS");
        promotions.setStyle("-fx-text-fill: white; -fx-font-family: 'Times New Roman'; -fx-font-size: 40px;");

        Label newYears = new Label("New Year's Special");
        newYears.setStyle("-fx-text-fill: white; -fx-font-family: 'Times New Roman'; -fx-font-size: 20px;");

        Label underEight = new Label("Children 8 and Under Eat Free");
        underEight.setStyle("-fx-text-fill: white; -fx-font-family: 'Times New Roman'; -fx-font-size: 20px;");
        TextField textField1 = createNumericTextField();

        Label seniors = new Label("Seniors 65+ Eat 50% Off");
        seniors.setStyle("-fx-text-fill: white; -fx-font-family: 'Times New Roman'; -fx-font-size: 20px;");
        TextField textField2 = createNumericTextField();

        // Create buttons
        Button button1 = new Button("New Years' Rolls");
        button1.setStyle("-fx-text-fill: black; -fx-font-family: 'Times New Roman'; -fx-font-size: 20px;");

        Button button2 = new Button("New Years' Soup");
        button2.setStyle("-fx-text-fill: black; -fx-font-family: 'Times New Roman'; -fx-font-size: 20px;");

        Button button3 = new Button("New Years' Noodles");
        button3.setStyle("-fx-text-fill: black; -fx-font-family: 'Times New Roman'; -fx-font-size: 20px;");

        Button submitButton = new Button("Submit Participants");
        submitButton.setDisable(true);
        textField1.textProperty().addListener((observable, oldValue, newValue) -> {
            submitButton.setDisable(textField1.getText().isEmpty() && textField2.getText().isEmpty());
        });
        textField2.textProperty().addListener((observable, oldValue, newValue) -> {
            submitButton.setDisable(textField1.getText().isEmpty() && textField2.getText().isEmpty());
        });
        submitButton.setStyle("-fx-text-fill: black; -fx-font-family: 'Times New Roman'; -fx-font-size: 20px;");

        Image New_Years_Rolls = new Image ("springrolls.jpg");
        ImageView button1_image = new ImageView(New_Years_Rolls);
        button1_image.setFitWidth(65);
        button1_image.setFitHeight(65);
        button1.setGraphic(button1_image);

        Image New_Years_Soup = new Image ("soup.jpg");
        ImageView button2_image = new ImageView(New_Years_Soup);
        button2_image.setFitWidth(65);
        button2_image.setFitHeight(65);
        button2.setGraphic(button2_image);

        Image New_Years_Noodles = new Image ("po.jpg");
        ImageView button3_image = new ImageView(New_Years_Noodles);
        button3_image.setFitWidth(65);
        button3_image.setFitHeight(65);
        button3.setGraphic(button3_image);

        // Set submit button action
        submitButton.setOnAction(event -> {
            String textField1Value = textField1.getText();
            String textField2Value = textField2.getText();

            // Check if both text fields are empty
            if (textField1Value.isEmpty() && textField2Value.isEmpty()) {
                Alert alert = new Alert(AlertType.WARNING);
                alert.setTitle("Input Error");
                alert.setHeaderText(null);
                alert.setContentText("Please enter a value in at least one of the text fields");
                alert.showAndWait();
            } else {
                // At least one of the text fields has a value, so proceed with data handling
                if (!textField1Value.isEmpty()) {
                    // Call data handler method with promotion and participants from text field 1
                    dataHandler.handleParticipantsSubmitted("New Year's Special", textField1Value);
                }
                if (!textField2Value.isEmpty()) {
                    // Call data handler method with promotion and participants from text field 2
                    dataHandler.handleParticipantsSubmitted("Seniors 65+ Eat 50% Off", textField2Value);
                }

                // Show confirmation dialog
                showParticipantsDialog("Promotion Participants", textField1Value + ", " + textField2Value);
            }
        });


        // Create HBox layouts for labels and text fields
        HBox hbox3 = new HBox(10);
        hbox3.setAlignment(Pos.CENTER);
        hbox3.getChildren().addAll(underEight, textField1);

        HBox hbox4 = new HBox(17);
        hbox4.setAlignment(Pos.CENTER);
        hbox4.getChildren().addAll(seniors, textField2);

        // Create a VBox layout and add label, HBox layouts, and buttons to it
        VBox vbox = new VBox(50);
        vbox.setAlignment(Pos.CENTER);
        vbox.setBackground(new Background(new BackgroundFill(Color.BLACK, CornerRadii.EMPTY, javafx.geometry.Insets.EMPTY)));
        vbox.getChildren().addAll(promotions, newYears, hbox3, hbox4, button1, button2, button3, submitButton);

        // Create a Scene with the VBox layout
        Scene scene = new Scene(vbox, 800, 800);

        scene.setFill(javafx.scene.paint.Color.BLACK);

        // Set the title of the stage to "Promotion"
        stage.setTitle("Promotion");

        // Add the Scene to the Stage and show
        stage.setScene(scene);
        stage.show();

        button1.setOnAction(event -> dataHandler.handlePromotionClicked("New Years' Rolls"));
        button2.setOnAction(event -> dataHandler.handlePromotionClicked("New Years' Soup"));
        button3.setOnAction(event -> dataHandler.handlePromotionClicked("New Years' Noodles"));
        submitButton.setOnAction(event -> {
            dataHandler.handleParticipantsSubmitted("Children 8 and Under Eat Free", textField1.getText());
            dataHandler.handleParticipantsSubmitted("Seniors 65+ Eat 50% Off", textField2.getText());
        });
    }

    public static void main(String[] args) {
        launch(args);
    }
}