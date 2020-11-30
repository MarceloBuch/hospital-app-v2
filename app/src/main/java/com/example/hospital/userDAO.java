package com.example.hospital;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

public class userDAO {
    private Connection connection;
    private SQLiteDatabase dbHospital;

    public userDAO(Context context){
        connection = new Connection(context);
        dbHospital = connection.getWritableDatabase();
    }
    public boolean inserir(User user){
        ContentValues values = new ContentValues();
        values.put("nome", user.getNome());
        values.put("CPF",user.getCPF());
        values.put("telefone",user.getFone());
        values.put("numCon",user.getNumCon());
        dbHospital.insert("user",null, values);
        return true;
    }
}
