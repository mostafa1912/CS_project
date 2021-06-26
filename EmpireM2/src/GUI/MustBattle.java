package GUI;

import java.io.IOException;

import engine.City;
import engine.Game;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Modality;
import javafx.stage.Stage;
import units.Army;

public class MustBattle {
	
	
public static void displayYouMustBattleWindow (Game g, City c, Army army ) { 
		
		BackgroundImage bg = new BackgroundImage(new Image("file:images/alertbox.png"),
				BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT,
				BackgroundPosition.CENTER, new BackgroundSize(1.0 ,1.0,true,true, false, false) );

		
		
		
		Stage window = new Stage(); 
		
		window.initModality(Modality.APPLICATION_MODAL);
		
		window.setTitle("You Must Go To Battle View");
		
		window.setHeight(350);
		window.setWidth(500);
		
		Label label = new Label();
		label.setText("After Besieging A City For 3 Round You, The Battle Starts Automatically");
		label.setAlignment(Pos.TOP_CENTER);
		label.setFont(Font.font("Cambria", 32));
		label.setTextFill(Color.web("WHITE"));
		label.setWrapText(true);
		
		Button closeButton= new Button("GO TO BATTLE VIEW");
		closeButton.setStyle("-fx-font: 25 arial; -fx-base: #191100;");
		closeButton.setOnAction(e->{
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
		
		VBox layout = new VBox(100); 
		layout.getChildren().addAll(label,closeButton);
		layout.setAlignment(Pos.CENTER);
		
		layout.setBackground(new Background(bg));
		Scene scene = new Scene(layout);
		
		window.setScene(scene);
		
		window.showAndWait();
		
		
		
	}
	

}
