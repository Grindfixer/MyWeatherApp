package android.jwn.myweatherapp.service;

import android.jwn.myweatherapp.data.Current;

public interface WeatherServiceCallback {
    void serviceSuccess(Current current);
    void serviceFailure(Exception exception);


}
