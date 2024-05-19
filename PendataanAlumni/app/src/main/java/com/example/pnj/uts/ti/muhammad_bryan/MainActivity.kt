package com.example.pnj.uts.ti.muhammad_bryan

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val loginButton = findViewById<Button>(R.id.button)

        val editUsername = findViewById<EditText>(R.id.inputEmail)
        val editPassword = findViewById<EditText>(R.id.inputPassword)

        loginButton.setOnClickListener {
            val enteredUsername = editUsername.text.toString()
            val enteredPassword = editPassword.text.toString()

            if (enteredUsername == "admin@gmail.com" && enteredPassword == "admin") {
                val intent = Intent(this, fragmentHome::class.java)
                startActivity(intent)
                finish()
            } else {
                val toast = Toast.makeText(this, "email atau password salah", Toast.LENGTH_SHORT)
                toast.show()
            }
        }
    }
}