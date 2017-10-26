package com.cursokotlin.storewars.repository.remote

import android.util.Log
import com.cursokotlin.storewars.entity.StarWarsItem
import com.cursokotlin.storewars.infra.EndpointConstants
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

/**
 * Created by samila on 25/10/17.
 */
class RetrofitManager {


    companion object {

        lateinit var mListener : OnReponse
        var success : Boolean = false

        fun create() : StoreWarsService {

            val retrofit : Retrofit = Retrofit.Builder ()
                    .baseUrl(EndpointConstants.BASE.URL)
                    .addConverterFactory(GsonConverterFactory.create ())
                    .build()

            val service = retrofit.create(StoreWarsService ::class.java)

            return service
        }

        fun getAllItens (service : StoreWarsService){
            val call : Call<List<StarWarsItem>> = service.getAllItens()
            var list : List <StarWarsItem>? = mutableListOf <StarWarsItem>()

            call.enqueue(object : Callback<List<StarWarsItem>> {
                override fun onFailure(call: Call<List<StarWarsItem>>?, t: Throwable?) {
                    Log.i("STW", "Ocorreu um erro")
                    success = false
                    mListener.onResponse(mutableListOf(), success)
                }

                override fun onResponse(call: Call<List<StarWarsItem>>?, response: Response<List<StarWarsItem>>?) {
                    list = response!!.body()

                    if (!(list == null)) {
                        success = true
                        mListener.onResponse(list, success)
                    }
                }

            })
    }

        fun setOnResponseListener (listener : RetrofitManager.OnReponse ){
            mListener = listener
        }
}


    interface OnReponse {
        fun onResponse(list: List <StarWarsItem>?, success : Boolean)
    }



}