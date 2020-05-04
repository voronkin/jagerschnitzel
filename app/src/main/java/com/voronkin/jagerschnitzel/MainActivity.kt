package com.voronkin.jagerschnitzel

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        setTheme(R.style.AppTheme)
        super.onCreate(savedInstanceState)
        try {
            Thread.sleep(4000)
        } catch (e: InterruptedException) {
        }
        setContentView(R.layout.activity_main)
    }
}
