package org.traccar.client

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class LoginActivity : AppCompatActivity() {

    companion object {
        private const val STATIC_PASSWORD = "mySecret123" // Fixed password known only to IT
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        val passwordInput = findViewById<EditText>(R.id.passwordInput)
        val loginButton = findViewById<Button>(R.id.loginButton)

        loginButton.setOnClickListener {
            val enteredPassword = passwordInput.text.toString()

            if (enteredPassword == STATIC_PASSWORD) {
                val intent = Intent(this, MainActivity::class.java)
                startActivity(intent)
                finish() // Ensures user can't navigate back to LoginActivity
            } else {
                Toast.makeText(this, "Incorrect Password", Toast.LENGTH_SHORT).show()
            }
        }
    }
}