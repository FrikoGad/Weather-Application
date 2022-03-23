package com.example.weatherapplication2;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    public static final String FROM_SECOND_ACTIVITY = "FROM_SECOND_ACTIVITY";

    private EditText cityName;
    private Button nextActivityButton;
    private TextView weather;
    private CheckBox humidity;
    private CheckBox pressure;
    private CheckBox speedOfWind;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        nextActivityButton.setOnClickListener(view -> onSaveAndFinishClicked());
    }

    @SuppressLint("WrongViewCast")
    private void initView() {
        cityName = findViewById(R.id.et_city_name);
        nextActivityButton = findViewById(R.id.btn_buttonSearch);
        weather = findViewById(R.id.tv_weather);
        humidity = findViewById(R.id.cb_humidity);
        pressure = findViewById(R.id.cb_pressure);
        speedOfWind = findViewById(R.id.cb_speed_of_wind);
    }

    private void onSaveAndFinishClicked() {
        if (cityName.getText().toString().length() == 0) {
            Toast.makeText(this, "City cannot be empty", Toast.LENGTH_SHORT).show();
        } else {
            WeatherParameters wp = new WeatherParameters(cityName.getText().toString(), humidity.isChecked(), pressure.isChecked(), speedOfWind.isChecked());
            SecondActivity.startSecondActivity(this, wp);
        }
    }
}