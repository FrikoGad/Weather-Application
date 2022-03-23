package com.example.weatherapplication2;

import static com.example.weatherapplication2.MainActivity.FROM_SECOND_ACTIVITY;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

public class SecondActivity extends AppCompatActivity {

    private TextView city;
    private TextView temperature;
    private TextView humidity;
    private TextView pressure;
    private TextView speedOfWind;

    public static void startSecondActivity(@NonNull Context context, WeatherParameters wp) {
        Intent intent = new Intent(context, SecondActivity.class);
        context.startActivity(intent.putExtra(FROM_SECOND_ACTIVITY, wp));
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        initView();

        if (getIntent() != null && getIntent().getExtras() != null) {
            WeatherParameters wp = (WeatherParameters) getIntent().getSerializableExtra(FROM_SECOND_ACTIVITY);
            city.setText(wp.getCityName());
            humidity.setVisibility(wp.getHumidity() ? View.VISIBLE : View.GONE);
            pressure.setVisibility(wp.getPressure() ? View.VISIBLE : View.GONE);
            speedOfWind.setVisibility(wp.getSpeedOfWind() ? View.VISIBLE : View.GONE);
        }
    }

    private void initView() {
        city = findViewById(R.id.tv_city_name);
        temperature = findViewById(R.id.tv_temperature);
        humidity = findViewById(R.id.tv_humidity);
        pressure = findViewById(R.id.tv_pressure);
        speedOfWind = findViewById(R.id.tv_speed_of_wind);
    }
}
