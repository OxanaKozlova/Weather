package sample;


import com.sun.deploy.uitoolkit.impl.fx.ui.FXMessageDialog;
import javafx.scene.control.Label;
import javafx.fxml.FXML;

import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;



import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;



public class Controller {

    @FXML
    private Label description;
    @FXML
    private ImageView currentWeatherImage;
    @FXML
    private Label humidity;
    @FXML
    private Label wind;
    @FXML
    private Label cloudiness;
    @FXML
    private Label pressure;
    @FXML
    private Label currentTemperature;
    @FXML
    private TextField city;
    @FXML
    private Label temperatureNight1;
    @FXML
    private Label temperatureNight2;
    @FXML
    private Label temperatureNight3;
    @FXML
    private Label temperatureNight4;
    @FXML
    private Label temperatureDay1;
    @FXML
    private Label temperatureDay2;
    @FXML
    private Label temperatureDay3;
    @FXML
    private Label temperatureDay4;
    @FXML
    private ImageView image1;
    @FXML
    private ImageView image2;
    @FXML
    private ImageView image3;
    @FXML
    private ImageView image4;
    @FXML
    private Label date1;
    @FXML
    private Label date2;
    @FXML
    private Label date3;
    @FXML
    private Label date4;
    @FXML
    private Label cityName;


    private CurrentWeatherAPI currentWeather;
    private DailyWeather dailyWeather;




    private static int daysCount = 5;

    public Controller() {
        currentWeather = new CurrentWeatherAPI("");
        dailyWeather = new DailyWeather("", daysCount);
    }

    public void initialize(){
        TextField l = new TextField("Minsk");
        city.setText("Minsk");
        loadData();

    }

    public void loadData(){
        getCurrentWeather();
        getDailyWeather();
        cityName.setText(currentWeather.getCityName());
    }

    boolean isCorrectCity(){
        if(currentWeather.getCityName() == null)
            return false;
        return true;
    }

    void showCityName(){
        if(isCorrectCity() == false){

        }
    }

    public void getDailyWeather(){
        dailyWeather.setDailyWeather(city.getText(), daysCount);
        getArrayDayTemperature();
        getArrayNightTemperature();
        setImages();
        setDates();
    }

    private ArrayList<Image> getArrayImage(){
        ArrayList<Image> image = new ArrayList<Image>();
        for(int i=1; i<daysCount; i++){
            image.add((i-1), new Image("http://openweathermap.org/img/w/" + dailyWeather.getLogo(i) + ".png"));
        }
        return image;
    }

    private  ArrayList<ImageView> getArrayImageView(){
        ArrayList<ImageView> imagesDailyWeather = new ArrayList<ImageView>();
        imagesDailyWeather.add(image1);
        imagesDailyWeather.add(image2);
        imagesDailyWeather.add(image3);
        imagesDailyWeather.add(image4);
        return imagesDailyWeather;
    }

    private void setImages( ){
        ArrayList<ImageView> imagesDailyWeather =getArrayImageView();
        ArrayList<Image> image = getArrayImage();
        for(int i=1; i<daysCount; i++){
            imagesDailyWeather.get(i-1).setImage(image.get(i-1));
        }
    }

   private void getArrayDayTemperature(){
       ArrayList<Label>labelDay = new ArrayList<Label>();
       labelDay.add(0,temperatureDay1);
       labelDay.add(1,temperatureDay2);
       labelDay.add(2,temperatureDay3);
       labelDay.add(3,temperatureDay4);
       for(int i = 1; i<daysCount;i++ ){
           labelDay.get(i-1).setText(dailyWeather.getTemperatureDay(i));
       }
   }

    private void getArrayNightTemperature(){
        ArrayList<Label>labelNight = new ArrayList<Label>();
        labelNight.add(0,temperatureNight1);
        labelNight.add(1,temperatureNight2);
        labelNight.add(2,temperatureNight3);
        labelNight.add(3,temperatureNight4);

        for(int i = 1; i<daysCount;i++ ){
            labelNight.get(i-1).setText(dailyWeather.getTemperatureNight(i));
        }
    }

    private void getCurrentWeather(){
        currentWeather.setCurrentWeather(city.getText());
        description.setText(currentWeather.getDescription());
        currentWeatherImage.setImage(new Image("http://openweathermap.org/img/w/" + currentWeather.getLogo() + ".png"));
        cloudiness.setText("Cloudiness: " + currentWeather.getCloud());
        pressure.setText("Pressure: " + currentWeather.getPressure());
        wind.setText("Wind: " + currentWeather.getWindSpeed());
        humidity.setText("Humidity: " + currentWeather.getHumidity());
        currentTemperature.setText(currentWeather.getCurrentTemperature());
    }

    private void setDates(){
        Calendar today = new GregorianCalendar();
        SimpleDateFormat format1 = new SimpleDateFormat("dd.MM.yyyy");
        ArrayList<Label> dateLabels = getDateLabel();
        for(int i=0; i<daysCount-1 ;i++){
            today.add(Calendar.DAY_OF_YEAR, 1);
            dateLabels.get(i).setText(format1.format(today.getTime()));
        }
    }

    private ArrayList<Label> getDateLabel(){
        ArrayList<Label> dateLabels = new ArrayList<Label>();
        dateLabels.add(date1);
        dateLabels.add(date2);
        dateLabels.add(date3);
        dateLabels.add(date4);
        return dateLabels;
    }
}
