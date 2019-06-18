package android.jwn.myweatherapp;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.jwn.myweatherapp.data.Current;
import android.jwn.myweatherapp.service.OpenWeatherService;
import android.jwn.myweatherapp.service.WeatherServiceCallback;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements WeatherServiceCallback {


private ImageView weatherIconImageView;
private TextView temperatureTextView;
private TextView conditionTextView;
private TextView locationTextView;

private OpenWeatherService service;
private ProgressDialog dialog;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        weatherIconImageView = (ImageView)findViewById(R.id.weatherIconImageView);
        temperatureTextView = (TextView)findViewById(R.id.temperatureTextView);
        conditionTextView = (TextView)findViewById(R.id.conditionTextView);
        locationTextView = (TextView)findViewById(R.id.locationTextView);

        service = new OpenWeatherService(this);
        dialog = new ProgressDialog(this);
        dialog.setMessage("Loading...");
        dialog.show();

        service.refreshWeather("Scottsburg, IN");
    }


    @Override
    public void serviceSuccess(Current current) {
        dialog.hide();
    }

    @Override
    public void serviceFailure(Exception exception) {
        dialog.hide();
        Toast.makeText(this, exception.getMessage(), Toast.LENGTH_LONG).show();
    }
}//end MainActivity
