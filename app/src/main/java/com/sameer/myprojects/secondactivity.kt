package com.sameer.myprojects

import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.AdapterView
import android.widget.Spinner
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class secondactivity : AppCompatActivity(), AdapterView.OnItemSelectedListener {
    lateinit var myspinner:Spinner
    var TAG = secondactivity::class.java.simpleName //"secondactivity"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_secondactivity)
        myspinner = findViewById(R.id.spinner)
        myspinner.onItemSelectedListener=this;


        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

    }
    @Override
    override fun onItemSelected(adapter:AdapterView<*>?, view: View?, postion:Int, id:Long){
        val item = adapter?.getItemAtPosition(postion).toString();
        Log.i(TAG ,item)
    }

    override fun onNothingSelected(parent: AdapterView<*>?) {
        TODO("Not yet implemented")
    }
}