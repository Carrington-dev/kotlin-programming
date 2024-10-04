package za.co.stemgon.retrofitapp.services

import retrofit2.http.GET

interface APIService {
    @GET("makes/")
    suspend fun getMakes(){

    }
}