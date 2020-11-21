package com.example.hospital;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.Switch;
import android.widget.Toast;

import com.example.hospital.helperr.AppPreferencesManager;

public class MainActivity extends AppCompatActivity {

    Button btnLink;
    Button btnContact;
    Button btnLocation;
    Button btnEmer;
    Button btnTemp;
    Switch swiDarkMode;
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
        setContentView(R.layout.activity_main);
        swiDarkMode = findViewById(R.id.dMSwitch);
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
            public void onClick(View v){
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
        swiDarkMode.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                if(swiDarkMode.isChecked()) {
                    AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                    builder.setTitle("Dark Mode ligado!")
                            .setMessage("Para ligar o Dark Mode do app, é necessário que ele seja reiniciado! \n Você quer mesmo fazer isso?")
                            .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int which) {
                                    if (preferencesManager.getDarkModeState()) {
                                        darkMode(false);
                                    } else {
                                        darkMode(true);
                                    }
                                }
                            }).setNegativeButton("No", null)
                            .create().show();
                }else{
                    setTheme(R.style.AppTheme);
                }
            }
        });
    }

    private void darkMode(boolean b) {
        preferencesManager.setDarkModeState(b);
        Toast.makeText(this,"Você abilitou o Dark Mode!",Toast.LENGTH_SHORT).show();
        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(getApplicationContext(),MainActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK|Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(intent);
                finish();
            }
        },1000);
    }

}
