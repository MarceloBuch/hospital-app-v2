package com.example.hospital;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import androidx.annotation.Nullable;

public class Connection extends SQLiteOpenHelper {
    private static final String NAME = "dbHospital";
    private static final int VERSION = 1;

    public Connection(@Nullable Context context) {
        super(context, NAME, null, VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase dbHospital) {
        dbHospital.execSQL("create table user(id intenger primary key autoincrement, nome varchar(250) not null, CPF varchar(9) not null, telefone varchar(10) not null, numCon varchar(50))");
    }

    @Override
    public void onUpgrade(SQLiteDatabase dbHospital, int oldVersion, int newVersion) {

    }
}
