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






}
