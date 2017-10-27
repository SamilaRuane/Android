package com.cursokotlin.storewars.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import com.cursokotlin.storewars.R
import com.cursokotlin.storewars.entity.Transaction
import kotlinx.android.synthetic.main.item_transaction_list.view.*
import java.text.SimpleDateFormat

/**
 * Created by samila on 19/10/17.
 */
class TransactionAdapter : BaseAdapter{

     var mTransactionList: MutableList<Transaction>
     var mCtx: Context

    constructor(ctx:Context, transactionList: MutableList<Transaction>) : super() {
        mTransactionList = transactionList
        mCtx = ctx
    }


    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {

        val layout : View = LayoutInflater.from(mCtx).inflate(R.layout.item_transaction_list, parent, false)
        val t = mTransactionList[position]

        val simpleDateFormat = SimpleDateFormat ("dd/MM/yyyy")
        layout.txt_card_owner.text = t.cardOwnerName
        layout.txt_card_number.text = t.card_number
        layout.txt_shopy_value.text = t.transactionValue.toString()
        layout.txt_card_number.text = "**** **** **** ${t.card_number}"
        layout.txt_transaction_date.text = simpleDateFormat.format(t.dateTime)


        return layout
    }

    override fun getItem(position: Int): Any = mTransactionList[position]

    override fun getItemId(position: Int): Long = position.toLong()

    override fun getCount(): Int = mTransactionList.size
}