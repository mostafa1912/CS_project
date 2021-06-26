package GUI;

import engine.City;
import engine.Game;
import exceptions.FriendlyCityException;
import exceptions.TargetNotReachedException;
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.control.Tooltip;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.util.Duration;
import units.Army;

public class SiegingChoice  {




    public static void giveSiegeChoice(Game game , Army army)
    {
        //creating window
        Stage window = new Stage();
        window.setResizable(false);
        window.initModality(Modality.APPLICATION_MODAL);
        window.setTitle("Please make your choice");
        window.setHeight(500);
        window.setWidth(700);



        //creating layout
        VBox layout = new VBox(100);

        BackgroundImage bg = new BackgroundImage(new Image("file:images/alertbox.png"),
                BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT,
                BackgroundPosition.CENTER, new BackgroundSize(1.0 ,1.0,true,true, false, false) );

        layout.setBackground(new Background(bg));

        //creating label

        Label label = new Label("An army has reached its target city : " + army.getTarget() + ", please choose whether you want to lay" +
                "siege to the city or continue the game  ");
        
        label.setAlignment(Pos.TOP_CENTER);
		label.setFont(Font.font("Cambria", 32));
		label.setTextFill(Color.web("WHITE"));
		label.setWrapText(true);
		
        //create choice buttons
		
		HBox buttonsHBox = new HBox(30);
		
		Hyperlink  laySiegeButton  = new Hyperlink ();	
		Image laySiegeTextLogo = new Image("file:images/laysiegetextlogo.png");
		ImageView laySiegeTextLogoView = new ImageView(laySiegeTextLogo);
		laySiegeTextLogoView.setFitHeight(60);;
		laySiegeTextLogoView.setFitWidth(200);
		laySiegeButton.setGraphic(laySiegeTextLogoView);
		
		
		
		Hyperlink  closeButton  = new Hyperlink ();
		Image closeTextLogo = new Image("file:images/continuetextlogo.png");
		ImageView closeTextLogoView = new ImageView(closeTextLogo);
		closeTextLogoView.setFitHeight(60);;
		closeTextLogoView.setFitWidth(200);
		closeButton.setGraphic(closeTextLogoView);
		
        
		buttonsHBox.setAlignment(Pos.CENTER);
        
       
        
		buttonsHBox.getChildren().addAll(laySiegeButton,closeButton);
        layout.getChildren().addAll(label,buttonsHBox);

        closeButton.setOnAction(e -> {
            window.close();

        } );
        laySiegeButton.setOnAction(e -> {
            //looking for the city object to be put in siege method
            City city;
            city = new City("sddwd");

            for (City c : game.getAvailableCities()){
                if (army.getCurrentLocation() == c.getName())
                {
                    city = c ;
                }

            }
            System.out.print(city.getName());
            try {
                game.getPlayer().laySiege(army , city);
                System.out.print("ana get hena" + army.getCurrentStatus().toString());

            } catch (TargetNotReachedException targetNotReachedException) {
                AlertBox.display("Target Not Reached ",targetNotReachedException.getMessage());
            } catch (FriendlyCityException friendlyCityException) {
                AlertBox.display("Friendly Fire ",friendlyCityException.getMessage());
            }



                   window.close();
            System.out.print("ana get hena" + army.getCurrentStatus().toString());} );






        Scene scene = new Scene(layout);
        window.setScene(scene);
        window.show();




    }


}
