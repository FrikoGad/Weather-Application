package com.example.weatherapplication2;

import java.io.Serializable;

public class WeatherParameters implements Serializable {
    private String cityName;
    private boolean humidity;
    private boolean pressure;
    private boolean speedOfWind;

    public WeatherParameters(String cityName, boolean humidity, boolean pressure, boolean speedOfWind) {
        this.cityName = cityName;
        this.humidity = humidity;
        this.pressure = pressure;
        this.speedOfWind = speedOfWind;
    }

    public String getCityName(){
        return cityName;
    }
    public boolean getHumidity(){
        return humidity;
    }
    public boolean getPressure(){
        return pressure;
    }
    public boolean getSpeedOfWind(){
        return speedOfWind;
    }
}
