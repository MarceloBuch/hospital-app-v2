package com.example.hospital;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.widget.TextView;

import com.example.hospital.helperr.AppPreferencesManager;

public class activityTemp extends AppCompatActivity implements SensorEventListener {
    private TextView txtTemp;
    private SensorManager sensorManager;
    private Sensor tempSensor;
    private Boolean isTemperatureSensorAvailable;
    public TextView txtAva;
    AppPreferencesManager preferencesManager;

    @Override
    public final void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        preferencesManager = new AppPreferencesManager(this);
        if(preferencesManager.getDarkModeState()){
            setTheme(R.style.AppThemeDark);
        }else{
            setTheme(R.style.AppTheme);
        }
        setContentView(R.layout.activity_temp);
        txtTemp = findViewById(R.id.txtTemp);
        txtAva = findViewById(R.id.txtAva);
        sensorManager = (SensorManager) getSystemService(Context.SENSOR_SERVICE);
        if(sensorManager.getDefaultSensor(Sensor.TYPE_AMBIENT_TEMPERATURE) != null){
            tempSensor = sensorManager.getDefaultSensor(Sensor.TYPE_AMBIENT_TEMPERATURE);
        }else{
            txtTemp.setText("O sensor de temperatura não esta funcionando");
            txtAva.setText("Tente Novamente");
            isTemperatureSensorAvailable = false;
        }
    }

    @Override
    public void onSensorChanged(SensorEvent sensorEvent) {
        txtTemp.setText(sensorEvent.values[0]+" ºC");
        if (sensorEvent.values[0] >= 45){
            txtAva.setText("Ambiente com possível risco de hipertermia");
        } else if (sensorEvent.values[0] <= -5){
            txtAva.setText("Ambiente com possível risco de hipotermia");
        }
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {

    }

    @Override
    public void onResume(){
        super.onResume();
        if(isTemperatureSensorAvailable){
            sensorManager.registerListener(this,tempSensor, SensorManager.SENSOR_DELAY_NORMAL);
        }
    }

    @Override
    public void onPause() {
        super.onPause();
        if(isTemperatureSensorAvailable){
            sensorManager.unregisterListener(this);
        }
    }
}
