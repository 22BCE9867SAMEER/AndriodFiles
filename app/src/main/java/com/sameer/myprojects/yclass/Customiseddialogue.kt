package com.sameer.myprojects.yclass

import android.app.Dialog
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.sameer.myprojects.R

class Customiseddialogue : AppCompatActivity() {
    lateinit var dialog:Dialog
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_customiseddialogue)
        dialog = Dialog(this)
        val bnt = findViewById<Button>(R.id.bntclick)
        dialog.setContentView(R.layout.bg_dialogue)
        dialog.window?.setBackgroundDrawable(getDrawable(R.drawable.bg_alertbox))
        val bntgood = dialog.findViewById<Button>(R.id.bntgood)
        val bntfeedback = dialog.findViewById<Button>(R.id.bntfeeadback)
        bntgood.setOnClickListener {
            //actions
            dialog.dismiss()
        }
        bntfeedback.setOnClickListener {
            //use intents and pass the data using link --implicit intent

        }
bnt.setOnClickListener {
    dialog.show()
}
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}