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
import com.google.firebase.auth.FirebaseAuth

class SigninActivitymain : AppCompatActivity() {
    private lateinit var  buttonsigup:Button
    private lateinit var  buttonlogin:Button
    private lateinit var mailenter:EditText
    private lateinit var nameenter:EditText
    private lateinit var mauth : FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_signin_activitymain)
        buttonsigup = findViewById(R.id.buttonsiguppage)
        buttonlogin = findViewById(R.id.buttonloginpage)
        mailenter = findViewById(R.id.entermail)
        nameenter = findViewById(R.id.entername)
        mauth = FirebaseAuth.getInstance()
        supportActionBar


        buttonsigup.setOnClickListener {
            Toast.makeText(this,"opening sigup page",Toast.LENGTH_SHORT).show()
            val intent = Intent(this,SigupMainActivity::class.java)
            startActivity(intent)
        }

        buttonlogin.setOnClickListener {

           val textfrommail = mailenter.text.toString()
            val textpassword = nameenter.text.toString()
            loginuser(textfrommail ,textpassword)
        }
        


        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }

    private fun loginuser(textfrommail:String ,textpassword:String) {
        mauth.signInWithEmailAndPassword(textfrommail,textpassword)
            .addOnCompleteListener(this) {task ->
                if(task.isSuccessful){
                    //logint to the home activity
                    Toast.makeText(this,"opening Chat page",Toast.LENGTH_SHORT).show()
                    val inetent = Intent(this,MainChatActivity::class.java)
                    finish()
                    startActivity(inetent)
                }
                else{
                    Toast.makeText(this,"user doesnot exit ", Toast.LENGTH_SHORT).show()

                }
            }


    }
}