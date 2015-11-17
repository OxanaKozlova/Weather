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


        CurrentWeatherAPI cur = new CurrentWeatherAPI("Minsk");
      /*  System.out.println(cur.getCurrentTemperature());
        System.out.println(cur.getCloud());
        System.out.println(cur.getPressure());
        System.out.println(cur.getHumidity());
        System.out.println(cur.getWindSpeed());
        cur.getLogo();
        cur.getDescription();*/
        DailyWeather d = new DailyWeather("Minsk",5);



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
