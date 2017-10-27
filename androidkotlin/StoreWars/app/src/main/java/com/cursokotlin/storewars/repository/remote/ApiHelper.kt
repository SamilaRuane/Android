package com.cursokotlin.storewars.repository.remote

import com.cursokotlin.storewars.entity.Transaction
import com.cursokotlin.storewars.entity.TransactionApi

/**
 * Created by samila on 18/10/17.
 */
interface ApiHelper{

    fun getAllItens()
    fun newTransaction (transaction:TransactionApi)
}