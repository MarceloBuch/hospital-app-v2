package com.example.hospital;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class activityContact extends AppCompatActivity {

    Button btnCall;
    Button btnSearchMap;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact);
        btnCall =findViewById(R.id.btnCall);
        btnSearchMap = findViewById(R.id.btnSearchMap);

        btnCall.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Uri uri = Uri.parse("tel:1126020000");
                Intent inCall = new Intent(Intent.ACTION_DIAL,uri);
                startActivity(inCall);
            }
        });
        btnSearchMap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Uri uriLocation = Uri.parse("geo:0,0?q=Hospital+Aviccena");
                Intent OpenMap = new Intent(Intent.ACTION_VIEW,uriLocation);
                startActivity(OpenMap);
            }
        });
    }
}
