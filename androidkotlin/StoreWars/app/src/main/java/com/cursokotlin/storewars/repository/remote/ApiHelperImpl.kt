package com.cursokotlin.storewars.repository.remote

import com.cursokotlin.storewars.repository.remote.RetrofitManager
import com.cursokotlin.storewars.repository.remote.StoreWarsService

/**
 * Created by samila on 13/10/17.
 */
class ApiHelperImpl {
    companion object {

        fun getAllItens(){

            val service : StoreWarsService = RetrofitManager.create()
             RetrofitManager.getAllItens(service)
        }
    }
}