package com.cursokotlin.storewars.repository.remote

import com.cursokotlin.storewars.entity.Transaction
import com.cursokotlin.storewars.entity.TransactionApi
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.POST
import retrofit2.http.Path

/**
 * Created by samila on 26/10/17.
 */
interface TransactionService {
    @POST("transaction")
    fun newTransaction (@Body transaction : TransactionApi) : Call<TransactionApi>
}