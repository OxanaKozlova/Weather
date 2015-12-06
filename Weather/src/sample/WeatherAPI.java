package sample;


import net.aksingh.owmjapis.CurrentWeather;
import net.aksingh.owmjapis.OpenWeatherMap;

import java.util.ArrayList;
import java.util.StringTokenizer;


public abstract class WeatherAPI {
   protected  OpenWeatherMap weather;
   protected String city;


   public WeatherAPI(String city){
       this.city = city;
       this.weather = new OpenWeatherMap("9ca7ae2f039f2d88942a2135d26d1edd");
   }

    protected int convertToCelsius(float degreeFahrenheit){
        return (int)((degreeFahrenheit - 32)/ 1.8);
    }







    


    /*public static void azaza()
            throws IOException, MalformedURLException, JSONException {
// declaring object of "OpenWeatherMap" class



// getting current weather data for the "London" city
        CurrentWeather cwd = owm.currentWeatherByCityName("f");
byte a = 0;
DailyForecast d = owm.dailyForecastByCityName("Minsk",a);
        System.out.println(d.getForecastInstance(2).getDateTime());
//printing city name from the retrieved data
        System.out.println("City: " + cwd.getCityName());
//// printing the max./min. temperature
        System.out.println("Temperature: " + cwd.getMainInstance().getMaxTemperature()
                + "/" + cwd.getMainInstance().getMinTemperature() + "\'F   "+ cwd.getMainInstance().getTemperature());
        cwd.getWindInstance().getWindDegree();

        Tools tool = new Tools();
        tool.convertDegree2Direction(cwd.getWindInstance().getWindDegree());
        System.out.println(tool.convertDegree2Direction(cwd.getWindInstance().getWindDegree()));



    }*/
}
