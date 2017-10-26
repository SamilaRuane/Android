package com.cursokotlin.storewars.repository.remote

import com.cursokotlin.storewars.entity.StarWarsItem
import retrofit2.Call
import retrofit2.http.GET

/**
 * Created by samila on 25/10/17.
 */
interface StoreWarsService {

    @GET("products.json")
    fun getAllItens (): Call<List <StarWarsItem>>

}