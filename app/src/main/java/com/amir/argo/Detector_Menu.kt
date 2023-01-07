package com.amir.argo

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.Switch
import android.widget.TextView
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import com.amir.argo.databinding.ActivityTextDetectorBinding

class Detector_Menu : AppCompatActivity() {
    @SuppressLint("UseSwitchCompatOrMaterialCode", "MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detector_menu)

        val text = findViewById<TextView>(R.id.textView)
        text.text = intent.getStringExtra("type")


        val themeSwitch = findViewById<Switch>(R.id.themeSwitch)
        val background = intent.getStringExtra("background")
        themeSwitch.isChecked = background.equals("backgroundImage2")

        val transperant = findViewById<View>(R.id.transperant)
        transperant.setOnClickListener{
            val intent = Intent(this,Text_Detector::class.java)
            intent.putExtra("type", "Text Detector")
            startActivity(intent)
        }

        val whitePaper = findViewById<Button>(R.id.whitePaper)
        whitePaper.setOnClickListener{
            val intent = Intent(this,whitePaper::class.java)
            intent.putExtra("type", "White Paper")
            intent.putExtra("content", getString(R.string.White_Paper_info))
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

        val privacy = findViewById<Button>(R.id.privacy)
        privacy.setOnClickListener{
            val intent = Intent(this,Paper::class.java)
            intent.putExtra("type", "Privacy")
            intent.putExtra("content", getString(R.string.Privacy_info))
            intent.putExtra("background", if(themeSwitch.isChecked) "backgroundImage2" else "backgroundImage")
            startActivity(intent)
        }

        val home = findViewById<Button>(R.id.home)
        home.setOnClickListener{
            val intent = Intent(this,MainActivity::class.java)
            intent.putExtra("background", if(themeSwitch.isChecked) "backgroundImage2" else "backgroundImage")
            startActivity(intent)
        }
        val detect = findViewById<Button>(R.id.textDetector)
        detect.setOnClickListener{
            val toast = Toast.makeText(this, "You're in Text Detector", Toast.LENGTH_LONG)
            toast.show()
        }

    }
}