package com.sameer.myprojects

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    val tag = "MainActivity"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        val bnt = findViewById<Button>(R.id.button)

        bnt.setOnClickListener {
            intent = Intent(this,secondactivity::class.java)
           //throw NullPointerException("demo vit")
            //val c = 10+20
            startActivity(intent)
        }
        add(10,20)
        Log.i(tag ,"activity is getting creeatead")
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }



    override fun onStart() {
        super.onStart()
        Log.e(tag,"activity is started")

    }

    override fun onStop() {
        super.onStop()
        Log.d(tag,"activity is stopped")
    }

    override fun onPause() {
        super.onPause()
        Log.w(tag,"activity is paused")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.v(tag,"activity is destroyed")
    }
    fun add(a:Int,B:Int){
        val c = a+B
        mul(a,B)
    }
    fun mul(a:Int ,B:Int){
        div(a,B)
    }
    fun div(a:Int,B:Int){
        val c = a/B;
    }

}