package com.example.helpnow

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitInstance {

        private val retrofit by lazy {
            Retrofit.Builder().baseUrl("http://localhost:3000/request-ipfs-data/")
                .addConverterFactory(GsonConverterFactory.create()).build()
        }
        val apiInterface by lazy {
            retrofit.create(ApiInterface::class.java)
        }
}