package com.example.texttospeech

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.speech.tts.TextToSpeech
import android.widget.Button
import android.widget.EditText
import java.util.*

lateinit var tts: TextToSpeech

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var b1: Button = findViewById(R.id.btnSpeak)
        var e1: EditText = findViewById(R.id.edtText)

        b1.setOnClickListener {
            tts = TextToSpeech(applicationContext, TextToSpeech.OnInitListener {
                if (it == TextToSpeech.SUCCESS){
                    tts.language = Locale.US
                    tts.setSpeechRate(1.0f)
                    tts.speak(e1.text.toString(), TextToSpeech.QUEUE_ADD, null)
                }
            })
        }


    }
}