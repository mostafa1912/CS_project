package GUI;

import engine.Game;
import engine.Player;
import exceptions.NotEnoughGoldException;
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

public class BuildBuilding {
	
	
	
public static void  displayBuildEconomicalBuilding (Player p ,String cityName) { 
		
	
		
		BackgroundImage bg = new BackgroundImage(new Image("file:images/alertbox.png"),
				BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT,
				BackgroundPosition.CENTER, new BackgroundSize(1.0 ,1.0,true,true, false, false) );

		
		
		
		Stage window = new Stage(); 
		
		window.initModality(Modality.APPLICATION_MODAL);
		
		window.setTitle("Building a Building ");
		
		window.setHeight(500);
		window.setWidth(700);
		
		
		
		VBox layout = new VBox(100); 
		layout.setAlignment(Pos.CENTER);
		
		
		Label label = new Label();
		label.setText("Choose An Economical Building To Build");
		label.setAlignment(Pos.TOP_CENTER);
		label.setFont(Font.font("Cambria", 32));
		label.setTextFill(Color.web("WHITE"));
		label.setWrapText(true);
// HBox containing Farm Button and Market Button 
		HBox buildingsVBox = new HBox (10);
		
		Hyperlink  buildFarmButton  = new Hyperlink ();
		
		Image farmIcon = new Image("file:images/farmicon.png");
		ImageView farmIconView = new ImageView(farmIcon);
		farmIconView.setFitHeight(200);;
		farmIconView.setFitWidth(200);
		buildFarmButton.setGraphic(farmIconView);
		
		
		Tooltip tt1 = new Tooltip("Build A Farm");
		tt1.setShowDelay(new Duration (0));
		tt1.setHideDelay(new Duration (10));
		Tooltip.install(buildFarmButton, tt1);
		buildingsVBox.getChildren().add(buildFarmButton);
		Boolean x = true; 
		
		buildFarmButton.setOnAction( e -> { 
			try {
				p.build("Farm", cityName);
			} catch (NotEnoughGoldException e1) {
				// TODO Auto-generated catch block
				AlertBox.display("You don't have Enough Gold",e1.getMessage());
			}
			window.close();
		});
		
		
		
		
		Hyperlink  buildMarketButton  = new Hyperlink ();
		
		Image marketIcon = new Image("file:images/marketicon.png");
		ImageView marketIconView = new ImageView(marketIcon);
		marketIconView.setFitHeight(200);;
		marketIconView.setFitWidth(200);
		buildMarketButton.setGraphic(marketIconView);
		
		
		Tooltip tt2 = new Tooltip("Build A Market");
		tt2.setShowDelay(new Duration (0));
		tt2.setHideDelay(new Duration (10));
		Tooltip.install(buildMarketButton, tt2);
		buildingsVBox.getChildren().add(buildMarketButton);
		
		
		buildMarketButton.setOnAction( e -> { 
			try {
				p.build("Market", cityName);
			} catch (NotEnoughGoldException e1) {
				// TODO Auto-generated catch block
				AlertBox.display("You don't have Enough Gold",e1.getMessage());
			}
			window.close();
		});
		
		
		
		
		
		//closeButton.setOnAction(e -> window.close());
		
	
		layout.getChildren().addAll(label,buildingsVBox);
		layout.setAlignment(Pos.CENTER);
		
		layout.setBackground(new Background(bg));
		Scene scene = new Scene(layout);
		
		window.setScene(scene);
		
		window.showAndWait();
		
		
		
	}

public static void displayBuildMilitary(Player p, String cityName) {
	BackgroundImage bg = new BackgroundImage(new Image("file:images/alertbox.png"),
			BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT,
			BackgroundPosition.CENTER, new BackgroundSize(1.0 ,1.0,true,true, false, false) );

	
	
	
	Stage window = new Stage(); 
	
	window.initModality(Modality.APPLICATION_MODAL);
	
	window.setTitle("Building a Building ");
	
	window.setHeight(500);
	window.setWidth(700);
	
	
	
	VBox layout = new VBox(100); 
	layout.setAlignment(Pos.CENTER);
	
	
	Label label = new Label();
	label.setText("Choose A Military Building To Build");
	label.setAlignment(Pos.TOP_CENTER);
	label.setFont(Font.font("Cambria", 32));
	label.setTextFill(Color.web("WHITE"));
	label.setWrapText(true);
//HBox containing Farm Button and Market Button 
	
	HBox buildingsVBox = new HBox (10);
	
	
	
	/***/
	

	Hyperlink  buildArcheryRangeButton  = new Hyperlink ();
	
	Image ArcheryRangeIcon = new Image("file:images/archeryrangeicon.png");
	ImageView archeryRangeIconView = new ImageView(ArcheryRangeIcon);
	archeryRangeIconView.setFitHeight(200);;
	archeryRangeIconView.setFitWidth(200);
	buildArcheryRangeButton.setGraphic(archeryRangeIconView);
	
	
	Tooltip tt1 = new Tooltip("Build An Archery Range");
	tt1.setShowDelay(new Duration (0));
	tt1.setHideDelay(new Duration (10));
	Tooltip.install(buildArcheryRangeButton, tt1);
	buildingsVBox.getChildren().add(buildArcheryRangeButton);
	
	
	buildArcheryRangeButton.setOnAction( e -> { 
		try {
			p.build("Archeryrange", cityName);
		} catch (NotEnoughGoldException e1) {
			// TODO Auto-generated catch block
			AlertBox.display("You don't have Enough Gold",e1.getMessage());
		}
		window.close();
	});
	

	Hyperlink  buildInfantryButton  = new Hyperlink ();
	
	Image infantryIcon = new Image("file:images/baracksicon.png");
	ImageView infantryIconView = new ImageView(infantryIcon);
	infantryIconView.setFitHeight(200);;
	infantryIconView.setFitWidth(200);
	buildInfantryButton.setGraphic(infantryIconView);
	
	
	Tooltip tt2 = new Tooltip("Build A Barrack");
	tt2.setShowDelay(new Duration (0));
	tt2.setHideDelay(new Duration (10));
	Tooltip.install(buildInfantryButton, tt2);
	buildingsVBox.getChildren().add(buildInfantryButton);
	
	
	buildInfantryButton.setOnAction( e -> { 
		try {
			p.build("Barracks", cityName);
		} catch (NotEnoughGoldException e1) {
			// TODO Auto-generated catch block
			AlertBox.display("You don't have Enough Gold",e1.getMessage());
		}
		window.close();
	});
	
	
	
	Hyperlink  buildStableButton  = new Hyperlink ();
	
	Image stableIcon = new Image("file:images/stableicon.png");
	ImageView stableIconView = new ImageView(stableIcon);
	stableIconView.setFitHeight(200);;
	stableIconView.setFitWidth(200);
	buildStableButton.setGraphic(stableIconView);
	
	
	Tooltip tt3 = new Tooltip("Build A Stable");
	tt3.setShowDelay(new Duration (0));
	tt3.setHideDelay(new Duration (10));
	Tooltip.install(buildStableButton, tt3);
	buildingsVBox.getChildren().add(buildStableButton);
	
	
	buildStableButton.setOnAction( e -> { 
		try {
			p.build("Stable", cityName);
		} catch (NotEnoughGoldException e1) {
			// TODO Auto-generated catch block
			AlertBox.display("You don't have Enough Gold",e1.getMessage());
		}
		window.close();
	});
	
	
	
	
	
	
	
	layout.getChildren().addAll(label,buildingsVBox);
	layout.setAlignment(Pos.CENTER);
	
	layout.setBackground(new Background(bg));
	Scene scene = new Scene(layout);
	
	window.setScene(scene);
	
	window.showAndWait();
}

}
