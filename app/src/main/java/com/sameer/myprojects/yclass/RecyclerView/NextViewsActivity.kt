package com.sameer.myprojects.yclass.RecyclerView

import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.sameer.myprojects.R

class NextViewsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_next_views)
val heading = intent.getStringExtra("tiitle")
        val body = intent.getStringExtra("newscontent")
        val imagenewset=intent.getIntExtra("image",R.drawable.rohit1)



        val newhead = findViewById<TextView>(R.id.newsheadingtextview)
        val newsbody = findViewById<TextView>(R.id.textnewscontent)
        val newsphoto = findViewById<ImageView>(R.id.imagerohit)

        //setting
        newhead.text = heading
        newsbody.text = body

        newsphoto.setImageResource(imagenewset)





        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}