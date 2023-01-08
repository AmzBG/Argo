package com.amir.argo

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.view.isVisible

class MainActivity : AppCompatActivity() {

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val guideImage = findViewById<ImageView>(R.id.guideImage)
        val guideBar = findViewById<View>(R.id.guidebar)
        val icon = findViewById<ImageView>(R.id.icon)
        val guideContent = findViewById<TextView>(R.id.guideContent)
        val guideAppearance = intent.getStringExtra("guide")
        if (guideAppearance.equals("disappear"))
        {
            guideImage.isVisible = false
            guideBar.isVisible = false
            icon.isVisible = false
            guideContent.isVisible = false
        }
        else
        {
            guideImage.isVisible = true
            guideBar.isVisible = true
            icon.isVisible = true
            guideContent.isVisible = true
        }

        val layout = findViewById<ConstraintLayout>(R.id.layout)
        val menu = findViewById<ImageButton>(R.id.menu)

        val background = intent.getStringExtra("background")
        var boolean = false
        if (background.equals("blue")) {
            layout.setBackgroundResource(R.color.blue)
            boolean = true
        }
        else
            layout.setBackgroundResource(R.color.green)
        menu.setOnClickListener{
            val intent = Intent(this,Main_Menu::class.java)
            intent.putExtra("background", if(boolean) "blue" else "green")
            startActivity(intent)
        }
    }
}