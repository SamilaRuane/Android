package com.cursokotlin.storewars.repository

import com.cursokotlin.storewars.entity.Transaction

/**
 * Created by samila on 15/10/17.
 */
interface TransactionRepository  {

    fun save (transaction: Transaction)
    fun delete (transaction: Transaction)
    fun select (query : String?) : MutableList<Transaction>
}