package com.cursokotlin.storewars.ui.transaction

import com.cursokotlin.storewars.entity.Transaction
import com.cursokotlin.storewars.entity.TransactionApi

/**
 * Created by samila on 15/10/17.
 */
interface TransactionContract {
    interface View{

    }

    interface Presenter {

    fun save (transaction : Transaction)
    fun selectAllTransactions () : MutableList<Transaction>
    fun getTransaction (id : Int)
        fun newTransactionToApi (transaction: TransactionApi)


    }

}