package GUI;

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

public class Instructions {

	
public static void display () { 
		
		BackgroundImage bg = new BackgroundImage(new Image("file:images/alertbox.png"),
				BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT,
				BackgroundPosition.CENTER, new BackgroundSize(1.0 ,1.0,true,true, false, false) );

		
		
		
		Stage window = new Stage(); 
		
		window.initModality(Modality.APPLICATION_MODAL);
		
		window.setTitle("Game Rules");
		
		window.setHeight(700);
		window.setWidth(1000);
		
		Label label1 = new Label();
		label1.setText("THE CONQUEROR");
		label1.setFont(Font.font("Cambria", 44));
		label1.setTextFill(Color.web("Orange"));
		label1.setWrapText(true);
		label1.setAlignment(Pos.TOP_LEFT);
		
		Label label2 = new Label();
		label2.setText("The Conqueror is a single player turn-based empire building game. A player initially chooses one historical city to start his empire with. The goal is to conquer the whole world by taking control over every other city in less than 50 turns. In order to achieve this goal, the player have the option of building various types of building in any city he has control over and also build armies in order to conquer other cities.    Good Luck in conquering the WORLD !!!");
		label2.setTextFill(Color.web("WHITE"));
		
		label2.setFont(Font.font("Cambria", 22));
		label2.setWrapText(true);
		
		
		
		
		Button closeButton= new Button("Close the window");
		closeButton.setStyle("-fx-font: 25 arial; -fx-base: #191100;");
		closeButton.setOnAction(e -> window.close());
		
		VBox layout = new VBox(100); 
		layout.getChildren().addAll(label1,label2,closeButton);
		layout.setAlignment(Pos.CENTER);
		
		layout.setBackground(new Background(bg));
		Scene scene = new Scene(layout);
		
		window.setScene(scene);
		
		window.showAndWait();
		
		
		
	}
}
