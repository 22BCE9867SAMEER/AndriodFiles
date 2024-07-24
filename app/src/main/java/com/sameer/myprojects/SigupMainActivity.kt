package com.sameer.myprojects

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.firebase.Firebase
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase

class SigupMainActivity : AppCompatActivity() {
    private lateinit var  buttonsigup: Button
  private lateinit var password:EditText
    private lateinit var mailenter: EditText
    private lateinit var nameenter: EditText
    private lateinit var mauth : FirebaseAuth
    private lateinit var mdataref:DatabaseReference

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_sigup_main)

        mailenter = findViewById(R.id.usermail)
        nameenter = findViewById(R.id.username)
        mauth = FirebaseAuth.getInstance()
        password = findViewById(R.id.userpassword)
        buttonsigup = findViewById(R.id.usersigupbutton)



        buttonsigup.setOnClickListener {

            val mail = mailenter.text.toString()
            val password = password.text.toString()
            val name = nameenter.text.toString()

            sigup(name,mail,password)
        }






        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }

    private fun sigup(name:String,mail: String, password: String) {
        //logic for creating user
        mauth.createUserWithEmailAndPassword(mail , password)
            .addOnCompleteListener(this) {task ->
                if(task.isSuccessful){
                    //logint to the home activity
                    //this instance can add user to atunctication
                    //but we need to add the user to dsata base to access the all the user
                    addusertodatabase(name,mail,mauth.currentUser?.uid!!)
                    Toast.makeText(this,"User registered",Toast.LENGTH_SHORT).show()
                    val inetent = Intent(this,MainChatActivity::class.java)
                    finish()
                    startActivity(inetent)
                }
                else{
                    Toast.makeText(this,"some error occured ",Toast.LENGTH_SHORT).show()

                }
            }


    }

    private fun addusertodatabase(name: String, mail: String, uid: String) {
        mdataref = FirebaseDatabase.getInstance().getReference()
        mdataref.child("user").child(uid).setValue(User(name,mail,uid))


    }
}