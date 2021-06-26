package GUI;


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
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Modality;
import javafx.stage.Stage;



public class AlertBox {
	
	public static void display (String title, String message) { 
		
		BackgroundImage bg = new BackgroundImage(new Image("file:images/alertbox.png"),
				BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT,
				BackgroundPosition.CENTER, new BackgroundSize(1.0 ,1.0,true,true, false, false) );

		
		
		
		Stage window = new Stage(); 
		
		window.initModality(Modality.APPLICATION_MODAL);
		
		window.setTitle(title);
		
		window.setHeight(350);
		window.setWidth(500);
		
		Label label = new Label();
		label.setText(message);
		label.setAlignment(Pos.TOP_CENTER);
		label.setFont(Font.font("Cambria", 32));
		label.setTextFill(Color.web("WHITE"));
		label.setWrapText(true);
		
		Button closeButton= new Button("Close the window");
		closeButton.setStyle("-fx-font: 25 arial; -fx-base: #191100;");
		closeButton.setOnAction(e -> window.close());
		
		VBox layout = new VBox(100); 
		layout.getChildren().addAll(label,closeButton);
		layout.setAlignment(Pos.CENTER);
		
		layout.setBackground(new Background(bg));
		Scene scene = new Scene(layout);
		
		window.setScene(scene);
		
		window.showAndWait();
		
		
		
	}
	
	public static void display ( String message) { 
		
		BackgroundImage bg = new BackgroundImage(new Image("file:images/alertbox.png"),
				BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT,
				BackgroundPosition.CENTER, new BackgroundSize(1.0 ,1.0,true,true, false, false) );

		
		
		
		Stage window = new Stage(); 
		
		window.initModality(Modality.APPLICATION_MODAL);
		
		window.setTitle("Error Message");
		
		window.setHeight(350);
		window.setWidth(500);
		
		Label label = new Label();
		label.setText(message);
		label.setAlignment(Pos.TOP_CENTER);
		label.setFont(Font.font("Cambria", 32));
		label.setTextFill(Color.web("WHITE"));
		label.setWrapText(true);
		
		Button closeButton= new Button("Close the window");
		closeButton.setStyle("-fx-font: 25 arial; -fx-base: #191100;");
		closeButton.setOnAction(e -> window.close());
		
		VBox layout = new VBox(100); 
		layout.getChildren().addAll(label,closeButton);
		layout.setAlignment(Pos.CENTER);
		
		layout.setBackground(new Background(bg));
		Scene scene = new Scene(layout);
		
		window.setScene(scene);
		
		window.showAndWait();
		
		
		
	}

}
