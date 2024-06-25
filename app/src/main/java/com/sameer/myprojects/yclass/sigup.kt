package com.sameer.myprojects.yclass

import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.android.material.textfield.TextInputEditText
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import com.sameer.myprojects.R

class sigup : AppCompatActivity() {
     lateinit var database: DatabaseReference
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_sigup)
        val uname = findViewById<TextInputEditText>(R.id.name)
        val email = findViewById<TextInputEditText>(R.id.mail)
        val password1=findViewById<TextInputEditText>(R.id.password)
        val uid = findViewById<TextInputEditText>(R.id.id)
        val bnt = findViewById<Button>(R.id.button)

        bnt.setOnClickListener {
            val user_name = uname.text.toString()
            val mail = email.text.toString()
            val password =password1.text.toString()
            val uniqueid = uid.text.toString()
            val user = User(user_name,mail,password,uniqueid)
            database=FirebaseDatabase.getInstance().getReference("Data")
            database.child(uniqueid).setValue(user).addOnSuccessListener {
                Toast.makeText(this,"user registered", Toast.LENGTH_SHORT).show()
            }.addOnSuccessListener {
                Toast.makeText(this,"Failed ",Toast.LENGTH_SHORT).show()
            }

        }
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}

