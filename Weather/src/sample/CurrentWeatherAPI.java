package sample;


import java.io.IOException;
import net.aksingh.owmjapis.CurrentWeather;


public class CurrentWeatherAPI extends WeatherAPI {

     private CurrentWeather currentWeather;

    public CurrentWeatherAPI(String city) {
        super(city);
        try {
            this.currentWeather = this.weather.currentWeatherByCityName(city);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void setCurrentWeather(String cityNmae){
        try {
            this.currentWeather = this.weather.currentWeatherByCityName(cityNmae);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public String getCurrentTemperature(){
        if(this.currentWeather.hasCityCode() == true){
            Float maxTemperatureFahrenheit = this.currentWeather.getMainInstance().getMaxTemperature();
            Integer maxTemperature  = convertToCelsius(maxTemperatureFahrenheit);
            return ( maxTemperature.toString() + " °C");
        }
        else return null;
    }

    public String getCloud(){
        if(currentWeather.hasCityCode() == true){
            Integer cloud = ((int)this.currentWeather.getCloudsInstance().getPercentageOfClouds());
            return (cloud.toString() + " %");
        }
        else return null;
    }

    public String getPressure(){
        if(currentWeather.hasCityCode() == true){
            Integer pressure = ((int)this.currentWeather.getMainInstance().getPressure());
            return (pressure.toString() + "  hpa");
        }
        else return null;
    }

    public String getHumidity(){
        if(currentWeather.hasCityCode() == true){
            if(this.currentWeather.getMainInstance().hasHumidity()) {
                Integer pressure = ((int) this.currentWeather.getMainInstance().getHumidity());
                return (pressure.toString() + "  %");
            }
            else return "0 %";
        }
        else return null;
    }





    public String getWindSpeed(){
        if(this.currentWeather.hasCityCode() == true){
            if(this.currentWeather.getWindInstance().hasWindGust()){
                Integer windSpeed = (int)(currentWeather.getWindInstance().getWindSpeed()/2);
                return (windSpeed.toString()+ " m/s");
            }

        }
        return null;
    }

    public String getLogo(){

        return currentWeather.getWeatherInstance(0).getWeatherIconName();
    }

    public String getCityName(){
        return currentWeather.getCityName();

    }

    public String getDescription(){
        return currentWeather.getWeatherInstance(0).getWeatherDescription();

    }


}
