package com.sameer.myprojects.yclass

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.android.material.textfield.TextInputEditText
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import com.sameer.myprojects.R

class Sigup : AppCompatActivity() {
    private lateinit var database: DatabaseReference
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_sigup)
        val uname = findViewById<TextInputEditText>(R.id.name)
        val email = findViewById<TextInputEditText>(R.id.mail)
        val password1=findViewById<TextInputEditText>(R.id.password)
        val uid = findViewById<TextInputEditText>(R.id.id)
        val bnt = findViewById<Button>(R.id.button)
        val textview = findViewById<TextView>(R.id.textView2)

        bnt.setOnClickListener {
            val username = uname.text.toString()
            val mail = email.text.toString()
            val password = password1.text.toString()
            val uniqueid = uid.text.toString()
            val user = User(username, mail, password, uniqueid)
            database = FirebaseDatabase.getInstance().getReference("Data")
            database.child(uniqueid).setValue(user).addOnSuccessListener {
                Toast.makeText(this, "user registered", Toast.LENGTH_SHORT).show()
            }.addOnSuccessListener {
                Toast.makeText(this, "Failed ", Toast.LENGTH_SHORT).show()
            }
        }
        textview.setOnClickListener{
            val intent = Intent(this,signin::class.java)
            startActivity(intent)

        }

        enableEdgeToEdge()
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}

