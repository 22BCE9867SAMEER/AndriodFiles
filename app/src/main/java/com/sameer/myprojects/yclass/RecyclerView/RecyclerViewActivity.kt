package com.sameer.myprojects.yclass.RecyclerView

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.sameer.myprojects.R
import com.sameer.myprojects.yclass.Myadapter
import java.util.ArrayList

class RecyclerViewActivity : AppCompatActivity() {
    lateinit var myrecylerview :RecyclerView
    lateinit var array: ArrayList<News>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_recycler_view)
        myrecylerview = findViewById(R.id.recyclerview)

        val newimage = arrayOf(R.drawable.reedy,R.drawable.pic0,R.drawable.rohit1,R.drawable.surya12)
        val newtitle = arrayOf("France’s exceptionally high-stakes elections have begun as support for the far right grows","Floridians taste ‘lab-grown’ meat for last time before state ban","California is set to track gun shop credit card sales as 17 other states pass laws that prohibit it","How will Louisiana’s new Ten Commandments classroom requirement be funded and enforced?")
        //to set the hav bhav of items inside the recyclerrview for verticlly scrolling ,horizontally,gridviews
        myrecylerview.layoutManager= LinearLayoutManager(this)
        array = arrayListOf<News>()




for(index in newimage.indices){
    val news = News(newtitle[index] ,newimage[index])

    array.add(news)
}

        //implement adapter
        myrecylerview.adapter = Myadapter1(array , this)



        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}