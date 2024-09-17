package com.example.navigation

import android.content.ComponentName
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class MyDB(context:Context ,
    name: String,
    version: Int
) : SQLiteOpenHelper ( context , name , null , version) {
    override fun onCreate(db: SQLiteDatabase?) {


        val t = "CREATE TABLE IF NOT EXISTS sv (ten text , lop text , sdt text  primary key )"
        db?.execSQL(t)




    }

    override fun onUpgrade(db: SQLiteDatabase?, p1: Int, p2: Int) {

    }


}