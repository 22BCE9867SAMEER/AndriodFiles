package com.sameer.myprojects.yclass

import android.content.Intent
import android.os.Bundle
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.sameer.myprojects.R

class Welcome : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_welcome)
        val name = intent.getStringExtra(signin.KEY2)
        val mail = intent.getStringExtra(signin.KEY1)
        val id = intent.getStringExtra(signin.KEY3)
        val textwel = findViewById<TextView>(R.id.textwel)
        textwel.text="WELCOME" +"  "+name

        val textmail = findViewById<TextView>(R.id.textmail)
        textmail.text = "Your mail is :$mail"
       val uid = findViewById<TextView>(R.id.textname)
        uid.text = "your unique id is :$id"

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}