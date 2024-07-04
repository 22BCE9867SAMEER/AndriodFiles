package com.sameer.myprojects.yclass.Bottomnavigation

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.fragment.app.Fragment
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.sameer.myprojects.R

class BottomnagvigationActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_bottomnagvigation)
        //to set actions bottom navigation we have use fragments
        val bnt = findViewById<BottomNavigationView>(R.id.bottomnavigation)
        Replacewithfragment(Home())
        bnt.setOnItemSelectedListener {
            when(it.itemId){
                R.id.home1 -> Replacewithfragment(Home())
                R.id.search1 -> Replacewithfragment(Search())
                R.id.person1 -> Replacewithfragment(Person())
                else -> {

                }
            }
            true
        }

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
    fun Replacewithfragment(fragment:Fragment){
        val fragmentmanager = supportFragmentManager
        val tarnscation = fragmentmanager.beginTransaction()
        tarnscation.replace(R.id.frame , fragment)
        tarnscation.commit()
    }
}