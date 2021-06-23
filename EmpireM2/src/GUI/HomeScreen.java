package GUI;

import java.io.File;
import java.io.IOException;
import engine.*;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.NodeOrientation;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
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
		
		 String uriString = new File("music/warmusic.wav").toURI().toString();
		    MediaPlayer player = new MediaPlayer( new Media(uriString));
		    player.play();
		launch(args);
	}

	public static Background Createbackground1(String imageName ){
		String path= "file:images/" + imageName;
		BackgroundImage bg = new BackgroundImage(new Image(path),
				BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT,
				BackgroundPosition.CENTER, new BackgroundSize(1.0 ,1.0,true,true, false, false) );
		return new Background(bg);
	}


	public void start(Stage primaryWindow) throws Exception {

		Stage window = new Stage();
		primaryWindow = window;
		window.setTitle("The Conqueror");

		game = null;



		scene1(window);

		primaryWindow.show();
	}



	public void scene1(Stage window) {

		StackPane startLayout = new StackPane();// Start pane
		
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

		//creating a background image object
		BackgroundImage bg = new BackgroundImage(new Image("file:images/gameHomeScreen.jpg"),
				BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT,
				BackgroundPosition.CENTER, new BackgroundSize(1.0 ,1.0,true,true, false, false) );
		//setting Layout background
		startLayout.setBackground(new Background(bg));

		//creating the start button
		Button startButton = new Button("PLAY");
		//setting button size and font
		startButton.setMaxHeight(50);
		startButton.setMaxWidth(125);
		startButton.setStyle("-fx-font: 25 arial; -fx-base: #b6e7c9;");
		//adding start button to layout
		startLayout.getChildren().addAll(gamenamelogoViewVBox ,deepquoteViewVBox,startButton);
		// setting default scene dimensions
		Scene startScene = new Scene(startLayout, 1275, 680);
		window.setScene(startScene);

		
		//leh try catch?
		startButton.setOnAction(e -> {
			try {
				scene2(window);
			} catch (IOException e1) {

				AlertBox.display(e1.getMessage());
			}
		});

	}


	public void scene2(Stage window) throws IOException {
		//adding the next button and setting its size
		Button next = new Button("Next");
		next.setAlignment(Pos.BOTTOM_CENTER);
		next.setMaxHeight(50);
		next.setMaxWidth(140);
		next.setStyle("-fx-font: 25 arial; -fx-base: #b6e7c9;");
		next.setTranslateY(-40);
		
		next.setTranslateY(150);
		
		
		Image enteryournamelogo = new Image("file:images/enteryournamelogo.png");
		ImageView enteryournamelogoView = new ImageView(enteryournamelogo);
		
		HBox enteryournamelogoViewVbox = new HBox();
		enteryournamelogoViewVbox.getChildren().add(enteryournamelogoView);
		enteryournamelogoViewVbox.setAlignment(Pos.TOP_CENTER);
		
		
		//adding a text field
		TextField playerOne = new TextField();
		playerOne.setPromptText("Player Name     ");
		playerOne.setMaxSize(400, 50);
		playerOne.setNodeOrientation(NodeOrientation.RIGHT_TO_LEFT);
		playerOne.setFocusTraversable(true);
		playerOne.setAlignment(Pos.CENTER);
		//creating layout for the new scene
		StackPane nameLayout = new StackPane();
		playerOne.setAlignment(Pos.CENTER_RIGHT);

		//setting layout background
		BackgroundImage bg = new BackgroundImage(new Image("file:images/scene2wallpaper.png"),
				BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT,
				BackgroundPosition.CENTER, new BackgroundSize(1.0 ,1.0,true,true, false, false) );

		
		

		nameLayout.getChildren().addAll(playerOne,enteryournamelogoViewVbox,next);

		Scene writeName = new Scene(nameLayout, 1275, 680);
		nameLayout.setBackground(new Background(bg));
		window.setScene(writeName);








		next.setOnMouseClicked(e -> {
			if (playerOne.getText().isEmpty()) {
			
				AlertBox.display("Please Enter Your Name","You can't proceed without entering a name");
				try {
					scene2(window);
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					AlertBox.display(e1.getMessage());
				}
			} else {
				try {
					scene3(window, playerOne.getText());
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					AlertBox.display(e1.getMessage());
				}
			}
			

		});

	}

	public void scene3(Stage window, String playerName) throws IOException	{

		Background bg = Createbackground1("worldmap.jpg");



		Button cairoButton = new Button ();
		Button spartaButton = new Button ();
		Button romeButton = new Button ();


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
		stackPane.setBackground(bg);
		stackPane.getChildren().addAll(chooseYourCityVbox ,buttonsHBox);
		Scene worldmap = new Scene(stackPane, 1275, 680);
		window.setScene(worldmap);





		cairoButton.setOnAction(e -> {
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

		spartaButton.setOnAction(e -> {
			playerCityName = "Sparta" ;
			try {
				game = new Game (playerName,"Sparta");
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
		romeButton.setOnAction(e -> {

			playerCityName = "Rome";

			try {
				game = new Game (playerName,"Rome");
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





	}


	public void worldMapView(Stage window) throws IOException	{
		//creating label to show food, gold , and other info
		Label label = new Label("player name: " + game.getPlayer().getName()  + "\n Player City: " + playerCityName + "\n Turn Count: " +
				game.getCurrentTurnCount() + "\n Food: " + game.getPlayer().getFood() + "\n Gold: "+ game.getPlayer().getTreasury());

		
		BackgroundImage bg = new BackgroundImage(new Image("file:images/calmwallpaper.jpg"),
				BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT,
				BackgroundPosition.CENTER, new BackgroundSize(1.0 ,1.0,true,true, false, false) );

		
		
		Label label1 = new Label( );
		label1.setLayoutX(200);
		//creating a borderpane to be the main layout
		BorderPane pageLayout = new BorderPane();
		//creating hbox for label and adding to main layout
		HBox hBox = new HBox();
		hBox.getChildren().addAll(label);
		hBox.setAlignment(Pos.TOP_LEFT);
		pageLayout.setTop(hBox);


		HBox citiesHBox = new HBox(50);

		Button cairoButton = new Button ();
		Button spartaButton = new Button ();
		Button romeButton = new Button ();

		//cities hbox
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

		//adding to main layout
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
