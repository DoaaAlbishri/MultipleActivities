package com.example.multipleactivities

import android.app.Dialog
import android.content.DialogInterface
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AlertDialog
import org.w3c.dom.Text

class Confirm : AppCompatActivity() {
    lateinit var btnConfirm: Button
    lateinit var tvConfirm: TextView
    var data = ArrayList<String>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_confirm)
        btnConfirm=findViewById(R.id.btnConfirm)
        tvConfirm=findViewById(R.id.tvConfirm)
        val intent = intent
        data = intent.getStringArrayListExtra("data")!!
        println(data)
        tvConfirm.text = data.toString()

        btnConfirm.setOnClickListener {
            //dialog
            showdialog()
        }

    }

    private fun showdialog(){
        val dialogBuilder = Dialog(this)
        dialogBuilder.setTitle("Confirm")
        dialogBuilder.setContentView(R.layout.confirm_dialog)
        dialogBuilder.window?.setLayout(ViewGroup.LayoutParams.MATCH_PARENT,ViewGroup.LayoutParams.WRAP_CONTENT)
        val textView2 = dialogBuilder.findViewById<TextView>(R.id.textViewConfirm)
        val btncon = dialogBuilder.findViewById<Button>(R.id.confirmbt)
        textView2.text = tvConfirm.text
        btncon.setOnClickListener {
            val intent = Intent(this, Data::class.java)
            //println(data)
            intent.putExtra("confirmData", data)
            startActivity(intent)
        }
        dialogBuilder.show()
    }

}