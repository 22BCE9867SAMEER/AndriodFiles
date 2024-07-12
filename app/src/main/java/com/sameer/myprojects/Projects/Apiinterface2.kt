package com.sameer.myprojects.Projects

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Headers
import retrofit2.http.Query

interface Apiinterface2 {
    //adding the hearder in the apin
    @Headers("x-rapidapi-key:041cd9bb1fmsh976e0779f53a428p148bc8jsn63c381892c9c","x-rapidapi-host: deezerdevs-deezer.p.rapidapi.com" )
    //adding the end point
    @GET("search")
    //adding reqired query int he api

    fun getData(@Query("q")query:String) : Call<MYMUSIC>

}