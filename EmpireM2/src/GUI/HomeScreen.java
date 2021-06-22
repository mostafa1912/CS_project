package GUI;





import java.io.File;
import java.io.IOException;

import com.sun.prism.paint.ImagePattern;

import engine.*;
import javafx.application.Application;

import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleButton;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;


public class HomeScreen extends Application {
	
	
	
	Game game ; 
	
	String playerCityName;
	
	
	
	
	public static void main(String[] args) {
		launch(args);
	}


	
	
	public void start(Stage primaryWindow) throws Exception {
	
		
		
		
	
		
		Stage window = new Stage();
		primaryWindow = window;
		window.setTitle("The Conqueror");
		
		game = null;

		
		
		
		
		
		
		
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
		Image startImage = new Image("file:images/gameHomeScreen.jpg");
		ImageView startview = new ImageView(startImage);
		// Fitting Image to scene dimentions 
		startview.setFitHeight(680);
		startview.setFitWidth(1275);
		Group startg = new Group();
		startg.getChildren().addAll(startview);
		
		
		
		Button startButton = new Button("PLAY");
		startButton.setMaxHeight(50);
		startButton.setMaxWidth(125);
		
		
		
		startButton.setStyle("-fx-font: 25 arial; -fx-base: #b6e7c9;");
		startlayout.getChildren().addAll(startg, startButton);
		// Default scene dimentions 
		Scene startScene = new Scene(startlayout, 1275, 680);
		window.setScene(startScene);
		
		
		startButton.setOnMouseClicked(e -> {
			try {
				scene2(window);
			} catch (IOException e1) {
				
				e1.printStackTrace();
			}
		});

	}
	
	
	public void scene2(Stage window) throws IOException {

		Button next = new Button("Next");
		next.setAlignment(Pos.BOTTOM_CENTER);
		next.setMaxHeight(50);
		next.setMaxWidth(140);
		next.setStyle("-fx-font: 25 arial; -fx-base: #b6e7c9;");
		
		
		
		
		
		
		

		TextField playerone = new TextField();
		playerone.setPromptText("Player Name");
		playerone.setMaxSize(200, 80);
		
		
		

		
		GridPane namelayout = new GridPane();
		playerone.setAlignment(Pos.CENTER_RIGHT);
		
		Image nameimage = new Image("file:images/gameHomeScreen.jpg");
		ImageView nameview = new ImageView(nameimage);
		Group nameg = new Group();
		nameg.getChildren().addAll(nameview);
		BackgroundImage bg = new BackgroundImage(new Image("file:images/gameHomeScreen.jpg"),
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
		
		
		//namelayout.getChildren().addAll(cairoButton,romeButton,spartaButton);
		
		
		
		
		
		
		
		
		next.setOnMouseClicked(e -> {
			if (playerone.getText().isEmpty()) {
				//Alertnames.display();

			} else {
				try {
					scene3(window, playerone.getText());
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
			

		});
		
	}
	
	public void scene3(Stage window, String playerName) throws IOException	{
		//game = new Game (playerName,playerCityName);
		System.out.println(playerName);
		
		Image startImage = new Image("file:images/worldmap.jpg");
		ImageView startview = new ImageView(startImage);
		// Fitting Image to scene dimentions 
		startview.setFitHeight(680);
		startview.setFitWidth(1275);
		Group startg = new Group();
		startg.getChildren().addAll(startview);
		
		ToggleButton cairoButton = new ToggleButton ();
		ToggleButton spartaButton = new ToggleButton ();
		ToggleButton romeButton = new ToggleButton ();
		
		
		Image cairoImage = new Image("file:images/cairologo.jpg");
		ImageView cairoImageView = new ImageView(cairoImage);
		cairoImageView.setFitHeight(200);;
		cairoImageView.setFitWidth(200);
		cairoButton.setGraphic(cairoImageView);
		Image spartaImage = new Image("file:images/spartalogo.png");
		ImageView spartaImageView = new ImageView(spartaImage);
		spartaImageView.setFitHeight(200);;
		spartaImageView.setFitWidth(200);
		spartaButton.setGraphic(spartaImageView);
		
		Image romeImage = new Image("file:images/romelogo.png");
		ImageView romeImageView = new ImageView(romeImage);
		romeImageView.setFitHeight(200);;
		romeImageView.setFitWidth(200);
		romeButton.setGraphic(romeImageView);
		romeButton.setGraphic(romeImageView);
		//cairoButton.setPadding(new Insets(50));
		//spartaButton.setPadding(new Insets(50));
		//romeButton.setPadding(new Insets(50));
		
		playerCityName="";
		if (cairoButton.isPressed()){ 
			this.playerCityName = "Cairo";
		}
		
		if (spartaButton.isPressed()){ 
			this.playerCityName = "Sparta";
		}
		
		
		if (romeButton.isPressed()){ 
			this.playerCityName = "Rome";
			
		}
			
		HBox buttonsHBox = new HBox();
		buttonsHBox.getChildren().add(cairoButton);
		buttonsHBox.getChildren().add(spartaButton);
		buttonsHBox.getChildren().add(romeButton);
		
		buttonsHBox.setAlignment(Pos.CENTER);	
		
		
		
		
		
		Image pickYourCity = new Image("file:images/pickyourcitylogo.png");
		ImageView pickYourCityView = new ImageView(pickYourCity);
		VBox chooseYourCityVbox= new VBox();
		chooseYourCityVbox.getChildren().add(pickYourCityView);
		chooseYourCityVbox.setAlignment(Pos.BASELINE_CENTER);
		
		
		
		StackPane stackPane = new StackPane();
		stackPane.getChildren().addAll(startview,chooseYourCityVbox ,buttonsHBox);
		Scene worldmap = new Scene(stackPane, 1275, 680);
		window.setScene(worldmap);
		
		
	}
	
	
	
	
	
	

}
