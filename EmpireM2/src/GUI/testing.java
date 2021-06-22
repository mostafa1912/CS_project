package GUI;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;


public class testing extends Application {
    Stage window;
    Scene scene1 , scene2;


    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
     window = primaryStage;
     Label label1 = new Label("welcome to the first scene");
     Button button1 = new Button("go to scene 2");
     button1.setOnAction(e -> window.setScene(scene2));

        VBox layout = new VBox(20);
        layout.getChildren().addAll(label1 , button1);
        scene1 = new Scene(layout , 200,200);




        //button 2
        Button button2 = new Button("go to scene 1");
        button2.setOnAction(e -> window.setScene(scene1));
        //layout2
        StackPane layout2 = new StackPane();
        layout2.getChildren().add(button2);
        //scene 2
        scene2 = new Scene(layout2,400,300);

        window.setScene(scene1);
        window.setTitle("wwrwsr");
        window.show();


    }


}
