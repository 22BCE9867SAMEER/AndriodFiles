package com.sameer.myprojects.Projects

import android.os.Bundle
import android.util.Log
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.sameer.myprojects.R
import com.sameer.myprojects.yclass.Api.Myadapter2
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create

class MUSICLIST : AppCompatActivity() {
    lateinit var recyclerView: RecyclerView
    lateinit var myadapter3:Myadapter3
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_musiclist)
        recyclerView = findViewById(R.id.recyclerviewmovie)
        // add retrofit tommit
        val retrofitbulider = Retrofit.Builder()
            .baseUrl("https://deezerdevs-deezer.p.rapidapi.com/" )
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(Apiinterface2::class.java)

        val retrofitdata = retrofitbulider.getData("eminem")
        retrofitdata.enqueue(object : Callback<MYMUSIC?> {
            override fun onResponse(call: Call<MYMUSIC?>, response: Response<MYMUSIC?>) {
                //create the respone body
                var responsebody = response.body()
                val musiclist = responsebody?.data!!
                //setting the adapter now

                    myadapter3  = Myadapter3(this@MUSICLIST,musiclist)
                recyclerView.adapter = myadapter3
                recyclerView.layoutManager = LinearLayoutManager(this@MUSICLIST)

            }

            override fun onFailure(call: Call<MYMUSIC?>, t: Throwable) {
              Log.d("MUSICLIST","onfaliure"+t.message)
            }
        })

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}