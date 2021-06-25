package GUI;

import engine.City;
import engine.Game;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
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
import units.Army;

public class ViewCities {

	public static void displayUnCotrolledCities(Army army,Game g) {
		BackgroundImage bg = new BackgroundImage(new Image("file:images/alertbox.png"),
				BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT,
				BackgroundPosition.CENTER, new BackgroundSize(1.0 ,1.0,true,true, false, false) );

		
		
		
		Stage window = new Stage(); 
		
		window.initModality(Modality.APPLICATION_MODAL);
		
		window.setTitle("Set Target City");
		
		window.setHeight(500);
		window.setWidth(700);
		
		
		VBox layout = new VBox(100); 
		layout.setAlignment(Pos.CENTER);
		
		
		Label label = new Label();
		label.setText("Choose A City To Be The Target Of The Army");
		label.setAlignment(Pos.TOP_CENTER);
		label.setFont(Font.font("Cambria", 32));
		label.setTextFill(Color.web("WHITE"));
		label.setWrapText(true);
		
		
		HBox allUnControlledCitiesHBox = new HBox(6);
		for (City c : g.getAvailableCities() ) { 
			
		if (!g.getPlayer().getControlledCities().contains(c)){
			Hyperlink  cityButton  = new Hyperlink ();
			Image cityLogo = new Image("file:images/cairologo.jpg");
			
			if (c.getName().equals("Sparta"))
				cityLogo = new Image("file:images/spartalogo.png");
			if (c.getName().equals("Rome"))
				cityLogo = new Image("file:images/romelogo.png");
			
			
			ImageView cityLogoView = new ImageView(cityLogo);
			cityLogoView.setFitHeight(130);;
			cityLogoView.setFitWidth(180);
			
			cityButton.setGraphic(cityLogoView);
			
			allUnControlledCitiesHBox.getChildren().add(cityButton);
			
			cityButton.setOnAction(e-> { 
				g.targetCity(army,c.getName());
				window.close();
			});
			
		}}
		
		
		
		layout.getChildren().addAll(label,allUnControlledCitiesHBox);
		layout.setAlignment(Pos.CENTER);
		
		layout.setBackground(new Background(bg));
		Scene scene = new Scene(layout);
		
		window.setScene(scene);
		
		window.showAndWait();
		
		
		
	}

}
