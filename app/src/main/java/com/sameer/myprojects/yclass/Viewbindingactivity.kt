package com.sameer.myprojects.yclass

import android.content.res.ColorStateList
import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.firebase.database.collection.LLRBNode.Color
import com.google.firebase.database.collection.LLRBNode.Color.*
import com.sameer.myprojects.R
import com.sameer.myprojects.databinding.ActivityMainBinding
import com.sameer.myprojects.databinding.ActivityViewbindingactivityBinding

class Viewbindingactivity : AppCompatActivity() {
    lateinit var binding:ActivityViewbindingactivityBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityViewbindingactivityBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.button2.setOnClickListener {
            if(binding.checkbox.isChecked){
                //open a new screen


            }else{
                binding.checkbox.buttonTintList = ColorStateList.valueOf(android.graphics.Color.RED)
                Toast.makeText(this,"please aceept on terms and conditions",Toast.LENGTH_SHORT).show()

            }
        }


        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}