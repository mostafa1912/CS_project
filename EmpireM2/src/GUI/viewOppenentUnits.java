package GUI;

import engine.Game;
import exceptions.FriendlyFireException;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.control.Tooltip;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.Pane;
import javafx.scene.layout.TilePane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.util.Duration;
import units.Army;
import units.Unit;

public class viewOppenentUnits  {

	
	
	public static void displayOpponentUnits (Unit selectedUnit , Army defendingArmy ,Game g) { 
		BackgroundImage bg = new BackgroundImage(new Image("file:images/alertbox.png"),
				BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT,
				BackgroundPosition.CENTER, new BackgroundSize(1.0 ,1.0,true,true, false, false) );

		
		
		
		Stage window = new Stage(); 
		
		window.initModality(Modality.APPLICATION_MODAL);
		
		window.setTitle("Opposing Army Units ");
		
		window.setHeight(680);
		window.setWidth(1275);
		
		VBox pageLayout = new VBox(10);
		
		Label label = new Label();
		label.setText("Choose a Unit to Attack ");
		label.setAlignment(Pos.TOP_CENTER);
		label.setFont(Font.font("Cambria", 32));
		label.setTextFill(Color.web("Black"));
		label.setWrapText(true);
		pageLayout.getChildren().add(label);
		
		
		TilePane tilepane = new TilePane();
		
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
			
			
			unitLogoButton2.setOnAction(e->{ 
				try {
					selectedUnit.attack(d);
					g.setBattleLog(g.getBattleLog()+ "\n-Players Unit " +selectedUnit.getType()+ " Attacked Oppenent's Unit " + d.getType() + " \nAnd made it's count = " + d.getCurrentSoldierCount() +"\n");
				} catch (FriendlyFireException e1) {
					// TODO Auto-generated catch block
					AlertBox.display("Friendly Fire", e1.getMessage());
					
				}
				
				window.close();
			});
			
			
			tilepane.getChildren().add(unitLogoButton2);
			
		}
		
		
		
	
		
		pageLayout.getChildren().addAll(tilepane);
		
		
		Scene scene = new Scene(pageLayout);
		
		window.setScene(scene);
		window.setResizable(false);
		window.showAndWait();
		
		
		
		
		
		
		
		
	}

	
}

