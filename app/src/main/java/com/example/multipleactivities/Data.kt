package com.example.multipleactivities

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AlertDialog
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class Data : AppCompatActivity() {
    lateinit var myRv : RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_data)
        myRv = findViewById(R.id.recyclerView)
        val intent = intent
        val data = intent.getStringArrayListExtra("confirmData")
        myRv.adapter = RecyclerViewAdapter(data!!)
        myRv.layoutManager = LinearLayoutManager(this)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menus, menu)
        return true
    }
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            R.id.m1 -> {
                //dialog
                showdialog()
                return true
            }
            R.id.m2 -> {
                return true
            }
        }
        return super.onOptionsItemSelected(item)
    }

    private fun showdialog(){
        val dialogBuilder = AlertDialog.Builder(this)
        val dialogView = layoutInflater.inflate(R.layout.menu_dialog, null)
        dialogBuilder.setTitle("Alert Dialog")
        dialogBuilder.setMessage("When you go?")
        dialogBuilder.setView(dialogView)
        val HomeBtn = dialogView.findViewById<Button>(R.id.homebt)
        val ExitBtn = dialogView.findViewById<Button>(R.id.exitbt)

        HomeBtn.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }

        ExitBtn.setOnClickListener {
            this.finish()
            System.exit(0)
        }
        dialogBuilder.show()
    }
}