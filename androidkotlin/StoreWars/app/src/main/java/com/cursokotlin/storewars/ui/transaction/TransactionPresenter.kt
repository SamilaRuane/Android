package com.cursokotlin.storewars.ui.transaction

import android.content.Context
import com.cursokotlin.storewars.entity.Transaction
import com.cursokotlin.storewars.entity.TransactionApi
import com.cursokotlin.storewars.repository.DataManager
import com.cursokotlin.storewars.repository.DataManagerImpl

/**
 * Created by samila on 15/10/17.
 */
class TransactionPresenter : TransactionContract.Presenter{

    val mView : TransactionContract.View
    val mDataManager : DataManager

    constructor(view:TransactionContract.View, ctx:Context){
        mView = view
        mDataManager = DataManagerImpl(ctx)
    }


    override fun save(transaction: Transaction) {
        mDataManager.save(transaction)
    }

    override fun selectAllTransactions(): MutableList<Transaction> {
        return mDataManager.select("")
    }

    override fun getTransaction(id: Int) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun newTransactionToApi(transaction: TransactionApi) {
        mDataManager.newTransaction(transaction)
    }
}