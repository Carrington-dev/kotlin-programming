package za.co.stemgon.retrofitapp.services

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create
import retrofit2.http.GET
import za.co.stemgon.retrofitapp.models.MakeResponse

val retrofit = Retrofit
    .Builder()
    .baseUrl("https://api.vroomhive.co.za/api/v1/")
    .addConverterFactory(GsonConverterFactory.create())
    .build()

val makeAPIService = retrofit.create(APIService::class.java)

interface APIService {
    @GET("makes/")
    suspend fun getMakes(): MakeResponse
}