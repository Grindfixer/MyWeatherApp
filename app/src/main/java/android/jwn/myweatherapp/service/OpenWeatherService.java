package android.jwn.myweatherapp.service;

import android.os.AsyncTask;

public class OpenWeatherService {
    private WeatherServiceCallback callback;
    private String location;

    public OpenWeatherService(WeatherServiceCallback callback) {
        this.callback = callback;
    }

    public String getLocation() {
        return location;
    }

    public void refreshWeather(String location){
       new AsyncTask<String, Void, String>(){
           @Override
           protected String doInBackground(String... strings) {
               return null;
           }

           @Override
           protected void onPreExecute(String s) {
               super.onPreExecute();
           }
       }.execute(location);

    }

}//end OpenWeatherService
