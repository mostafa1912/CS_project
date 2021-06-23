package GUI;

import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import java.io.File;



import java.io.File;
import java.io.IOException;

import engine.*;
import javafx.application.Application;

import javafx.geometry.Insets;
import javafx.geometry.NodeOrientation;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleButton;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
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

		Image gamenamelogo = new Image("file:images/gamenamelogo.png");
		ImageView gamenamelogoView = new ImageView(gamenamelogo);
		
		VBox gamenamelogoViewVBox = new VBox();
		gamenamelogoViewVBox.getChildren().add(gamenamelogoView);
		
		gamenamelogoViewVBox.setAlignment(Pos.TOP_CENTER);
		
		
		
		Image deepquote = new Image("file:images/deepquote.png");
		ImageView deepquoteView = new ImageView(deepquote);
		
		VBox deepquoteViewVBox = new VBox();
		deepquoteViewVBox.getChildren().add(deepquoteView);
		deepquoteViewVBox.setAlignment(Pos.BOTTOM_CENTER);
		
		
// Making Image as wallpaper 
// will add start pic and button
		BackgroundImage bg = new BackgroundImage(new Image("file:images/gameHomeScreen.jpg"),
				BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT,
				BackgroundPosition.CENTER, new BackgroundSize(1.0 ,1.0,true,true, false, false) );
		
		startlayout.setBackground(new Background(bg));
		
		
		
		Button startButton = new Button("PLAY");
		startButton.setMaxHeight(50);
		startButton.setMaxWidth(125);
		startButton.setAlignment(Pos.CENTER);
		
		
		
		startButton.setStyle("-fx-font: 25 arial; -fx-base: #b6e7c9;");
		startlayout.getChildren().addAll(gamenamelogoViewVBox ,deepquoteViewVBox,startButton);
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
		next.setTranslateY(-40);
		
		next.setTranslateY(150);;
		
		
		Image enteryournamelogo = new Image("file:images/enteryournamelogo.png");
		ImageView enteryournamelogoView = new ImageView(enteryournamelogo);
		
		HBox enteryournamelogoViewVbox = new HBox();
		enteryournamelogoViewVbox.getChildren().add(enteryournamelogoView);
		enteryournamelogoViewVbox.setAlignment(Pos.TOP_CENTER);
		
		
		
		

		TextField playerone = new TextField();
		playerone.setPromptText("Player Name");
		playerone.setMaxSize(400, 50);
		playerone.setNodeOrientation(NodeOrientation.RIGHT_TO_LEFT);
		playerone.setFocusTraversable(true);
		playerone.setAlignment(Pos.CENTER);
		

		
		StackPane namelayout = new StackPane();
		playerone.setAlignment(Pos.CENTER_RIGHT);
		
		Image nameimage = new Image("file:images/gameHomeScreen.jpg");
		ImageView nameview = new ImageView(nameimage);
		Group nameg = new Group();
		nameg.getChildren().addAll(nameview);
		BackgroundImage bg = new BackgroundImage(new Image("file:images/scene2wallpaper.png"),
				BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT,
				BackgroundPosition.CENTER, new BackgroundSize(1.0 ,1.0,true,true, false, false) );

		
		namelayout.getChildren().addAll(playerone,enteryournamelogoViewVbox,next);
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
			
				AlertBox.display("Please Enter Your Name","You can't proceed without entering a name");
				try {
					scene2(window);
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					AlertBox.display(e1.getMessage());
				}
			} else {
				try {
					scene3(window, playerone.getText());
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					AlertBox.display(e1.getMessage());
				}
			}
			

		});
		
	}
	
	public void scene3(Stage window, String playerName) throws IOException	{
		

		
		
		//game = new Game (playerName,playerCityName);
		//System.out.println(game.getAvailableCities().get(0).getName());
		
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
		
		
		
		

		cairoButton.setOnMouseClicked(e -> { 
			playerCityName = "Cairo";
			try {
				game = new Game (playerName,"Cairo");
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			try {
				worldMapView(window);
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		});
		
		spartaButton.setOnMouseClicked(e -> { 
			playerCityName = "Sparta" ;
			try {
				game = new Game (playerName,"Sparta");
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				AlertBox.display(e1.getMessage());
			}
			try {
				worldMapView(window);
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				AlertBox.display(e1.getMessage());
			}
		});
		romeButton.setOnMouseClicked(e -> { 
			
			playerCityName = "Rome";
					
			try {
				game = new Game (playerName,"Rome");
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				AlertBox.display(e1.getMessage());
			}
			try {
				worldMapView(window);
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				AlertBox.display(e1.getMessage());
			}
		});
		
		
		
		
		
	}
	
	
	public void worldMapView(Stage window) throws IOException	{
		System.out.println(game.getPlayer().getName() + " : " +playerCityName );
		Label label = new Label("player name: " + game.getPlayer().getName()  + "\n Player City: " + playerCityName + "\n Turn Count: " +
				game.getCurrentTurnCount() + "\n Food: " + game.getPlayer().getFood() + "\n Gold: "+ game.getPlayer().getTreasury());
		
		BackgroundImage bg = new BackgroundImage(new Image("file:images/calmwallpaper.jpg"),
				BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT,
				BackgroundPosition.CENTER, new BackgroundSize(1.0 ,1.0,true,true, false, false) );

		
		
		Label label1 = new Label( );
		label1.setLayoutX(200);

		BorderPane pageLayout = new BorderPane();
		HBox hBox = new HBox();
		hBox.getChildren().addAll(label);
		hBox.setAlignment(Pos.TOP_LEFT);
		pageLayout.setTop(hBox);

		//city vboxes
		HBox citiesHBox = new HBox(50);
		
		ToggleButton cairoButton = new ToggleButton ();
		ToggleButton spartaButton = new ToggleButton ();
		ToggleButton romeButton = new ToggleButton ();
		
		
		Image cairoImage = new Image("file:images/cairotextlogo.png");
		ImageView cairoImageView = new ImageView(cairoImage);
		cairoImageView.setFitHeight(200);;
		cairoImageView.setFitWidth(200);
		cairoButton.setGraphic(cairoImageView);
		Image spartaImage = new Image("file:images/spartatextlogo.png");
		ImageView spartaImageView = new ImageView(spartaImage);
		spartaImageView.setFitHeight(200);;
		spartaImageView.setFitWidth(200);
		spartaButton.setGraphic(spartaImageView);
		
		Image romeImage = new Image("file:images/rometextlogo.png");
		ImageView romeImageView = new ImageView(romeImage);
		romeImageView.setFitHeight(200);;
		romeImageView.setFitWidth(200);
		romeButton.setGraphic(romeImageView);
		romeButton.setGraphic(romeImageView);
		
		
		citiesHBox.getChildren().addAll(cairoButton,spartaButton,romeButton);
		citiesHBox.setAlignment(Pos.CENTER);
		
		pageLayout.setCenter(citiesHBox);
		pageLayout.setBackground(new Background(bg));
		Scene worldMapView = new Scene(pageLayout , 1275, 680);

		
		window.setScene(worldMapView);


	}
	public void cityView(Stage window) throws IOException	{
		System.out.println(game.getPlayer().getName() + " : " +playerCityName );
		Label label = new Label("player name: " + game.getPlayer().getName()  + "\n Player City: " + playerCityName + "\n Turn Count: " +
				game.getCurrentTurnCount() + "\n Food: " + game.getPlayer().getFood() + "\n Gold: "+ game.getPlayer().getTreasury());
		Label label1 = new Label( );
		label1.setLayoutX(200);

		BorderPane pageLayout = new BorderPane();
		HBox hBox = new HBox();
		hBox.getChildren().addAll(label);
		hBox.setAlignment(Pos.TOP_LEFT);
		pageLayout.setTop(hBox);

		Scene cityView = new Scene(pageLayout , 1275, 680);

		window.setScene(cityView);


	}
	public void battleView(Stage window) throws IOException	{
		System.out.println(game.getPlayer().getName() + " : " +playerCityName );
		Label label = new Label("player name: " + game.getPlayer().getName()  + "\n Player City: " + playerCityName + "\n Turn Count: " +
				game.getCurrentTurnCount() + "\n Food: " + game.getPlayer().getFood() + "\n Gold: "+ game.getPlayer().getTreasury());
		Label label1 = new Label( );
		label1.setLayoutX(200);

		BorderPane pageLayout = new BorderPane();
		HBox hBox = new HBox();
		hBox.getChildren().addAll(label);
		hBox.setAlignment(Pos.TOP_LEFT);
		pageLayout.setTop(hBox);

		Scene battleView = new Scene(pageLayout , 1275, 680);

		window.setScene(battleView);


	}
	
	
	
	
	
	

}
