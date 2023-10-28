/* Author: Sara McKim
 * Date: March 28, 2023
 *
 * Description: The home page for January 1st. It leads into the menu and outputs the users table
 * and allows the user to select the type of meal they wish to have.
 */
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class Home extends Application {

    @Override
    public void start(Stage primaryStage) {
        //Create informative photos to advertise the restaurant
        Image restaurantAd = new Image("januaryfirst.jpg");
        Image dimsum = new Image("dimsum.jpg");
        Image rolls = new Image("rolls.jpg");
        Image sashimi = new Image("sashimi.jpg");
        Image sushi = new Image("sushi.jpg");
        Image tempura = new Image("tempura.jpg");
        Image udon = new Image("udon.jpg");

        //Create an image view
        ImageView ad = new ImageView(restaurantAd);
        ad.setFitWidth(700);
        ad.setFitHeight(200);
        ImageView dimsumImage = new ImageView(dimsum);
        dimsumImage.setFitWidth(350);
        dimsumImage.setFitHeight(300);
        ImageView rollsImage = new ImageView(rolls);
        rollsImage.setFitWidth(350);
        rollsImage.setFitHeight(300);
        ImageView sashimiImage = new ImageView(sashimi);
        sashimiImage.setFitWidth(350);
        sashimiImage.setFitHeight(300);
        ImageView sushiImage = new ImageView(sushi);
        sushiImage.setFitWidth(350);
        sushiImage.setFitHeight(300);

        //Create a button that will lead the user into the menu
        Button menuButton = new Button ("Menu");
        menuButton.setPrefWidth(600);
        menuButton.setPrefHeight(50);

        //Make the menu button open the menu class
        menuButton.setOnAction(e -> {
            MenuApplication menu = new MenuApplication();
            try {
                menu.start(primaryStage);
            } catch (Exception ex) {
                throw new RuntimeException(ex);
            }
        });

        //Create a grid pane to hold the restaurants informative photos.
        GridPane pane = new GridPane();
        pane.setPrefSize(700, 700);
        pane.setAlignment(Pos.CENTER);
        pane.setHgap(10);
        pane.setVgap(10);
        pane.add(ad, 0, 0, 2, 1);
        pane.add(menuButton, 0, 1 );
        pane.add(dimsumImage, 0, 2);
        pane.add(rollsImage, 1, 2);
        pane.add(sashimiImage, 0, 3);
        pane.add(sushiImage, 1, 3);

        //Create the title page
        Group image = new Group();
        image.getChildren().add(pane);

        //Create a stackpane to then center the Home page
        StackPane stackpane = new StackPane(image);
        stackpane.setAlignment(Pos.CENTER);
        stackpane.setBackground(new Background(new BackgroundFill(Color.BLACK, CornerRadii.EMPTY, Insets.EMPTY)));

        //Create a scene with the grid pane and set it on the stage
        Scene scene = new Scene(stackpane, 800, 800);
        scene.setFill(Color.BLACK);
        primaryStage.setTitle("Home");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }

}