package com.example.multipleactivities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class Confirm : AppCompatActivity() {
    lateinit var btnConfirm: Button
    lateinit var tvConfirm: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_confirm)
        btnConfirm=findViewById(R.id.btnConfirm)
        tvConfirm=findViewById(R.id.tvConfirm)
        val intent = intent
        val data = intent.getStringArrayListExtra("data")

        tvConfirm.text = data.toString()

        btnConfirm.setOnClickListener {
            //dialog
            val intent = Intent(this, Data::class.java)
            intent.putExtra("confirmData",data)
            startActivity(intent)
        }

    }
}