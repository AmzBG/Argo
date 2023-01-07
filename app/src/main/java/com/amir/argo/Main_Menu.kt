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
        val background = intent.getStringExtra("background")

//        restoreSwitchState(this, themeSwitch)
        if (background.equals("backgroundImage2"))
        {
            themeSwitch.isChecked = true
            layout.setBackgroundResource(R.drawable.backgroundimage2)
            theme.setImageResource(R.drawable.darkmode)
        }
        else {
            themeSwitch.setOnCheckedChangeListener { _, isChecked ->
                if (isChecked) {
                    themeSwitch.isChecked = true
                    layout.setBackgroundResource(R.drawable.backgroundimage2)
                    theme.setImageResource(R.drawable.darkmode)
                } else {
                    themeSwitch.isChecked = false
                    layout.setBackgroundResource(R.drawable.backgroundimage)
                    theme.setImageResource(R.drawable.lightmode)
                }
            }
        }
        themeSwitch.setOnCheckedChangeListener{_, isChecked ->
            if(!isChecked)
            {
                layout.setBackgroundResource(R.drawable.backgroundimage)
                theme.setImageResource(R.drawable.lightmode)
            }
            else
            {
                layout.setBackgroundResource(R.drawable.backgroundimage2)
                theme.setImageResource(R.drawable.darkmode)
            }
        }

        val textDetector = findViewById<Button>(R.id.textDetector)
        textDetector.setOnClickListener{
            val intent = Intent(this,textDetector::class.java)
            intent.putExtra("background", if(themeSwitch.isChecked) "backgroundImage2" else "backgroundImage")
            startActivity(intent)
        }
        val transperant = findViewById<View>(R.id.transperant)
        transperant.setOnClickListener{
            val intent = Intent(this,MainActivity::class.java)
            intent.putExtra("background", if(themeSwitch.isChecked) "backgroundImage2" else "backgroundImage")
            startActivity(intent)
        }

        val whitePaper = findViewById<Button>(R.id.whitePaper)
        whitePaper.setOnClickListener{
            val intent = Intent(this,Paper::class.java)
            intent.putExtra("type", "White Paper")
            intent.putExtra("content", getString(R.string.White_Paper_info))
            intent.putExtra("background", if(themeSwitch.isChecked) "backgroundImage2" else "backgroundImage")
            startActivity(intent)
        }
        val privacy = findViewById<Button>(R.id.privacy)
        privacy.setOnClickListener{
            val intent = Intent(this,Paper::class.java)
            intent.putExtra("type", "Privacy")
            intent.putExtra("content", getString(R.string.Privacy_info))
            intent.putExtra("background", if(themeSwitch.isChecked) "backgroundImage2" else "backgroundImage")
            startActivity(intent)
        }
        val settings = findViewById<Button>(R.id.settings)
        settings.setOnClickListener{
            val intent = Intent(this,Paper::class.java)
            intent.putExtra("type", "Settings")
            intent.putExtra("content", getString(R.string.Settings_info))
            intent.putExtra("background", if(themeSwitch.isChecked) "backgroundImage2" else "backgroundImage")
            startActivity(intent)
        }
        val home = findViewById<Button>(R.id.home)
        home.setOnClickListener{
            val toast = Toast.makeText(this, "You're in Home", Toast.LENGTH_LONG)
            toast.show()
        }
    }
}