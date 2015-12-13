package sample;


import net.aksingh.owmjapis.DailyForecast;
import java.io.IOException;

public class DailyWeather extends WeatherAPI {
    private DailyForecast dailyWeather;

    public DailyWeather(String city, int days){
        super(city);
        try {
            this.dailyWeather = this.weather.dailyForecastByCityName(city, (byte)days);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void setDailyWeather(String city, int days){
        try {
            this.dailyWeather = this.weather.dailyForecastByCityName(city, (byte)days);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
    public String getTemperatureDay(int day){
        Float temperatureF  = dailyWeather.getForecastInstance(day).getTemperatureInstance().getDayTemperature();
        Integer dayTemperature  = convertToCelsius(temperatureF);
        return ( dayTemperature.toString() + " °C");
    }

    public String getTemperatureNight(int day){
        Float temperatureF  = dailyWeather.getForecastInstance(day).getTemperatureInstance().getNightTemperature();
        Integer nightTemperature  = convertToCelsius(temperatureF);
        return ( nightTemperature.toString() + " °C");
    }

    public String getLogo(int day){
        return dailyWeather.getForecastInstance(day).getWeatherInstance(0).getWeatherIconName();
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
