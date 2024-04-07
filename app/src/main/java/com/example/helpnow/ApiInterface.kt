package com.example.helpnow

import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.POST

interface ApiInterface {
        //    @GET("?t={q}&apikey=b7df68f6")
//        @GET
//        fun postMedicalDocument(
////        @Path(value = "name",encoded = true) name:String,
////        @Query("q") movie:String
//            @Url url : String
//        ) : retrofit2.Call<MedicalInfo>
        @POST("medical-documents")
        fun postMedicalDocument(
            @Body medicalInfo: MedicalInfo
        ): Call<MedicalInfo>

}