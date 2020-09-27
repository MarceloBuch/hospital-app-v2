package com.example.hospital;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import android.Manifest;
import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.Address;
import android.location.Geocoder;
import android.location.Location;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import java.io.IOException;
import java.util.List;
import java.util.Locale;

public class activityLocation extends AppCompatActivity {

    Button btnFind;
    Button btnOpenMap;
    TextView yourLocation;
    TextView unitLocation;
    FusedLocationProviderClient fusedLocationProviderClient;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_location);
        btnFind = findViewById(R.id.btnFind);
        btnOpenMap = findViewById(R.id.btnMap);
        yourLocation = findViewById(R.id.yourLocation);
        unitLocation = findViewById(R.id.unitLocation);
        fusedLocationProviderClient = LocationServices.getFusedLocationProviderClient(this);

        btnFind.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (ActivityCompat.checkSelfPermission(activityLocation.this,
                        Manifest.permission.ACCESS_FINE_LOCATION) == PackageManager.PERMISSION_GRANTED) {
                    getLocation();
                } else {
                    ActivityCompat.requestPermissions(activityLocation.this,
                            new String[]{Manifest.permission.ACCESS_FINE_LOCATION}, 44);
                }
            }
        });

        btnOpenMap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Uri location = Uri.parse("geo:0,0?q=Hospital+Aviccena");
                Intent intentMapa = new Intent(Intent.ACTION_VIEW,location);
                startActivity(intentMapa);
            }
        });
    }

    private void getLocation() {
        fusedLocationProviderClient.getLastLocation().addOnCompleteListener(new OnCompleteListener<Location>() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onComplete(@NonNull Task<Location> task) {
                Location location = task.getResult();
                if(location != null){
                    try {

                        Geocoder geocoder = new Geocoder(activityLocation.this,
                                Locale.getDefault());
                        List<Address> addresses = geocoder.getFromLocation(
                                location.getLatitude(),location.getLongitude(),1
                        );
                        yourLocation.setText("Seu endereço: \n" + addresses.get(0).getAddressLine(0));
                        unitLocation.setText("Unidade mais próxima: \n R. Padre Adelino, 901 - Quarta Parada, São Paulo - SP");
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        });
    }
}
