package com.example.multipleactivities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.CheckBox
import android.widget.EditText
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    lateinit var ETname: EditText
    lateinit var ETloc: EditText
    lateinit var ETmobile: EditText
    lateinit var ETemail: EditText
    lateinit var saveBtn: Button
    lateinit var cb:CheckBox

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        ETname = findViewById(R.id.ETname)
        ETloc = findViewById(R.id.ETloc)
        ETmobile = findViewById(R.id.ETmobile)
        ETemail = findViewById(R.id.ETemail)
        saveBtn = findViewById(R.id.button)
        cb = findViewById<CheckBox>(R.id.checkBox)
        saveBtn.setOnClickListener {
            if (!cb.isChecked)
                //dialog
                Toast.makeText(applicationContext, "Check agree!!", Toast.LENGTH_SHORT).show()
            else {
                val intent = Intent(this, Confirm::class.java)
                intent.putExtra(
                        "data", arrayListOf(
                        ETname.text.toString(),
                        ETloc.text.toString(),
                        ETmobile.text.toString(),
                        ETemail.text.toString()
                ))
                startActivity(intent)
            }
        }
    }
}