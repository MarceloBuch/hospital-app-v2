package com.example.hospital;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class activityRegister extends AppCompatActivity {

    private EditText nome;
    private EditText CPF;
    private EditText fone;
    private EditText numCon;
    private userDAO userDAO;
    Button btnRegister;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        nome = findViewById(R.id.ediName);
        CPF = findViewById(R.id.ediCPF);
        fone = findViewById(R.id.ediFone);
        numCon = findViewById(R.id.ediNumCon);
        btnRegister = findViewById(R.id.btnRegister);
        userDAO = new userDAO(this);
    }
    public void register(View v){
        User user = new User();
        user.setNome(nome.getText().toString());
        user.setCPF(CPF.getText().toString());
        user.setFone(fone.getText().toString());
        user.setNumCon(numCon.getText().toString());
        Toast.makeText(activityRegister.this,"Usuário cadastrado!",Toast.LENGTH_SHORT).show();
    }
}