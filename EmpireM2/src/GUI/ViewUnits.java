package GUI;

import engine.City;
import engine.Game;
import engine.Player;
import exceptions.TargetNotReachedException;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.control.Tooltip;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.util.Duration;
import units.Army;
import units.Status;
import units.Unit;

import java.io.IOException;

public class ViewUnits {

	public static void displayChooseUnitToInitializeArmy(City currentCity , Player p) {
		
		
		BackgroundImage bg = new BackgroundImage(new Image("file:images/alertbox.png"),
				BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT,
				BackgroundPosition.CENTER, new BackgroundSize(1.0 ,1.0,true,true, false, false) );

		
		
		
		Stage window = new Stage(); 
		
		window.initModality(Modality.APPLICATION_MODAL);
		
		window.setTitle("Initialize An Attacking Army");
		
		window.setHeight(500);
		window.setWidth(700);
		
		
		
		VBox layout = new VBox(100); 
		layout.setAlignment(Pos.CENTER);
		
		
		Label label = new Label();
		label.setText("Choose A Unit From "+currentCity.getName()+ "'s Defending Army \n To Initialize Your Attacking Army ");
		label.setAlignment(Pos.TOP_CENTER);
		label.setFont(Font.font("Cambria", 32));
		label.setTextFill(Color.web("WHITE"));
		label.setWrapText(true);
		
		
		
		HBox defendingArmyUnitsHBox = new HBox (15);
		
		for (Unit u : currentCity.getDefendingArmy().getUnits()) { 
			
			
			String unitType = "Archer";
			Image unitLogo = new Image("file:images/archericon.png");
			
			if (u.getType().equals("Infantry")) {
				unitLogo = new Image("file:images/infantryicon.png");
				unitType = "Infantry";
			}
			
			if (u.getType().equals("Cavalry")) {
				unitLogo = new Image("file:images/cavalaryicon.png");
				unitType = "Cavalry";
			}
			
			
			Hyperlink  unitButton  = new Hyperlink ();
			
			ImageView unitLogoView = new ImageView(unitLogo);
			unitLogoView.setFitHeight(130);;
			unitLogoView.setFitWidth(130);
			
			unitButton.setGraphic(unitLogoView);
			
			// Adding hover text to the building
			Tooltip tt = new Tooltip("Unit Type: " + unitType +"\n Unit Level: "+  u.getLevel() + "\n Current Solider Count: " + u.getCurrentSoldierCount() + "\n Max Solider Count: " + u.getMaxSoldierCount());
			tt.setShowDelay(new Duration (0));
			tt.setHideDelay(new Duration (10));
			Tooltip.install(unitButton, tt);
			defendingArmyUnitsHBox.getChildren().add(unitButton);
			
			unitButton.setOnAction(e -> { 
				p.initiateArmy(currentCity, u);
				window.close();
			});
			
			
		}
		
		
		
		
		
		
		
		
		
		
		
		

		layout.getChildren().addAll(label,defendingArmyUnitsHBox);
		layout.setAlignment(Pos.CENTER);
		
		layout.setBackground(new Background(bg));
		Scene scene = new Scene(layout);
		
		window.setScene(scene);
		
		window.showAndWait();
		
	}
	
	
	public static void displayUnitsOfArmy(Army army , Player p,Game g,City c) {
		


		BackgroundImage bg = new BackgroundImage(new Image("file:images/alertbox.png"),
				BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT,
				BackgroundPosition.CENTER, new BackgroundSize(1.0 ,1.0,true,true, false, false) );

		
		
		
		Stage window = new Stage(); 
		
		window.initModality(Modality.APPLICATION_MODAL);
		
		window.setTitle("Units Of Choosen Army");
		
		window.setHeight(500);
		window.setWidth(700);
		
		
		
		VBox layout = new VBox(100); 
		layout.setAlignment(Pos.CENTER);
		
		
		Label label = new Label();
		label.setText("Click On Any Unit To Relocate It");
		label.setAlignment(Pos.TOP_CENTER);
		label.setFont(Font.font("Cambria", 32));
		label.setTextFill(Color.web("WHITE"));
		label.setWrapText(true);
		
		

		HBox defendingArmyUnitsHBox = new HBox (15);
		
		for (Unit u : army.getUnits()) { 
			
			
			String unitType = "Archer";
			Image unitLogo = new Image("file:images/archericon.png");
			
			if (u.getType().equals("Infantry")) {
				unitLogo = new Image("file:images/infantryicon.png");
				unitType = "Infantry";
			}
			
			if (u.getType().equals("Cavalry")) {
				unitLogo = new Image("file:images/cavalaryicon.png");
				unitType = "Cavalry";
			}
			
			
			Hyperlink  unitButton  = new Hyperlink ();
			
			ImageView unitLogoView = new ImageView(unitLogo);
			unitLogoView.setFitHeight(130);;
			unitLogoView.setFitWidth(130);
			
			unitButton.setGraphic(unitLogoView);
			
			// Adding hover text to the building
			Tooltip tt = new Tooltip("Unit Type: " + unitType +"\n Unit Level: "+  u.getLevel() + "\n Current Solider Count: " + u.getCurrentSoldierCount() + "\n Max Solider Count: " + u.getMaxSoldierCount());
			tt.setShowDelay(new Duration (0));
			tt.setHideDelay(new Duration (10));
			Tooltip.install(unitButton, tt);
			defendingArmyUnitsHBox.getChildren().add(unitButton);
			
			unitButton.setOnAction(e -> { 
				RelocateUnit.displayRelocateUnitScreen(p.getControlledArmies(),u,g,c.getName());
				window.close();
			});
			
			
			
		}
		
		
		
		/**/
		
		Hyperlink  setTargetButton  = new Hyperlink ();
		
		Image setTargetTextLogo = new Image("file:images/setarmytargettextlogo.png");
		ImageView setTargetTextLogoView = new ImageView(setTargetTextLogo);
		setTargetTextLogoView.setFitHeight(60);;
		setTargetTextLogoView.setFitWidth(200);
		setTargetButton.setGraphic(setTargetTextLogoView);
		
		
		Tooltip tt2 = new Tooltip("Set Target Of Army");
		tt2.setShowDelay(new Duration (0));
		tt2.setHideDelay(new Duration (10));
		Tooltip.install(setTargetButton, tt2);
		
		
		setTargetButton.setOnAction(e->{ 
			ViewCities.displayUnCotrolledCities(army,g);
			window.close();
		});
		
		//creating attack button
		

		HBox buttonsHBox = new HBox();

		if (!army.getTarget().isBlank()) {
			Hyperlink  attackButton  = new Hyperlink ();
			
			Image attackTextLogo = new Image("file:images/attacktextlogo.png");
			ImageView attackTextLogoLogoView = new ImageView(attackTextLogo);
			attackTextLogoLogoView.setFitHeight(60);;
			attackTextLogoLogoView.setFitWidth(200);
			attackButton.setGraphic(attackTextLogoLogoView);
			
			
			Tooltip tt3 = new Tooltip("Attack");
			tt3.setShowDelay(new Duration (0));
			tt3.setHideDelay(new Duration (10));
			Tooltip.install(attackButton, tt3);
			attackButton.setOnAction(e -> {
				City city = null;
				for (City c1 : g.getAvailableCities()){
					if(c.getName() == c1.getName())
						city = c1;
				}
	
				
				try {
					window.setX(0);
					window.setY(0);
					window.setWidth(1500);
					window.setHeight(800);
					
					window.setTitle("Battle View");
					
					HomeScreen.battleView(window, army , city.getDefendingArmy() );
				} catch (IOException ioException) {
					ioException.printStackTrace();
				}
			});
			
			buttonsHBox.getChildren().addAll(setTargetButton,attackButton);
		} 
		else { 
			buttonsHBox.getChildren().addAll(setTargetButton);
		}
		
		
		buttonsHBox.setAlignment(Pos.CENTER);
		layout.setBackground(new Background(bg));
		layout.getChildren().addAll(label,defendingArmyUnitsHBox,buttonsHBox);
		layout.setAlignment(Pos.CENTER);
		

		Scene scene = new Scene(layout);
		
		window.setScene(scene);
		window.setResizable(false);
		window.showAndWait();
		
		
		
		
		
		
	}
	
	//runs when clicking army from worldmap view
	//has set target and attack
public static void displayUnitsOfArmy(Army army , Player p,Game g,String cityName) {
		

		
		BackgroundImage bg = new BackgroundImage(new Image("file:images/alertbox.png"),
				BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT,
				BackgroundPosition.CENTER, new BackgroundSize(1.0 ,1.0,true,true, false, false) );

		
		
		
		Stage window = new Stage(); 
		
		window.initModality(Modality.APPLICATION_MODAL);
		
		window.setTitle("Units Of Choosen Army");
		
		window.setHeight(500);
		window.setWidth(700);
		
		
		
		VBox layout = new VBox(100); 
		layout.setAlignment(Pos.CENTER);
		
		
		Label label = new Label();
		label.setText("Click On Any Unit To Relocate It");
		label.setAlignment(Pos.TOP_CENTER);
		label.setFont(Font.font("Cambria", 32));
		label.setTextFill(Color.web("WHITE"));
		label.setWrapText(true);
		
		

		HBox defendingArmyUnitsHBox = new HBox (15);
		
		for (Unit u : army.getUnits()) { 
			
			
			String unitType = "Archer";
			Image unitLogo = new Image("file:images/archericon.png");
			
			if (u.getType().equals("Infantry")) {
				unitLogo = new Image("file:images/infantryicon.png");
				unitType = "Infantry";
			}
			
			if (u.getType().equals("Cavalry")) {
				unitLogo = new Image("file:images/cavalaryicon.png");
				unitType = "Cavalry";
			}
			
			
			Hyperlink  unitButton  = new Hyperlink ();
			
			ImageView unitLogoView = new ImageView(unitLogo);
			unitLogoView.setFitHeight(130);;
			unitLogoView.setFitWidth(130);
			
			unitButton.setGraphic(unitLogoView);
			
			// Adding hover text to the building
			Tooltip tt = new Tooltip("Unit Type: " + unitType +"\n Unit Level: "+  u.getLevel() + "\n Current Solider Count: " + u.getCurrentSoldierCount() + "\n Max Solider Count: " + u.getMaxSoldierCount());
			tt.setShowDelay(new Duration (0));
			tt.setHideDelay(new Duration (10));
			Tooltip.install(unitButton, tt);
			defendingArmyUnitsHBox.getChildren().add(unitButton);
			
			unitButton.setOnAction(e -> { 
				RelocateUnit.displayRelocateUnitScreen(p.getControlledArmies(),u,g,cityName);
				window.close();
			});
			
			
			
		}
		
		
		
		/**/
		
		Hyperlink  setTargetButton  = new Hyperlink ();
		
		Image setTargetTextLogo = new Image("file:images/setarmytargettextlogo.png");
		ImageView setTargetTextLogoView = new ImageView(setTargetTextLogo);
		setTargetTextLogoView.setFitHeight(60);;
		setTargetTextLogoView.setFitWidth(200);
		setTargetButton.setGraphic(setTargetTextLogoView);
		
		
		Tooltip tt2 = new Tooltip("Set Target Of Army");
		tt2.setShowDelay(new Duration (0));
		tt2.setHideDelay(new Duration (10));
		Tooltip.install(setTargetButton, tt2);
		
		
		setTargetButton.setOnAction(e->{ 
			ViewCities.displayUnCotrolledCities(army,g);
			window.close();
		});

		//creating attack button
		

		HBox buttonsHBox = new HBox();

		if (!army.getCurrentStatus().equals(Status.IDLE)) {
			Hyperlink  attackButton  = new Hyperlink ();
			
			Image attackTextLogo = new Image("file:images/attacktextlogo.png");
			ImageView attackTextLogoLogoView = new ImageView(attackTextLogo);
			attackTextLogoLogoView.setFitHeight(60);;
			attackTextLogoLogoView.setFitWidth(200);
			attackButton.setGraphic(attackTextLogoLogoView);
			
			
			Tooltip tt3 = new Tooltip("Attack");
			tt3.setShowDelay(new Duration (0));
			tt3.setHideDelay(new Duration (10));
			Tooltip.install(attackButton, tt3);
			attackButton.setOnAction(e -> {
				
				if (army.getCurrentStatus().equals(Status.MARCHING)) { 
					try {
						throw new TargetNotReachedException();
					}
					catch (TargetNotReachedException e1){ 
						AlertBox.display("TargetNotReached" , "Target Not Reached Yet");
						window.close();
					}
				}
				else {
					City city = null;
					for (City c : g.getAvailableCities()){
						if(cityName == c.getName())
							city = c;
					}
		
					
					try {
						window.setX(0);
						window.setY(0);
						window.setWidth(1500);
						window.setHeight(800);
						
						window.setTitle("Battle View");
						
						HomeScreen.battleView(window, army , city.getDefendingArmy() );
					} catch (IOException ioException) {
						ioException.printStackTrace();
					}
				}
			});
			
			buttonsHBox.getChildren().addAll(setTargetButton,attackButton);
		} 
		else { 
			buttonsHBox.getChildren().addAll(setTargetButton);
		}
		
		
		buttonsHBox.setAlignment(Pos.CENTER);
		layout.setBackground(new Background(bg));
		layout.getChildren().addAll(label,defendingArmyUnitsHBox,buttonsHBox);
		layout.setAlignment(Pos.CENTER);
		

		Scene scene = new Scene(layout);
		
		window.setScene(scene);
		window.setResizable(false);
		window.showAndWait();
		
		
		
		
		
		
	}
	

}
