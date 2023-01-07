package com.amir.argo

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageButton
import androidx.constraintlayout.widget.ConstraintLayout

class MainActivity : AppCompatActivity() {

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)



        val layout = findViewById<ConstraintLayout>(R.id.layout)
        val menu = findViewById<ImageButton>(R.id.menu)

        val background = intent.getStringExtra("background")
        var boolean = false
        if (background.equals("backgroundImage2")) {
            layout.setBackgroundResource(R.drawable.backgroundimage2)
            boolean = true
        }
        else
            layout.setBackgroundResource(R.drawable.backgroundimage)
        menu.setOnClickListener{
            val intent = Intent(this,Main_Menu::class.java)
            intent.putExtra("background", if(boolean) "backgroundImage2" else "backgroundImage")
            startActivity(intent)
        }
    }
}