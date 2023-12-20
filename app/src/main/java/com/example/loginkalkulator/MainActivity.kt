package com.example.loginkalkulator

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.text.method.PasswordTransformationMethod
import android.view.MotionEvent
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat

class MainActivity : AppCompatActivity() {

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sing_in)

        val etPassword = findViewById<EditText>(R.id.et_password)
        val eyeIcon = ContextCompat.getDrawable(this, R.drawable.ic_eye)

        eyeIcon?.let {
            it.setBounds(0, 0, it.intrinsicWidth, it.intrinsicHeight)
            etPassword.setCompoundDrawablesRelative(null, null, it, null)
            etPassword.compoundDrawablePadding = 10

            etPassword.setOnTouchListener { _, event ->
                if (event.action == MotionEvent.ACTION_UP) {
                    val drawableRight = 2
                    if (event.rawX >= etPassword.right - etPassword.compoundDrawables[drawableRight].bounds.width()) {
                        // Toggle password visibility
                        if (etPassword.transformationMethod == PasswordTransformationMethod.getInstance()) {
                            // Password is hidden, show it
                            etPassword.transformationMethod = null
                        } else {
                            // Password is visible, hide it
                            etPassword.transformationMethod = PasswordTransformationMethod.getInstance()
                        }
                        return@setOnTouchListener true
                    }
                }
                false
            }
        }

        val btnLogin = findViewById<Button>(R.id.button)

        btnLogin.setOnClickListener {
            val intent = Intent(this, KalkulatorActivity::class.java)
            startActivity(intent)
        }
    }
}
