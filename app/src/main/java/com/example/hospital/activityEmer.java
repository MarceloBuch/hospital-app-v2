package com.example.hospital;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.hospital.helperr.AppPreferencesManager;

public class activityEmer extends AppCompatActivity {

    Button btnEmer;
    AppPreferencesManager preferencesManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        preferencesManager = new AppPreferencesManager(this);
        if(preferencesManager.getDarkModeState()){
            setTheme(R.style.AppThemeDark);
        }else{
            setTheme(R.style.AppTheme);
        }
        setContentView(R.layout.activity_emer);
        btnEmer = findViewById(R.id.btnEmer);
        btnEmer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Uri uriCallEmer = Uri.parse("tel:192");
                Intent inCallEmer = new Intent(Intent.ACTION_DIAL,uriCallEmer);
                startActivity(inCallEmer);
            }
        });

    }
}
