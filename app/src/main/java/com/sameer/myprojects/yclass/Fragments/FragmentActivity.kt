package com.sameer.myprojects.yclass.Fragments

import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.fragment.app.Fragment
import com.sameer.myprojects.R

class FragmentActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_fragment)
        val bntclock = findViewById<Button>(R.id.buttonclock)
        val bntexam = findViewById<Button>(R.id.buttonexam)
      val   bntvalid  = findViewById<Button>(R.id.buttonvalidate)

        bntclock.setOnClickListener {
            Replacewithfragemnt(Clock())


        }
        bntexam.setOnClickListener {
Replacewithfragemnt(Exam())
        }
        bntvalid.setOnClickListener {

        }
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
    fun Replacewithfragemnt(fragment:Fragment){
        val fragmentmanger = supportFragmentManager
        val fragmenttrans = fragmentmanger.beginTransaction()
        fragmenttrans.replace(R.id.framlayout , fragment)
        fragmenttrans.commit()
    }
}