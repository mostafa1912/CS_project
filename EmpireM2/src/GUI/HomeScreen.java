package GUI;
import engine.Game;
import engine.Player;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.stage.Stage;


public class HomeScreen extends Application {

    Player player;

    Game game;





    public static void main(String[] args) {
        launch(args);
    }




    public void start(Stage primaryWindow) throws Exception {






        Stage window = new Stage();
        primaryWindow = window;
       window.setTitle("The conquerer");





		/*

        Button startGameButton = new Button ();

        // Setting Image for button button
        Image img = new Image(new File("images/startGameButton.png").toURI().toString());
	    ImageView view = new ImageView(img);
	    view.setFitHeight(80);
	    view.setPreserveRatio(true);
	    startGameButton.setGraphic(view);




       // Setting a scene and it's layout
        VBox homeScreneLayout = new VBox(20);
        homeScreneLayout.getChildren().addAll(startGameButton);
		Scene homeScene = new Scene(homeScreneLayout,500,500);


	// Setting background image for the scene

		BackgroundImage myBI= new BackgroundImage(new Image(new File("images/gameHomeScreen.png").toURI().toString()),
		        BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER,
		          new BackgroundSize(1275,680,false,false,false,true));

		homeScreneLayout.setBackground(new Background(myBI));
		*/

        scene1(window);

        primaryWindow.show();
    }



    public void scene1(Stage window) {





        StackPane startlayout = new StackPane();// Start pane



// Making Image as wallpaper
        // will add start pic and button
        Image startImage = new Image("file:images/gameHomeScreen.png");
        ImageView startview = new ImageView(startImage);
        // Fitting Image to scene dimensions
        startview.setFitHeight(680);
        startview.setFitWidth(1275);

        Group start = new Group();
        start.getChildren().addAll(startview);
        Button startButton = new Button("PLAY");

        startButton.setMaxHeight(50);
        startButton.setMaxWidth(125);

        startButton.setStyle("-fx-font: 25 arial; -fx-base: #b6e7c9;");
        startlayout.getChildren().addAll(start, startButton);
        // Default scene dimentions
        Scene startScene = new Scene(startlayout, 1275, 680);
        window.setScene(startScene);


        startButton.setOnMouseClicked(e -> scene2(window));

    }


    public void scene2(Stage window) {

        Button next = new Button("Next");
        next.setAlignment(Pos.BOTTOM_CENTER);
        next.setMaxHeight(50);
        next.setMaxWidth(140);
        next.setStyle("-fx-font: 25 arial; -fx-base: #b6e7c9;");

        Button cairoButton = new Button ("Cairo");
        Button spartaButton = new Button ("Sparta");
        Button romeButton = new Button ("Rome");

        TextField playerone = new TextField();
        playerone.setPromptText("Player Name");


        playerone.setMaxSize(200, 80);


        GridPane namelayout = new GridPane();
        playerone.setAlignment(Pos.CENTER_RIGHT);

        Image nameimage = new Image("file:images/gameHomeScreen.png");
        ImageView nameview = new ImageView(nameimage);
        Group nameg = new Group();
        nameg.getChildren().addAll(nameview);
        BackgroundImage bg = new BackgroundImage(new Image("file:images/gameHomeScreen.png"),
                BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT,
                BackgroundPosition.CENTER, new BackgroundSize(1275, 680, false,
                false, false, true));

        namelayout.setPadding(new Insets(50, 50, 50, 50));
        namelayout.setHgap(20);
        namelayout.setVgap(20);
        namelayout.add(playerone, 25, 12);
        namelayout.add(next, 25, 20);

        Scene writename = new Scene(namelayout, 1275, 680);
        namelayout.setBackground(new Background(bg));
        window.setScene(writename);
        //Button tool = new Button("Instructions") ;
        //tool.setMaxHeight(50);
        //tool.setMaxWidth(140);
        //tool.setStyle("-fx-font: 20 arial; -fx-base: #b6e7c9;");


        namelayout.add(cairoButton, 25, 21);
        namelayout.add(spartaButton, 25, 21);
        namelayout.add(romeButton, 25, 21);






        next.setOnMouseClicked(e -> {
            if (playerone.getText().isEmpty()) {
                //Alertnames.display();

            } else {
                //scene3(window, playerone.getText());
            }


        });


    }








}