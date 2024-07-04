package com.sameer.myprojects.yclass.Api

import android.widget.TextView
import retrofit2.Call
import retrofit2.http.GET

interface Apiinterface {
    @GET("products")
    fun getProducts(): Call<Mydata>
}