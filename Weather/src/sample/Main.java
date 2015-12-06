package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {


    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        primaryStage.setTitle("Weather");
        primaryStage.setScene(new Scene(root));
        setWindowSize(primaryStage, 520,600);







        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }

    private void setWindowSize(Stage stage, int height, int width){
        stage.setMaxHeight(height);
        stage.setMaxWidth(width);
        stage.setMinHeight(height);
        stage.setMinWidth(width);

    }
}
