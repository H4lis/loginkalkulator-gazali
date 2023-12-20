package com.example.loginkalkulator

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class Profile : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile)


        val btnLogin = findViewById<Button>(R.id.button)
        btnLogin.setOnClickListener {
            val intent = Intent(this, KalkulatorActivity::class.java)
            startActivity(intent)
        }
    }
}