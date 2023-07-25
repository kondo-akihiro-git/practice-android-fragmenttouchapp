package com.example.simplemusicapp

import android.graphics.Color
import android.media.MediaPlayer
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    private lateinit var mp:MediaPlayer


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        //get view
        val tv:TextView= findViewById(R.id.tv)
        val btn:Button=findViewById(R.id.btn)
        btn.setOnClickListener{
            tv.setTextColor(Color.RED)
        }
        //play music
        mp = MediaPlayer.create(this,R.raw.music)
        mp.isLooping=true
        mp.start()


    }


    override fun onResume() {
        super.onResume()
        mp.start()
    }

    override fun onPause() {
        super.onPause()
        mp.pause()

    }

    override fun onDestroy() {
        super.onDestroy()
        mp.stop()
        mp.release()
    }

}