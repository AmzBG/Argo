package com.amir.argo

import android.annotation.SuppressLint
import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageButton
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout

class Paper : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_paper)

        val layout = findViewById<ConstraintLayout>(R.id.layout)
        val text = findViewById<TextView>(R.id.Title)
        text.text = intent.getStringExtra("type")
        val content = findViewById<TextView>(R.id.content)
        content.text = intent.getStringExtra("content")
        var boolean = false
        val background = intent.getStringExtra("background")
        if(background.equals("blue"))
        {
            if (text.text.equals("White Paper"))
            {
                layout.setBackgroundColor(Color.WHITE)
                content.setTextColor(Color.BLACK)
                boolean = true
            }
            else
            {
                layout.setBackgroundColor(Color.rgb(21, 22, 43))
                content.setTextColor(Color.WHITE)
                boolean = true
            }
        }
        else
        {
            layout.setBackgroundColor(Color.WHITE)
            content.setTextColor(Color.BLACK)
        }
        val menu = findViewById<ImageButton>(R.id.paper_menu)
        menu.setOnClickListener{
            val intent = Intent(this,Paper_Menu::class.java)
            intent.putExtra("type", text.text)
            intent.putExtra("content", content.text)
            intent.putExtra("background", if(boolean) "blue" else "green")
            startActivity(intent)
        }
    }
}