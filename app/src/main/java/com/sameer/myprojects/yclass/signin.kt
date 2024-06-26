package com.sameer.myprojects.yclass

import android.content.Intent
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

class signin : AppCompatActivity() {
    lateinit var databasereference:DatabaseReference
    companion object{
        const val KEY1 = "com.sameer.myprojects.yclass.mail"
        const val KEY2 = "com.sameer.myprojects.yclass.name"
        const val KEY3 = "com.sameer.myprojects.yclass.id"
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_signin)
        val bnt = findViewById<Button>(R.id.button2)
        val id = findViewById<TextInputEditText>(R.id.uid)
        bnt.setOnClickListener {
            //check the id
            //open other activity
            //welcome
            val uniqueid = id.text.toString()
            if(uniqueid.isNotEmpty()){
                readdata(uniqueid)
            }
            else{
                Toast.makeText(this,"enter userid ",Toast.LENGTH_SHORT).show()
            }


        }
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }

    private fun readdata(uniqueid: String) {
        databasereference = FirebaseDatabase.getInstance().getReference("Data")
        databasereference.child(uniqueid).get().addOnSuccessListener {
            if(it.exists()){
                val email = it.child("mail").value
                val uname = it.child("username").value
                val uid =it.child("id").value
                //val intentwelcome = Intent(this,)
                val intent = Intent(this,Welcome::class.java)
                intent.putExtra(KEY1,email.toString())
                intent.putExtra(KEY2,uname.toString())
                intent.putExtra(KEY3,uid.toString())
                startActivity(intent)


            }else{
                Toast.makeText(this,"user not found ",Toast.LENGTH_SHORT).show()

            }
        }.addOnFailureListener{
            Toast.makeText(this,"error in database",Toast.LENGTH_SHORT).show()
        }

    }
}