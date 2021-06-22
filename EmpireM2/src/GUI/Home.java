package GUI;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.stage.Stage;

import java.io.File;

public class Home extends Application {
    Stage window;
    Scene StartingView;


    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {
        //creating layout
        BorderPane Layout1_Border_pane = new BorderPane();
        //creating window stage and setting it as primary
            window = stage;
        //setting window title
            window.setTitle("The Conqueror");
        //creating the first scene and setting its layout
            StartingView = new Scene(Layout1_Border_pane );
        //setting stage size to full screen
            window.setFullScreen(true);
        //creating a background image object
        BackgroundImage home = new BackgroundImage(new Image(new File("images/gameHomeScreen.jpg").toURI().toString()) ,
                BackgroundRepeat.NO_REPEAT, BackgroundRepeat.REPEAT, BackgroundPosition.CENTER,
                new BackgroundSize(1.0 ,1.0,true,true, false, false) );
        //setting layout background
        Layout1_Border_pane.setBackground(new Background(home));
        //setting the scene for window
        window.setScene(StartingView);
        //showing stage to user
        window.show();


    }
}
