package com.cursokotlin.storewars.ui.transaction

import android.support.v7.app.AppCompatActivity
import android.os.Bundle

import com.cursokotlin.storewars.R
import com.cursokotlin.storewars.adapters.TransactionAdapter
import com.cursokotlin.storewars.entity.Transaction
import kotlinx.android.synthetic.main.activity_transaction_list.*

class TransactionListActivity : AppCompatActivity (), TransactionContract.View {

    lateinit var mTransactionPresenter : TransactionContract.Presenter
    lateinit var mAdapter : TransactionAdapter
    lateinit var  mTransactionList : MutableList<Transaction>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_transaction_list)

        mTransactionPresenter = TransactionPresenter (this, applicationContext)
        mTransactionList = mTransactionPresenter.selectAllTransactions()
        mAdapter = TransactionAdapter(this, mTransactionList)
        transaction_list_view.adapter = mAdapter

        mAdapter.notifyDataSetChanged()
    }
}
