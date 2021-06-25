package GUI;

import java.util.ArrayList;

import engine.City;
import engine.Game;
import engine.Player;
import exceptions.MaxCapacityException;
import javafx.geometry.Pos;
import javafx.scene.Scene;
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
import units.Unit;

public class RelocateUnit {

	
	public static void displayRelocateUnitScreen(ArrayList <Army> avaliableArmies , Unit u, Game game,City currentCity) {
		
		
		BackgroundImage bg = new BackgroundImage(new Image("file:images/alertbox.png"),
				BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT,
				BackgroundPosition.CENTER, new BackgroundSize(1.0 ,1.0,true,true, false, false) );

		
		
		
		Stage window = new Stage(); 
		
		window.initModality(Modality.APPLICATION_MODAL);
		
		window.setTitle("Relocate Unit");
		
		window.setHeight(500);
		window.setWidth(700);
		
		
		VBox layout = new VBox(100); 
		layout.setAlignment(Pos.CENTER);
		
		
		Label label = new Label();
		label.setText("Choose An Army From Your Controlled Armies In " + currentCity.getName()+" For Your Choosen "+u.getType()+" To Be Relocated");
		label.setAlignment(Pos.TOP_CENTER);
		label.setFont(Font.font("Cambria", 32));
		label.setTextFill(Color.web("WHITE"));
		label.setWrapText(true);
		
		
		HBox allControlledArmiesHBox = new HBox(6);
		for (Army a : game.getPlayer().getControlledArmies()) {
			if (a.getCurrentLocation().equals(currentCity.getName()) && !u.getParentArmy().equals(a)) {
				Hyperlink  armyButtonButton  = new Hyperlink ();
				Image armyLogo = new Image("file:images/armylogo.png");
				
				ImageView armyLogoView = new ImageView(armyLogo);
				armyLogoView.setFitHeight(130);;
				armyLogoView.setFitWidth(180);
				
				armyButtonButton.setGraphic(armyLogoView);
				
				// Adding hover text to the building
				String ttString = "--- Units: \n";
				for (int i = 0 ; i < a.getUnits().size() ; i++) {
					Unit u1 = a.getUnits().get(i);
					ttString+= "" + i+1 + "." +" Unit Type: " + u1.getType() +"; Unit Level: "+  u1.getLevel() + "; Current Solider Count: " + u1.getCurrentSoldierCount() + "; Max Solider Count: " + u1.getMaxSoldierCount() +"\n";
					
				}
				Tooltip tt = new Tooltip(ttString);
				tt.setShowDelay(new Duration (0));
				tt.setHideDelay(new Duration (10));
				Tooltip.install(armyButtonButton, tt);
				
				armyButtonButton.setOnAction( e->{
					try {
						a.relocateUnit(u);
						window.close();
					} catch (MaxCapacityException e1) {
						// TODO Auto-generated catch block
						AlertBox.display("Max Capacity",e1.getMessage());
					}
				});
				
				allControlledArmiesHBox.getChildren().add(armyButtonButton);
			
		}}

		
		layout.getChildren().addAll(label,allControlledArmiesHBox);
		layout.setAlignment(Pos.CENTER);
		
		layout.setBackground(new Background(bg));
		Scene scene = new Scene(layout);
		
		window.setScene(scene);
		
		window.showAndWait();
		
		
	}
	
	
public static void displayRelocateUnitScreen(ArrayList <Army> avaliableArmies , Unit u, Game game,String currentCityName) {
		
		
		BackgroundImage bg = new BackgroundImage(new Image("file:images/alertbox.png"),
				BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT,
				BackgroundPosition.CENTER, new BackgroundSize(1.0 ,1.0,true,true, false, false) );

		
		
		
		Stage window = new Stage(); 
		
		window.initModality(Modality.APPLICATION_MODAL);
		
		window.setTitle("Relocate Unit");
		
		window.setHeight(500);
		window.setWidth(700);
		
		
		VBox layout = new VBox(100); 
		layout.setAlignment(Pos.CENTER);
		
		
		Label label = new Label();
		label.setText("Choose An Army From Your Controlled Armies In " + currentCityName+" For Your Choosen "+u.getType()+" To Be Relocated");
		label.setAlignment(Pos.TOP_CENTER);
		label.setFont(Font.font("Cambria", 32));
		label.setTextFill(Color.web("WHITE"));
		label.setWrapText(true);
		
		
		HBox allControlledArmiesHBox = new HBox(6);
		for (Army a : game.getPlayer().getControlledArmies()) {
			if (a.getCurrentLocation().equals(currentCityName) && !u.getParentArmy().equals(a)) {
				Hyperlink  armyButtonButton  = new Hyperlink ();
				Image armyLogo = new Image("file:images/armylogo.png");
				
				ImageView armyLogoView = new ImageView(armyLogo);
				armyLogoView.setFitHeight(130);;
				armyLogoView.setFitWidth(180);
				
				armyButtonButton.setGraphic(armyLogoView);
				
				// Adding hover text to the building
				String ttString = "--- Units: \n";
				for (int i = 0 ; i < a.getUnits().size() ; i++) {
					Unit u1 = a.getUnits().get(i);
					ttString+= "" + i+1 + "." +" Unit Type: " + u1.getType() +"; Unit Level: "+  u1.getLevel() + "; Current Solider Count: " + u1.getCurrentSoldierCount() + "; Max Solider Count: " + u1.getMaxSoldierCount() +"\n";
					
				}
				Tooltip tt = new Tooltip(ttString);
				tt.setShowDelay(new Duration (0));
				tt.setHideDelay(new Duration (10));
				Tooltip.install(armyButtonButton, tt);
				
				armyButtonButton.setOnAction( e->{
					try {
						a.relocateUnit(u);
						window.close();
					} catch (MaxCapacityException e1) {
						// TODO Auto-generated catch block
						AlertBox.display("Max Capacity",e1.getMessage());
					}
				});
				
				allControlledArmiesHBox.getChildren().add(armyButtonButton);
			
		}}

		
		layout.getChildren().addAll(label,allControlledArmiesHBox);
		layout.setAlignment(Pos.CENTER);
		
		layout.setBackground(new Background(bg));
		Scene scene = new Scene(layout);
		
		window.setScene(scene);
		
		window.showAndWait();
		
		
	}
}
