package com.cursokotlin.storewars.repository.remote

import com.cursokotlin.storewars.entity.TransactionApi


/**
 * Created by samila on 13/10/17.
 */
class ApiHelperImpl : ApiHelper {

    override fun getAllItens() {
        val service : StoreWarsService = RetrofitManager.createStoreWarsService()
        RetrofitManager.getAllItens(service)
    }

    override fun newTransaction(transaction: TransactionApi) {
        val service : TransactionService = RetrofitManager.createTransactionService()
        RetrofitManager.newTransaction(service, transaction)
    }
}