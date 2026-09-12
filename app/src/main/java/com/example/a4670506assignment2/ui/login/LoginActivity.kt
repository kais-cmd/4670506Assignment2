package com.example.a4670506assignment2.ui.login

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.ProgressBar
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.a4670506assignment2.R
import com.example.a4670506assignment2.ui.dashboard.DashboardActivity
import org.koin.androidx.viewmodel.ext.android.viewModel

class LoginActivity : AppCompatActivity() {

    private val viewModel: LoginViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        val usernameEditText = findViewById<EditText>(R.id.etUsername)
        val passwordEditText = findViewById<EditText>(R.id.etPassword)
        val loginButton = findViewById<Button>(R.id.btnLogin)
        val progressBar = findViewById<ProgressBar>(R.id.progressBar)

        loginButton.setOnClickListener {
            val username = usernameEditText.text.toString().trim()
            val password = passwordEditText.text.toString().trim()

            progressBar.visibility = View.VISIBLE
            loginButton.isEnabled = false

            viewModel.login(
                username = username,
                password = password,
                onSuccess = { keypass ->
                    progressBar.visibility = View.GONE
                    loginButton.isEnabled = true

                    val intent = Intent(this, DashboardActivity::class.java)
                    intent.putExtra("KEYPASS", keypass)
                    startActivity(intent)
                },
                onError = { message ->
                    progressBar.visibility = View.GONE
                    loginButton.isEnabled = true
                    Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
                }
            )
        }
    }
}