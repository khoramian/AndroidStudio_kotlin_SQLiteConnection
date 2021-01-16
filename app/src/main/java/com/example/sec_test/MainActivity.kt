package com.example.sec_test

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val context = this

        btn_insert.setOnClickListener({
            if (etvName.text.toString().length > 0 && etvAge.text.toString().length > 0) {
                var usr = user(etvName.text.toString(), etvAge.text.toString().toInt())
                var db = DatabaseHandler(context)
                db.insertData(usr)
            }else {
                Toast.makeText(context, "insertion failed", Toast.LENGTH_SHORT).show()
            }
        })
    }
}