package GUI;

import engine.City;
import engine.Game;
import exceptions.FriendlyCityException;
import exceptions.TargetNotReachedException;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.stage.Modality;
import javafx.stage.Stage;
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
        VBox layout = new VBox();

        BackgroundImage bg = new BackgroundImage(new Image("file:images/alertbox.png"),
                BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT,
                BackgroundPosition.CENTER, new BackgroundSize(1.0 ,1.0,true,true, false, false) );

        layout.setBackground(new Background(bg));

        //creating label

        Label label = new Label("An army has reached its target city : " + army.getTarget() + ", please choose whether you want to lay" +
                "siege to the city or continue the game  ");
        //create choice buttons
        Button siegeButton = new Button("Lay siege ");
        Button close = new Button("No, continue");
        HBox buttons = new HBox();
        buttons.getChildren().addAll(siegeButton,close);
        layout.getChildren().addAll(label,buttons);

        close.setOnAction(e -> {
            window.close();

        } );
        siegeButton.setOnAction(e -> {
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
                targetNotReachedException.printStackTrace();
            } catch (FriendlyCityException friendlyCityException) {
                friendlyCityException.printStackTrace();
                AlertBox.display("Friendly City Exception","You can't lay siege to a friendly city");
            }



                   window.close();
            System.out.print("ana get hena" + army.getCurrentStatus().toString());} );






        Scene scene = new Scene(layout);
        window.setScene(scene);
        window.show();




    }


}
