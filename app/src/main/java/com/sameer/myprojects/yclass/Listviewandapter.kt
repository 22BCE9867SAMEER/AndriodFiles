package com.sameer.myprojects.yclass

import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.ListView
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.sameer.myprojects.R

class Listviewandapter : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_listviewandapter)
        val list = findViewById<ListView>(R.id.list)
        val array = arrayListOf<String>()
        array.add("exam conducated ")
        array.add("marks will realse on 27th")
        array.add("final result will realse on 29th")
        array.add("class will commited from 2nd")
        val adapterformylistview = ArrayAdapter(this,android.R.layout.simple_list_item_1,array)
        list.adapter=adapterformylistview
       list.setOnItemClickListener { parent, view, position, id ->
           val text = "Clicked on item :"+(view as TextView).text.toString()
           Toast.makeText(this,text,Toast.LENGTH_SHORT).show()
       }
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}