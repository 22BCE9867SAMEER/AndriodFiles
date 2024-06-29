package com.sameer.myprojects.yclass

import android.app.Person
import android.os.Bundle
import android.widget.ListView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.sameer.myprojects.R

class Listviewandadapterproj2 : AppCompatActivity() {
    lateinit var array:ArrayList<Persons>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_listviewandadapterproj2)
        val name = arrayOf("Arjun Reddy","NTR","ROHIT","SURYA")
        val time = arrayOf("10:00AM","12:00PM","7:00PM","9:00PM")
        val imageid = arrayOf(R.drawable.reedy,R.drawable.pic0,R.drawable.rohit1,R.drawable.surya12)
        val lastmg = arrayOf("when will you call","can youexplain this ","hi,we will win worldup ","supla shots ka king")
        val phonenumber = arrayOf("454567890","45265445116","7899902565","235648413")
        array=ArrayList()
        for(eachindex in name.indices){
            val user = Persons(name[eachindex],lastmg[eachindex],time[eachindex],imageid[eachindex],phonenumber[eachindex])
            array.add(user)
        }
        val listview = findViewById<ListView>(R.id.listview
        )
        listview.isClickable=true
        listview.adapter= Myadapter(this,array)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}