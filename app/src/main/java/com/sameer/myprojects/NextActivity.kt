package com.sameer.myprojects

import android.os.Bundle
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import de.hdodenhof.circleimageview.CircleImageView

class NextActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_next)

        val name = intent.getStringExtra("name")
        val phone = intent.getStringExtra("phonenumber")
        val lastmsg = intent.getStringExtra("lastmessage")
        val img = intent.getIntExtra("imageid",R.drawable.reedy)
        val nm = findViewById< TextView>(R.id.textname)
        val ph = findViewById<TextView>(R.id.textphone)
        val lm = findViewById<TextView>(R.id.textlastmsg)
        val imge = findViewById<CircleImageView>(R.id.profile1_img)
        nm.text = name
        ph.text = phone
        lm.text = lastmsg
        imge.setImageResource(img)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}