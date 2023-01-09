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

class Paper_Menu : AppCompatActivity() {

    @SuppressLint("UseSwitchCompatOrMaterialCode", "MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_paper_menu)


        val text = findViewById<TextView>(R.id.Title)
        text.text = intent.getStringExtra("type")
        val content = findViewById<TextView>(R.id.content)
        content.text = intent.getStringExtra("content")

        val theme = findViewById<ImageView>(R.id.theme)
        val layout = findViewById<ConstraintLayout>(R.id.layout)
        val themeSwitch = findViewById<Switch>(R.id.themeSwitch)
        val background = intent.getStringExtra("background")
        if(background.equals("blue"))
        {
            if (text.text.equals("White Paper"))
            {
                themeSwitch.isChecked = true
                layout.setBackgroundColor(Color.WHITE)
                content.setTextColor(Color.BLACK)
                theme.setImageResource(R.drawable.lightmode)
            }
            else
            {
                themeSwitch.isChecked = true
                layout.setBackgroundColor(Color.rgb(21, 22, 43))
                content.setTextColor(Color.WHITE)
                theme.setImageResource(R.drawable.darkmode)
            }
        }
        else
        {
            if (text.text.equals("White Paper"))
            {
                themeSwitch.isChecked = false
                layout.setBackgroundColor(Color.WHITE)
                content.setTextColor(Color.BLACK)
                theme.setImageResource(R.drawable.lightmode)
            }
            else
            {
                themeSwitch.isChecked = false
                layout.setBackgroundColor(Color.rgb(0, 131, 92))
                content.setTextColor(Color.BLACK)
                theme.setImageResource(R.drawable.lightmode)
            }
        }
        themeSwitch.setOnCheckedChangeListener { _, isChecked ->
            if(isChecked)
            {
                if (text.text.equals("White Paper"))
                {
                    layout.setBackgroundColor(Color.WHITE)
                    content.setTextColor(Color.BLACK)
                    theme.setImageResource(R.drawable.lightmode)
                }
                else
                {
                    layout.setBackgroundColor(Color.rgb(21, 22, 43))
                    content.setTextColor(Color.WHITE)
                    theme.setImageResource(R.drawable.darkmode)
                }
            }
            else
            {
                layout.setBackgroundColor(Color.rgb(0, 131, 92))
                content.setTextColor(Color.BLACK)
                theme.setImageResource(R.drawable.lightmode)
            }
        }

        val transperant = findViewById<View>(R.id.transperant)
        transperant.setOnClickListener{
            val intent = Intent(this,Paper::class.java)
            intent.putExtra("type", text.text)
            intent.putExtra("content", content.text)
            intent.putExtra("background", if(themeSwitch.isChecked) "blue" else "green")
            startActivity(intent)
        }

        val textDetector = findViewById<Button>(R.id.textDetector)
        textDetector.setOnClickListener{
            val intent = Intent(this,Text_Detector::class.java)
            intent.putExtra("type", "Text Detector")
            intent.putExtra("background", if(themeSwitch.isChecked) "blue" else "green")
            startActivity(intent)
        }

        val whitePaper = findViewById<Button>(R.id.whitePaper)
        whitePaper.setOnClickListener{
            if (text.text.equals("White Paper")){
                    val toast = Toast.makeText(this, "You're in White Paper", Toast.LENGTH_LONG)
                    toast.show()
                }
            else
            {
                val intent = Intent(this,Paper::class.java)
                intent.putExtra("type", "White Paper")
                intent.putExtra("background", if(themeSwitch.isChecked) "blue" else "green")
                startActivity(intent)
            }
        }

        val settings = findViewById<Button>(R.id.settings)
        settings.setOnClickListener{
            if (text.text.equals("Settings")){
                val toast = Toast.makeText(this, "You're in Settings", Toast.LENGTH_LONG)
                toast.show()
            }
            else
            {
                val intent = Intent(this,Paper::class.java)
                intent.putExtra("type", "Settings")
                intent.putExtra("content", getString(R.string.Settings_info))
                intent.putExtra("background", if(themeSwitch.isChecked) "blue" else "green")
                startActivity(intent)
            }
        }

        val privacy = findViewById<Button>(R.id.privacy)
        privacy.setOnClickListener{
            if (text.text.equals("Privacy")){
                val toast = Toast.makeText(this, "You're in Privacy", Toast.LENGTH_LONG)
                toast.show()
            }
            else
            {
                val intent = Intent(this,Paper::class.java)
                intent.putExtra("type", "Privacy")
                intent.putExtra("content", getString(R.string.Privacy_info))
                intent.putExtra("background", if(themeSwitch.isChecked) "blue" else "green")
                startActivity(intent)
            }
        }

        val home = findViewById<Button>(R.id.home)
        home.setOnClickListener{
            val intent = Intent(this,RealMainActivity::class.java)
            intent.putExtra("guide", "disappear")
            intent.putExtra("background", if(themeSwitch.isChecked) "blue" else "green")
            startActivity(intent)
        }

    }
}

