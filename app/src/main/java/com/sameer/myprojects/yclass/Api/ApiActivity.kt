package com.sameer.myprojects.yclass.Api

import android.os.Bundle
import android.util.Log
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.sameer.myprojects.R
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create

class ApiActivity : AppCompatActivity() {
    lateinit var recyclerview :RecyclerView
   lateinit var adaptermy :Myadapter2
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_api)
        recyclerview = findViewById(R.id.rv)

        val retrofitBuilder = Retrofit.Builder()
            .baseUrl("https://dummyjson.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(Apiinterface::class.java)

        val retrofitData = retrofitBuilder.getProducts()
        retrofitData.enqueue(object : Callback<Mydata?> {
            override fun onResponse(call: Call<Mydata?>, response: Response<Mydata?>) {
                //if api is scuuess , then use the dta of api and show
                var responesebody = response.body()
                val productlist= responesebody?.products!!

 //intialize the adapter
                adaptermy = Myadapter2(this@ApiActivity,productlist)
                recyclerview.adapter  = adaptermy
                recyclerview.layoutManager = LinearLayoutManager(this@ApiActivity)

             /*   val collectDatainsb = StringBuilder()

               if (productlist != null) {
                    for(mydata in productlist){
                        collectDatainsb.append(mydata.title+" ")



                    }
                    val tv = findViewById<TextView>(R.id.te)
                    tv.text = collectDatainsb
                }*/

            }

            override fun onFailure(call: Call<Mydata?>, t: Throwable) {
                Log.d("ApiActivity","onfaliure"+t.message)

            }
        })

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}