package com.example.multipleactivities

import android.content.DialogInterface
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.*
import androidx.appcompat.app.AlertDialog

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
                showdialog()
                //Toast.makeText(applicationContext, "Check agree!!", Toast.LENGTH_SHORT).show()
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
    private fun showdialog(){
            // first we create a variable to hold an AlertDialog builder
            val dialogBuilder = AlertDialog.Builder(this)
            // here we set the message of our alert dialog
            dialogBuilder.setMessage("Check agree!!")
                    // positive button text and action
                    .setPositiveButton("OK", DialogInterface.OnClickListener { dialog, id ->
                    })
                    // negative button text and action
                    .setNegativeButton("Cancel", DialogInterface.OnClickListener { dialog, id ->
                    })
            // create dialog box
            val alert = dialogBuilder.create()
            // set title for alert dialog box
            alert.setTitle("Alert Rule")
            // show alert dialog
            alert.show()
    }
}