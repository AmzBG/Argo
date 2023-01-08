package com.amir.argo

import android.annotation.SuppressLint
import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.Switch
import android.widget.TextView
import android.widget.Toast
import androidx.constraintlayout.widget.ConstraintLayout

class Detector_Menu : AppCompatActivity() {
    @SuppressLint("UseSwitchCompatOrMaterialCode", "MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detector_menu)

        val title = findViewById<TextView>(R.id.Title)
        title.text = intent.getStringExtra("type")

        val themeSwitch = findViewById<Switch>(R.id.themeSwitch)
        val layout = findViewById<ConstraintLayout>(R.id.layout)
        val theme = findViewById<ImageView>(R.id.theme)
        val background = intent.getStringExtra("background")

        if(background.equals("blue"))
        {
            themeSwitch.isChecked = true
            layout.setBackgroundColor(Color.rgb(21, 22, 43))
            theme.setImageResource(R.drawable.darkmode)
        }
        else
        {
            themeSwitch.isChecked = false
            layout.setBackgroundColor(Color.rgb(0, 131, 92))
            theme.setImageResource(R.drawable.lightmode)
        }
        themeSwitch.setOnCheckedChangeListener { _, isChecked ->
            if(isChecked)
            {
                layout.setBackgroundColor(Color.rgb(21, 22, 43))
                theme.setImageResource(R.drawable.darkmode)
            }
            else
            {
                layout.setBackgroundColor(Color.rgb(0, 131, 92))
                theme.setImageResource(R.drawable.lightmode)
            }
        }

        val transperant = findViewById<View>(R.id.transperant)
        transperant.setOnClickListener{
            val intent = Intent(this,Text_Detector::class.java)
            intent.putExtra("type", "Text Detector")
            intent.putExtra("background", if(themeSwitch.isChecked) "blue" else "green")
            startActivity(intent)
        }

        val whitePaper = findViewById<Button>(R.id.whitePaper)
        whitePaper.setOnClickListener{
            val intent = Intent(this,Paper::class.java)
            intent.putExtra("type", "White Paper")
            intent.putExtra("background", if(themeSwitch.isChecked) "blue" else "green")
            startActivity(intent)
        }

        val settings = findViewById<Button>(R.id.settings)
        settings.setOnClickListener{
            val intent = Intent(this,Paper::class.java)
            intent.putExtra("type", "Settings")
            intent.putExtra("content", getString(R.string.Settings_info))
            intent.putExtra("background", if(themeSwitch.isChecked) "blue" else "green")
            startActivity(intent)
        }

        val privacy = findViewById<Button>(R.id.privacy)
        privacy.setOnClickListener{
            val intent = Intent(this,Paper::class.java)
            intent.putExtra("type", "Privacy")
            intent.putExtra("content", getString(R.string.Privacy_info))
            intent.putExtra("background", if(themeSwitch.isChecked) "blue" else "green")
            startActivity(intent)
        }

        val home = findViewById<Button>(R.id.home)
        home.setOnClickListener{
            val intent = Intent(this,MainActivity::class.java)
            intent.putExtra("guide", "disappear")
            intent.putExtra("background", if(themeSwitch.isChecked) "blue" else "green")
            startActivity(intent)
        }
        val detectText = findViewById<Button>(R.id.textDetector)
        detectText.setOnClickListener{
            val toast = Toast.makeText(this, "You're in Text Detector", Toast.LENGTH_LONG)
            toast.show()
        }

    }
}