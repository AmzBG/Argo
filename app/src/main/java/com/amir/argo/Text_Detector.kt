package com.amir.argo

import android.content.ClipData
import android.content.ClipboardManager
import android.content.Intent
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.graphics.Color
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.MediaStore
import android.text.SpannableString
import android.text.Spanned
import android.text.style.ForegroundColorSpan
import android.widget.Toast
import androidx.core.view.isVisible
import androidx.databinding.DataBindingUtil
import com.amir.argo.databinding.ActivityTextDetectorBinding
import com.google.mlkit.vision.common.InputImage
import com.google.mlkit.vision.text.TextRecognition
import com.google.mlkit.vision.text.latin.TextRecognizerOptions

class Text_Detector : AppCompatActivity() {


    val recognizer = TextRecognition.getClient(TextRecognizerOptions.DEFAULT_OPTIONS)

    lateinit var binding: ActivityTextDetectorBinding

    private val REQUEST_IMAGE_CAPTURE = 1

    private var imageBitmap: Bitmap?= null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_text_detector)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_text_detector)

        binding.Title.text = intent.getStringExtra("type")

        val caution = "*Caution: Make sure the picture is shot in Portait Mode, well lit, and close to the text while using CAPTURE Mode!!"

        val cautionSpannableString = SpannableString(caution)

        val red = ForegroundColorSpan(Color.RED)
        val blue = ForegroundColorSpan(Color.BLUE)
        cautionSpannableString.setSpan(blue,43, 55, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE)
        cautionSpannableString.setSpan(red,101, 113, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE)

        val textView = binding.textView
        textView.text = cautionSpannableString


        val layout = binding.layout
        val background = intent.getStringExtra("background")
        binding.copy.isVisible = false
        if(background.equals("backgroundImage2"))
        {
            layout.setBackgroundColor(Color.rgb(21, 22, 43))
            textView.setTextColor(Color.WHITE)
        }
        else
        {
            layout.setBackgroundColor(Color.WHITE)
            textView.setTextColor(Color.BLACK)
        }

        binding.apply {

            captureImage.setOnClickListener{
                intent.putExtra("button", "capture")
                takeImage()
                textView.text = ""

            }

            uploadImage.setOnClickListener{

                intent.putExtra("button", "upload")
                val intent = Intent(Intent.ACTION_GET_CONTENT).apply { type = "image/*" }
                startActivityForResult(intent, 1)
                textView.text = ""

            }

            detectText.setOnClickListener{
                processImage()
                if (imageBitmap != null)
                    copy.isVisible = true
                if (background.equals("backgroundImage2"))
                    textView.setTextColor(Color.WHITE)
                else
                    textView.setTextColor(Color.BLACK)
            }

            copy.setOnClickListener{
                val clipboardManager = getSystemService(CLIPBOARD_SERVICE) as ClipboardManager
                val clipData = ClipData.newPlainText("nonsense_data", textView.text)
                clipboardManager.setPrimaryClip(clipData)
                Toast.makeText(this@Text_Detector, "Copied", Toast.LENGTH_SHORT).show()
            }

        }

        binding.detectorMenu.setOnClickListener{
            val intent = Intent(this, Detector_Menu::class.java)
            intent.putExtra("type", "Text Detector")
            intent.putExtra("background", background)
            startActivity(intent)
        }
    }

    private fun processImage()
    {

        if(imageBitmap!= null)
        {
            val image = imageBitmap?.let {
                InputImage.fromBitmap(it, 0)
            }

            image?.let {

                recognizer.process(it)
                    .addOnSuccessListener{
                        binding.textView.text = it.text
                    }
            }
        }

        else
        {
            Toast.makeText(this, "Please select image first", Toast.LENGTH_LONG).show()

        }

    }

    private fun takeImage()
    {
        val intent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)

        try {

            startActivityForResult(intent, REQUEST_IMAGE_CAPTURE)


        }
        catch (e: Exception){

        }


    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == REQUEST_IMAGE_CAPTURE && resultCode == RESULT_OK) {
            if (intent.getStringExtra("button").equals("capture"))
            {
                val extras: Bundle? = data?.extras
                imageBitmap = extras?.get("data") as Bitmap


                if (imageBitmap != null) {
                    binding.imageView.setImageBitmap(imageBitmap)
                }
            }
            else
            {
                val uri: Uri = data?.data ?: return
                val bytes = contentResolver.openInputStream(uri)?.readBytes() ?: return
                imageBitmap = BitmapFactory.decodeByteArray(bytes, 0, bytes.size)
                binding.imageView.setImageBitmap(imageBitmap)
            }
        }
    }
}

