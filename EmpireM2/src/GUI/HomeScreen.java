package GUI;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import buildings.*;
import engine.*;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.NodeOrientation;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.Tooltip;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import javafx.util.Duration;
import units.Army;
import units.Status;
import units.Unit;


public class HomeScreen extends Application {
	Game game ;
	String playerCityName;

	public static void main(String[] args) {
		
		//String uriString = new File("music/warmusic.wav").toURI().toString();
		 //MediaPlayer player = new MediaPlayer( new Media(uriString));
		 // player.play();
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
				AlertBox.display(e1.getMessage());
			}
		});





	}


	public void worldMapView(Stage window) throws IOException	{
		
		//creating a borderpane to be the main layout
				GridPane pageLayout = new GridPane();
				
				

//Label containing Player info and game info 
		
		//creating label to show food, gold , and other info
		Label playerInfoLabel = new Label("Player name: " + game.getPlayer().getName()  + "\n Player City: " + playerCityName + "\n Turn Count: " +
				game.getCurrentTurnCount() + "\n Food: " + game.getPlayer().getFood() + "\n Gold: "+ game.getPlayer().getTreasury());

		
		//creating hbox for label and adding to main layout
		HBox playerInfoHBox = new HBox();
		playerInfoHBox.getChildren().addAll(playerInfoLabel);
		playerInfoHBox.setAlignment(Pos.TOP_LEFT);
		GridPane.setConstraints(playerInfoLabel,0,0);
		
		pageLayout.getChildren().add(playerInfoHBox);
		
	/*	BackgroundImage bg = new BackgroundImage(new Image("file:images/calmwallpaper.jpg"),
			BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT,
				BackgroundPosition.CENTER, new BackgroundSize(1.0 ,1.0,true,true, false, false) );

		*/
		
		
		
//HBox containing cities Buttons 
		
		// Start of Cities HBox
		HBox citiesHBox = new HBox(50);

		Button cairoButton = new Button ();
		Button spartaButton = new Button ();
		Button romeButton = new Button ();
		Tooltip cityButtonsToolTip = new Tooltip("Click To Open City View");
		cityButtonsToolTip.setShowDelay(new Duration (0));
		cityButtonsToolTip.setHideDelay(new Duration (10));
		cairoButton.setTooltip(cityButtonsToolTip);
		spartaButton.setTooltip(cityButtonsToolTip);
		romeButton.setTooltip(cityButtonsToolTip);
		
		
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

		GridPane.setConstraints(citiesHBox,5,5);
		pageLayout.getChildren().add(citiesHBox);
		// End of Cities HBox 
		
		
		
// A representation for the idle armies the player controls in VBox  
		
		VBox idleArmiesControlledByPlayerAndLabelVBox = new VBox();
		
		Label idleArmiesControlledByPlayerTitle = new Label ("Idle Armies Controlled By " + game.getPlayer().getName() );
		idleArmiesControlledByPlayerTitle.setFont(Font.font("Cambria", 26));
		
		
		HBox idleArmiesControlledByPlayer = new HBox();
		
		
		// Loop for creating idle armies and putting them in hbox
		
		for (Army a : game.getPlayer().getControlledArmies()) {
			if (a.getCurrentStatus().equals(Status.IDLE)) {
				Label currentArmyLabel = new Label ("Number of Units: " + a.getUnits().size() + "\n Army Location: "+ a.getCurrentLocation());
				String toolTipString = "";
				
				for (Unit u : a.getUnits()) { 
					toolTipString += ""+u.getType()+ "; Level: "+ u.getLevel() + "; Current Solider Count: "+ u.getCurrentSoldierCount() + "; Max Solider Count: " + u.getMaxSoldierCount();	
					toolTipString+="\n";
				}
				
				
				Tooltip tt = new Tooltip(toolTipString);
				tt.setShowDelay(new Duration (0));
				tt.setHideDelay(new Duration (10));
				
				currentArmyLabel.setTooltip(tt);
				idleArmiesControlledByPlayer.getChildren().add(currentArmyLabel);
			}
		}

		idleArmiesControlledByPlayerAndLabelVBox.getChildren().addAll(idleArmiesControlledByPlayerTitle,idleArmiesControlledByPlayer);
		// Grid pane numbers not set yet 
		GridPane.setConstraints(idleArmiesControlledByPlayerAndLabelVBox,0,0);
		pageLayout.getChildren().addAll(idleArmiesControlledByPlayerAndLabelVBox);
		
		
		
		
//Hbox containg marching armies 
		
		VBox marchingArmiesandLabelVBox = new VBox();
		
		Label marchingArmiesandLabelVBoxTitle = new Label ("Marching Armies");
		marchingArmiesandLabelVBoxTitle.setFont(Font.font("Cambria", 26));
		
		
		HBox marchingArmies = new HBox();
		
		// Loop for adding marching armies in hbox
		
		
				for (Army a : game.getPlayer().getControlledArmies()) {
					if (a.getCurrentStatus().equals(Status.MARCHING)) {
						Label currentArmyLabel = new Label ("Number of Units: " + a.getUnits().size() + "\n Army Location: On Road to " + a.getTarget() +"\n Distance to Target: " + a.getDistancetoTarget());
						String toolTipString = "";
						
						for (Unit u : a.getUnits()) { 
							toolTipString += ""+u.getType()+ "; Level: "+ u.getLevel() + "; Current Solider Count: "+ u.getCurrentSoldierCount() + "; Max Solider Count: " + u.getMaxSoldierCount();	
							toolTipString+="\n";
						}
						
						
						Tooltip tt = new Tooltip(toolTipString);
						tt.setShowDelay(new Duration (0));
						tt.setHideDelay(new Duration (10));
						
						currentArmyLabel.setTooltip(tt);
						marchingArmies.getChildren().add(currentArmyLabel);
					}
				}
		
				marchingArmiesandLabelVBox.getChildren().addAll(marchingArmiesandLabelVBoxTitle,marchingArmies);
				// Grid pane numbers not set yet 
				GridPane.setConstraints(marchingArmiesandLabelVBox,0,1);
				pageLayout.getChildren().addAll(marchingArmiesandLabelVBox);
				
				
				

////Hbox containg besieging armies 
		
				VBox besiegingArmiesandLabelVBox = new VBox();
				
				Label besiegingArmiesandLabelVBoxTitle = new Label ("Besieging Armies");
				besiegingArmiesandLabelVBoxTitle.setFont(Font.font("Cambria", 26));
				
				
				HBox besiegingArmies = new HBox();
				
				// Loop for adding besieging armies in hbox
				
				//For besieging armies, the player should be able to know which city is this army besieging and for how many turns the city was under siege. 

						for (Army a : game.getPlayer().getControlledArmies()) {
							if (a.getCurrentStatus().equals(Status.BESIEGING)) {
								String labelString = "Number of Units: " + a.getUnits().size() + "\n Besieging City " + a.getTarget() +"\n Turns Under Siege " ;
								
								
								for (City c : game.getAvailableCities()) { 
									if (c.getName().equals(a.getTarget()))
										labelString += ""+ c.getTurnsUnderSiege();
								}
								
								Label currentArmyLabel = new Label (labelString);
								String toolTipString = "";
								
								for (Unit u : a.getUnits()) { 
									toolTipString += ""+u.getType()+ "; Level: "+ u.getLevel() + "; Current Solider Count: "+ u.getCurrentSoldierCount() + "; Max Solider Count: " + u.getMaxSoldierCount();	
									toolTipString+="\n";
								}
								
								
								Tooltip tt = new Tooltip(toolTipString);
								tt.setShowDelay(new Duration (0));
								tt.setHideDelay(new Duration (10));
								
								currentArmyLabel.setTooltip(tt);
								besiegingArmies.getChildren().add(currentArmyLabel);
							}
						}
				
				besiegingArmiesandLabelVBox.getChildren().addAll(besiegingArmiesandLabelVBoxTitle,besiegingArmies);
				// Grid pane numbers not set yet 
				GridPane.setConstraints(besiegingArmiesandLabelVBox,0,2);
				pageLayout.getChildren().addAll(besiegingArmiesandLabelVBox);
						
						
						
						
		
				
				
			
		// Go to city view only if the city is controlled by the player 
		
				Boolean bolControlledCitiesContainsCairo = false;
				Boolean bolControlledCitiesContainsSparta = false;
				Boolean bolControlledCitiesContainsRome = false;
				
				for (City c  : game.getPlayer().getControlledCities()) {
					if (c.getName().equals("Cairo"))
						bolControlledCitiesContainsCairo = true;
					if (c.getName().equals("Rome"))
						bolControlledCitiesContainsRome = true;
					if (c.getName().equals("Sparta"))
						bolControlledCitiesContainsSparta = true;
				}
				
				
				// I added those final variables as a lambda expression can only deal with final variables 
				
				final Boolean  finalbolControlledCitiesContainsCairo = bolControlledCitiesContainsCairo;
				final Boolean finalbolControlledCitiesContainsSparta = bolControlledCitiesContainsSparta;
				final Boolean finalbolControlledCitiesContainsRome = bolControlledCitiesContainsRome;
				
				cairoButton.setOnAction(e -> {
					if (finalbolControlledCitiesContainsCairo)
						try {
							cityView(window,"Cairo");
						} catch (IOException e1) {
							// TODO Auto-generated catch block
							AlertBox.display(e1.getMessage());;
						}
					else { 
							AlertBox.display("Can't Open City View", "You Can't Open The City View Of A City Not Under Your Control");
							try {
								worldMapView( window);
							} catch (IOException e1) {
								// TODO Auto-generated catch block
								AlertBox.display(e1.getMessage());;
							}
							
					}});
				
				romeButton.setOnAction(e -> {
					if (finalbolControlledCitiesContainsRome)
						try {
							cityView(window,"Rome");
						} catch (IOException e1) {
							// TODO Auto-generated catch block
							AlertBox.display(e1.getMessage());;
						}
					else { 
							AlertBox.display("Can't Open City View", "You Can't Open The City View Of A City Not Under Your Control");
							try {
								worldMapView( window);
							} catch (IOException e1) {
								// TODO Auto-generated catch block
								AlertBox.display(e1.getMessage());;
							}
							
					}});
				
				spartaButton.setOnAction(e -> {
					if (finalbolControlledCitiesContainsSparta)
						try {
							cityView(window,"Sparta");
						} catch (IOException e1) {
							// TODO Auto-generated catch block
							AlertBox.display(e1.getMessage());;
						}
					else { 
							AlertBox.display("Can't Open City View", "You Can't Open The City View Of A City Not Under Your Control");
							try {
								worldMapView( window);
							} catch (IOException e1) {
								// TODO Auto-generated catch block
								AlertBox.display(e1.getMessage());;
							}
							
					}});
				
	
		
		Scene worldMapView = new Scene(pageLayout , 1275, 680);

		
		window.setScene(worldMapView);


	}
	
	
	
	
	
	public void cityView(Stage window , String currentCityName) throws IOException	{
	// Getting current City of the view  
		City currentCity = game.getPlayer().getControlledCities().get(0);
		for (City c :game.getPlayer().getControlledCities())
			if (c.getName().equals(currentCityName))
				currentCity= c;
	// Initializations for testing till we understand the game logic 
	
		currentCity.getEconomicalBuildings().add(new Farm());
		currentCity.getEconomicalBuildings().add(new Market());
		
		GridPane pageLayout = new GridPane();
		pageLayout.setHgap(10); 
		pageLayout.setVgap(10); 
		
		System.out.println("Current City View: " + currentCityName);
	

	
		
//Setting City Icon on Top Left of Page 		
		Image cityLogo = new Image("file:images/cairologo.jpg");
		
		if (currentCity.getName().equals("Sparta"))
			cityLogo = new Image("file:images/spartalogo.png");
		if (currentCity.getName().equals("Rome"))
			cityLogo = new Image("file:images/romelogo.png");
		
		ImageView cityLogoView = new ImageView(cityLogo);
		cityLogoView.setFitHeight(150);;
		cityLogoView.setFitWidth(150);
		GridPane.setConstraints(cityLogoView, 0, 1);
		pageLayout.getChildren().add(cityLogoView);
		
// Adding Player Info Next To City Label 
		Label label = new Label("Player name: " + game.getPlayer().getName()  + "; Player City: " + playerCityName + "; Turn Count: " +
				game.getCurrentTurnCount() + "; Food: " + game.getPlayer().getFood() + "; Gold: "+ game.getPlayer().getTreasury());
		label.setMaxHeight(10);
		label.setMinWidth(1275);
		label.setTextFill(Color.web("WHITE"));
		HBox hBox = new HBox();
		hBox.getChildren().addAll(label);
		hBox.setAlignment(Pos.TOP_LEFT);
		hBox.setBackground(new Background(new BackgroundFill( Color.BLACK, CornerRadii.EMPTY, Insets.EMPTY )));
		
		GridPane.setConstraints(hBox, 0, 0);
		pageLayout.getChildren().add(hBox);
		
		
		
		
//  Economical Buildings Label 
		
		Label economicalBuildingsLabel = new Label ("Economical Buildings");
		economicalBuildingsLabel.setFont(Font.font("Cambria", 26));
		GridPane.setConstraints(economicalBuildingsLabel, 0, 2);
		pageLayout.getChildren().add(economicalBuildingsLabel);
		
// Displaying all Economical buildings next to each other 
		
		
		
		System.out.println("Economical Buildings size "+  currentCity.getEconomicalBuildings().size());
		
		HBox economicalBuildingsHBox = new HBox (3);
		for (int i = 0 ; i < currentCity.getEconomicalBuildings().size(); i++) {
			Building currentBuilding = currentCity.getEconomicalBuildings().get(i);
			
			String buildingType = "Farm";
			
			
			VBox currentBuildingVBox = new VBox(3);
			//Adding building logo
			Image buildingLogo = new Image("file:images/farmicon.png");
			
			if (currentCity.getEconomicalBuildings().get(i) instanceof Market) {
				buildingLogo = new Image("file:images/marketicon.png");
				buildingType = "Market";
			}
			
			ImageView buildingLogoView = new ImageView(buildingLogo);
			buildingLogoView.setFitHeight(130);;
			buildingLogoView.setFitWidth(130);
			
			// Adding hover text to the building
			Tooltip tt = new Tooltip("Building Type: " + buildingType +"\n Building Level: "+  currentBuilding.getLevel());
			tt.setShowDelay(new Duration (0));
			tt.setHideDelay(new Duration (10));
			Tooltip.install(buildingLogoView, tt);
			currentBuildingVBox.getChildren().add(buildingLogoView);
			
			
			// Adding Upgrade Button Under Each Building 
			
			Button upgradeBuildingButton  = new Button();
			
			Image upgradeTextLogo = new Image("file:images/upgradetextlogo.png");
			ImageView upgradeTextLogoView = new ImageView(upgradeTextLogo);
			upgradeTextLogoView.setFitHeight(40);;
			upgradeTextLogoView.setFitWidth(130);
			upgradeBuildingButton.setGraphic(upgradeTextLogoView);
			
			
			Tooltip tt1 = new Tooltip("Upgrade Cost: " + currentBuilding.getUpgradeCost());
			tt1.setShowDelay(new Duration (0));
			tt1.setHideDelay(new Duration (10));
			Tooltip.install(upgradeBuildingButton, tt1);
			currentBuildingVBox.getChildren().add(upgradeBuildingButton);
					
			
			
			
			
			
			economicalBuildingsHBox.getChildren().add(currentBuildingVBox);
			
			
			
			

			
			
		}
		
		GridPane.setConstraints(economicalBuildingsHBox,0,3);
		pageLayout.getChildren().add(economicalBuildingsHBox);
		
		
	//  Economical Buildings Label 
		
			Label MilitaryBuildingsLabel = new Label ("Military Buildings");
			MilitaryBuildingsLabel.setFont(Font.font("Cambria", 26));
			GridPane.setConstraints(economicalBuildingsLabel, 0, 4);
			pageLayout.getChildren().add(MilitaryBuildingsLabel);
			
	
			
		
		
		

		
		
		
		

		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
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
