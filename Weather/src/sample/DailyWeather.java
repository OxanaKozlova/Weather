package sample;


import net.aksingh.owmjapis.DailyForecast;

import java.io.IOException;

public class DailyWeather extends WeatherAPI {
    private DailyForecast dailyWeather;

    public DailyWeather(String city, int day){
        super(city);
        try {
            this.dailyWeather = this.weather.dailyForecastByCityName(city, (byte)day);
        } catch (IOException e) {
            e.printStackTrace();
        }
       // System.out.println(dailyWeather.getRawResponse());
        //System.out.println(dailyWeather.getForecastInstance(1).getTemperatureInstance().getDayTemperature());
        //System.out.println(dailyWeather.getForecastInstance(1).getTemperatureInstance().getNightTemperature());
        //System.out.println(dailyWeather.getForecastInstance(4).getWeatherInstance(0).getWeatherIconName());



    }


    public String getNightTemperature(){
        if(this.dailyWeather.hasCityInstance() == true){
            Float maxTemperatureFahrenheit = this.dailyWeather.getForecastInstance(1).getTemperatureInstance().getNightTemperature();
            Integer maxTemperature  = convertToCelsius(maxTemperatureFahrenheit);
            return ( maxTemperature.toString() + " C");
        }
        else return null;

    }

    public String getDayTemperature(){
        if(this.dailyWeather.hasCityInstance() == true){
            Float maxTemperatureFahrenheit = dailyWeather.getForecastInstance(1).getTemperatureInstance().getDayTemperature();
            Integer maxTemperature  = convertToCelsius(maxTemperatureFahrenheit);
            return ( maxTemperature.toString() + " C");
        }
        else return null;
    }
}
