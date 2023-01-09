package com.amir.argo

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.Switch
import android.widget.Toast
import androidx.constraintlayout.widget.ConstraintLayout

open class Main_Menu : AppCompatActivity() {

    @SuppressLint("UseSwitchCompatOrMaterialCode", "MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu)

        val theme = findViewById<ImageView>(R.id.theme)
        val layout = findViewById<ConstraintLayout>(R.id.layout)
        val themeSwitch = findViewById<Switch>(R.id.themeSwitch)
        val homeicon = findViewById<ImageView>(R.id.homeicon)
        val background = intent.getStringExtra("background")

//        restoreSwitchState(this, themeSwitch)
        if (background.equals("blue"))
        {
            themeSwitch.isChecked = true
            layout.setBackgroundResource(R.color.blue)
            theme.setImageResource(R.drawable.darkmode)
            homeicon.setImageResource(R.drawable.whitehomeicon)


        }
        else {
            themeSwitch.setOnCheckedChangeListener { _, isChecked ->
                if (isChecked) {
                    themeSwitch.isChecked = true
                    layout.setBackgroundResource(R.color.blue)
                    theme.setImageResource(R.drawable.darkmode)
                    homeicon.setImageResource(R.drawable.whitehomeicon)
                } else {
                    themeSwitch.isChecked = false
                    layout.setBackgroundResource(R.color.green)
                    theme.setImageResource(R.drawable.lightmode)
                    homeicon.setImageResource(R.drawable.homeicon)
                }
            }
        }
        themeSwitch.setOnCheckedChangeListener{_, isChecked ->
            if(!isChecked)
            {
                layout.setBackgroundResource(R.color.green)
                theme.setImageResource(R.drawable.lightmode)
                homeicon.setImageResource(R.drawable.homeicon)
            }
            else
            {
                layout.setBackgroundResource(R.color.blue)
                theme.setImageResource(R.drawable.darkmode)
                homeicon.setImageResource(R.drawable.whitehomeicon)
            }
        }

        val textDetector = findViewById<Button>(R.id.textDetector)
        textDetector.setOnClickListener{
            val intent = Intent(this,Text_Detector::class.java)
            intent.putExtra("type", "Text Detector")
            intent.putExtra("background", if(themeSwitch.isChecked) "blue" else "green")
            startActivity(intent)
        }
        val transperant = findViewById<View>(R.id.transperant)
        transperant.setOnClickListener{
            val intent = Intent(this,RealMainActivity::class.java)
            intent.putExtra("guide", "disappear")
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
        val privacy = findViewById<Button>(R.id.privacy)
        privacy.setOnClickListener{
            val intent = Intent(this,Paper::class.java)
            intent.putExtra("type", "Privacy")
            intent.putExtra("content", getString(R.string.Privacy_info))
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
        val home = findViewById<Button>(R.id.home)
        home.setOnClickListener{
            val toast = Toast.makeText(this, "You're in Home", Toast.LENGTH_LONG)
            toast.show()
        }
    }
}