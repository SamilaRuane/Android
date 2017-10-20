package com.cursokotlin.storewars.repository

import android.content.Context
import android.net.ConnectivityManager
import android.net.NetworkInfo
import com.cursokotlin.storewars.entity.HTTPResponse
import com.cursokotlin.storewars.entity.Parameters

/**
 * Created by samila on 13/10/17.
 */
class StarWarsItensHTTP {
    companion object : BaseHTTP() {
        fun getAllItens (parameters : Parameters) : HTTPResponse {
            return super.execute(parameters)
        }

        fun isConnected (ctx : Context) : Boolean {
            val cm : ConnectivityManager = ctx.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
            val info : NetworkInfo = cm.activeNetworkInfo
            return (info != null && info.isConnected)
        }
    }
}