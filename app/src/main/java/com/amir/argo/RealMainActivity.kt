package com.amir.argo

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageButton
import android.widget.ImageView
import androidx.constraintlayout.widget.ConstraintLayout

class RealMainActivity : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_real_main)

        val layout = findViewById<ConstraintLayout>(R.id.layout)
        val menu = findViewById<ImageButton>(R.id.menu)
        val homeicon = findViewById<ImageView>(R.id.homeicon)

        val background = intent.getStringExtra("background")
        var boolean = false
        if (background.equals("blue")) {
            layout.setBackgroundResource(R.color.blue)
            homeicon.setImageResource(R.drawable.whitehomeicon)
            boolean = true
        }
        else
        {
            layout.setBackgroundResource(R.color.green)
            homeicon.setImageResource(R.drawable.homeicon)
        }
        menu.setOnClickListener{
            val intent = Intent(this,Main_Menu::class.java)
            intent.putExtra("background", if(boolean) "blue" else "green")
            startActivity(intent)
        }
    }
}