package com.sameer.myprojects.yclass

import android.os.Bundle
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.sameer.myprojects.R

class Stylishphotoframe : AppCompatActivity() {

var currentimg = 0
    lateinit var img:ImageView
    val names = arrayOf("vijay","NTR","Rohit","Surya")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_stylishphotoframe)
        val prev= findViewById<ImageButton>(R.id.imageprev)
        val next = findViewById<ImageButton>(R.id.imagenext)
        val text = findViewById<TextView>(R.id.textname)
        prev.setOnClickListener{
            val idcurrentimagestring = "pic$currentimg"
            //convert string id to integer address asociated with it
            val idcurrentimgintshow = this.resources.getIdentifier(idcurrentimagestring,"id",packageName)
            img = findViewById(idcurrentimgintshow)
            img.alpha =0f

            currentimg=(4+currentimg-1)%4
            val idccurrentshow = "pic$currentimg"
            //convert string id to integer address asociated with it
            val imgtoshow= this.resources.getIdentifier(idccurrentshow,"id",packageName)
            img = findViewById(imgtoshow)
            img.alpha =1f
            text.text=names[currentimg]


        }
        next.setOnClickListener{
            val idcurrentimagestring = "pic$currentimg"
            //convert string id to integer address asociated with it
            val idcurrentimgintshow = this.resources.getIdentifier(idcurrentimagestring,"id",packageName)
            img = findViewById(idcurrentimgintshow)
            img.alpha =0f

            currentimg=(4+currentimg+1)%4
            val idccurrentshow = "pic$currentimg"
            //convert string id to integer address asociated with it
            val imgtoshow= this.resources.getIdentifier(idccurrentshow,"id",packageName)
            img = findViewById(imgtoshow)
            img.alpha =1f
            text.text=names[currentimg]

        }
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}