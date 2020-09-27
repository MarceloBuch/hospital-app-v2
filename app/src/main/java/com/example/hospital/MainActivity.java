package com.example.hospital;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button btnLink;
    Button btnContact;
    Button btnLocation;
    Button btnEmer;
    Button btnTemp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnLink = findViewById(R.id.linkMain);
        btnContact = findViewById(R.id.btnContact);
        btnEmer = findViewById(R.id.btnEmergency);
        btnTemp = findViewById(R.id.btnTemp);
        btnLocation = findViewById(R.id.btnSearchLocation);
        btnLink.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                Uri uri = Uri.parse("http://www.aviccena.com.br/");
                Intent intentSite = new Intent(Intent.ACTION_VIEW, uri);
                startActivity(intentSite);
            }
        });
        btnContact.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent inContact = new Intent(MainActivity.this,activityContact.class);
                startActivity(inContact);
            }
        });
        btnEmer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent inEmer = new Intent(MainActivity.this,activityEmer.class);
                startActivity(inEmer);
            }
        });
        btnLocation.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                Intent inLocation = new Intent(MainActivity.this, activityLocation.class);
                startActivity(inLocation);
            }
        });
        btnTemp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent inTemp = new Intent(MainActivity.this,activityTemp.class);
                startActivity(inTemp);
            }
        });
    }

}
