package com.sameer.myprojects.yclass

import android.content.DialogInterface
import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.sameer.myprojects.R
import com.sameer.myprojects.databinding.ActivityDialgoueBoxesBinding

class DialgoueBoxesActivity : AppCompatActivity() {
    lateinit var bind:ActivityDialgoueBoxesBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
bind = ActivityDialgoueBoxesBinding.inflate(layoutInflater)
        enableEdgeToEdge()
        setContentView(bind.root)
        bind.bnt1.setOnClickListener {
            val bulider1 =AlertDialog.Builder(this)
            bulider1.setTitle("Are you sure?")
            bulider1.setMessage("Do you want to close the App")
            bulider1.setPositiveButton("Yes",DialogInterface.OnClickListener { dialog, i ->
                //what action should we perform
                finish()
            })
            bulider1.setNegativeButton("No",DialogInterface.OnClickListener { dialog, which ->

            })
            bulider1.show()

        }
        bind.bnt2.setOnClickListener {
            val options = arrayOf("sammer","rohit","kohli")
            val bulider2 = AlertDialog.Builder(this)
            bulider2.setTitle("who is your favarite ?")
            bulider2.setSingleChoiceItems(options,0,DialogInterface.OnClickListener { dialog, which ->
                //actions made
                Toast.makeText(this, "you selected ${options[which]}",Toast.LENGTH_SHORT).show()
            })
            bulider2.setPositiveButton("submit",DialogInterface.OnClickListener { dialog, which ->
                //what action should we perform

            })
            bulider2.setNegativeButton("decline",DialogInterface.OnClickListener { dialog, which ->

            })
            bulider2.show()

        }
        bind.bnt3.setOnClickListener {
            val options = arrayOf("sammer","rohit","kohli")
            val bulider3 = AlertDialog.Builder(this)
            bulider3.setTitle("who is your favarite ?")
          bulider3.setMultiChoiceItems(options,null,DialogInterface.OnMultiChoiceClickListener { dialog, which, isChecked ->
              Toast.makeText(this, "you selected ${options[which]}",Toast.LENGTH_SHORT).show()
          })
            bulider3.setPositiveButton("submit",DialogInterface.OnClickListener { dialog, which ->
                //what action should we perform
                finish()
            })
            bulider3.setNegativeButton("decline",DialogInterface.OnClickListener { dialog, which ->

            })
            bulider3.show()

        }






























        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}