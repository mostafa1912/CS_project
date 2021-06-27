package GUI;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import buildings.*;
import engine.*;
import exceptions.BuildingInCoolDownException;
import exceptions.FriendlyFireException;
import exceptions.MaxLevelException;
import exceptions.MaxRecruitedException;
import exceptions.NotEnoughGoldException;
import javafx.application.Application;
import javafx.event.Event;
import javafx.event.EventHandler;
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


public class HomeScreen extends Application  {
	static Game game ;
	static String playerCityName;


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

		startButton.setStyle("-fx-font: 25 arial; -fx-base: #FFB806;");

		
		Button  RulesButton = new Button ("Rules");
		//setting button size and font
		RulesButton.setMaxHeight(50);
		RulesButton.setMaxWidth(125);

		RulesButton.setStyle("-fx-font: 25 arial; -fx-base: #FFB806;");
		
		VBox buttonsVBox = new VBox(20);
		buttonsVBox.getChildren().addAll(startButton,RulesButton);
		buttonsVBox.setAlignment(Pos.CENTER);
		//adding start button to layout
		startLayout.getChildren().addAll(gamenamelogoViewVBox ,deepquoteViewVBox,buttonsVBox);
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
		
		RulesButton.setOnAction(e->{
			Instructions.display();
		});

	}


	public void scene2(Stage window) throws IOException {
		//adding the next button and setting its size
		Button  next = new Button ("Next");
		next.setAlignment(Pos.BOTTOM_CENTER);
		next.setMaxHeight(50);
		next.setMaxWidth(140);
		next.setStyle("-fx-font: 25 arial; -fx-base: #FFB806;");
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

public  void scene3(Stage window, String playerName) throws IOException	{

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


public static void worldMapView(Stage window) throws IOException	{
BorderPane bp = new BorderPane();

// Label with player info 
		
		Label label = new Label("Player name: " + game.getPlayer().getName()  + "                                                              Player City: " + playerCityName + "                                                              Turn Count: " +
				game.getCurrentTurnCount() + "                                                              Food: " + game.getPlayer().getFood() + "                                                              Gold: "+ game.getPlayer().getTreasury());
		label.setMaxHeight(10);
		label.setBackground(new Background(new BackgroundFill(Color.BLACK,CornerRadii.EMPTY, Insets.EMPTY)));

		HBox labelHbox = new HBox();
		labelHbox.getChildren().add(label);
		labelHbox.setBackground(new Background(new BackgroundFill(Color.BLACK,
				CornerRadii.EMPTY,
				Insets.EMPTY)));

		label.setMinWidth(1275);
		label.setTextFill(Color.web("WHITE"));
		HBox upperHBoxOfPlayerInfo = new HBox();
		upperHBoxOfPlayerInfo.getChildren().addAll(labelHbox);
		upperHBoxOfPlayerInfo.setAlignment(Pos.TOP_LEFT);
		upperHBoxOfPlayerInfo.setBackground(new Background(new BackgroundFill( Color.BLACK, CornerRadii.EMPTY, Insets.EMPTY )));
		bp.setTop(label);
		




		
	//setting background
	BackgroundImage bg = new BackgroundImage(new Image("file:images/worldmapview.jpg"),
			BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT,
				BackgroundPosition.CENTER, new BackgroundSize(1.0 ,1.0,true,true, false, false) );
		bp.setBackground(new Background(bg));


		// Start of Cities HBox containing buttons for city choice
		HBox citiesHBox = new HBox();

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


		//trying to change position of chosen city





		citiesHBox.getChildren().addAll(cairoButton,spartaButton,romeButton);
		
		citiesHBox.setAlignment(Pos.CENTER);
		citiesHBox.setTranslateX(-180);
		citiesHBox.setTranslateY(100);
		bp.setCenter(citiesHBox);

		
	//representation for idle armies
		
		
		VBox leftVBox = new VBox();
		Label IdleArmiesandLabel = new Label ("Idle Armies Controlled By " + game.getPlayer().getName()+ " :" );
		IdleArmiesandLabel.setFont(Font.font("Cambria", 26));
		IdleArmiesandLabel.setTextFill(Color.web("Orange"));
		leftVBox.getChildren().add(IdleArmiesandLabel);

		HBox idleArmiesHBox = new HBox(6);
		for (Army a : game.getPlayer().getControlledArmies()) {
			
		if (a.getCurrentStatus().equals(Status.IDLE ) && a.getUnits().size() != 0)	{

			Hyperlink  armyButton  = new Hyperlink ();
			Image armyLogo = new Image("file:images/armylogo.png");
			ImageView armyLogoView = new ImageView(armyLogo);
			armyLogoView.setFitHeight(130);;
			armyLogoView.setFitWidth(180);
			armyButton.setGraphic(armyLogoView);
			
			
			// Adding hover text to the building
			String ttString = "---Click To View Units Or Set Target---\n--- Units: \n";
			for (int i = 0 ; i < a.getUnits().size() ; i++) {
				Unit u = a.getUnits().get(i);
				ttString+= "" + (i+1) + "." +" Unit Type: " + u.getType() +"; Unit Level: "+  u.getLevel() + "; Current Solider Count: " + u.getCurrentSoldierCount() + "; Max Solider Count: " + u.getMaxSoldierCount() +"\n";
				
			}
			Tooltip tt = new Tooltip(ttString);
			tt.setShowDelay(new Duration (0));
			tt.setHideDelay(new Duration (10));
			Tooltip.install(armyButton, tt);
			
			armyButton.setOnAction(e->{ 
				ViewUnits.displayUnitsOfArmy(a, game.getPlayer(), game, a.getCurrentLocation());
				try {
					worldMapView(window);
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					AlertBox.display(e1.getMessage());
				}
			});
			
			
			idleArmiesHBox.getChildren().add(armyButton);
			
		}}
		
		leftVBox.getChildren().add(idleArmiesHBox);


		
		
		
		
//Hbox containg marching armies 
		
		
		
		Label marchingArmiesandLabelVBoxTitle = new Label ("Marching Armies Controlled By "+ game.getPlayer().getName()+": ");
		marchingArmiesandLabelVBoxTitle.setFont(Font.font("Cambria", 26));
		marchingArmiesandLabelVBoxTitle.setTextFill(Color.web("Orange"));
		leftVBox.getChildren().add(marchingArmiesandLabelVBoxTitle);
		
		
		
		HBox marchingArmiesHBox = new HBox();
		
	
				for (Army a : game.getPlayer().getControlledArmies()) {
					if (a.getCurrentStatus().equals(Status.MARCHING) && a.getUnits().size() != 0) {
						Hyperlink  armyButton  = new Hyperlink ();
						Image armyLogo = new Image("file:images/armylogo.png");
						ImageView armyLogoView = new ImageView(armyLogo);
						armyLogoView.setFitHeight(130);;
						armyLogoView.setFitWidth(180);
						armyButton.setGraphic(armyLogoView);
						

						String ttString = "Number of Units: " + a.getUnits().size() + "; Army Location: On Road to " + a.getTarget() +";  Distance to Target: " + a.getDistancetoTarget() + "\n";
						ttString+= "---Units : \n";
						for (int i = 0 ; i < a.getUnits().size() ; i++) {
							Unit u = a.getUnits().get(i);
							ttString+= "" + (i+1) + "." +" Unit Type: " + u.getType() +"; Unit Level: "+  u.getLevel() + "; Current Solider Count: " + u.getCurrentSoldierCount() + "; Max Solider Count: " + u.getMaxSoldierCount() +"\n";
							
						}
						Tooltip tt = new Tooltip(ttString);
						tt.setShowDelay(new Duration (0));
						tt.setHideDelay(new Duration (10));
						Tooltip.install(armyButton, tt);
						
						
						armyButton.setOnAction(e->{ 
							ViewUnits.displayUnitsOfArmy(a, game.getPlayer(), game, a.getCurrentLocation());
							
						});
						
						
						
						marchingArmiesHBox.getChildren().add(armyButton);
						
						
						
					}
				}
		
		leftVBox.getChildren().add(marchingArmiesHBox);

				
				
				

////Hbox containg besieging armies 
		
		Label besiegingArmiesLabel = new Label ("Besieging Armies Controlled By "+ game.getPlayer().getName()+": " );
		besiegingArmiesLabel.setFont(Font.font("Cambria", 26));
		besiegingArmiesLabel.setTextFill(Color.web("Orange"));
		
		leftVBox.getChildren().add(besiegingArmiesLabel);

		HBox besiegingArmiesHBox = new HBox();
	
// Loop for adding besieging armies in hbox

//For besieging armies, the player should be able to know which city is this army besieging and for how many turns the city was under siege. 

				for (Army a : game.getPlayer().getControlledArmies()) {
					if (a.getCurrentStatus().equals(Status.BESIEGING) && a.getUnits().size() != 0 ) {
						Hyperlink  armyButton  = new Hyperlink ();
						Image armyLogo = new Image("file:images/armylogo.png");
						ImageView armyLogoView = new ImageView(armyLogo);
						armyLogoView.setFitHeight(130);;
						armyLogoView.setFitWidth(180);
						armyButton.setGraphic(armyLogoView);

						
						
						

						String ttString = "Number of Units: " + a.getUnits().size() + "\nBesieging City " + a.getCurrentLocation() +"\n Turns Under Siege " ;
						
						
						for (City c : game.getAvailableCities()) { 
							if (c.getName().equals(a.getCurrentLocation()))
								ttString += ""+ c.getTurnsUnderSiege();
						
						

					}
						
						ttString+= "\n---Units : \n";
						for (int i = 0 ; i < a.getUnits().size() ; i++) {
							Unit u = a.getUnits().get(i);
							ttString+= "" + (i+1) + "." +" Unit Type: " + u.getType() +"; Unit Level: "+  u.getLevel() + "; Current Solider Count: " + u.getCurrentSoldierCount() + "; Max Solider Count: " + u.getMaxSoldierCount() +"\n";
							
						}
						Tooltip tt = new Tooltip(ttString);
						tt.setShowDelay(new Duration (0));
						tt.setHideDelay(new Duration (10));
						Tooltip.install(armyButton, tt);
						

						besiegingArmiesHBox.getChildren().add(armyButton);
						
						for (City c : game.getAvailableCities()) { 
							if (c.getName().equals(a.getCurrentLocation()) && c.getTurnsUnderSiege() == 3 ) { 
								//System.out.println("Window shoulf be displayed");

								MustBattle.displayYouMustBattleWindow(game, c, a);
								worldMapView(window);
								
								
							}
						}
						armyButton.setOnAction(e->{ 
							ViewUnits.displayUnitsOfArmy(a, game.getPlayer(), game, a.getCurrentLocation());
							try {
								worldMapView(window);
							} catch (IOException e1) {
								// TODO Auto-generated catch block
								AlertBox.display(e1.getMessage());
							}
						});
					}
		}
					
				
				

				leftVBox.getChildren().add(besiegingArmiesHBox);

				bp.setLeft(leftVBox);
								
						

				
						
		
				
				
			
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
	//creating the end turn button
	Button end = new Button("End Turn ");
	Color orange = Color.web("#FFB806");


	//end.setBackground(new Background( new BackgroundFill(orange , CornerRadii.EMPTY, Insets.EMPTY)));
	bp.setBottom(end);

	Scene worldMapView = new Scene(bp, 1275, 680);

	window.setScene(worldMapView);

	end.setMaxHeight(40);
	end.setMaxWidth(240);
	end.setStyle("-fx-font: 25 arial; -fx-base: #FFB806;");
		end.setOnAction(e -> {
			

			game.endTurn();
			
			for (Army a : game.getPlayer().getControlledArmies()  )
			{
				
				if(a.getDistancetoTarget()==0 && !a.getCurrentStatus().equals(Status.BESIEGING)){
					SiegingChoice.giveSiegeChoice(game , a);
				

				}
			}
			
			try {
				worldMapView(window);
			} catch (IOException ioException) {
				ioException.printStackTrace();
			}
			
			if (game.getCurrentTurnCount()>= 51) { 
				
				youLost(window);
				//System.out.println("You Lost");
			}
			else if (game.getPlayer().getControlledCities().size() == 3 ) { 
				youWon(window);
			}
		});
		end.setAlignment(Pos.CENTER);
		end.setTranslateX(520);

		


	}

	
public static void cityView(Stage window , String currentCityName) throws IOException	{

		clearEmptyArmies();
		Background bg = Createbackground1("cityviewwallpaper.jpg");
		
		
		
	// Getting current City of the view  
		City currentCity1 = game.getPlayer().getControlledCities().get(0);
		for (City c :game.getPlayer().getControlledCities())
			if (c.getName().equals(currentCityName))
				currentCity1= c;
		
		final City currentCity = currentCity1;
		
		

		VBox superLayout = new VBox ();
		
		
	// Page main layout
		GridPane pageLayout = new GridPane();
		pageLayout.setHgap(5); 
		pageLayout.setVgap(1); 
		
		


	
		
//Setting City Icon on Top Left of Page 		
		Image cityLogo = new Image("file:images/cairotextlogo1.png");
		
		if (currentCity.getName().equals("Sparta"))
			cityLogo = new Image("file:images/spartatextlogo.png");
		if (currentCity.getName().equals("Rome"))
			cityLogo = new Image("file:images/rometextlogo.png");
		
		ImageView cityLogoView = new ImageView(cityLogo);
		cityLogoView.setFitHeight(100);;
		cityLogoView.setFitWidth(300);
		cityLogoView.setTranslateX(487.5);
		
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
		HBox economicalBuildingsLabelHBox = new HBox ();
		Label economicalBuildingsLabel = new Label ("Economical Buildings in "+ currentCity.getName());
		economicalBuildingsLabel.setFont(Font.font("Cambria", 26));
		economicalBuildingsLabel.setTextFill(Color.web("#0076a3"));
		economicalBuildingsLabelHBox.getChildren().add(economicalBuildingsLabel);
	
		
// Putting Build Label Next to Economical Buildings Label 
		
		Hyperlink  buildEcoBuildingButton  = new Hyperlink ();
		Image buildTextLogo = new Image("file:images/buildtextlogo.png");
		ImageView buildTextLogoView = new ImageView(buildTextLogo);
		buildTextLogoView.setFitHeight(20);;
		buildTextLogoView.setFitWidth(65);
		buildEcoBuildingButton.setGraphic(buildTextLogoView);
		
		buildEcoBuildingButton.setOnAction(e ->{
			BuildBuilding.displayBuildEconomicalBuilding(game.getPlayer(), currentCity.getName());
			try {
				cityView(window, currentCityName);
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				AlertBox.display(e1.getMessage());
			}
		});
		
		economicalBuildingsLabelHBox.getChildren().add(buildEcoBuildingButton);
		
		
		
		
		pageLayout.getChildren().add(economicalBuildingsLabelHBox);
		GridPane.setConstraints(economicalBuildingsLabelHBox, 0, 3);
// Displaying all Economical buildings next to each other 
		
		
		
		HBox economicalBuildingsHBox = new HBox (6);
		for (int i = 0 ; i < currentCity.getEconomicalBuildings().size(); i++) {
			EconomicBuilding currentBuilding = currentCity.getEconomicalBuildings().get(i);
			
			String buildingType = "Farm";
			
			
			VBox currentBuildingVBox = new VBox(3);
			//Adding building logo
			Image buildingLogo = new Image("file:images/farmicon.png");
			
			if (currentCity.getEconomicalBuildings().get(i) instanceof Market) {
				buildingLogo = new Image("file:images/marketicon.png");
				buildingType = "Market";
			}
			
			
			final String buildingTypeFinal = buildingType;
			
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

			
			
			
			
			upgradeBuildingButton.setOnAction( e -> { 
				
				try {
					try {
						game.getPlayer().upgradeBuilding(currentBuilding);
					} catch (NotEnoughGoldException e1) {
						// TODO Auto-generated catch block
						AlertBox.display("Not Enough Gold", e1.getMessage());
					};
				} catch (BuildingInCoolDownException | MaxLevelException e1) {
					
					AlertBox.display("Unable to Upgrade Building" , e1.getMessage());
				}
				
				Tooltip ttx = new Tooltip("Building Type: " + buildingTypeFinal +"\n Building Level: "+  currentBuilding.getLevel());
				ttx.setShowDelay(new Duration (0));
				ttx.setHideDelay(new Duration (10));
				Tooltip.install(buildingLogoView, ttx);
				
				
				
				Tooltip tty = new Tooltip("Upgrade Cost: " + currentBuilding.getUpgradeCost());
				tty.setShowDelay(new Duration (0));
				tty.setHideDelay(new Duration (10));
				Tooltip.install(upgradeBuildingButton, tty);

				
				
			});
			
			
			
			economicalBuildingsHBox.getChildren().add(currentBuildingVBox);
			
			
			
			

			
			
		}
		
		GridPane.setConstraints(economicalBuildingsHBox,0,4);
		pageLayout.getChildren().add(economicalBuildingsHBox);
		
	
//  Military Buildings Label 
		HBox MilitaryBuildingsLabelHBox = new HBox();
		Label MilitaryBuildingsLabel = new Label ("Military Buildings in "+ currentCity.getName()+": ");
		MilitaryBuildingsLabel.setFont(Font.font("Cambria", 26));
		MilitaryBuildingsLabel.setTextFill(Color.web("#0076a3"));
		MilitaryBuildingsLabelHBox.getChildren().add(MilitaryBuildingsLabel);
		
		
// Putting Build Label Next to Military Buildings Label 
		
		Hyperlink  buildMilBuildingButton  = new Hyperlink ();
		
		Image buildMilTextLogo = new Image("file:images/buildtextlogo.png");
		ImageView buildMilTextLogoView = new ImageView(buildMilTextLogo);
		buildMilTextLogoView.setFitHeight(20);;
		buildMilTextLogoView.setFitWidth(65);
		buildMilBuildingButton.setGraphic(buildMilTextLogoView);
		
		buildMilBuildingButton.setOnAction(e ->{
			BuildBuilding.displayBuildMilitary(game.getPlayer(), currentCity.getName());
			try {
				cityView(window, currentCityName);
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				AlertBox.display(e1.getMessage());
			}
		});
		
		MilitaryBuildingsLabelHBox.getChildren().add(buildMilBuildingButton);
		
				
		
		
		
		
		GridPane.setConstraints(MilitaryBuildingsLabelHBox, 1, 3);
		pageLayout.getChildren().add(MilitaryBuildingsLabelHBox);
		
		
		
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
				buildingType = "Barrack";
			}
			
			if (currentCity.getMilitaryBuildings().get(i) instanceof Stable) {
				buildingLogo = new Image("file:images/stableicon.png");
				buildingType = "Stable";
			}
			
			
			final String buildingtypeFinal = buildingType;
			
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
			
			
			Tooltip tt2 = new Tooltip("Recruitment Cost: " + currentBuilding.getRecruitmentCost());
			tt2.setShowDelay(new Duration (0));
			tt2.setHideDelay(new Duration (10));
			Tooltip.install(recruitButton, tt2);
			
			upgradeBuildingButton.setOnAction( e -> { 
				try {
					game.getPlayer().upgradeBuilding(currentBuilding);
				} catch (BuildingInCoolDownException | MaxLevelException e1) {
					
					AlertBox.display("Unable to Upgrade Building" , e1.getMessage());
				} catch (NotEnoughGoldException e1) {
					// TODO Auto-generated catch block
					AlertBox.display("Unable to Upgrade Building" , e1.getMessage());
				}
				
				
				Tooltip ttx = new Tooltip("Building Type: " + buildingtypeFinal +"\n Building Level: "+  currentBuilding.getLevel());
				ttx.setShowDelay(new Duration (0));
				ttx.setHideDelay(new Duration (10));
				Tooltip.install(buildingLogoView, ttx);
				
				
				Tooltip tty = new Tooltip("Upgrade Cost: " + currentBuilding.getUpgradeCost());
				tty.setShowDelay(new Duration (0));
				tty.setHideDelay(new Duration (10));
				Tooltip.install(upgradeBuildingButton, tty);
				
				
			});
			
			
			currentBuildingVBox.getChildren().add(recruitButton);
		
			
			recruitButton.setOnAction( e -> { 
				String unitType = "Archer";
				if (currentBuilding instanceof Barracks) { 
					unitType = "infantry";
				}
				if (currentBuilding instanceof Stable) { 
					unitType = "cavalry";
				}
				
				try {
					game.getPlayer().recruitUnit(unitType, currentCity.getName());
				} catch (BuildingInCoolDownException | MaxRecruitedException | NotEnoughGoldException e1) {
					AlertBox.display("Unit Can't Be Recruited", e1.getMessage());
				}
				
				try {
					cityView(window, currentCityName);
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					AlertBox.display(e1.getMessage());
				}
				
				
				Tooltip ttz = new Tooltip("Recruitment Cost: " + currentBuilding.getRecruitmentCost());
				ttz.setShowDelay(new Duration (0));
				ttz.setHideDelay(new Duration (10));
				Tooltip.install(recruitButton, ttz);
				
			});
			
			
			
			militaryBuildingsHBox.getChildren().add(currentBuildingVBox);
			
			
			
			

			
			
		}
		
		GridPane.setConstraints(militaryBuildingsHBox,1,4);
		pageLayout.getChildren().add(militaryBuildingsHBox);
		
		
	
	
	

		
//  Military Buildings Label 
	
		Label defendingArmyLabel = new Label (currentCity.getName()+"'s Defending Army");
		defendingArmyLabel.setFont(Font.font("Cambria", 26));
		defendingArmyLabel.setTextFill(Color.web("#0076a3"));
		GridPane.setConstraints(defendingArmyLabel, 0, 7);
		pageLayout.getChildren().add(defendingArmyLabel);
		
		

// Put all units of defending army 
		
		
		HBox defendingArmyUnitsHBox = new HBox (15);
		
		for (Unit u : currentCity.getDefendingArmy().getUnits()) { 
			
			
			String unitType = "Archer";
			Image unitLogo = new Image("file:images/archericon.png");
			
			if (u.getType().equals("Infantry")){
				unitLogo = new Image("file:images/infantryicon.png");
				unitType = "Infantry";
			}
			
			if (u.getType().equals("Cavalry")) {
				unitLogo = new Image("file:images/cavalaryicon.png");
				unitType = "Cavalry";
			}
			
			Hyperlink  unitLogoButton  = new Hyperlink ();
			ImageView unitLogoView = new ImageView(unitLogo);
			unitLogoView.setFitHeight(130);;
			unitLogoView.setFitWidth(130);
			
			unitLogoButton.setGraphic(unitLogoView);
			
			// Adding hover text to the building
			Tooltip tt = new Tooltip("---Click To Relocate Unit--- \nUnit Type: " + unitType +"\n Unit Level: "+  u.getLevel() + "\n Current Solider Count: " + u.getCurrentSoldierCount() + "\n Max Solider Count: " + u.getMaxSoldierCount()+"");
			tt.setShowDelay(new Duration (0));
			tt.setHideDelay(new Duration (10));
			Tooltip.install(unitLogoButton, tt);
			defendingArmyUnitsHBox.getChildren().add(unitLogoButton);
			
			unitLogoButton.setOnAction(e -> { 
				RelocateUnit.displayRelocateUnitScreen(game.getPlayer().getControlledArmies(), u, game,currentCity);
				try {
					cityView(window,currentCityName);
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					AlertBox.display(e1.getMessage());
				}
			});
			
			
		}
		
		GridPane.setConstraints(defendingArmyUnitsHBox,0,8);
		pageLayout.getChildren().add(defendingArmyUnitsHBox);
		
		
		
		
		

//  Stationed Armies Label 
		VBox stationedArmiesLabelHBox = new VBox(6);
		
		Label stationedArmiesLabel = new Label ("Player Armies Currently Located In "+ currentCity.getName());
		stationedArmiesLabel.setFont(Font.font("Cambria", 26));
		stationedArmiesLabel.setTextFill(Color.web("#0076a3"));
		stationedArmiesLabelHBox.getChildren().add(stationedArmiesLabel);
		
		
		

// Putting Build Label Next to Military Buildings Label 
		
		
	
		
				
				
				
				
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		GridPane.setConstraints(stationedArmiesLabelHBox, 1, 7);
		pageLayout.getChildren().add(stationedArmiesLabelHBox);
		
// Put all armies together in the city
		
		HBox stationedArmiesHBox = new HBox(6);
		for (Army a : game.getPlayer().getControlledArmies()) {
			if (a.getCurrentLocation().equals(currentCity.getName())) {
				
				
			/********/
				Hyperlink  armyButton  = new Hyperlink ();
				Image armyLogo = new Image("file:images/armylogo.png");
				ImageView armyLogoView = new ImageView(armyLogo);
				armyLogoView.setFitHeight(130);;
				armyLogoView.setFitWidth(180);
				armyButton.setGraphic(armyLogoView);
				
				
				// Adding hover text to the building
				String ttString = "---Click To View Units---\n--- Units: \n";
				for (int i = 0 ; i < a.getUnits().size() ; i++) {
					Unit u = a.getUnits().get(i);
					ttString+= "" + (i+1) + "." +" Unit Type: " + u.getType() +"; Unit Level: "+  u.getLevel() + "; Current Solider Count: " + u.getCurrentSoldierCount() + "; Max Solider Count: " + u.getMaxSoldierCount() +"\n";
					
				}
				Tooltip tt = new Tooltip(ttString);
				tt.setShowDelay(new Duration (0));
				tt.setHideDelay(new Duration (10));
				Tooltip.install(armyButton, tt);
				
				armyButton.setOnAction(e->{ 
					ViewUnits.displayUnitsOfArmy(a, game.getPlayer(), game, currentCity);
					try {
						cityView(window,currentCityName);
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						AlertBox.display(e1.getMessage());
					}
				});
				
				
				stationedArmiesHBox.getChildren().add(armyButton);
			}
		}
		
		
		GridPane.setConstraints(stationedArmiesHBox,1,8);
		pageLayout.getChildren().add(stationedArmiesHBox);
		
		
//Go to World Map View Button 
		
		Button goToMapViewButton = new Button ("World Map View");
		goToMapViewButton.setMaxHeight(40);
		goToMapViewButton.setMaxWidth(240);
		goToMapViewButton.setStyle("-fx-font: 25 arial; -fx-base: #191100;");

		
		
		Button initiateArmyButton = new Button ("Initiate Army");
		initiateArmyButton.setMaxHeight(40);
		initiateArmyButton.setMaxWidth(240);
		initiateArmyButton.setStyle("-fx-font: 25 arial; -fx-base: #191100;");

		
		initiateArmyButton.setOnAction(e ->{
			ViewUnits.displayChooseUnitToInitializeArmy(currentCity, game.getPlayer());
			try {
				cityView(window, currentCityName);
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				AlertBox.display(e1.getMessage());
			}
		});
		
		
		
		goToMapViewButton.setOnAction(e -> { 
			try {
				worldMapView(window);
			} catch (IOException e1) {
				AlertBox.display(e1.getMessage());
			}
		});

	//creating the end turn button
	Button end = new Button("End Turn ");
	end.setOnAction(e -> {game.endTurn();
		
		for (Army a : game.getPlayer().getControlledArmies()  )
		{
			if(a.getDistancetoTarget()==0 && !a.getCurrentStatus().equals(Status.MARCHING)){
				SiegingChoice.giveSiegeChoice(game , a);


			}
		}
		try {
			cityView(window,currentCityName);
		} catch (IOException ioException) {
			ioException.printStackTrace();
		}
		
		if (game.getCurrentTurnCount()>= 51) { 
			youLost(window);
		}
		else if (game.getPlayer().getControlledCities().size() == 3 ) { 
			youWon(window);
		}
	});
	end.setMaxHeight(40);
	end.setMaxWidth(240);
	end.setStyle("-fx-font: 25 arial; -fx-base: #191100;");

	//hbox containing the two  buttons
		HBox buttonsHBox = new HBox();
		buttonsHBox.setAlignment(Pos.CENTER);
		buttonsHBox.getChildren().addAll(goToMapViewButton,end,initiateArmyButton);
		buttonsHBox.setPadding(new Insets(15));
		buttonsHBox.setSpacing(15);
		
		
		
		pageLayout.setMinHeight(600);
		
		superLayout.getChildren().add(upperHBoxOfPlayerInfo);

		superLayout.getChildren().addAll(pageLayout,buttonsHBox);

		superLayout.setBackground(bg);
		
		
		Scene cityView = new Scene(superLayout ,1275, 680);

		window.setScene(cityView);


	}



public static void battleView(Stage window, Army attackingArmy, Army defendingArmy) throws IOException	{

	
	
	
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
	
	//creating main subcomponents for page layout
	
	
	GridPane pageLayout = new GridPane();

//setting background
BackgroundImage bg = new BackgroundImage(new Image("file:images/BattleViewBackground.jpeg"),
		BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT,
			BackgroundPosition.CENTER, new BackgroundSize(1.0 ,1.0,true,true, false, false) );

		
		

		
		Label logLabel = new Label (game.getBattleLog());
		
		logLabel.setTextFill(Color.web("WHITE"));
		logLabel.setMinWidth(500);
		HBox hBoxOfLog = new HBox();
		
		hBoxOfLog.setMaxHeight(800);
		hBoxOfLog.setMinHeight(800);
		hBoxOfLog.setMinWidth(500);
		hBoxOfLog.setMaxWidth(500);
		hBoxOfLog.getChildren().add(logLabel);
		hBoxOfLog.setAlignment(Pos.TOP_LEFT);
		hBoxOfLog.setBackground(new Background(new BackgroundFill( Color.BLACK, CornerRadii.EMPTY, Insets.EMPTY )));
		
		
		Button autoResolveButton = new Button ("Auto Resolve The Battle");
		autoResolveButton.setMaxHeight(40);
		autoResolveButton.setMaxWidth(500);
		autoResolveButton.setStyle("-fx-font: 25 arial; -fx-base: #191100;");


		VBox autoResolveButtonHbox = new VBox();
		
		autoResolveButtonHbox.getChildren().addAll(autoResolveButton);
		
		
		
		
		
		
		
		
		GridPane.setConstraints(hBoxOfLog,1,0 );
		pageLayout.getChildren().add(hBoxOfLog);
		
		
		
		
	
		autoResolveButton.setOnAction(e-> { 
			try {
				game.autoResolve(attackingArmy, defendingArmy);
			} catch (FriendlyFireException e1) {
				// TODO Auto-generated catch block
				AlertBox.display(e1.getMessage());
			}
			
			try {
				battleView(window,attackingArmy,defendingArmy);
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				AlertBox.display(e1.getMessage());
			}
			
			
		});
		
		
		
		VBox superLayout = new VBox();
		//superLayout.setBackground(new Background(bg));
		
		
		
	//	HBox attacking = new HBox();
	//	attacking.setMaxSize(999999999, 999999999);
		upperHBoxOfPlayerInfo.setBackground(new Background(new BackgroundFill(Color.BLACK,
                CornerRadii.EMPTY,
                Insets.EMPTY)));
		
		VBox centre = new VBox(40);
		HBox attacking1 = new HBox();
		HBox attacking2 = new HBox();
		HBox attacking3 = new HBox();
		VBox attacking = new VBox();
		
		
		VBox defending = new VBox();
		TilePane defendingTilePane = new TilePane();
// Looping on attacking army units and adding their photos


	Label attackingArmyLabel = new Label (game.getPlayer().getName()+" Attacking Army: ");
	attackingArmyLabel.setFont(Font.font("Cambria", 26));
	attackingArmyLabel.setTextFill(Color.web("Orange"));
	

	attacking.getChildren().addAll(attackingArmyLabel,attacking1,attacking2,attacking3);
// Looping on defending army units and adding their photos
			for (Unit d : defendingArmy.getUnits()) { 
				String unitType2 = "";
				Image unitLogo2 = null;
				if (d.getType().equals("Archer")) {
				unitType2 = "Archer";
				unitLogo2 = new Image("file:images/ArchersCard.png");
				}
				
				if (d.getType().equals("Infantry")){
				unitLogo2 = new Image("file:images/BarbarianCard.png");
				unitType2 = "Infantry";
				}
				
				if (d.getType().equals("Cavalry")) {
				unitLogo2 = new Image("file:images/HogRiderCard.png");
				unitType2 = "Cavalry";
				}
				
				Hyperlink  unitLogoButton2  = new Hyperlink ();
				ImageView unitLogoView2 = new ImageView(unitLogo2);
				unitLogoView2.setFitHeight(130);;
				unitLogoView2.setFitWidth(130);
				
				unitLogoButton2.setGraphic(unitLogoView2);
				
				// Adding hover text to the building
				Tooltip tt2 = new Tooltip("Unit Type: " + unitType2 +"\n Unit Level: "+  d.getLevel() + "\n Current Solider Count: " + d.getCurrentSoldierCount() + "\n Max Solider Count: " + d.getMaxSoldierCount()+"");
				tt2.setShowDelay(new Duration (0));
				tt2.setHideDelay(new Duration (10));
				Tooltip.install(unitLogoButton2, tt2);
				
				if (defendingTilePane.getChildren().size() < 21)
				defendingTilePane.getChildren().add(unitLogoButton2);
				
				
	}

			for (Unit u : attackingArmy.getUnits()) { 
				String unitType = "";
				Image unitLogo = null;
				if (u.getType().equals("Archer")) {
				unitType = "Archer";
				unitLogo = new Image("file:images/ArchersCard.png");
				}
				
				if (u.getType().equals("Infantry")){
				unitLogo = new Image("file:images/BarbarianCard.png");
				unitType = "Infantry";
				}
				
				if (u.getType().equals("Cavalry")) {
				unitLogo = new Image("file:images/HogRiderCard.png");
				unitType = "Cavalry";
				}
				
				Hyperlink  unitLogoButton  = new Hyperlink ();
				ImageView unitLogoView = new ImageView(unitLogo);
				unitLogoView.setFitHeight(130);;
				unitLogoView.setFitWidth(130);
				
				unitLogoButton.setGraphic(unitLogoView);
				
				// Adding hover text to the building
				Tooltip tt = new Tooltip("Unit Type: " + unitType +"\n Unit Level: "+  u.getLevel() + "\n Current Solider Count: " + u.getCurrentSoldierCount() + "\n Max Solider Count: " + u.getMaxSoldierCount()+"");
				tt.setShowDelay(new Duration (0));
				tt.setHideDelay(new Duration (10));
				Tooltip.install(unitLogoButton, tt);
				
				if (attacking1.getChildren().size()<8)
					attacking1.getChildren().addAll(unitLogoButton);
				else if (attacking2.getChildren().size() < 8 && defendingTilePane.getChildren().size() < 14)
					attacking2.getChildren().addAll(unitLogoButton);
			
				
				unitLogoButton.setOnAction(e-> {
					 viewOppenentUnits.displayOpponentUnits(u,defendingArmy,game);
						if (attackingArmy.getUnits().size() != 0 && defendingArmy.getUnits().size() == 0 ) {
							game.setBattleLog(game.getBattleLog()+ "\n------Player Occupied " + defendingArmy.getCurrentLocation()+"------");
							game.occupy(attackingArmy, defendingArmy.getCurrentLocation());
							
							for (City c : game.getAvailableCities() ) { 
								if (c.getName().equals(attackingArmy.getCurrentLocation())) {
									c.setTurnsUnderSiege(1);
								}
							}
							attackingArmy.setCurrentStatus(Status.IDLE);
							attackingArmy.setDistancetoTarget(50);
						}
						else if (attackingArmy.getUnits().size() == 0 && defendingArmy.getUnits().size() != 0){
							game.setBattleLog(game.getBattleLog()+ "\n------Player's Army Got destroyed------");
						
							for (City c : game.getAvailableCities() ) { 
								if (c.getName().equals(attackingArmy.getCurrentLocation())) {
									c.setTurnsUnderSiege(1);
								}
							}
							attackingArmy.setCurrentStatus(Status.IDLE);
							attackingArmy.setDistancetoTarget(50);
							}
					 try {
						
						battleView(window,attackingArmy,defendingArmy);
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						AlertBox.display(e1.getMessage());
					}
				});
	}

			
	Label defendingArmyLabel = new Label (defendingArmy.getCurrentLocation()+"'s Defending Army: ");
	defendingArmyLabel.setFont(Font.font("Cambria", 26));
	defendingArmyLabel.setTextFill(Color.web("Orange"));
	defending.getChildren().addAll(defendingArmyLabel,defendingTilePane);
				
	autoResolveButtonHbox.setTranslateX(500);
	
	
	
	if (attackingArmy.getUnits().size() == 0 || defendingArmy.getUnits().size() == 0) { 
		Button goToMapViewButton = new Button ("World Map View");
		goToMapViewButton.setMaxHeight(40);
		goToMapViewButton.setMaxWidth(500);
		goToMapViewButton.setStyle("-fx-font: 25 arial; -fx-base: #191100;");

		
		
		
		
		goToMapViewButton.setOnAction(e -> { 
			window.close();
			game.setBattleLog("---Battle Log: \n");
			//clearEmptyArmies();
		});
		
		autoResolveButtonHbox.getChildren().add(goToMapViewButton);
	}
	centre.getChildren().addAll(defending,attacking,autoResolveButtonHbox);
	GridPane.setConstraints(centre,0,0 );
	centre.setMinWidth(1000);
	centre.setBackground(new Background(bg));
	pageLayout.getChildren().add(centre);

	
	
	superLayout.getChildren().addAll(upperHBoxOfPlayerInfo,pageLayout);
	
	
	
	
	window.setX(0);
	window.setY(0);
	
	
	window.setTitle("Battle View");
	
	
	Scene battleView = new Scene(superLayout , 1500, 800);
	window.setScene(battleView);


	}
	

	
public static void clearEmptyArmies() { 
	if (!game.getPlayer().getControlledArmies().isEmpty()) {
		Army temp =game.getPlayer().getControlledArmies().get(0) ;
		for (Army c : game.getPlayer().getControlledArmies()) {
			if (c.getUnits().size()==0)
				temp = c;
		}
		
		if (temp.getUnits().size()==0)
			game.getPlayer().getControlledArmies().remove(temp);
		
		}
	}

	

public static void youWon(Stage window) { 
		
		BackgroundImage bg = new BackgroundImage(new Image("file:images/youwon.png"),
				BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT,
				BackgroundPosition.CENTER, new BackgroundSize(1.0 ,1.0,true,true, false, false) );

		
		
HBox pageLayout = new HBox();
		
		
		Image enteryournamelogo = new Image("file:images/youwontextlogo.png");
		ImageView enteryournamelogoView = new ImageView(enteryournamelogo);
		HBox enteryournamelogoViewVbox = new HBox();
		enteryournamelogoViewVbox.getChildren().add(enteryournamelogoView);
		enteryournamelogoViewVbox.setAlignment(Pos.TOP_CENTER);
		
		pageLayout.getChildren().add(enteryournamelogoViewVbox);

		StackPane stackPane = new StackPane();
		stackPane.setBackground(new Background(bg));
		stackPane.getChildren().addAll(enteryournamelogoViewVbox );
		Scene worldmap = new Scene(stackPane, 1275, 680);
		window.setScene(worldmap);
		window.show();

	}
	
public static void youLost(Stage window) { 
		
		BackgroundImage bg = new BackgroundImage(new Image("file:images/youlost.png"),
				BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT,
				BackgroundPosition.CENTER, new BackgroundSize(1.0 ,1.0,true,true, false, false) );

		
		
		HBox pageLayout = new HBox();
		
		
		Image enteryournamelogo = new Image("file:images/youlosttextlogo.png");
		ImageView enteryournamelogoView = new ImageView(enteryournamelogo);
		HBox enteryournamelogoViewVbox = new HBox();
		enteryournamelogoViewVbox.getChildren().add(enteryournamelogoView);
		enteryournamelogoViewVbox.setAlignment(Pos.TOP_CENTER);
		
		pageLayout.getChildren().add(enteryournamelogoViewVbox);
		
		Label label = new Label();
		label.setText("You Exceeded 50 Turns Without Conquering The World");
		label.setAlignment(Pos.BOTTOM_CENTER);
		label.setTranslateY(-200);
		label.setFont(Font.font("Cambria", 32));
		label.setTextFill(Color.web("WHITE"));
		label.setWrapText(true);

		StackPane stackPane = new StackPane();
		stackPane.setBackground(new Background(bg));
		stackPane.getChildren().addAll(enteryournamelogoViewVbox,label );
		Scene worldmap = new Scene(stackPane, 1275, 680);
		window.setScene(worldmap);
		window.show();
	}



}



