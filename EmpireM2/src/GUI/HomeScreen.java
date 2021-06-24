package GUI;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import buildings.*;
import engine.*;
import exceptions.BuildingInCoolDownException;
import exceptions.MaxLevelException;
import exceptions.MaxRecruitedException;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.NodeOrientation;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Hyperlink ;
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
import javafx.scene.text.TextFlow;
import javafx.stage.Stage;
import javafx.util.Duration;
import units.*;
import units.Army;
import units.Cavalry;
import units.Infantry;
import units.Status;
import units.Unit;


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
		window.setResizable(false);
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
		Button  startButton = new Button ("PLAY");
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
		Button  next = new Button ("Next");
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



		Hyperlink  cairoButton = new Hyperlink  ();
		Hyperlink  spartaButton = new Hyperlink  ();
		Hyperlink  romeButton = new Hyperlink  ();


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
		
// Label with player info 
		
		Label label = new Label("Player name: " + game.getPlayer().getName()  + "                                                              Player City: " + playerCityName + "                                                              Turn Count: " +
				game.getCurrentTurnCount() + "                                                              Food: " + game.getPlayer().getFood() + "                                                              Gold: "+ game.getPlayer().getTreasury());
		label.setMaxHeight(10);
		
		label.setMinWidth(1275);
		label.setTextFill(Color.web("WHITE"));
		HBox upperHBoxOfPlayerInfo = new HBox();
		upperHBoxOfPlayerInfo.getChildren().addAll(label);
		upperHBoxOfPlayerInfo.setAlignment(Pos.TOP_LEFT);
		upperHBoxOfPlayerInfo.setBackground(new Background(new BackgroundFill( Color.BLACK, CornerRadii.EMPTY, Insets.EMPTY )));
		
		
		//creating a borderpane to be the main layout
		BorderPane pageLayout = new BorderPane();
		//creating main subcomponents for page laypout
		VBox right= new VBox();
		VBox left = new VBox();

		pageLayout.setLeft(left);
		pageLayout.setRight(right);


		
	//setting background
	BackgroundImage bg = new BackgroundImage(new Image("file:images/ancientworldmap.png"),
			BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT,
				BackgroundPosition.CENTER, new BackgroundSize(1.0 ,1.0,true,true, false, false) );
		
		// Start of Cities HBox containing buttons for city choice
		HBox citiesHBox = new HBox(50);

		Hyperlink  cairoButton = new Hyperlink  ();
		Hyperlink  spartaButton = new Hyperlink  ();
		Hyperlink  romeButton = new Hyperlink  ();
		Tooltip cityButtonsToolTip = new Tooltip("Click To Open City View");
		cityButtonsToolTip.setShowDelay(new Duration (0));
		cityButtonsToolTip.setHideDelay(new Duration (10));
		cairoButton.setTooltip(cityButtonsToolTip);
		spartaButton.setTooltip(cityButtonsToolTip);
		romeButton.setTooltip(cityButtonsToolTip);
		
		
		//cities hbox pictures
		Image cairoImage = new Image("file:images/cairotextlogo.jfif");
		ImageView cairoImageView = new ImageView(cairoImage);
		cairoImageView.setFitHeight(200);;
		cairoImageView.setFitWidth(200);
		cairoButton.setGraphic(cairoImageView);

		Image spartaImage = new Image("file:images/spartabutton.jfif");
		ImageView spartaImageView = new ImageView(spartaImage);
		spartaImageView.setFitHeight(200);;
		spartaImageView.setFitWidth(200);
		spartaButton.setGraphic(spartaImageView);

		Image romeImage = new Image("file:images/romebutton.jfif");
		ImageView romeImageView = new ImageView(romeImage);
		romeImageView.setFitHeight(200);;
		romeImageView.setFitWidth(200);
		romeButton.setGraphic(romeImageView);
		romeButton.setGraphic(romeImageView);


		citiesHBox.getChildren().addAll(cairoButton,spartaButton,romeButton);
		citiesHBox.setAlignment(Pos.CENTER);


		pageLayout.setCenter(citiesHBox);
		// End of Cities HBox 
		
		
		
// A representation for the idle armies the player controls in VBox  

		VBox idleArmiesVBox = new VBox();
		
		Label idleArmiesTitle = new Label ("Idle Armies Controlled By " + game.getPlayer().getName() + ":");
		idleArmiesTitle.setFont(Font.font("Cambria", 15));
		
		
		HBox idleArmies = new HBox();
		
		
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
				idleArmies.getChildren().add(currentArmyLabel);
			}
		}

		idleArmiesVBox.getChildren().addAll(idleArmiesTitle,idleArmies);

		left.getChildren().add(idleArmiesVBox);

		
		
		
		
//Hbox containg marching armies 
		
		VBox marchingArmiesandLabelVBox = new VBox();
		
		Label marchingArmiesandLabelVBoxTitle = new Label ("Marching Armies: ");
		marchingArmiesandLabelVBoxTitle.setFont(Font.font("Cambria", 15));
		
		
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
				left.getChildren().add(marchingArmiesandLabelVBox);

				
				
				

////Hbox containg besieging armies 
		
				VBox besiegingArmiesandLabelVBox = new VBox();
				
				Label besiegingArmiesandLabelVBoxTitle = new Label ("Besieging Armies: ");
				besiegingArmiesandLabelVBoxTitle.setFont(Font.font("Cambria", 15));

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


				left.getChildren().add(besiegingArmiesandLabelVBox);
				citiesHBox.setTranslateX(-100);

						

				left.setTranslateY(30.0);
						
		
				
				
			
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
				
				
				
				
	
		VBox superLayout = new VBox () ; 
		superLayout.setBackground(new Background(bg));
		superLayout.getChildren().addAll(upperHBoxOfPlayerInfo,pageLayout);
		
		Scene worldMapView = new Scene(superLayout , 1275, 680);

		
		window.setScene(worldMapView);


	}
	
	
	
	
	
	public void cityView(Stage window , String currentCityName) throws IOException	{
	
		Background bg = Createbackground1("cityviewwallpaper.jpg");
		
		
		
	// Getting current City of the view  
		City currentCity = game.getPlayer().getControlledCities().get(0);
		for (City c :game.getPlayer().getControlledCities())
			if (c.getName().equals(currentCityName))
				currentCity= c;
		
		// not sure if I should initialize the defending army automatically 
		currentCity.setDefendingArmy(new Army(currentCity.getName()));
		
		
	// Initializations for testing till we understand the game logic 
	
		currentCity.getEconomicalBuildings().add(new Farm());
		currentCity.getEconomicalBuildings().add(new Market());
		
		currentCity.getMilitaryBuildings().add(new Barracks());
		currentCity.getMilitaryBuildings().add(new ArcheryRange());
		currentCity.getMilitaryBuildings().add(new Stable());
		
		currentCity.getDefendingArmy().getUnits().add(new Archer(60, 60, 60, 60, 60));
		currentCity.getDefendingArmy().getUnits().add(new Infantry(60, 60, 60, 60, 60));
		currentCity.getDefendingArmy().getUnits().add(new Cavalry(60, 60, 60, 60, 60));
		
		game.getPlayer().getControlledArmies().add(new Army (currentCity.getName()));
		
		VBox superLaypout = new VBox ();
		
		
	// Page main layout
		GridPane pageLayout = new GridPane();
		pageLayout.setHgap(5); 
		pageLayout.setVgap(1); 
		
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
		cityLogoView.setTranslateX(562.5);
		
		GridPane.setConstraints(cityLogoView,0,0);
		pageLayout.getChildren().add(cityLogoView);
		
		
		

		
		
		
// Adding Player Info  To  Label 
		Label label = new Label("Player name: " + game.getPlayer().getName()  + "                                                              Player City: " + playerCityName + "                                                              Turn Count: " +
				game.getCurrentTurnCount() + "                                                              Food: " + game.getPlayer().getFood() + "                                                              Gold: "+ game.getPlayer().getTreasury());
		
		label.setMaxHeight(10);
		
		label.setMinWidth(1275);
		label.setTextFill(Color.web("WHITE"));
		HBox upperHBoxOfPlayerInfo = new HBox();
		upperHBoxOfPlayerInfo.getChildren().addAll(label);
		upperHBoxOfPlayerInfo.setAlignment(Pos.TOP_LEFT);
		upperHBoxOfPlayerInfo.setBackground(new Background(new BackgroundFill( Color.BLACK, CornerRadii.EMPTY, Insets.EMPTY )));
		
		
		
		
		

//  Economical Buildings Label 
		
		Label economicalBuildingsLabel = new Label ("Economical Buildings");
		economicalBuildingsLabel.setFont(Font.font("Cambria", 26));
		economicalBuildingsLabel.setTextFill(Color.web("#0076a3"));
		GridPane.setConstraints(economicalBuildingsLabel, 0, 3);
		pageLayout.getChildren().add(economicalBuildingsLabel);
		
// Displaying all Economical buildings next to each other 
		
		
		
		HBox economicalBuildingsHBox = new HBox (6);
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
			
			
			// Adding Upgrade Hyperlink  Under Each Building 
			
			Hyperlink  upgradeBuildingButton  = new Hyperlink ();
			
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
					
			
			upgradeBuildingButton.setOnAction( e -> { 
				try {
					currentBuilding.upgrade();
				} catch (BuildingInCoolDownException | MaxLevelException e1) {
					
					AlertBox.display("Unable to Upgrade Building" , e1.getMessage());
				}
				
				
			});
			
			
			
			economicalBuildingsHBox.getChildren().add(currentBuildingVBox);
			
			
			
			

			
			
		}
		
		GridPane.setConstraints(economicalBuildingsHBox,0,4);
		pageLayout.getChildren().add(economicalBuildingsHBox);
		
	
//  Military Buildings Label 
	
		Label MilitaryBuildingsLabel = new Label ("Military Buildings");
		MilitaryBuildingsLabel.setFont(Font.font("Cambria", 26));
		MilitaryBuildingsLabel.setTextFill(Color.web("#0076a3"));
		GridPane.setConstraints(MilitaryBuildingsLabel, 1, 3);
		pageLayout.getChildren().add(MilitaryBuildingsLabel);
		
		
		
// Displaying all Military buildings next to each other 
		
		
		
		HBox militaryBuildingsHBox = new HBox (6);
		for (int i = 0 ; i < currentCity.getMilitaryBuildings().size(); i++) {
			MilitaryBuilding currentBuilding = currentCity.getMilitaryBuildings().get(i);
			
			String buildingType = "Archery Range";
			
			
			VBox currentBuildingVBox = new VBox(6);
			//Adding building logo
			Image buildingLogo = new Image("file:images/archeryrangeicon.png");
			
			if (currentCity.getMilitaryBuildings().get(i) instanceof Barracks) {
				buildingLogo = new Image("file:images/baracksicon.png");
				buildingType = "Barracks";
			}
			
			if (currentCity.getMilitaryBuildings().get(i) instanceof Stable) {
				buildingLogo = new Image("file:images/stableicon.png");
				buildingType = "Stable";
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
			
			
			// Adding Upgrade Hyperlink  Under Each Building 
			
			Hyperlink  upgradeBuildingButton  = new Hyperlink ();
			
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
			
// Adding Upgrade Hyperlink  Under Each Building 

			Hyperlink  recruitButton  = new Hyperlink ();
			
			Image recruitTextLogo = new Image("file:images/recruittextlogo.png");
			ImageView recruitTextLogoView = new ImageView(recruitTextLogo);
			recruitTextLogoView.setFitHeight(40);;
			recruitTextLogoView.setFitWidth(130);
			recruitButton.setGraphic(recruitTextLogoView);
			
			
			Tooltip tt2 = new Tooltip("Upgrade Cost: " + currentBuilding.getRecruitmentCost());
			tt2.setShowDelay(new Duration (0));
			tt2.setHideDelay(new Duration (10));
			Tooltip.install(recruitButton, tt2);
			
			upgradeBuildingButton.setOnAction( e -> { 
				try {
					currentBuilding.upgrade();
				} catch (BuildingInCoolDownException | MaxLevelException e1) {
					
					AlertBox.display("Unable to Upgrade Building" , e1.getMessage());
				}
				
				
			});
			
			
			currentBuildingVBox.getChildren().add(recruitButton);
		
			
			recruitButton.setOnAction( e -> { 
				try {
					
					//23mel eh bel unit dy ???
					currentBuilding.recruit();
				} catch (BuildingInCoolDownException | MaxRecruitedException e1) {
					// TODO Auto-generated catch block
					AlertBox.display("Unable to Recruit" , e1.getMessage());
				}
				
				
			});
			
			
			
			militaryBuildingsHBox.getChildren().add(currentBuildingVBox);
			
			
			
			

			
			
		}
		
		GridPane.setConstraints(militaryBuildingsHBox,1,4);
		pageLayout.getChildren().add(militaryBuildingsHBox);
		
		
	
	
	

		
//  Military Buildings Label 
	
		Label defendingArmyLabel = new Label ("Defending Army");
		defendingArmyLabel.setFont(Font.font("Cambria", 26));
		defendingArmyLabel.setTextFill(Color.web("#0076a3"));
		GridPane.setConstraints(defendingArmyLabel, 0, 7);
		pageLayout.getChildren().add(defendingArmyLabel);
		
		

// Put all units of defending army 
		
		
		HBox defendingArmyUnitsHBox = new HBox (15);
		
		for (Unit u : currentCity.getDefendingArmy().getUnits()) { 
			
			
			String unitType = "Archer";
			Image unitLogo = new Image("file:images/archericon.png");
			
			if (u.getType().equals("Infantry")) {
				unitLogo = new Image("file:images/infantryicon.png");
				unitType = "Barracks";
			}
			
			if (u.getType().equals("Cavalry")) {
				unitLogo = new Image("file:images/cavalaryicon.png");
				unitType = "Cavalry";
			}
			
			ImageView unitLogoView = new ImageView(unitLogo);
			unitLogoView.setFitHeight(130);;
			unitLogoView.setFitWidth(130);
			
			// Adding hover text to the building
			Tooltip tt = new Tooltip(" Unit Type: " + unitType +"\n Unit Level: "+  u.getLevel() + "\n Current Solider Count: " + u.getCurrentSoldierCount() + "\n Max Solider Count: " + u.getMaxSoldierCount());
			tt.setShowDelay(new Duration (0));
			tt.setHideDelay(new Duration (10));
			Tooltip.install(unitLogoView, tt);
			defendingArmyUnitsHBox.getChildren().add(unitLogoView);
			
		}
		
		GridPane.setConstraints(defendingArmyUnitsHBox,0,8);
		pageLayout.getChildren().add(defendingArmyUnitsHBox);
		
		
		
		
		

//  Stationed Armies Label 
	
		Label stationedArmiesLabel = new Label ("Player Armies Currently Located In "+ currentCity.getName());
		stationedArmiesLabel.setFont(Font.font("Cambria", 26));
		stationedArmiesLabel.setTextFill(Color.web("#0076a3"));
		GridPane.setConstraints(stationedArmiesLabel, 1, 7);
		pageLayout.getChildren().add(stationedArmiesLabel);
		
// Put all armies together in the city
		
		HBox stationedArmiesHBox = new HBox(6);
		for (Army a : game.getPlayer().getControlledArmies()) {
			if (a.getCurrentLocation().equals(currentCity.getName())) {
				
				Image armyLogo = new Image("file:images/armylogo.png");
				
				ImageView armyLogoView = new ImageView(armyLogo);
				armyLogoView.setFitHeight(130);;
				armyLogoView.setFitWidth(180);
				
				
				
				// Adding hover text to the building
				String ttString = "";
				for (int i = 0 ; i < a.getUnits().size() ; i++) {
					Unit u = a.getUnits().get(i);
					ttString+= "" + i+1 + "." +" Unit Type: " + u.getType() +"\n Unit Level: "+  u.getLevel() + "\n Current Solider Count: " + u.getCurrentSoldierCount() + "\n Max Solider Count: " + u.getMaxSoldierCount() +"\n";
					
				}
				Tooltip tt = new Tooltip(ttString);
				tt.setShowDelay(new Duration (0));
				tt.setHideDelay(new Duration (10));
				Tooltip.install(armyLogoView, tt);
				
				
				
				stationedArmiesHBox.getChildren().add(armyLogoView);
			}
		}
		
		
		GridPane.setConstraints(stationedArmiesHBox,1,8);
		pageLayout.getChildren().add(stationedArmiesHBox);
		
		
//Go to World Map View Button 
		
		Button goToMapViewButton = new Button ("World Map View");
		goToMapViewButton.setMaxHeight(40);
		goToMapViewButton.setMaxWidth(240);
		goToMapViewButton.setStyle("-fx-font: 25 arial; -fx-base: #b6e7c9;");
		goToMapViewButton.setTranslateX(517.5);
		goToMapViewButton.setTranslateY(10);
		
		
		
		
		goToMapViewButton.setOnAction(e -> { 
			try {
				worldMapView(window);
			} catch (IOException e1) {
				AlertBox.display(e1.getMessage());
			}
		});
		
		
		
		
		
		
		
		
		
		superLaypout.getChildren().add(upperHBoxOfPlayerInfo);

		superLaypout.getChildren().addAll(pageLayout,goToMapViewButton);

		superLaypout.setBackground(bg);
		
		
		Scene cityView = new Scene(superLaypout ,1275, 680);

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
