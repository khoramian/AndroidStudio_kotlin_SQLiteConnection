package com.example.sec_test

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import android.widget.Toast
import java.security.AccessControlContext

val DATABASE_NAME = "MyDB"
val TABLE_NAME = "users"
val COL_NAME = "name"
val COL_AGE = "age"
val COL_ID = "id"

class DatabaseHandler(var context: Context) : SQLiteOpenHelper(context, DATABASE_NAME, null, 1)
{
    override fun onCreate(db: SQLiteDatabase?)
    {

        val createTable = "CREATE TABLE " + TABLE_NAME + " (" +
                COL_ID + " INTEGER PRIMARY KEY AUTOINCREMENT," +
                COL_NAME + " VARCHAR(256)," +
                COL_AGE + " INTEGER)"

        db?.execSQL(createTable)
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int)
    {
        TODO("Not yet implemented")
    }

    fun insertData(user: user)
    {
        val db = this.writableDatabase
        val cv = ContentValues()

        cv.put(COL_AGE, user.age)
        cv.put(COL_NAME, user.name)
        var result = db.insert(TABLE_NAME, null, cv)

        if (result ==-1.toLong())
            Toast.makeText(context, "insertion failed", Toast.LENGTH_SHORT).show()
        else
            Toast.makeText(context, "successfully inserted", Toast.LENGTH_SHORT).show()
    }
}